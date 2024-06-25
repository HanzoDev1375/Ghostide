package Ninja.coder.Ghostemane.code.utils;

import Ninja.coder.Ghostemane.code.databin.DiagnosticWrapper;
import java.util.List;

public interface DiagnosticsListener {

  void onDiagnosticsUpdate(List<DiagnosticWrapper> diagnostics);
}
