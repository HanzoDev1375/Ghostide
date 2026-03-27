package ir.ninjacoder.prograsssheet.util;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import android.text.TextUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.InputStream;
import org.jetbrains.annotations.Contract;

public class AndroidUtils {
  public static ThreadLocal<byte[]> readBufferLocal = new ThreadLocal<>();
  public static ThreadLocal<byte[]> bufferLocal = new ThreadLocal<>();

  @AnyThread
  @Nullable
  public static String getPathExtension(@NonNull String path) {
    return getPathExtension(path, true);
  }

  @AnyThread
  @Nullable
  public static String getPathExtension(@NonNull String path, boolean forceLowercase) {
    String str = getLastPathSegment(path);
    int lastIndexOfDot = str.lastIndexOf('.');
    if (lastIndexOfDot == -1 || lastIndexOfDot == str.length() - 1) return null;
    String extension = str.substring(lastIndexOfDot + 1);
    return forceLowercase ? extension.toLowerCase(Locale.ROOT) : extension;
  }

  @Contract("null, _ -> null")
  @Nullable
  public static String sanitize(@Nullable String path, boolean omitRoot) {
    if (path == null) {
      return null;
    }
    if (path.isEmpty()) {
      return null;
    }
    path = path.replaceAll("[\r\n]", "");
    boolean isAbsolute = path.startsWith(File.separator);
    String[] parts = path.split(File.separator);
    List<String> newParts = new ArrayList<>(parts.length);
    for (String part : parts) {
      if (part.isEmpty() || part.equals(".")) continue;
      newParts.add(part);
    }
    path = TextUtils.join(File.separator, newParts);
    if (isAbsolute) {
      if (path.isEmpty()) {
        return File.separator;
      }
      if (!omitRoot) {
        return File.separator + path;
      }
    }
    return path.isEmpty() ? null : path;
  }

  @AnyThread
  @NonNull
  public static String getLastPathSegment(@NonNull String path) {
    path = sanitize(path, false);
    // path has no trailing / or .
    if (path == null || path.equals(File.separator)) {
      return "";
    }
    int separatorIndex = path.lastIndexOf(File.separator);
    if (separatorIndex == -1) {
      // There are no `/` in the string, so return as is.
      return path;
    }
    // There are path components, so return the last one.
    String lastPart = path.substring(separatorIndex + 1);
    if (lastPart.equals("..")) {
      // Invalid part
      return "";
    }
    return lastPart;
  }

  @AnyThread
  @NonNull
  public static String trimPathExtension(@NonNull String path) {
    if (path.isEmpty()) {
      return "";
    }
    boolean isAbsolute = path.startsWith(File.separator);
    String[] parts = path.split(File.separator);
    Stack<String> newParts = new Stack<>();
    for (String part : parts) {
      if (part.isEmpty() || part.equals(".")) continue;
      newParts.push(part);
    }
    if (newParts.isEmpty()) {
      return isAbsolute ? File.separator : "";
    }
    String lastPart = newParts.peek();
    if (!lastPart.equals("..")) {
      int lastIndexOfDot = lastPart.lastIndexOf('.');
      int lastIndexOfPath = lastPart.length() - 1;
      if (lastIndexOfDot != 0 && lastIndexOfDot != -1 && lastIndexOfDot != lastIndexOfPath) {
        newParts.pop();
        newParts.push(lastPart.substring(0, lastIndexOfDot));
      }
    }
    path = TextUtils.join(File.separator, newParts);
    if (isAbsolute) {
      return File.separator + path;
    }
    return path;
  }

  public static String readRes(int rawRes, Context context) {
    int totalRead = 0;
    byte[] readBuffer = readBufferLocal.get();
    if (readBuffer == null) {
      readBuffer = new byte[64 * 1024];
      readBufferLocal.set(readBuffer);
    }
    InputStream inputStream = null;
    try {

      inputStream = context.getResources().openRawResource(rawRes);
      int readLen;
      byte[] buffer = bufferLocal.get();
      if (buffer == null) {
        buffer = new byte[4096];
        bufferLocal.set(buffer);
      }
      while ((readLen = inputStream.read(buffer, 0, buffer.length)) >= 0) {
        if (readBuffer.length < totalRead + readLen) {
          byte[] newBuffer = new byte[readBuffer.length * 2];
          System.arraycopy(readBuffer, 0, newBuffer, 0, totalRead);
          readBuffer = newBuffer;
          readBufferLocal.set(readBuffer);
        }
        if (readLen > 0) {
          System.arraycopy(buffer, 0, readBuffer, totalRead, readLen);
          totalRead += readLen;
        }
      }
    } catch (Throwable e) {
      return null;
    } finally {
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (Throwable ignore) {

      }
    }

    return new String(readBuffer, 0, totalRead);
  }
}
