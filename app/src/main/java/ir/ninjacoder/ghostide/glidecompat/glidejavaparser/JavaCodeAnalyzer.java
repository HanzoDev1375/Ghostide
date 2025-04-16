package ir.ninjacoder.ghostide.glidecompat.glidejavaparser;

import java.io.File;
import java.io.IOException;

public interface JavaCodeAnalyzer {

    JavaAnalysisResult analyze(File javaFile) throws IOException;
}
