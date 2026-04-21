package ir.ninjacoder.prograsssheet.fileinfo;

import android.os.Handler;
import android.os.Looper;


import kotlin.Unit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/**
 * کلاس مدیریت کوروتین‌ها برای استفاده در جاوا این کلاس امکان استفاده آسان از کوروتین‌های Kotlin را
 * در کد جاوا فراهم می‌کند
 */
public class CoroutineManager {

  private static CoroutineScope mainScope;
  private static CoroutineScope ioScope;
  private static CoroutineScope defaultScope;
  private static final Handler mainHandler = new Handler(Looper.getMainLooper());

  public static CoroutineScope getMainScope() {
    if (mainScope == null) {
      mainScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }
    return mainScope;
  }

  public static CoroutineScope getIOScope() {
    if (ioScope == null) {
      ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }
    return ioScope;
  }

  public static CoroutineScope getDefaultScope() {
    if (defaultScope == null) {
      defaultScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    }
    return defaultScope;
  }

  // اجرای عملیات در IO با callback
  public static <T> void runOnIO(IOCallable<T> callable, CoroutineCallback<T> callback) {
    BuildersKt.launch(
        getIOScope(),
        Dispatchers.getIO(),
        CoroutineStart.DEFAULT,
        (scope, continuation) -> {
          try {
            T result = callable.call();
            if (callback != null) {
              mainHandler.post(() -> callback.onSuccess(result));
            }
          } catch (Exception e) {
            if (callback != null) {
              mainHandler.post(() -> callback.onError(e));
            }
          }
          return Unit.INSTANCE;
        });
  }

  // اجرای عملیات در IO بدون مقدار بازگشتی
  public static void runOnIO(IORunnable runnable, ErrorCallback errorCallback) {
    BuildersKt.launch(
        getIOScope(),
        Dispatchers.getIO(),
        CoroutineStart.DEFAULT,
        (scope, continuation) -> {
          try {
            runnable.run();
            if (errorCallback != null) {
              mainHandler.post(errorCallback::onSuccess);
            }
          } catch (Exception e) {
            if (errorCallback != null) {
              mainHandler.post(() -> errorCallback.onError(e));
            }
          }
          return Unit.INSTANCE;
        });
  }

  public static void runOnIO(IORunnable runnable) {
    runOnIO(runnable, null);
  }

  // اجرا در Main thread
  public static void runOnMain(Runnable runnable) {
    BuildersKt.launch(
        getMainScope(),
        Dispatchers.getMain(),
        CoroutineStart.DEFAULT,
        (scope, continuation) -> {
          runnable.run();
          return Unit.INSTANCE;
        });
  }

  // اجرا در Default (CPU-intensive)
  public static void runOnDefault(Runnable runnable) {
    BuildersKt.launch(
        getDefaultScope(),
        Dispatchers.getDefault(),
        CoroutineStart.DEFAULT,
        (scope, continuation) -> {
          runnable.run();
          return Unit.INSTANCE;
        });
  }

  public static void runDelayed(long delayMillis, Runnable runnable) {
    mainHandler.postDelayed(runnable, delayMillis);
  }

  public static void cancelAll() {
    cancelScope(mainScope);
    cancelScope(ioScope);
    cancelScope(defaultScope);
  }

  private static void cancelScope(CoroutineScope scope) {
    if (scope != null) {
      Job job = scope.getCoroutineContext().get(Job.Key);
      if (job != null && !job.isCancelled()) {
        JobKt.cancel(job, null);
      }
    }
  }

  // Interfaces
  @FunctionalInterface
  public interface IOCallable<T> {
    T call() throws Exception;
  }

  @FunctionalInterface
  public interface IORunnable {
    void run() throws Exception;
  }

  public interface CoroutineCallback<T> {
    void onSuccess(T result);

    void onError(Exception e);
  }

  public interface ErrorCallback {
    void onSuccess();

    void onError(Exception e);
  }
}
