package io.github.rosemoe.sora.event;

import io.github.rosemoe.sora.diagnostics.Diagnostic;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.List;

public class DiagnosticsEvent extends Event {
  private final List<Diagnostic> oldDiagnostics;
  private final List<Diagnostic> newDiagnosticsEvent;

  public DiagnosticsEvent(
      CodeEditor editor, List<Diagnostic> oldDiagnostics, List<Diagnostic> newDiagnosticsEvent) {
    super(editor);
    this.oldDiagnostics = oldDiagnostics;
    this.newDiagnosticsEvent = newDiagnosticsEvent;
  }

  public List<Diagnostic> getOldDiagnostics() {
    return oldDiagnostics;
  }

  public List<Diagnostic> getNewDiagnosticsEvent() {
    return newDiagnosticsEvent;
  }
}
