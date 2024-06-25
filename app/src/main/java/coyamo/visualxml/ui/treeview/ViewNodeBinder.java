package coyamo.visualxml.ui.treeview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import Ninja.coder.Ghostemane.code.R;
import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

public class ViewNodeBinder extends TreeViewBinder<ViewNodeBinder.ViewHolder> {

    @Override
    public ViewHolder provideViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public void bindView(ViewHolder holder, int position, final TreeNode node) {
        final ViewBean viewBean = (ViewBean) node.getContent();
        holder.arrow.setBackgroundResource(viewBean.getArrowId());
        // 重置旧状态
        holder.arrow.setRotation(0);
        // 设置新状态
        if (node.isExpand()) {
            holder.arrow.animate().rotationBy(90).start();
        }
        if (viewBean.isViewGroup() && !node.isLeaf()) {
            holder.arrow.setVisibility(View.VISIBLE);
        } else {
            holder.arrow.setVisibility(View.INVISIBLE);
        }
        if (viewBean.getId() != null) {
            holder.idName.setText(viewBean.getId());
            holder.tagName.setText(viewBean.getTagName());
        } else {
            holder.idName.setText(viewBean.getTagName());
            holder.tagName.setText("");
        }

        holder.icon.setBackgroundResource(viewBean.getImgId());
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_bean_item;
    }

    public class ViewHolder extends TreeViewBinder.ViewHolder {
        public ImageView arrow, icon;
        public TextView idName, tagName;

        public ViewHolder(View rootView) {
            super(rootView);
            this.arrow = findViewById(R.id.iv_arrow);
            this.icon = findViewById(R.id.iv_icon);
            this.idName = findViewById(R.id.tv_idName);
            this.tagName = findViewById(R.id.tv_tagName);
        }
    }
}
