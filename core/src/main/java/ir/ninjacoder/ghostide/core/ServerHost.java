package ir.ninjacoder.ghostide.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

public class ServerHost {
  public WebServer server;
  private String rootFolder;
  private String indexName;
  private int port;

  public ServerHost(int port, String rootFolder, String indexName) {
    this.port = port;
    this.rootFolder = rootFolder;
    this.indexName = indexName;
  }

  public void startServer() {
    try {
      server = new WebServer(port);
      server.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void stopServer() {
    if (server != null) {
      server.stop();
    }
  }

  public String getLocalIpAddress() {
    return "http://localhost:" + port + "/" + indexName;
  }

  private class WebServer extends NanoHTTPD {
    private String MIME_PLAINTEXT = "text/html";

    public WebServer(int port) {
      super("localhost", port);
    }

    @Override
    public Response serve(IHTTPSession session) {
      String uri = session.getUri();

      // اگر مسیر با / تمام شود، فایل index را اضافه کنید
      if (uri.endsWith("/")) {
        uri += indexName;
      }

      // مسیر کامل فایل
      String filePath = rootFolder + uri;

      try {
        File file = new File(filePath);
        if (file.exists()) {
          // تشخیص نوع MIME بر اساس پسوند فایل
          String mimeType = getMimeType(filePath);

          FileInputStream fis = new FileInputStream(file);
          long contentLength = file.length();

          return newFixedLengthResponse(Response.Status.OK, mimeType, fis, contentLength);
        } else {
          // اگر فایل پیدا نشد، خطای 404 برگردانید
          return newFixedLengthResponse(
              Response.Status.NOT_FOUND, MIME_PLAINTEXT, "File not found.");
        }
      } catch (IOException e) {
        e.printStackTrace();
        return newFixedLengthResponse(
            Response.Status.INTERNAL_ERROR, MIME_PLAINTEXT, "Internal server error.");
      }
    }

    private String getMimeType(String filePath) {
      if (filePath.endsWith(".html")) {
        return "text/html";
      } else if (filePath.endsWith(".css")) {
        return "text/css";
      } else if (filePath.endsWith(".js")) {
        return "application/javascript";
      } else if (filePath.endsWith(".png")) {
        return "image/png";
      } else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
        return "image/jpeg";
      } else if (filePath.endsWith(".gif")) {
        return "image/gif";
      } else if (filePath.endsWith(".svg")) {
        return "image/svg+xml";
      } else if (filePath.endsWith(".json")) {
        return "application/json";
      } else if (filePath.endsWith(".ico")) {
        return "image/x-icon";
      } else {
        return "*/*";
      }
    }
  }
}
