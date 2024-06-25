package Ninja.coder.Ghostemane.code.marco;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ProgressMonitor;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
code by ninja
this code using ful to Ghost web ide
dont share in code to other app...

*/

public class CloneRepository {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private File directory;
    private Git git = null;
    private String urlName;

    public void setDirectory(File directory) {
        this.directory = directory;
    }

    public void setUrl(String urlName) {
        this.urlName = urlName;
    }

    public void cloneRp(OnGitChange gitChange) {
        executor.execute(
                () -> {
                    try {
                        String url = urlName.trim();
                        if (!url.endsWith(".git")) {
                            url += ".git";
                        }
                        File output = new File(directory, extractRepositoryNameFromURL(urlName));
                        if (output.exists() && output.isDirectory()) {
                            Log.e(
                                    "CloneRepository",
                                    "Directory already exists: ".concat(output.getAbsolutePath()));
                        } else {
                            git =
                                    Git.cloneRepository()
                                            .setURI(url)
                                            .setDirectory(output)
                                            .setProgressMonitor(
                                                    new ProgressMonitor() {
                                                        @Override
                                                        public void start(int arg0) {
                                                            Log.e("start" + arg0, "");
                                                            gitChange.Start();
                                                        }

                                                        @Override
                                                        public void beginTask(
                                                                String arg0, int arg1) {
                                                            Log.e("beginTask ", arg0);
                                                            gitChange.BindTask(arg0, arg1);
                                                        }

                                                        @Override
                                                        public void update(int arg0) {
                                                            Log.e("Update", "" + arg0);
                                                            gitChange.UploadData(arg0);
                                                        }

                                                        @Override
                                                        public void endTask() {
                                                            gitChange.EndTask();
                                                        }

                                                        @Override
                                                        public boolean isCancelled() {
                                                            return false;
                                                        }

                                                        @Override
                                                        public void showDuration(boolean arg0) {
                                                        }
                                                    })
                                            .call();
                        }

                    } catch (GitAPIException e) {
                        e.printStackTrace();
                    }
                });
    }

    private String extractRepositoryNameFromURL(String url) {
        String repositoryName = "";
        int lastSlashIndex = url.lastIndexOf("/");

        if (lastSlashIndex >= 0 && lastSlashIndex < url.length() - 1) {
            repositoryName = url.substring(lastSlashIndex + 1);

            if (repositoryName.endsWith(".git")) {
                repositoryName = repositoryName.substring(0, repositoryName.length() - 4);
            }
        }

        return repositoryName;
    }

    public interface OnGitChange {
        public void Start();

        public void BindTask(String string, int i);

        public void UploadData(int upload);

        public void EndTask();
    }
}