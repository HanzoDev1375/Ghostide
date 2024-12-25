package ir.ninjacoder.ghostide.filehelper;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.File;

public class JavaModule {

    public void makeModuleClass(String className, String packageName, String output) {
        try {
            TypeSpec classMaker =
                    TypeSpec.classBuilder(className)
                            .addModifiers(Modifier.PUBLIC)
                            .addMethod(
                                    MethodSpec.methodBuilder("main")
                                            .addModifiers(Modifier.PUBLIC)
                                            .returns(TypeName.VOID)
                                            .build())
                            .build();
            JavaFile javafile = JavaFile.builder(packageName, classMaker).build();
            javafile.writeToFile(new File(output));
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void makeModuleInterface(String interfaceName, String packageName, String output) {
        try {
            TypeSpec interfaceMaker =
                    TypeSpec.interfaceBuilder(interfaceName).addModifiers(Modifier.PUBLIC).build();
            JavaFile javafile = JavaFile.builder(packageName, interfaceMaker).build();
            javafile.writeToFile(new File(output));
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void makeModuleEnum(String enums, String packageName, String output) {
        try {
            TypeSpec enumz = TypeSpec.enumBuilder(enums).addModifiers(Modifier.PUBLIC).build();
            JavaFile javafile = JavaFile.builder(packageName, enumz).build();
            javafile.writeToFile(new File(output));
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void makeModuleAppCompatActivity(String className, String packageName, String output) {
        try {
            ClassName appCompatActivity = ClassName.get("androidx.appcompat.app", "AppCompatActivity");

            TypeSpec classMaker =
                    TypeSpec.classBuilder(className)
                            .superclass(appCompatActivity)
                            .addModifiers(Modifier.PUBLIC)
                            .addMethod(
                                    MethodSpec.methodBuilder("onCreate")
                                            .addAnnotation(Override.class)
                                            .addModifiers(Modifier.PUBLIC)
                                            .returns(TypeName.VOID)
                                            .addParameter(ClassName.get("android.os", "Bundle"), "savedInstanceState")
                                            .addStatement("super.onCreate(savedInstanceState)")
                                            .build())
                            .build();

            JavaFile javaFile =
                    JavaFile.builder(packageName, classMaker)
                            .addStaticImport(Override.class, "*")
                            .addStaticImport(Void.class, "*")
                            .addStaticImport(Modifier.class, "PUBLIC")
                            .addStaticImport(ClassName.get("android.os", "Bundle"), "*")
                            .build();

            javaFile.writeToFile(new File(output));
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
