package Ninja.coder.Ghostemane.code.services;

import fi.iki.elonen.NanoHTTPD;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyServer extends NanoHTTPD {
    private String htmlFilePath;
    private int port;

    public MyServer(int port, String htmlFilePath) throws IOException {
        super(port);
        this.port = port;
        this.htmlFilePath = htmlFilePath;
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println(String.format("\nRunning! Point your browsers to http://localhost:%d/ \n", port));
    }

    @Override
    public Response serve(IHTTPSession session) {
        File file = new File(htmlFilePath);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            fis.read(buffer);

            return newFixedLengthResponse(new String(buffer));
        } catch (IOException e) {
            e.printStackTrace();
            return newFixedLengthResponse("Error: " + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
