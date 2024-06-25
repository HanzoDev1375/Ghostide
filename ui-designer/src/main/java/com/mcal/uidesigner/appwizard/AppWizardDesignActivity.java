package com.mcal.uidesigner.appwizard;

import static com.mcal.uidesigner.utils.FileHelper.readFile;
import static com.mcal.uidesigner.utils.FileHelper.writeText;
import static com.mcal.uidesigner.utils.StorageHelper.getLayoutFilePath;
import static com.mcal.uidesigner.utils.StorageHelper.getProjectFilepath;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mcal.uidesigner.R;
import com.mcal.uidesigner.appwizard.runtime.AppWizardActivity;
import com.mcal.uidesigner.appwizard.runtime.AppWizardProject;
import com.mcal.uidesigner.common.MessageBox;
import com.mcal.uidesigner.common.PositionalXMLReader;
import com.mcal.uidesigner.common.UndoManager;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AppWizardDesignActivity extends AppWizardActivity implements UndoManager.UndoRedoListener {
    private static final String APP_WIZARD_SETTINGS = "AppWizard";
    private static final String PREF_APPWIZARD_EDITMODE = "PREF_APPWIZARD_EDITMODE";
    private final AppWizardPropertiesEditor editor = new AppWizardPropertiesEditor(this);
    private boolean isInitialized;
    private UndoManager undoManager;

    public String createFragmentLayout(int id) {
        String layoutName = "fragment" + (id + 1);
        getAppActivity().getFragment(id).setLayoutNoRefresh(layoutName);
        return getLayoutFilePath(layoutName);
    }

    @Override
    public void revertToVersion(@NonNull String filepath, String content, int change) {
        final String projectFilePath = getProjectFilepath();
        if (filepath.equals(projectFilePath)) {
            try {
                writeText(projectFilePath, content);
                getProject().revertToVersion(parseXml(content), change);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void undoRedoStateChanged() {
        if (isInitialized) {
            refreshButtons();
        }
    }

    @Override
    public Document loadXml() {
        try {
            String xml = readFile(getProjectFilepath());
            undoManager.addBaseVersion(getProjectFilepath(), xml, 0);
            return parseXml(xml);
        } catch (Exception e) {
            return null;
        }
    }

    private Document parseXml(@NonNull String xml) throws IOException, SAXException {
        InputStream in = new ByteArrayInputStream(xml.getBytes());
        Document document = PositionalXMLReader.readXML(in);
        in.close();
        return document;
    }

    @Override
    public void saveXml(Document document, int change) {
        try {
            String xml = new AppWizardXmlDOMSerializer().serialize(document);
            final String projectFilePath = getProjectFilepath();
            undoManager.addVersion(projectFilePath, xml, change);
            new File(projectFilePath).getParentFile().mkdirs();
            writeText(projectFilePath, xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int inflateContentView() {
        setContentView(R.layout.appwizard);
        return R.id.appwizardContentContainer;
    }

    @Override
    protected Fragment createSectionFragment(AppWizardProject.AppFragment section) {
        return AppWizardDesignFragment.create(section);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (undoManager != null) {
            undoManager.removeListener(this);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(getPackageName(), "onCreate()");
        undoManager = new UndoManager();
        undoManager.addListener(this);
        if (savedInstanceState != null) {
            undoManager.load(savedInstanceState);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (undoManager != null) {
            undoManager.save(outState);
        }
    }

    public boolean isEditMode() {
        return getSharedPreferences(APP_WIZARD_SETTINGS, 0).getBoolean(PREF_APPWIZARD_EDITMODE, true);
    }

    public void setEditMode(boolean editMode) {
        SharedPreferences.Editor editor = getSharedPreferences(APP_WIZARD_SETTINGS, 0).edit();
        editor.putBoolean(PREF_APPWIZARD_EDITMODE, editMode);
        editor.apply();
        for (Fragment f : getSupportFragmentManager().getFragments()) {
            if (f instanceof AppWizardDesignFragment) {
                ((AppWizardDesignFragment) f).refreshEditMode();
            }
        }
        refreshButtons();
    }

    private void setEditListeners() {
        refreshButtons();
        findViewById(R.id.appwizardModeButton).setOnClickListener(p1 -> setEditMode(!isEditMode()));
        findViewById(R.id.appwizardEditButton).setOnClickListener(v -> editor.showProperties());
        findViewById(R.id.appwizardUndoButton).setOnClickListener(v -> undoManager.undo());
        findViewById(R.id.appwizardRedoButton).setOnClickListener(v -> undoManager.redo());
    }

    @SuppressLint("WrongConstant")
    private void refreshButtons() {
        ImageView modeButton = findViewById(R.id.appwizardModeButton);
        if (isEditMode()) {
            modeButton.setImageResource(R.drawable.ic_edit);
        } else {
            modeButton.setImageResource(R.drawable.ic_image);
        }
        findViewById(R.id.appwizardEditButtonLayout).setVisibility(isEditMode() ? 0 : 8);
        findViewById(R.id.appwizardUndoButton).setEnabled(undoManager.canUndo());
        findViewById(R.id.appwizardRedoButton).setEnabled(undoManager.canRedo());
    }

    @Override
    protected Dialog onCreateDialog(int id, Bundle args) {
        return MessageBox.onCreateDialog(this, id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public void refreshContent() {
        super.refreshContent();
        isInitialized = true;
        setEditListeners();
    }

    public UndoManager getUndoManager() {
        return undoManager;
    }
}
