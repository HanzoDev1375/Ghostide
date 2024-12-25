package ir.ninjacoder.ghostide.marco;

import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

public class FtpDownloader extends Thread {
    private String serverAddress;
    private int port;
    private String username;
    private String password;
    private String remoteFilePath;
    private String localFilePath;
    private ProgressListener listener;

    public FtpDownloader(String serverAddress, int port, String username, String password, String remoteFilePath,
                         String localFilePath, ProgressListener listener) {
        this.serverAddress = serverAddress;
        this.port = port;
        this.username = username;
        this.password = password;
        this.remoteFilePath = remoteFilePath;
        this.localFilePath = localFilePath;
        this.listener = listener;
    }

    @Override
    public void run() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(serverAddress, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            long fileSize = ftpClient.listFiles(remoteFilePath)[0].getSize();
            File file = new File(localFilePath);
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
            InputStream inputStream = ftpClient.retrieveFileStream(remoteFilePath);
            byte[] buffer = new byte[4096];
            long totalBytesRead = 0;
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
                int percent = (int) (totalBytesRead * 100 / fileSize);
                listener.onProgressUpdate(percent);
            }
            boolean success = ftpClient.completePendingCommand();
            outputStream.close();
            inputStream.close();

            if (success) {
                listener.onDownloadFinished();
            } else {
                listener.onError("خطا در دانلود فایل.");
            }

            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException ex) {
            listener.onError("خطا در ارتباط با سرور FTP.");
            ex.printStackTrace();
        }
    }

    public interface ProgressListener {
        void onProgressUpdate(int percent);

        void onError(String message);

        void onDownloadFinished();
    }

}
