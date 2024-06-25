package com.mcal.uidesigner.appwizard;

import static com.mcal.uidesigner.utils.FileHelper.writeText;
import static com.mcal.uidesigner.utils.StorageHelper.getLayoutFilePath;
import static com.mcal.uidesigner.utils.StorageHelper.getResDirPath;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mcal.uidesigner.R;
import com.mcal.uidesigner.XmlLayoutEditView;
import com.mcal.uidesigner.XmlLayoutEditViewMenu;
import com.mcal.uidesigner.XmlLayoutWidgetPicker;
import com.mcal.uidesigner.XmlLayoutlInflater;
import com.mcal.uidesigner.appwizard.runtime.AppWizardProject;
import com.mcal.uidesigner.common.UndoManager;

public class AppWizardDesignFragment extends Fragment {
    private static final String ARG_SECTION_ID = "ARG_SECTION_ID";
    private static final String ARG_SECTION_LAYOUT = "ARG_SECTION_LAYOUT";
    private static final String ARG_SECTION_TITLE = "ARG_SECTION_TITLE";
    private XmlLayoutlInflater inflater;

    @NonNull
    public static AppWizardDesignFragment create(@NonNull AppWizardProject.AppFragment section) {
        AppWizardDesignFragment fragment = new AppWizardDesignFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, section.getTitle());
        args.putString(ARG_SECTION_LAYOUT, section.getLayout());
        args.putInt(ARG_SECTION_ID, section.getId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup content = (ViewGroup) layoutInflater.inflate(R.layout.appwizard_section, container, false);
        ViewGroup layoutContainer = content.findViewById(R.id.appwizardSectionContainer);
        content.setClipChildren(false);
        final int sectionId = getArguments().getInt(ARG_SECTION_ID);
        String resDirPath = getResDirPath();
        String xmlFilePath = getLayoutFilePath(getArguments().getString(ARG_SECTION_LAYOUT));
        if (!(getUndoManager() == null || inflater == null)) {
            getUndoManager().removeListener(inflater);
        }
        inflater = new XmlLayoutlInflater(layoutContainer, xmlFilePath, resDirPath, getUndoManager()) {
            @Override
            protected void onEmptyLayoutClicked() {
                XmlLayoutWidgetPicker.selectRootView(getActivity(), "Add...", widget -> inflater.addView(widget));
            }

            @Override
            protected void onViewClicked(XmlLayoutEditView editView) {
                XmlLayoutEditViewMenu.showViewEditMenu(getActivity(), editView);
            }

            @Override
            protected void onXmlModified(boolean isUserEdit) {
                if (inflater.getXmlFilePath() == null) {
                    inflater.setXmlFilePath(getDesignActivity().createFragmentLayout(sectionId));
                }
                writeText(inflater.getXmlFilePath(), inflater.getXml());
            }

            @Override
            protected void onInflated() {
            }
        };
        inflater.init();
        inflater.setShowBorder(false);
        refreshEditMode();
        return content;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getUndoManager() != null && inflater != null) {
            getUndoManager().removeListener(inflater);
        }
    }

    private UndoManager getUndoManager() {
        return getDesignActivity().getUndoManager();
    }

    public AppWizardDesignActivity getDesignActivity() {
        return (AppWizardDesignActivity) getActivity();
    }

    public void refreshEditMode() {
        inflater.setEditMode(getDesignActivity().isEditMode());
    }
}
