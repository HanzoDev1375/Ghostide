package coyamo.visualxml.lib.parser;
/**
 * Copyright (C) 2020 Coyamo
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Stack;

import coyamo.visualxml.lib.proxy.ProxyAttributeSet;
import coyamo.visualxml.lib.proxy.ProxyResources;
import coyamo.visualxml.lib.proxy.ViewCreator;
import coyamo.visualxml.lib.utils.MessageArray;

public class AndroidXmlParser {
    public static final String ANDROID_NS = "http://schemas.android.com/apk/res/android";
    private XmlPullParser parser;
    private OnParseListener listener;
    private Context context;
    //存放解析过程中的所有view
    private Stack<View> allViewStack = new Stack<>();
    //存放解析过程中的viewgroup
    private Stack<ViewGroup> viewGroupStack = new Stack<>();
    private MessageArray debug = MessageArray.getInstanse();

    private AndroidXmlParser(Context context, ViewGroup container) {
        this.context = context;
        viewGroupStack.push(container);
        allViewStack.push(container);
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();
        } catch (Exception e) {
            debug.logW("初始化解析失败：" + e);
        }
    }

    public static AndroidXmlParser with(ViewGroup container) {
        return new AndroidXmlParser(container.getContext(), container);
    }


    public AndroidXmlParser parse(String xml) {
        StringReader sr = new StringReader(xml);
        parse(sr);
        return this;
    }

    public AndroidXmlParser parse(Reader reader) {
        if (listener != null) listener.onStart();
        try {
            parser.setInput(reader);
            parse();
            reader.close();
        } catch (Exception e) {
            debug.logW("从Reader解析失败：" + e);
        } finally {
            if (listener != null) listener.onFinish();
        }
        return this;
    }

    public AndroidXmlParser parse(File path) {
        try {
            FileReader fileReader = new FileReader(path);
            parse(fileReader);
        } catch (Exception e) {
            debug.logW("从File解析失败：" + e);
        }
        return this;
    }

    private void parse() {
        try {
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.TEXT:
                        if (!parser.getText().trim().isEmpty()) {
                            debug.logE(parser.getLineNumber() + "行 " + parser.getColumnNumber() + "列： 标签内不应该出现文字： " + parser.getText());
                        }
                        break;
                    case XmlPullParser.START_TAG:
                        String tagName = parser.getName();
                        View view;

                        //如果包含style属性，好像只能从构造方法给view设置？
                        String attr = parser.getAttributeValue(null, "style");
                        if (attr != null) {
                            int attrInt = ProxyResources.getInstance().getAttr(attr);
                            view = ViewCreator.create(tagName, context, attrInt);
                        } else {
                            view = ViewCreator.create(tagName, context);
                        }
                        //当前view group
                        ViewGroup viewGroup = viewGroupStack.peek();
                        //当前view
                        View lastView = allViewStack.peek();

                        ViewGroup viewGroup2 = null;
                        if (view instanceof ViewGroup) {
                            //添加到viewgroup栈
                            viewGroup2 = viewGroupStack.push((ViewGroup) view);
                            if (listener != null)
                                listener.onJoin(viewGroup2, new ReadOnlyParser(parser));
                        }

                        /*
						不知道这个检查错误的方法有没有bug
						*/
                        if (lastView == viewGroup) {
                            viewGroup.addView(view);
                            if (listener != null && viewGroup2 != view)
                                listener.onAddChildView(view, new ReadOnlyParser(parser));
                        } else {
                            //出现了非viewgroup的view包含view的情况
                            debug.logE(parser.getLineNumber() + "行 " + parser.getColumnNumber() + "列：" + lastView.getClass().getName() + "不能转换为ViewGroup，已经自动忽略错误的xml片段。");
                        }


                        allViewStack.push(view);

                        //设置属性
                        ProxyAttributeSet attrs = new ProxyAttributeSet(parser, context);
                        attrs.setTo(view);

                        break;
                    case XmlPullParser.END_TAG:
                        View v = allViewStack.pop();
                        if (v instanceof ViewGroup) {
                            ViewGroup viewGroup1 = viewGroupStack.pop();
                            if (listener != null)
                                listener.onRevert(viewGroup1, new ReadOnlyParser(parser));
                        }
                        break;
                }
                eventType = parser.next();
            }

        } catch (Exception e) {
            debug.logE(parser.getLineNumber() + "行 " + parser.getColumnNumber() + "列：解析过程中出现错误" + e);
        }


    }

    public AndroidXmlParser setOnParseListener(OnParseListener listener) {
        this.listener = listener;
        return this;
    }

    public interface OnParseListener {
        void onAddChildView(View v, ReadOnlyParser parser);

        void onJoin(ViewGroup viewGroup, ReadOnlyParser parser);

        void onRevert(ViewGroup viewGroup, ReadOnlyParser parser);

        void onFinish();

        void onStart();
    }
}
