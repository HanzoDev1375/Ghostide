package ir.ninjacoder.ghostide.core.marco;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textview.MaterialTextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

/**
 * Code By mister java and Big Progamer Ninja coder Using Library from Tag Html View Bind By
 * listView @Doc
 *
 * @see To install -> var tag = new HtmlTagView(); tag.Start(editor.getText().toString(),this);
 */
public class HtmlTagView {
    private ArrayList<HashMap<String, Object>> list = new ArrayList<>();

    public void Start(String txt, Context context, IdeEditor editor) {
        ListView listview1 = new ListView(context);
        listview1.setLayoutParams(
                new ListView.LayoutParams(
                        ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT));
        listview1.setVerticalScrollBarEnabled(false);
        LinearLayoutCompat compat = new LinearLayoutCompat(context);
        compat.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        compat.setGravity(Gravity.CENTER);
        MaterialTextView textView = new MaterialTextView(context);
        textView.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText("Not Found Tag");
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setTextColor(MaterialColors.getColor(textView, ObjectUtils.TvColor));
        listview1.setDividerHeight(0);
        AlertDialog dialogBuilder =
                new MaterialAlertDialogBuilder(context)
                        .setTitle("Html Tree View")
                        .setView(listview1)
                        .setPositiveButton("ok", null)
                        .create();
        dialogBuilder.setOnShowListener(
                v -> {
                    Button btn = dialogBuilder.getButton(DialogInterface.BUTTON_POSITIVE);
                    btn.setOnClickListener(
                            __ -> {
                                dialogBuilder.dismiss();
                            });
                    if (listview1 != null) listview1.setEmptyView(compat);

                    Document document = Jsoup.parse(txt);
                    Elements elements = document.select("*");
                    for (Element element : elements) {
                        if (!element.tagName().equals("#root")) {
                            {
                                HashMap<String, Object> _item = new HashMap<>();
                                _item.put("tag", element.tagName());
                                list.add(_item);
                            }
                        }
                    }
                    listview1.setAdapter(new Listview1Adapter(list, context));
                    ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
                    listview1.setOnItemClickListener(
                            (vi, view, pos, id) -> {
                                try {
                                    editor.getSearcher().search(list.get(pos).get("tag").toString());
                                    editor.getSearcher().gotoNext();
                                    dialogBuilder.dismiss();
                                } catch (Exception err) {
                                    editor.getSearcher().stopSearch();
                                }
                            });
                });
        dialogBuilder.show();
    }

    public void PythonTreeView(String text, Context context, CodeEditor editor) {
        ListView listview1 = new ListView(context);
        listview1.setLayoutParams(
                new ListView.LayoutParams(
                        ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT));
        listview1.setVerticalScrollBarEnabled(false);
        LinearLayoutCompat compat = new LinearLayoutCompat(context);
        compat.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        compat.setGravity(Gravity.CENTER);
        MaterialTextView textView = new MaterialTextView(context);
        textView.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText("Not Found Tag");
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setTextColor(MaterialColors.getColor(textView, ObjectUtils.TvColor));
        listview1.setDividerHeight(0);
        AlertDialog dialogBuilder =
                new MaterialAlertDialogBuilder(context)
                        .setTitle("Python Tree View")
                        .setView(listview1)
                        .setPositiveButton("ok", null)
                        .create();
        dialogBuilder.setOnShowListener(
                v -> {
                    Button btn = dialogBuilder.getButton(DialogInterface.BUTTON_POSITIVE);
                    btn.setOnClickListener(
                            __ -> {
                                dialogBuilder.dismiss();
                            });
                    if (listview1 != null) listview1.setEmptyView(compat);
                    List<String> keywords = new ArrayList<>();
                    Pattern pattern = Pattern.compile("\\b(def|class)\\s+\\w+");
                    Matcher matcher = pattern.matcher(text);
                    while (matcher.find()) {
                        keywords.add(matcher.group().trim());
                    }
                    for (String keyword : keywords) {
                        {
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("tag", keyword);
                            list.add(map);
                        }
                    }

                    listview1.setAdapter(new Listview1Adapter(list, context));
                    ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
                    listview1.setOnItemClickListener(
                            (vi, view, pos, id) -> {
                                try {
                                    editor.getSearcher().search(list.get(pos).get("tag").toString());
                                    editor.getSearcher().gotoNext();
                                    dialogBuilder.dismiss();
                                } catch (Exception err) {
                                    editor.getSearcher().stopSearch();
                                }
                            });
                });
        dialogBuilder.show();
    }

    public void KtTreeView(String text, Context context, CodeEditor editor) {
        ListView listview1 = new ListView(context);
        listview1.setLayoutParams(
                new ListView.LayoutParams(
                        ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT));
        listview1.setVerticalScrollBarEnabled(false);
        LinearLayoutCompat compat = new LinearLayoutCompat(context);
        compat.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        compat.setGravity(Gravity.CENTER);
        MaterialTextView textView = new MaterialTextView(context);
        textView.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText("Not Found Tag");
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setTextColor(MaterialColors.getColor(textView, ObjectUtils.TvColor));
        listview1.setDividerHeight(0);
        AlertDialog dialogBuilder =
                new MaterialAlertDialogBuilder(context)
                        .setTitle("Kt Tree View")
                        .setView(listview1)
                        .setPositiveButton("ok", null)
                        .create();
        dialogBuilder.setOnShowListener(
                v -> {
                    Button btn = dialogBuilder.getButton(DialogInterface.BUTTON_POSITIVE);
                    btn.setOnClickListener(
                            __ -> {
                                dialogBuilder.dismiss();
                            });
                    if (listview1 != null) listview1.setEmptyView(compat);
                    List<String> keywords = new ArrayList<>();
                    Pattern pattern =
                            Pattern.compile(
                                    "\\\\b(fun|private|protected|internal|open|public|inline)\\\\s+\\\\w+");
                    Matcher matcher = pattern.matcher(text);
                    while (matcher.find()) {
                        keywords.add(matcher.group().trim());
                    }
                    for (String keyword : keywords) {
                        {
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("tag", keyword);
                            list.add(map);
                        }
                    }

                    listview1.setAdapter(new Listview1Adapter(list, context));
                    ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
                    listview1.setOnItemClickListener(
                            (vi, view, pos, id) -> {
                                try {
                                    editor.getSearcher().search(list.get(pos).get("tag").toString());
                                    editor.getSearcher().gotoNext();
                                    dialogBuilder.dismiss();
                                } catch (Exception err) {
                                    editor.getSearcher().stopSearch();
                                }
                            });
                });
        dialogBuilder.show();
    }

    private MaterialShapeDrawable getShape(View v) {
        MaterialShapeDrawable shapeDrawable =
                new MaterialShapeDrawable(
                        ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 18).build());
        shapeDrawable.setFillColor(
                ColorStateList.valueOf(MaterialColors.getColor(v, ObjectUtils.Back, 0)));
        return shapeDrawable;
    }

    class Listview1Adapter extends BaseAdapter {

        ArrayList<HashMap<String, Object>> _data;
        Context context;

        public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr, Context context) {
            _data = _arr;
            this.context = context;
        }

        @Override
        public int getCount() {
            return _data.size();
        }

        @Override
        public HashMap<String, Object> getItem(int _index) {
            return _data.get(_index);
        }

        @Override
        public long getItemId(int _index) {
            return _index;
        }

        @Override
        public View getView(final int _position, View _v, ViewGroup _container) {

            View _view = LayoutInflater.from(context).inflate(R.layout.lbs, null);

            LinearLayout rooti = _view.findViewById(R.id.rooti);

            LinearLayout getTag = _view.findViewById(R.id.getTag);
            TextView titleview = _view.findViewById(R.id.titleview);
            TextView normaltext = _view.findViewById(R.id.normaltext);

            normaltext.setText(_data.get(_position).get("tag").toString());
            titleview.setText(normaltext.getText().toString().substring(0, 1));
            getTag.setBackground(getShape(getTag));
            titleview.setTextColor(MaterialColors.getColor(titleview, ObjectUtils.TvColor));
            normaltext.setTextColor(MaterialColors.getColor(normaltext, ObjectUtils.TvColor));

            return _view;
        }
    }
}
