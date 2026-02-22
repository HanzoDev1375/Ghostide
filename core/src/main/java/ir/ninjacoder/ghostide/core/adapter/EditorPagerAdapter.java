package ir.ninjacoder.ghostide.core.adapter;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.gson.Gson;
import ir.ninjacoder.ghostide.core.IdeEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ir.ninjacoder.ghostide.core.fragments.EditorFragment;
import ir.ninjacoder.ghostide.core.model.CodeEditorModel;

public class EditorPagerAdapter extends FragmentStateAdapter {

  private List<CodeEditorModel> tabs = new ArrayList<>();
  private HashMap<String, Object> themeMap;
  private OnEditorPageListener pageListener;
  private List<EditorFragment> attachedFragments = new ArrayList<>();
  private FragmentActivity activity;

  public interface OnEditorPageListener {
    void onEditorCreated(int position, EditorFragment fragment);

    void onTextChanged(int position, String path, boolean changed);

    void onErrorDetected(int position, String error);
  }

  public EditorPagerAdapter(
      @NonNull FragmentActivity fragmentActivity,
      HashMap<String, Object> theme,
      OnEditorPageListener listener) {
    super(fragmentActivity);
    this.themeMap = theme;
    this.pageListener = listener;
    this.activity = fragmentActivity;
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    String path = "";
    if (position < tabs.size()) {
      path = tabs.get(position).getPath();
    }

    String themeJson = new Gson().toJson(themeMap);
    EditorFragment fragment = EditorFragment.newInstance(path, themeJson);

    final int fragmentPosition = position;

    fragment.setEditorListener(
        new EditorFragment.OnEditorListener() {
          @Override
          public void onEditorReady(
              EditorFragment frag, IdeEditor editor) {

            attachedFragments.remove(frag);

            attachedFragments.add(frag);

            if (pageListener != null) {
              pageListener.onEditorCreated(fragmentPosition, frag);
            }
          }

          @Override
          public void onTextChanged(String path, boolean changed) {
            if (pageListener != null) {
              pageListener.onTextChanged(fragmentPosition, path, changed);
            }
          }

          @Override
          public void onErrorDetected(String error) {
            if (pageListener != null) {
              pageListener.onErrorDetected(fragmentPosition, error);
            }
          }
        });

    return fragment;
  }

  @Override
  public int getItemCount() {
    return tabs.size();
  }

  public void setTabs(List<CodeEditorModel> newTabs) {
    this.tabs = newTabs;
    attachedFragments.clear();
    
    notifyDataSetChanged();
  }

  public void updateTheme(HashMap<String, Object> newTheme) {
    this.themeMap = newTheme;
    for (EditorFragment fragment : attachedFragments) {
      if (fragment != null && fragment.isAdded()) {
        fragment.updateTheme(newTheme);
      }
    }
  }

  public EditorFragment getFragmentAt(int position) {

    if (position >= 0 && position < attachedFragments.size()) {
      EditorFragment fragment = attachedFragments.get(position);
      if (fragment != null && fragment.isAdded()) {
        return fragment;
      }
    }

    try {
      if (activity != null) {

        String tag = "f" + position;
        Fragment fragment = activity.getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment instanceof EditorFragment && fragment.isAdded()) {
          EditorFragment editorFragment = (EditorFragment) fragment;

          if (!attachedFragments.contains(editorFragment)) {

            if (position < attachedFragments.size()) {
              attachedFragments.add(position, editorFragment);
            } else {
              attachedFragments.add(editorFragment);
            }
          }
          return editorFragment;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      if (activity != null) {
        List<Fragment> fragments = activity.getSupportFragmentManager().getFragments();
        for (Fragment f : fragments) {
          if (f instanceof EditorFragment && f.isAdded() && f.getView() != null) {

            String filePath = ((EditorFragment) f).getFilePath();
            for (int i = 0; i < tabs.size(); i++) {
              if (tabs.get(i).getPath().equals(filePath)) {
                if (i == position) {

                  EditorFragment editorFragment = (EditorFragment) f;
                  if (!attachedFragments.contains(editorFragment)) {
                    attachedFragments.add(editorFragment);
                  }
                  return editorFragment;
                }
                break;
              }
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public void saveAllFiles() {
    for (EditorFragment fragment : attachedFragments) {
      if (fragment != null && fragment.isAdded() && fragment.isTextChanged()) {
        fragment.saveFile();
      }
    }
  }

  public void saveFileAt(int position) {
    EditorFragment fragment = getFragmentAt(position);
    if (fragment != null && fragment.isAdded()) {
      fragment.saveFile();
    }
  }

  public void removeFragment(EditorFragment fragment) {
    attachedFragments.remove(fragment);
  }

  @Override
  public boolean containsItem(long itemId) {
    return super.containsItem(itemId);
  }

  @Override
  public long getItemId(int position) {
    if (position < tabs.size()) {
      return tabs.get(position).getPath().hashCode();
    }
    return super.getItemId(position);
  }
}
