package com.mcal.uidesigner;

import android.graphics.Color;
import android.graphics.PorterDuff;
import androidx.appcompat.widget.Toolbar;
import com.mcal.uidesigner.common.ColorMaterial;
import static com.mcal.uidesigner.utils.FileHelper.chooseLayoutOrCreateNew;
import static com.mcal.uidesigner.utils.FileHelper.createNewLayoutFile;
import static com.mcal.uidesigner.utils.FileHelper.getRealFileNameFromUri;
import static com.mcal.uidesigner.utils.FileHelper.suggestNewLayoutName;
import static com.mcal.uidesigner.utils.StorageHelper.getDefaultResDirPath;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.mcal.uidesigner.common.ActivityStarter;
import com.mcal.uidesigner.common.AndroidHelper;
import com.mcal.uidesigner.common.HelpActivityStarter;
import com.mcal.uidesigner.common.MessageBox;
import com.mcal.uidesigner.common.ShopActivityStarter;
import com.mcal.uidesigner.common.TextToSpeechHelper;
import com.mcal.uidesigner.common.TrainerLogo;
import com.mcal.uidesigner.common.UndoManager;
import com.mcal.uidesigner.utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlLayoutDesignActivity extends AppCompatActivity {
  public static final String EXTRA_DEMO = "EXTRA_LICENSED";
  public static final String EXTRA_FILE = "EXTRA_FILE";
  public static final String EXTRA_LANGUAGE = "EXTRA_LANGUAGE";
  public static final String EXTRA_STANDALONE = "EXTRA_STANDALONE";
  public static final String EXTRA_TRAINER = "EXTRA_TRAINER";
  private static final int DARK = 3;
  private static final int DARK_SMALL = 1;
  private static final String EXTRA_TRAINER_ACTION = "EXTRA_TRAINER_ACTION";
  private static final String EXTRA_TRAINER_BUTTON = "EXTRA_TRAINER_BUTTON";
  private static final String EXTRA_TRAINER_HEADER = "EXTRA_HEADER";
  private static final String EXTRA_TRAINER_LOCALE = "EXTRA_TRAINER_LOCALE";
  private static final String EXTRA_TRAINER_RUN_BUTTON = "EXTRA_TRAINER_RUN_BUTTON";
  private static final String EXTRA_TRAINER_SOUND = "EXTRA_TRAINER_SOUND";
  private static final String EXTRA_TRAINER_SPEAK = "EXTRA_TRAINER_SPEAK";
  private static final String EXTRA_TRAINER_TASK = "EXTRA_TRAINER_TASK";
  private static final String EXTRA_TRAINER_TITLE = "EXTRA_TRAINER_TITILE";
  private static final int LIGHT = 2;
  private static final int LIGHT_SMALL = 0;
  private static final String PREF_XMLDESIGNER_EDITMODE = "PREF_XMLDESIGNER_EDITMODE";
  private static final String PREF_XMLDESIGNER_FILE = "PREF_XMLDESIGNER_FILE";
  private static final String PREF_XMLDESIGNER_VIEW = "XMLDESIGNER_VIEW";
  private LinearLayout containerView;
  private LinearLayout contentView;
  private ActionBarDrawerToggle drawerToggle;
  private XmlLayoutlInflater inflater;
  private boolean initialized;
  private boolean isDefaultProject;
  private boolean isDemo;
  private boolean isStandalone;
  private String resDirPath;
  private SoundPool soundPool;
  private int taskSound;
  private TextToSpeechHelper tts;
  private UndoManager undoManager;
  private String xmlFilePath;
  private Toolbar toolbar;

  public static void show(
      Activity parent, String language, String filePath, boolean isDemo, boolean isStandalone) {
    Intent intent = new Intent(parent, XmlLayoutDesignActivity.class);
    intent.putExtra(EXTRA_FILE, filePath);
    intent.putExtra(EXTRA_LANGUAGE, language);
    intent.putExtra(EXTRA_DEMO, isDemo);
    intent.putExtra(EXTRA_STANDALONE, isStandalone);
    intent.putExtra(EXTRA_TRAINER, false);
    parent.startActivity(intent);
  }

  public static void showTrainer(
      Activity parent,
      String language,
      String filePath,
      int trainerRequestCode,
      String[] trainerHeader,
      String trainerLocale,
      String trainerTask,
      String trainerTaskTitle,
      String trainerButton,
      String trainerRunButton,
      boolean speak,
      boolean sound) {
    Intent intent = new Intent(parent, XmlLayoutDesignActivity.class);
    intent.putExtra(EXTRA_FILE, filePath);
    intent.putExtra(EXTRA_LANGUAGE, language);
    intent.putExtra(EXTRA_DEMO, false);
    intent.putExtra(EXTRA_STANDALONE, false);
    intent.putExtra(EXTRA_TRAINER, true);
    intent.putExtra(EXTRA_TRAINER_SOUND, sound);
    intent.putExtra(EXTRA_TRAINER_TASK, trainerTask);
    intent.putExtra(EXTRA_TRAINER_TITLE, trainerTaskTitle);
    intent.putExtra(EXTRA_TRAINER_BUTTON, trainerButton);
    intent.putExtra(EXTRA_TRAINER_HEADER, trainerHeader);
    intent.putExtra(EXTRA_TRAINER_LOCALE, trainerLocale);
    intent.putExtra(EXTRA_TRAINER_SPEAK, speak);
    intent.putExtra(EXTRA_TRAINER_RUN_BUTTON, trainerRunButton);
    parent.startActivityForResult(intent, trainerRequestCode);
  }

  public static boolean resultContinue(@NonNull Intent data) {
    return data.getIntExtra(EXTRA_TRAINER_ACTION, 0) == 1;
  }

  public static boolean resultRun(@NonNull Intent data) {
    return data.getIntExtra(EXTRA_TRAINER_ACTION, 0) == 2;
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == -1 && requestCode == 3424345) {
      XmlLayoutPropertyEditor.addImageFromPicker(this, data);
    }
  }

  public void gotoSourceCode(int sourceLine, int sourceColumn) {
    ActivityStarter.navigateTo(this, xmlFilePath, sourceLine);
  }

  public void showHelp(String helpUrl) {
    HelpActivityStarter.showHelp(this, "https://developer.android.com/reference/" + helpUrl);
  }

  @SuppressLint("ResourceType")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    this.initialized = false;
    AndroidHelper.switchLanguage(this, getIntent().getStringExtra(EXTRA_LANGUAGE));
    getWindow().setSoftInputMode(2);
    AndroidHelper.forceOptionsMenuButton(this);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.designer);
    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    setTitle("Ghost ide Layout editor");
    AndroidHelper.makeToolbarFocusable(this);
    if (!isTrainer()) {
      AndroidHelper.setAndroidTVPadding(findViewById(R.id.designerFrame));
    }
    if (isTrainer() && AndroidHelper.isAndroidTV(this)) {
      getSupportActionBar().hide();
    }
    // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    if (isTrainer()) {
      TrainerLogo.set(
          getSupportActionBar(),
          R.drawable.ic_android,
          getIntent().getStringArrayExtra(EXTRA_TRAINER_HEADER));
    } else {
      DrawerLayout drawerLayout = findViewById(R.id.designerDrawer);
      this.drawerToggle =
          new ActionBarDrawerToggle(
              this,
              drawerLayout,
              // R.drawable.round_menu_24,
              R.string.add__,
              R.string.add__);
      drawerLayout.setDrawerListener(this.drawerToggle);
    }
    if (isTrainer()) {
      final View header = findViewById(R.id.designerHeaderLearnTask);
      header.setVisibility(0);
      TextView textView = header.findViewById(R.id.designerHeaderLearnTaskText);
      TextView titleView = header.findViewById(R.id.designerHeaderLearnTaskTitle);
      final TextView button = header.findViewById(R.id.designerHeaderLearnButton);
      titleView.setText(getIntent().getStringExtra(EXTRA_TRAINER_TITLE));
      textView.setText(Html.fromHtml(getIntent().getStringExtra(EXTRA_TRAINER_TASK)));
      button.setText(getIntent().getStringExtra(EXTRA_TRAINER_BUTTON));
      titleView.setTextSize(AndroidHelper.getTrainerHeaderFontSize(this));
      textView.setTextSize(AndroidHelper.getTrainerTextFontSize(this));
      button.setTextSize(AndroidHelper.getTrainerButtonFontSize(this));
      final TranslateAnimation anim =
          new TranslateAnimation(
              0.0f, 0.0f, -(150.0f * getResources().getDisplayMetrics().density), 0.0f) {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
              super.applyTransformation(interpolatedTime, t);
              header.invalidate();
            }
          };
      anim.setDuration(500);
      header.setVisibility(4);
      findViewById(R.id.designerHeaderLearnTaskInner)
          .setOnClickListener(
              v -> {
                Intent data = new Intent();
                data.putExtra(XmlLayoutDesignActivity.EXTRA_TRAINER_ACTION, 1);
                setResult(-1, data);
                finish();
              });
      findViewById(R.id.designerHeaderLearnTaskInner)
          .setOnFocusChangeListener(
              (v, hasFocus) -> {
                if (hasFocus) {
                  ScaleAnimation anim2 =
                      new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.0f, 1, 0.5f);
                  anim2.setDuration(400);
                  anim2.setFillAfter(true);
                  button.startAnimation(anim2);
                  return;
                }
                ScaleAnimation anim3 = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.0f, 1, 0.5f);
                anim3.setDuration(400);
                anim3.setFillAfter(true);
                button.startAnimation(anim3);
              });
      if (isFullscreenTrainerLayout()) {
        float density = getResources().getDisplayMetrics().density;
        findViewById(R.id.designerHeaderLearnTaskInner)
            .setPadding(
                (int) (48.0f * density), (int) (27.0f * density), (int) (48.0f * density), 0);
        findViewById(R.id.designerContent)
            .setPadding(
                (int) (48.0f * density), 0, (int) (48.0f * density), (int) (27.0f * density));
      }
      header.postDelayed(
          () -> {
            speak();
            header.setVisibility(0);
            header.startAnimation(anim);
          },
          500);
    } else {
      findViewById(R.id.designerHeaderLearnTask).setVisibility(8);
    }
    this.contentView = new LinearLayout(this);
    ((ViewGroup) findViewById(R.id.designerContent)).addView(this.contentView);
    this.contentView.setClipChildren(false);
    this.contentView.setGravity(17);
    this.containerView = new LinearLayout(this);
    this.contentView.addView(this.containerView);
    this.containerView.setClipChildren(false);
    this.containerView.setGravity(17);
    ((ListView) findViewById(R.id.designerViewList))
        .setOnItemClickListener(
            (parent, view, position, id) -> {
              ViewHierachyEntry entry = (ViewHierachyEntry) parent.getItemAtPosition(position);
              if (entry.view != null) {
                onViewClicked(entry.view);
              } else if (entry.file != null) {
                openLayout(entry.file.getPath());
              } else if (entry.isAddButton) {
                createNewLayout();
              }
            });
    initFromIntent(savedInstanceState == null);
    if (savedInstanceState != null) {
      this.undoManager.load(savedInstanceState);
    }
    configureBorderView();
    this.initialized = true;
  }

  protected void speak() {
    if (getIntent().getBooleanExtra(EXTRA_TRAINER_SPEAK, false)) {
      this.tts = new TextToSpeechHelper(this);
      this.tts.speak(
          getIntent().getStringExtra(EXTRA_TRAINER_LOCALE),
          getIntent().getStringExtra(EXTRA_TRAINER_TASK));
    }
    if (getIntent().getBooleanExtra(EXTRA_TRAINER_SOUND, false)) {
      this.soundPool = new SoundPool(1, 3, 0);
      this.taskSound = this.soundPool.load(this, R.raw.task, 1);
      this.soundPool.play(this.taskSound, 1.0f, 1.0f, 0, 0, 1.0f);
    }
  }

  private boolean isFullscreenTrainerLayout() {
    return AndroidHelper.isAndroidTV(this) && isTrainer();
  }

  private boolean isTrainer() {
    return getIntent().getBooleanExtra(EXTRA_TRAINER, false);
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    if (this.drawerToggle != null) {
      this.drawerToggle.syncState();
    }
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    if (this.drawerToggle != null) {
      this.drawerToggle.onConfigurationChanged(newConfig);
    }
    configureBorderView();
  }

  @Override
  protected void onSaveInstanceState(Bundle bundle) {
    super.onSaveInstanceState(bundle);
    if (this.undoManager != null) {
      this.undoManager.save(bundle);
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (this.undoManager != null && this.inflater != null) {
      this.undoManager.removeListener(this.inflater);
    }
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  private void configureBorderView() {
    switch (getViewType()) {
      case 0:
      case 1:
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        float density = getResources().getDisplayMetrics().density;
        this.containerView.setLayoutParams(
            new LinearLayout.LayoutParams(
                Math.min((int) (300.0f * density), (int) (((double) screenWidth) * 0.8d)),
                Math.min((int) (500.0f * density), (int) (((double) screenHeight) * 0.8d))));
        this.inflater.setShowBorder(true);
        return;
      default:
        this.containerView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.inflater.setShowBorder(false);
        return;
    }
  }

  @Override
  public void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    setIntent(intent);
    if ((intent.getFlags() & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) == 0) {
      initFromIntent(false);
    }
  }

  @SuppressLint("WrongConstant")
  private void initFromIntent(boolean isNewStart) {
    boolean z;
    Intent intent = getIntent();
    Bundle extras = intent.getExtras();
    this.isDemo = extras != null && extras.getBoolean(EXTRA_DEMO, false);
    z = extras == null || extras.getBoolean(EXTRA_STANDALONE, true);
    this.isStandalone = z;
    if (!this.isStandalone) {
      this.xmlFilePath = extras.getString(EXTRA_FILE);
      this.resDirPath = new File(this.xmlFilePath).getParentFile().getParentFile().getPath();
      this.isDefaultProject = false;
    } else if (extras != null
        && "android.intent.action.SEND".equals(intent.getAction())
        && (extras.get("android.intent.extra.STREAM") instanceof Uri)) {
      Uri uri = (Uri) extras.get("android.intent.extra.STREAM");
      this.resDirPath = getDefaultResDirPath();
      this.isDefaultProject = true;
      this.xmlFilePath = createNewLayoutFile(this.resDirPath, getRealFileNameFromUri(this, uri));
      setLastFilepath(this.xmlFilePath);
      try {
        Utils.transfer(
            getContentResolver().openInputStream(uri), new FileOutputStream(this.xmlFilePath));
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (extras != null
        && "android.intent.action.SEND".equals(intent.getAction())
        && extras.getString("android.intent.extra.TEXT") != null) {
      this.resDirPath = getDefaultResDirPath();
      this.isDefaultProject = true;
      this.xmlFilePath =
          createNewLayoutFile(
              this.resDirPath,
              suggestNewLayoutName(this.resDirPath),
              extras.getString("android.intent.extra.TEXT"));
      setLastFilepath(this.xmlFilePath);
    } else if (intent.getData() == null || intent.getData().getPath() == null) {
      this.resDirPath = getDefaultResDirPath();
      this.isDefaultProject = true;
      this.xmlFilePath = getLastFilepath();
      if (this.xmlFilePath == null || !new File(this.xmlFilePath).exists()) {
        this.xmlFilePath = chooseLayoutOrCreateNew(this.resDirPath);
        setLastFilepath(this.xmlFilePath);
      }
    } else {
      this.xmlFilePath = intent.getData().getPath();
      this.resDirPath = new File(this.xmlFilePath).getParentFile().getParentFile().getPath();
      this.isDefaultProject = false;
    }
    if (this.isStandalone && isNewStart) {
      ((DrawerLayout) findViewById(R.id.designerDrawer)).openDrawer(3);
    }
    createInflater();
  }

  public void createInflater() {
    this.undoManager = new UndoManager();
    this.inflater =
        new XmlLayoutlInflater(
            this.containerView, this.xmlFilePath, this.resDirPath, this.undoManager) {
          private boolean isFirstEdit = true;

          @Override
          protected void onViewClicked(XmlLayoutEditView editView) {
            XmlLayoutDesignActivity.this.onViewClicked(editView);
          }

          @Override
          protected void onEmptyLayoutClicked() {
            XmlLayoutWidgetPicker.selectRootView(
                XmlLayoutDesignActivity.this,
                getString(R.string.add_),
                widget -> inflater.addView(widget));
          }

          @Override
          protected void onXmlModified(boolean isUserEdit) {
            invalidateOptionsMenu();
            if (isDemo) {
              if (isUserEdit && this.isFirstEdit) {
                this.isFirstEdit = false;
                ShopActivityStarter.show(
                    XmlLayoutDesignActivity.this,
                    0,
                    "unlock the UI designer",
                    "savechanges",
                    true,
                    true,
                    false,
                    true,
                    false);
              }
            } else if (xmlFilePath != null) {
              try {
                FileWriter writer = new FileWriter(xmlFilePath);
                writer.write(inflater.getXml());
                writer.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
          }

          @Override
          protected void onInflated() {
            contentView.invalidate();
            if (getEditViews().size() > 0) {
              getEditViews().get(0).requestFocus();
            }
            updateHierachy();
          }
        };
    this.inflater.init();
    this.inflater.setEditMode(isEditMode());
    invalidateOptionsMenu();
  }

  public void updateHierachy() {
    List<ViewHierachyEntry> entries = new ArrayList<>();
    if (this.isStandalone) {
      for (File f : Utils.findLayoutFiles(this.resDirPath)) {
        entries.add(new ViewHierachyEntry(f));
      }
      entries.add(new ViewHierachyEntry(true));
    } else {
      entries.add(new ViewHierachyEntry(new File(this.xmlFilePath)));
    }
    for (XmlLayoutEditView view : this.inflater.getEditViews()) {
      entries.add(new ViewHierachyEntry(view));
    }
    ListView viewList = findViewById(R.id.designerViewList);
    ViewHierachyEntryAdapter adapter = (ViewHierachyEntryAdapter) viewList.getAdapter();
    if (adapter == null) {
      viewList.setAdapter(new ViewHierachyEntryAdapter(this, entries));
      return;
    }
    adapter.clear();
    for (ViewHierachyEntry entry : entries) {
      adapter.add(entry);
    }
  }

  public void onViewClicked(XmlLayoutEditView editView) {
    XmlLayoutEditViewMenu.showViewEditMenu(this, editView);
  }

  @Override
  protected Dialog onCreateDialog(int id, Bundle args) {
    return MessageBox.onCreateDialog(this, id);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.designer_options_menu, menu);
    return true;
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    super.onPrepareOptionsMenu(menu);
    menu.findItem(R.id.designerMenuRun).setVisible(isTrainer());
    menu.findItem(R.id.designerMenuRun)
        .setTitle(getIntent().getStringExtra(EXTRA_TRAINER_RUN_BUTTON));
    menu.findItem(R.id.designerMenuHideBorders).setVisible(!isTrainer() && isEditMode());

    MenuItem findItem = menu.findItem(R.id.designerMenuShowBorders);
    findItem.setVisible(!isTrainer() && !isEditMode());

    menu.findItem(R.id.designerMenuUndo).setEnabled(this.undoManager.canUndo());
    menu.findItem(R.id.designerMenuRedo).setEnabled(this.undoManager.canRedo());
    menu.findItem(R.id.designerMenuPaste).setEnabled(this.inflater.canPaste());

    MenuItem findItem2 = menu.findItem(R.id.designerMenuPaste);
    findItem2.setVisible(!isTrainer());

    MenuItem findItem3 = menu.findItem(R.id.designerMenuCopy);
    findItem3.setEnabled(!this.isDemo && this.inflater.getXml().length() > 0);

    MenuItem findItem4 = menu.findItem(R.id.designerMenuCopy);
    findItem4.setVisible(!isTrainer());

    MenuItem findItem5 = menu.findItem(R.id.designerMenuShare);
    findItem5.setEnabled(!this.isDemo && this.inflater.getXml().length() > 0);

    MenuItem findItem6 = menu.findItem(R.id.designerMenuShare);
    findItem6.setVisible(!isTrainer());
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (this.drawerToggle != null && this.drawerToggle.onOptionsItemSelected(item)) {
      return true;
    }
    if (item.getItemId() == 16908332) {
      finish();
    } else if (item.getItemId() == R.id.designerMenuRun) {
      Intent data = new Intent();
      data.putExtra(EXTRA_TRAINER_ACTION, 2);
      setResult(-1, data);
      finish();
    } else if (item.getItemId() == R.id.designerMenuShowBorders) {
      setEditMode(true);
    } else if (item.getItemId() == R.id.designerMenuHideBorders) {
      setEditMode(false);
    } else if (item.getItemId() == R.id.designerMenuUndo) {
      this.undoManager.undo();
    } else if (item.getItemId() == R.id.designerMenuRedo) {
      this.undoManager.redo();
    } else if (item.getItemId() == R.id.designerMenuPaste) {
      this.inflater.paste();
    } else if (item.getItemId() == R.id.designerMenuCopy) {
      this.inflater.copy();
    } else if (item.getItemId() == R.id.designerMenuShare) {
      this.inflater.share();
    }
    return false;
  }

  public void deleteLayout(final String filepath) {
    MessageBox.queryYesNo(
        this,
        getString(R.string.delete_layout) + new File(filepath).getName(),
        getString(R.string.really_delete_this_layout),
        () -> {
          new File(filepath).delete();
          if (xmlFilePath.equals(filepath)) {
            xmlFilePath = chooseLayoutOrCreateNew(resDirPath);
            if (isDefaultProject) {
              setLastFilepath(xmlFilePath);
            }
            createInflater();
            return;
          }
          updateHierachy();
        },
        null);
  }

  public void createNewLayout() {
    MessageBox.queryText(
        this,
        getString(R.string.new_layout),
        getString(R.string.file_name_),
        suggestNewLayoutName(this.resDirPath),
        name -> {
          setEditMode(true);
          xmlFilePath = createNewLayoutFile(resDirPath, name);
          if (isDefaultProject) {
            setLastFilepath(xmlFilePath);
          }
          createInflater();
        });
  }

  protected void openLayout(String filepath) {
    this.xmlFilePath = filepath;
    if (this.isDefaultProject) {
      setLastFilepath(this.xmlFilePath);
    }
    createInflater();
  }

  private boolean isEditMode() {
    if (isTrainer()) {
      return true;
    }
    return getPreferences().getBoolean(PREF_XMLDESIGNER_EDITMODE, true);
  }

  public void setEditMode(boolean editMode) {
    SharedPreferences.Editor editor = getPreferences().edit();
    editor.putBoolean(PREF_XMLDESIGNER_EDITMODE, editMode);
    editor.apply();
    invalidateOptionsMenu();
    this.inflater.setEditMode(editMode);
    configureBorderView();
    this.contentView.invalidate();
  }

  public int getViewType() {
    if (isTrainer()) {
      return 2;
    }
    return getPreferences().getInt(PREF_XMLDESIGNER_VIEW, 0);
  }

  public void setViewType(int view) {
    SharedPreferences.Editor editor = getPreferences().edit();
    editor.putInt(PREF_XMLDESIGNER_VIEW, view);
    editor.apply();
    recreate();
  }

  private SharedPreferences getPreferences() {
    return getSharedPreferences("UIDesigner", 0);
  }

  private String getLastFilepath() {
    return getPreferences().getString(PREF_XMLDESIGNER_FILE, null);
  }

  public void setLastFilepath(String filepath) {
    SharedPreferences.Editor editor = getPreferences().edit();
    editor.putString(PREF_XMLDESIGNER_FILE, filepath);
    editor.apply();
  }

  public static class ViewHierachyEntry {
    public File file;
    public boolean isAddButton;
    public XmlLayoutEditView view;

    public ViewHierachyEntry(File file) {
      this.file = file;
    }

    public ViewHierachyEntry(boolean isAddButton) {
      this.isAddButton = true;
    }

    public ViewHierachyEntry(XmlLayoutEditView view) {
      this.view = view;
    }
  }

  public class ViewHierachyEntryAdapter extends ArrayAdapter<ViewHierachyEntry> {

    public ViewHierachyEntryAdapter(Context context, List<ViewHierachyEntry> views) {
      super(context, R.layout.designer_viewlist_entry, views);
    }

    @SuppressLint({"WrongConstant", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      int i;
      View view = convertView;
      if (view == null) {
        view =
            LayoutInflater.from(getContext())
                .inflate(R.layout.designer_viewlist_entry, parent, false);
      }
      final ViewHierachyEntry entry = getItem(position);
      LinearLayout viewLayout = view.findViewById(R.id.designerViewlistentryViewLayout);
      LinearLayout fileLayout = view.findViewById(R.id.designerViewlistentryFileLayout);
      if (entry.view != null) {
        viewLayout.setVisibility(View.VISIBLE);
        fileLayout.setVisibility(8);
        viewLayout.setPadding(
            (int)
                (((float) ((entry.view.getDepth() * 20) + 5))
                    * getContext().getResources().getDisplayMetrics().density),
            0,
            0,
            0);

        TextView tv = view.findViewById(R.id.designerViewlistEntryName);
        ImageView imageView = view.findViewById(R.id.designerViewlistEntryImage);
        if (entry.view.canAddInside()) {
          i = R.drawable.ic_category;
          ColorMaterial.unserLineTextView(tv, entry.view.getNodeName());
        } else {
          i = R.drawable.ic_widgets;
          tv.setText(entry.view.getNodeName());
        }
        imageView.setImageResource(i);
        ColorMaterial.init(imageView, tv);
      } else if (entry.file != null) {
        viewLayout.setVisibility(View.GONE);
        fileLayout.setVisibility(View.VISIBLE);
        fileLayout.setPadding(0, 0, 0, 0);
        RadioButton fileRadioButton = view.findViewById(R.id.designerViewlistentryFileRadioButton);
        fileRadioButton.setFocusable(false);
        fileRadioButton.setFocusableInTouchMode(false);
        fileRadioButton.setChecked(xmlFilePath.equals(entry.file.getPath()));
        fileRadioButton.setVisibility(isStandalone ? View.VISIBLE : View.GONE);
        TextView fileNameView = view.findViewById(R.id.designerViewlistentryFileName);
        fileNameView.setText(entry.file.getName());
        if (xmlFilePath.equals(entry.file.getPath())) {
          fileNameView.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
          fileNameView.setTypeface(Typeface.DEFAULT);
        }
        ((ImageView) view.findViewById(R.id.designerViewlistFileImage))
            .setImageResource(R.drawable.ic_file);
        ImageView deleteButton = view.findViewById(R.id.designerViewlistentryDelete);
        deleteButton.setVisibility(isStandalone ? View.VISIBLE : View.GONE);
        deleteButton.setOnClickListener(v -> deleteLayout(entry.file.getPath()));
      } else {
        viewLayout.setVisibility(View.GONE);
        fileLayout.setVisibility(View.VISIBLE);
        fileLayout.setPadding(
            0, 0, 0, (int) (10.0f * getContext().getResources().getDisplayMetrics().density));
        RadioButton fileRadioButton2 = view.findViewById(R.id.designerViewlistentryFileRadioButton);
        fileRadioButton2.setFocusable(false);
        fileRadioButton2.setFocusableInTouchMode(false);
        fileRadioButton2.setVisibility(View.INVISIBLE);
        TextView fileNameView2 = view.findViewById(R.id.designerViewlistentryFileName);
        fileNameView2.setText(R.string.new_layout_);
        fileNameView2.setTypeface(Typeface.DEFAULT);
        ((ImageView) view.findViewById(R.id.designerViewlistFileImage))
            .setImageResource(AndroidHelper.obtainImageResourceId(getContext(), R.attr.icon_add));
        view.findViewById(R.id.designerViewlistentryDelete).setVisibility(8);
      }
      return view;
    }
  }
}
