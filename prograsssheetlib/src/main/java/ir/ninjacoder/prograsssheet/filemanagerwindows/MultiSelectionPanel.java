package ir.ninjacoder.prograsssheet.filemanagerwindows;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import ir.ninjacoder.prograsssheet.R;

public class MultiSelectionPanel {

  public interface PanelActionListener {
    void onCopyClicked(List<FileModel> selectedFiles);

    void onCutClicked(List<FileModel> selectedFiles);

    void onDeleteClicked(List<FileModel> selectedFiles);

    void onPasteClicked();

    void onCloseClicked();
  }

  private View panelView;
  private TextView txtCount;
  private ImageView btnCopy, btnCut, btnDelete, btnPaste, btnClose;
  private PanelActionListener listener;
  private FileModelAdapter adapter;

  public MultiSelectionPanel(
      View panelView, FileModelAdapter adapter, PanelActionListener listener) {
    this.panelView = panelView;
    this.adapter = adapter;
    this.listener = listener;

    this.txtCount = panelView.findViewById(R.id.txt_selected_count);
    this.btnCopy = panelView.findViewById(R.id.btn_copy);
    this.btnCut = panelView.findViewById(R.id.btn_cut);
    this.btnDelete = panelView.findViewById(R.id.btn_delete);
    this.btnPaste = panelView.findViewById(R.id.btn_paste);
    this.btnClose = panelView.findViewById(R.id.btn_close);

    setupClicks();
    setupAdapterListener();
  }

  private void setupClicks() {
    btnCopy.setOnClickListener(
        v -> {
          if (listener != null) listener.onCopyClicked(adapter.getSelectedFiles());
          adapter.clearSelection();
          panelView.setVisibility(View.VISIBLE);
        });

    btnCut.setOnClickListener(
        v -> {
          if (listener != null) listener.onCutClicked(adapter.getSelectedFiles());
          adapter.clearSelection();
          panelView.setVisibility(View.VISIBLE);
        });

    btnDelete.setOnClickListener(
        v -> {
          if (listener != null) listener.onDeleteClicked(adapter.getSelectedFiles());
          adapter.clearSelection();
          panelView.setVisibility(View.GONE);
        });

    btnPaste.setOnClickListener(
        v -> {
          if (listener != null) listener.onPasteClicked();
          adapter.clearSelection();
          panelView.setVisibility(View.GONE);
        });

    btnClose.setOnClickListener(
        v -> {
          adapter.clearSelection();
          if (listener != null) listener.onCloseClicked();
          panelView.setVisibility(View.GONE);
        });
  }

  private void setupAdapterListener() {
    adapter.setSelectionListener(
        count -> {
          if (count > 0) {
            panelView.setVisibility(View.VISIBLE);
            if (txtCount != null) txtCount.setText(String.valueOf(count));
          } else {
            panelView.setVisibility(View.GONE);
          }
        });
  }

  public ImageView getIconCopy() {
    return this.btnCopy;
  }

  public ImageView getIconCut() {
    return this.btnCut;
  }

  public ImageView getIconDelete() {
    return this.btnDelete;
  }

  public ImageView getIconPaste() {
    return this.btnPaste;
  }

  public ImageView getIconClose() {
    return this.btnClose;
  }
}
