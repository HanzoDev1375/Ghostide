package ir.ninjacoder.ghostide.core.pl;

import android.util.Log;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import dalvik.system.InMemoryDexClassLoader;
import ir.ninjacoder.ghostide.core.pl.PluginManagerCompat;

public class PluginClassFinder {
  private static final String TAG = "PluginClassFinder";

  public static Class<?> findPluginCompatibleClass(
      InMemoryDexClassLoader classLoader, String packageName) {
    try {
      List<Class<?>> compatibleClasses = new ArrayList<>();

      Object dexFile = getDexFile(classLoader);
      if (dexFile == null) {
        Log.e(TAG, "نتوانستیم DexFile را از ClassLoader دریافت کنیم");
        return null;
      }

      String[] classNames = getClassNameList(dexFile);
      if (classNames == null) {
        Log.e(TAG, "نتوانستیم لیست کلاسها را دریافت کنیم");
        return null;
      }

      Log.d(TAG, "تعداد کلاسهای موجود در DEX: " + classNames.length);

      for (String className : classNames) {

        if (packageName != null && !className.startsWith(packageName)) {
          continue;
        }

        try {
          Class<?> clazz = classLoader.loadClass(className);

          if (isPluginCompatibleClass(clazz)) {
            compatibleClasses.add(clazz);
            Log.d(TAG, "کلاس سازگار پیدا شد: " + className);
          }
        } catch (ClassNotFoundException e) {
          Log.w(TAG, "کلاس پیدا نشد: " + className);
        } catch (NoClassDefFoundError e) {
          Log.w(TAG, "تعریف کلاس پیدا نشد: " + className);
        } catch (Exception e) {
          Log.w(TAG, "خطا در بررسی کلاس: " + className, e);
        }
      }

      if (compatibleClasses.isEmpty()) {
        Log.e(TAG, "هیچ کلاس سازگاری پیدا نشد");
        return null;
      }

      if (compatibleClasses.size() > 1) {
        Log.w(TAG, "چندین کلاس سازگار پیدا شد. اولین کلاس استفاده خواهد شد");
      }

      return compatibleClasses.get(0);

    } catch (Exception e) {
      Log.e(TAG, "خطا در پیدا کردن کلاس سازگار", e);
      return null;
    }
  }

  private static boolean isPluginCompatibleClass(Class<?> clazz) {

    if (PluginManagerCompat.class.isAssignableFrom(clazz)) {

      if (Modifier.isAbstract(clazz.getModifiers())) {
        Log.d(TAG, "کلاس abstract است و نادیده گرفته میشود: " + clazz.getName());
        return false;
      }

      if (clazz.isInterface()) {
        Log.d(TAG, "کلاس یک interface است و نادیده گرفته میشود: " + clazz.getName());
        return false;
      }

      return true;
    }
    return false;
  }

  private static Object getDexFile(InMemoryDexClassLoader classLoader) {
    try {
      java.lang.reflect.Field pathListField =
          dalvik.system.BaseDexClassLoader.class.getDeclaredField("pathList");
      pathListField.setAccessible(true);
      Object pathList = pathListField.get(classLoader);

      java.lang.reflect.Field dexElementsField =
          pathList.getClass().getDeclaredField("dexElements");
      dexElementsField.setAccessible(true);
      Object[] dexElements = (Object[]) dexElementsField.get(pathList);

      if (dexElements.length > 0) {
        java.lang.reflect.Field dexFileField =
            dexElements[0].getClass().getDeclaredField("dexFile");
        dexFileField.setAccessible(true);
        return dexFileField.get(dexElements[0]);
      }
    } catch (Exception e) {
      Log.e(TAG, "خطا در دریافت DexFile", e);
    }
    return null;
  }

  private static String[] getClassNameList(Object dexFile) {
    try {
      java.lang.reflect.Method getClassNameListMethod =
          dexFile.getClass().getMethod("getClassNameList");
      return (String[]) getClassNameListMethod.invoke(dexFile);
    } catch (Exception e) {
      Log.e(TAG, "خطا در دریافت لیست نام کلاسها", e);
    }
    return null;
  }
}