package Ninja.coder.Ghostemane.code.marco;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ObjectUtils;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import com.blankj.utilcode.util.ClipboardUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import io.github.rosemoe.sora.widget.CodeEditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmaliHelper {

    public static final Pattern FIELD_DIRECTIVE_PATTERN =
            Pattern.compile("^\\.field (?:(?:[a-z\\-]*) )*((.*?):(.*))$");
    public static final Pattern FIELD_METHOD_CALL_PATTERN =
            Pattern.compile("^.*?((L.*?;)\\s*->\\s*(.*))$", Pattern.DOTALL);
    private static ArrayList<HashMap<String, Object>> map = new ArrayList<>();

    private static void run(
            CodeEditor editor, Context context, String regexCode, String title, String key) {
        var listview = new ListView(context);
        ListView.LayoutParams param =
                new ListView.LayoutParams(
                        ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT);
        AlertDialog dialog =
                new MaterialAlertDialogBuilder(context)
                        .setTitle(title)
                        .setView(listview)
                        .setPositiveButton("dismiss", null)
                        .create();
        dialog.setOnShowListener(
                c -> {
                    List<String> httpsLinks = new ArrayList<>();

                    Pattern pat = Pattern.compile(regexCode);
                    Matcher mat = pat.matcher(editor.getText().toString());
                    while (mat.find()) {
                        httpsLinks.add(mat.group().trim());
                    }
                    for (var data : httpsLinks) {
                        {
                            HashMap<String, Object> mapz = new HashMap<>();
                            mapz.put(key, data);
                            map.add(mapz);
                        }
                    }
                    Button btn = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                    if (btn != null) {
                        btn.setOnClickListener(v -> dialog.dismiss());
                    }
                    /// adding adptor

                    if (listview != null) {
                        View view = LayoutInflater.from(context).inflate(R.layout.emptyview, null);
                        listview.setEmptyView(view);
                    }
                    listview.setAdapter(new Listview1Adapter(map, context));
                    ((BaseAdapter) listview.getAdapter()).notifyDataSetChanged();
                    listview.setOnItemClickListener(
                            (vi, view, pos, id) -> {
                                try {
                                    editor.getSearcher().search(map.get(pos).get(key).toString());
                                    editor.getSearcher().gotoNext();
                                    dialog.dismiss();
                                } catch (Exception err) {
                                    editor.getSearcher().stopSearch();
                                }
                            });
                    listview.setOnItemLongClickListener(
                            (adview, view, pos, lo) -> {
                                ClipboardUtils.copyText(map.get(pos).get(key).toString());
                                Toast.makeText(context, "Item Copyed " + map.get(pos).get(key).toString(), 2)
                                        .show();

                                return true;
                            });
                });
        dialog.show();
    }

    public static void run(CodeEditor editor, Context context) {
        run(
                editor,
                context,
                "^\\.method (?:(?:[a-z\\-]*) )*((.*?)\\((.*))$",
                "Sml",
                "colormt");
    }


    static class Listview1Adapter extends BaseAdapter {

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

            normaltext.setText(_data.get(_position).get("colormt").toString());
            titleview.setText(normaltext.getText().toString().substring(0, 1));
            //  getTag.setBackground(getShape(getTag));
            titleview.setTextColor(MaterialColors.getColor(titleview, ObjectUtils.TvColor));
            normaltext.setTextColor(MaterialColors.getColor(normaltext, ObjectUtils.TvColor));

            return _view;
        }
    }
}
