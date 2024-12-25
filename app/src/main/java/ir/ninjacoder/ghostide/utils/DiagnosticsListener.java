package ir.ninjacoder.ghostide.utils;

import ir.ninjacoder.ghostide.databin.DiagnosticWrapper;
import java.util.List;

public interface DiagnosticsListener {

  void onDiagnosticsUpdate(List<DiagnosticWrapper> diagnostics);
}
