package ir.ninjacoder.ghostide.core.glidecompat.glidejavaparser;

import java.io.File;
import java.io.IOException;

public interface JavaCodeAnalyzer {

  JavaAnalysisResult analyze(File javaFile) throws IOException;
}
