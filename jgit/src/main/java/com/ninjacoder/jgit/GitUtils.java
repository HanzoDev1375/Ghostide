package com.ninjacoder.jgit;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class GitUtils {

  public static boolean isGitRepository(File folder) {
    try {
      FileRepositoryBuilder builder = new FileRepositoryBuilder();
      Repository repository =
          builder.setGitDir(new File(folder, ".git")).readEnvironment().findGitDir().build();
      return repository.getObjectDatabase().exists();
    } catch (IOException e) {
      return false;
    }
  }
}
