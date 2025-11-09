package io.github.rosemoe.sora.widget.commentRule;

import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.text.Cursor;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.PluginManager.Plugin;
import ir.ninjacoder.ghostide.PluginManager.PluginFactory;
import ninja.coder.codecomment.rule.CommentRule;

/*
 @see package
*/

public class CommentHelper implements PluginFactory {
  protected CodeEditor editor;
  String longCommentStart = "/*";
  String longCommentEnd = "*/";
  String longCommentHtmlStart = "<!--";
  String longCommentHtmlEnd = "-->";
  protected Plugin pl;
  protected CommentRule rule;

  public CommentHelper(CodeEditor editor) {
    this.editor = editor;
    pl = new Plugin("comment", true);
    rule = new CommentRule(editor.getContext());
    
  }

  public void MakeCommentJava() {
    try {
      int leftLine = editor.getCursor().getLeftLine();
      int leftColumn = editor.getCursor().getLeftColumn();
      editor.getText().insert(leftLine, leftColumn, rule.getJavaStart());
      int rightLine = editor.getCursor().getRightLine();
      int rightColumn = editor.getCursor().getRightColumn();
      editor.getText().insert(rightLine, rightColumn, rule.getJavaEnd());
      // editor.selectAll();
    } catch (Exception err) {
      err.printStackTrace();
    }
  }

  public void MakeCommentHtml() {
    try {
      int leftLine = editor.getCursor().getLeftLine();
      int leftColumn = editor.getCursor().getLeftColumn();
      editor.getText().insert(leftLine, leftColumn, rule.getHtmlStart());
      int rightLine = editor.getCursor().getRightLine();
      int rightColumn = editor.getCursor().getRightColumn();
      editor.getText().insert(rightLine, rightColumn, rule.getHtmlEnd());
      //	editor.selectAll();
    } catch (Exception err) {
      err.printStackTrace();
    }
  }

  public void CustomComment(String start, String end) {
    try {
      int leftLine = editor.getCursor().getLeftLine();
      int leftColumn = editor.getCursor().getLeftColumn();
      editor.getText().insert(leftLine, leftColumn, start);
      int rightLine = editor.getCursor().getRightLine();
      int rightColumn = editor.getCursor().getRightColumn();
      editor.getText().insert(rightLine, rightColumn, end);
      // editor.selectAll();
    } catch (Exception err) {
      err.printStackTrace();
    }
  }
  @Deprecated
  public void AutoRun() {
    
  }

  public void unComment() {
    Content text = editor.getText();
    Cursor cursor = editor.getCursor();
    for (int line = cursor.getLeftLine(); line <= cursor.getRightLine(); line++) {
      String lb = text.getLineString(line);
      if (lb.trim().startsWith(rule.getJavaNormal())) {
        int cd = lb.indexOf(rule.getJavaNormal());
        text.delete(line, cd, line, cd + 2);
      }
    }
  }

  public void onComment(String start, String end) {
    Content text = editor.getText();
    Cursor cursor = editor.getCursor();
    for (int line = cursor.getLeftLine(); line <= cursor.getRightLine(); line++) {
      String string = text.getLineString(line);
      if (string.trim().startsWith(start) && string.trim().endsWith(end)) {
        int str = string.indexOf(start);
        int ends = string.indexOf(end);
        text.delete(line, str, line, ends);
      }
    }
  }

  @Override
  public void getName(String name, boolean show) {
  }
}
