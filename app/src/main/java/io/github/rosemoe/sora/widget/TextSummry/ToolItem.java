package io.github.rosemoe.sora.widget.TextSummry;

import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.activities.BrowserActivity;
import ir.ninjacoder.ghostide.activities.CodeEditorActivity;
import ir.ninjacoder.ghostide.databin.XmlTranslator;
import ir.ninjacoder.ghostide.marco.SmaliHelper;
import ir.ninjacoder.ghostide.tasks.SmalitoJava;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.adapter.Recyclerview0Adapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import ir.ninjacoder.ghostide.R;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.data.CompletionItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ToolItem {
  private static final int SIZEBOOLTEXT = 17;
  protected Recyclerview0Adapter rp;

  public void MakeItemNinjaLang(Context context, CodeEditor editor) {
    MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(context);
    dialogBuilder.setTitle("Make Data ");
    dialogBuilder.setMessage("Type Your data like in public object : JVM()");

    View view = LayoutInflater.from(context).inflate(R.layout.layout_info, null);
    LinearLayout layout = view.findViewById(R.id.layout);
    TextInputLayout layout1 = view.findViewById(R.id.layout1);
    TextInputLayout layout2 = view.findViewById(R.id.layout2);
    TextInputEditText ed1 = view.findViewById(R.id.edi1);
    TextInputEditText ed2 = view.findViewById(R.id.edi2);

    dialogBuilder.setView(view);
    layout1.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_FILLED);
    layout2.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_FILLED);
    if (!ed1.getText().toString().isEmpty() || !ed2.getText().toString().isEmpty()) {
      layout1.setError("Text is Empty");
      layout1.setErrorEnabled(true);
      layout2.setError("Text is Empty");
      layout2.setErrorEnabled(true);
    } else {
      layout1.setErrorEnabled(false);
      layout2.setErrorEnabled(false);
    }
    ed1.setTextSize(16);
    ed2.setTextSize(16);
    dialogBuilder.setPositiveButton(
        "ok",
        new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            String start =
                "public "
                    + ed1.getText().toString()
                    + " : "
                    + ed2.getText().toString()
                    + " {"
                    + "\n \n }";
            int leftLine = editor.getCursor().getLeftLine();
            int leftColumn = editor.getCursor().getLeftColumn();
            editor.getText().insert(leftLine, leftColumn, start);
            Handler handler = new Handler();
            handler.postDelayed(
                new Runnable() {
                  @Override
                  public void run() {
                    editor.formatCodeAsync();
                  }
                },
                1000);
          }
        });
    dialogBuilder.show();
  }

  public LinearLayout getCustomHader(String text, Context context) {
    LinearLayout layout = new LinearLayout(context);
    TextView view = new TextView(context);
    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    LinearLayout.LayoutParams params1 =
        new LinearLayout.LayoutParams(
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    layout.setLayoutParams(params);
    view.setLayoutParams(params1);
    layout.setPadding(8, 8, 8, 8);
    view.setPadding(8, 8, 8, 8);
    view.setText(text);
    view.setTextSize(SIZEBOOLTEXT);
    layout.setBackgroundColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
    view.setTextColor(MaterialColors.getColor(context, ObjectUtils.TvColor, 0));
    layout.setOrientation(LinearLayout.HORIZONTAL);
    layout.setGravity(Gravity.CENTER);
    layout.addView(view);

    return layout;
  }

  public void BindViewsNinja(Context context, View view, CodeEditor editor) {
    PowerMenu menu =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("Data maker"))
            .addItem(new PowerMenuItem("Comment Normal"))
            .addItem(new PowerMenuItem("UnComment"))
            .addItem(new PowerMenuItem("Long Comment"))
            .addItem(new PowerMenuItem("Run Web site(beta)"))
            .build();
    menu.setMenuRadius(20f);
    menu.setTextColor(0);
    menu.setShowBackground(false);
    menu.setAutoDismiss(true);
    menu.setTextSize(14);
    menu.setMenuColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
    menu.setTextColor(MaterialColors.getColor(context, ObjectUtils.TvColor, 0));
    menu.showAsAnchorRightBottom(view);
    menu.setAnimation(MenuAnimation.ELASTIC_CENTER);
    menu.setHeaderView(getCustomHader("Ninja Helper", context));
    menu.setOnMenuItemClickListener(
        (pos, item) -> {
          if (pos == 0) {
            MakeItemNinjaLang(context, editor);
          } else if (pos == 1) {
            if (editor.getCursor().isSelected()) editor.getCommentHelper().CustomComment("//", "");
            else Toast.makeText(context, "SelectText", Toast.LENGTH_SHORT).show();
          } else if (pos == 2) {
            if (editor.getCursor().isSelected()) editor.getCommentHelper().unComment();
            else Toast.makeText(context, "SelectText", Toast.LENGTH_SHORT).show();
          } else if (pos == 3) {
            if (editor.getCursor().isSelected())
              editor.getCommentHelper().CustomComment("/*", "*/");
            else Toast.makeText(context, "Not isSelected ", Toast.LENGTH_SHORT).show();
          } else if (pos == 4) {
            ShareText(context, editor);
          }
        });
  }

  public Drawable getDiverAuto(Context ctc) {
    MaterialShapeDrawable mshap =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 20).build());
    mshap.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(ctc, ObjectUtils.ButtonBack, 0)));
    return (Drawable) mshap;
  }

  public void ShareText(Context context, CodeEditor editor) {
    var text = editor.getSelectedText();
    if (editor.getCursor().isSelected()) {
      if (text.startsWith("https") || text.startsWith("http")) {
        var intent = new Intent();
        intent.putExtra("test", text);
        intent.setClass(context, BrowserActivity.class);
        context.startActivity(intent);
      }
    }
  }

  public void GotoListFile(List<CompletionItem> item, ArrayList<String> paths) {}

  public void StringFog(CodeEditor editor) {
    StringFog(editor, "\"(.*?)\"");
  }

  public void StringFog(CodeEditor ed, String regex) {
    var listview = new RecyclerView(ed.getContext());
    var param =
        new RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
    listview.setLayoutParams(param);
    ArrayList<HashMap<String, Object>> map = new ArrayList<>();
    ArrayList<String> listStr = new ArrayList<>();
    Pattern patn = Pattern.compile(regex);
    Matcher mather = patn.matcher(ed.getText().toString());
    while (mather.find()) {
      listStr.add(mather.group(1));
    }
    for (var text : listStr) {
      {
        HashMap<String, Object> _maps = new HashMap<>();
        _maps.put("post", text);
        map.add(_maps);
      }
    }
    rp =
        new Recyclerview0Adapter(
            map,
            ed,
            ed.getContext(),
            new Recyclerview0Adapter.OnItemClick() {

              @Override
              public void onItemClick(int pos) {
                ed.getSearcher().search(map.get((int) pos).get("post").toString().trim());
                try {
                  ed.getSearcher().gotoNext();
                } catch (IllegalStateException e) {
                  e.printStackTrace();
                }
              }

              @Override
              public void onLongItemClick(int pos) {
                var di = new MaterialAlertDialogBuilder(ed.getContext());
                di.setTitle("Fog Decoder");
                di.setMessage(
                    "replace or replaceAll "
                        .concat(
                            map.get((int) pos)
                                .get("post")
                                .toString()
                                .trim()
                                .concat(
                                    "to"
                                        .concat(
                                            rp._Decrypt(
                                                map.get((int) pos)
                                                    .get("post")
                                                    .toString()
                                                    .trim())))));
                di.setNeutralButton(
                    "rep",
                    (p, d) -> {
                      try {
                        ed.getSearcher().replaceThis(rp.text);
                      } catch (IllegalStateException e) {
                        e.printStackTrace();
                      }
                      try {
                        ed.getSearcher().gotoNext();
                      } catch (IllegalStateException e) {
                        e.printStackTrace();
                      }
                    });
                di.setPositiveButton(
                    "repAll",
                    (p1, d2) -> {
                      try {
                        ed.getSearcher().replaceAll(rp.text);
                      } catch (IllegalStateException e) {
                        e.printStackTrace();
                      }
                      try {
                        ed.getSearcher().gotoNext();
                      } catch (IllegalStateException e) {
                        e.printStackTrace();
                      }
                    });
                di.show();
              }
            });
    listview.setAdapter(rp);
    listview.setLayoutManager(new LinearLayoutManager(ed.getContext()));
    var dialog = new MaterialAlertDialogBuilder(ed.getContext());
    dialog.setView(listview);
    if (dialog != null) {
      dialog.show();
    }
  }

  public void bindXml(Context context, CodeEditor editor, View view) {
    PowerMenu menu =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("translateXml"))
            .setIsMaterial(true)
            .build();
    menu.setShowBackground(false);
    menu.setMenuColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
    menu.setTextColor(MaterialColors.getColor(context, ObjectUtils.TvColor, 0));
    menu.setAnimation(MenuAnimation.FADE);
    menu.setAutoDismiss(true);
    menu.setOnMenuItemClickListener(
        (i, c) -> {
          switch (i) {
            case 0:
              new XmlTranslator((IdeEditor) editor, context);
              editor.getTextActionWindow().dismiss();
              menu.dismiss();
              break;
          }
        });
    menu.showAsDropDown(view);
  }

  public void bindSmail(Context context, CodeEditor editor, View view) {
    PowerMenu menu =
        new PowerMenu.Builder(context)
            .addItem(new PowerMenuItem("smail to java"))
            .addItem(new PowerMenuItem("smail code tree"))
            .setIsMaterial(true)
            .build();
    menu.setShowBackground(false);
    menu.setMenuColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
    menu.setTextColor(MaterialColors.getColor(context, ObjectUtils.TvColor, 0));
    menu.setAnimation(MenuAnimation.FADE);
    menu.setAutoDismiss(true);
    menu.setOnMenuItemClickListener(
        (i, c) -> {
          switch (i) {
            case 0:
              {
                try {
                  SmalitoJava.toAsync(
                      editor.getText().toString(),
                      new SmalitoJava.DecompileCallback() {

                        @Override
                        public void onResult(String javaCode) {
                          editor.setText(javaCode);
                        }

                        @Override
                        public void onError(Exception e) {
                          editor.setText(e.getLocalizedMessage());
                        }
                      });
                } catch (Exception err) {

                }
                editor.getTextActionWindow().dismiss();
                menu.dismiss();
                break;
              }

            case 1:
              {
                SmaliHelper.run(editor, context);
                editor.getTextActionWindow().dismiss();
                menu.dismiss();
                break;
              }
          }
        });
    menu.showAsDropDown(view);
  }
}
