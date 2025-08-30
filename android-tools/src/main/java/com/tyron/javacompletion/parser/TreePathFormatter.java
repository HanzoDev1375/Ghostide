package com.tyron.javacompletion.parser;

import org.openjdk.source.tree.ClassTree;
import org.openjdk.source.tree.IdentifierTree;
import org.openjdk.source.tree.MemberSelectTree;
import org.openjdk.source.tree.MethodTree;
import org.openjdk.source.tree.Tree;
import org.openjdk.source.util.SimpleTreeVisitor;
import org.openjdk.source.util.TreePath;

/** A utility that converts {@link TreePath} to string for debugging. */
public class TreePathFormatter {
    private static final TreeFormattingVisitor VISITOR = new TreeFormattingVisitor();

    private TreePathFormatter() {}

    public static String formatTreePath(TreePath treePath) {
        if (treePath == null) {
            return "<empty>";
        }
        StringBuilder sb = new StringBuilder();
        formatTreePath(treePath, sb);
        sb.append("<end>");
        return sb.toString();
    }

    private static void formatTreePath(TreePath treePath, StringBuilder sb) {
        TreePath parent = treePath.getParentPath();
        if (parent != null) {
            formatTreePath(parent, sb);
        }

        Tree node = treePath.getLeaf();
        sb.append(node.accept(VISITOR, null));
        sb.append(' ');
    }

    public static class TreeFormattingVisitor extends SimpleTreeVisitor<CharSequence, Void> {
        @Override
        protected CharSequence defaultAction(Tree node, Void unused) {
            return "[" + node.getClass().getSimpleName() + "]";
        }

        @Override
        public CharSequence visitIdentifier(IdentifierTree node, Void unused) {
            return "[Identifier " + node.getName() + "]";
        }

        @Override
        public CharSequence visitMemberSelect(MemberSelectTree node, Void unused) {
            return "[MemberSelect id:" + node.getIdentifier() + "]";
        }

        @Override
        public CharSequence visitClass(ClassTree node, Void unused) {
            return formatNode(node, node.getSimpleName());
        }

        @Override
        public CharSequence visitMethod(MethodTree node, Void unused) {
            return formatNode(node, node.getName());
        }

        private static String formatNode(Tree node, CharSequence info) {
            return "[" + node.getClass().getSimpleName() + ": " + info + "]";
        }
    }
}