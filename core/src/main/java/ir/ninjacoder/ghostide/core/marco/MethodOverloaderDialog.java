package ir.ninjacoder.ghostide.core.marco;

import android.content.Context;
import android.text.InputType;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.R;

public class MethodOverloaderDialog {

  private Context context;
  private String javaCode;
  private CompilationUnit cu;
  private IdeEditor et;
  private MethodDeclaration selectedMethod;

  public MethodOverloaderDialog(Context context, String javaCode, IdeEditor et) {
    this.context = context;
    this.javaCode = javaCode;
    this.et = et;
  }

  public void analyzeAndShowOverloadDialog() {
    try {
      cu = StaticJavaParser.parse(javaCode);
      List<MethodDeclaration> allMethods = cu.findAll(MethodDeclaration.class);

      if (allMethods.isEmpty()) {
        Toast.makeText(context, context.getString(R.string.no_methods_found), Toast.LENGTH_SHORT)
            .show();
        return;
      }

      showMethodSelectionDialog(allMethods);

    } catch (Exception e) {
      String errorMessage =
          String.format(context.getString(R.string.code_parsing_error), e.getMessage());
      Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
      e.printStackTrace();
    }
  }

  private void showMethodSelectionDialog(List<MethodDeclaration> allMethods) {
    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
    builder.setTitle(context.getString(R.string.select_method_for_overload));

    List<String> methodSignatures = new ArrayList<>();
    for (MethodDeclaration method : allMethods) {
      methodSignatures.add(generateMethodSignature(method));
    }

    builder.setItems(
        methodSignatures.toArray(new String[0]),
        (dialog, which) -> {
          selectedMethod = allMethods.get(which);
          showParameterSelectionDialog(selectedMethod);
        });

    builder.setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.dismiss());
    builder.show();
  }

  private void showParameterSelectionDialog(MethodDeclaration method) {
    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
    builder.setTitle(
        String.format(
            context.getString(R.string.select_parameters_for_overload), method.getNameAsString()));

    List<Parameter> parameters = method.getParameters();

    if (parameters.isEmpty()) {
      Toast.makeText(
              context, context.getString(R.string.method_has_no_parameters), Toast.LENGTH_SHORT)
          .show();
      return;
    }

    String[] paramOptions = new String[parameters.size()];
    boolean[] selectedParams = new boolean[parameters.size()];

    for (int i = 0; i < parameters.size(); i++) {
      Parameter param = parameters.get(i);
      paramOptions[i] = param.getType().asString() + " " + param.getNameAsString();
      selectedParams[i] = true; // Default all selected
    }

    builder.setMultiChoiceItems(
        paramOptions,
        selectedParams,
        (dialog, which, isChecked) -> {
          selectedParams[which] = isChecked;
        });

    builder.setPositiveButton(
        android.R.string.ok,
        (dialog, which) -> {
          List<Integer> selectedIndices = new ArrayList<>();
          for (int i = 0; i < selectedParams.length; i++) {
            if (selectedParams[i]) {
              selectedIndices.add(i);
            }
          }

          if (selectedIndices.isEmpty()) {
            Toast.makeText(
                    context,
                    context.getString(R.string.select_at_least_one_parameter),
                    Toast.LENGTH_SHORT)
                .show();
            return;
          }

          showParameterModificationDialog(method, selectedIndices);
        });

    builder.setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.dismiss());
    builder.show();
  }

  private void showParameterModificationDialog(
      MethodDeclaration method, List<Integer> selectedIndices) {
    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
    builder.setTitle(context.getString(R.string.modify_selected_parameters));

    LinearLayout layout = new LinearLayout(context);
    layout.setOrientation(LinearLayout.VERTICAL);
    layout.setPadding(50, 40, 50, 10);

    List<TextInputLayout> typeInputs = new ArrayList<>();
    List<TextInputLayout> nameInputs = new ArrayList<>();
    List<Parameter> parameters = method.getParameters();

    for (int index : selectedIndices) {
      Parameter param = parameters.get(index);

      LinearLayout paramLayout = new LinearLayout(context);
      paramLayout.setOrientation(LinearLayout.HORIZONTAL);

      // Create TextInputLayout for type
      TextInputLayout typeInput = new TextInputLayout(context);
      var typeEditText = new TextInputEditText(context);
      typeInput.addView(typeEditText);
      typeInput.setHint(context.getString(R.string.type));
      typeEditText.setText(param.getType().asString());
      typeEditText.setInputType(InputType.TYPE_CLASS_TEXT);
      typeInput.setLayoutParams(
          new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

      // Create TextInputLayout for name
      TextInputLayout nameInput = new TextInputLayout(context);
      var nameEditText = new TextInputEditText(context);
      nameInput.addView(nameEditText);
      nameInput.setHint(context.getString(R.string.name));
      nameEditText.setText(param.getNameAsString());
      nameEditText.setInputType(InputType.TYPE_CLASS_TEXT);
      nameInput.setLayoutParams(
          new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

      paramLayout.addView(typeInput);
      paramLayout.addView(nameInput);
      layout.addView(paramLayout);

      typeInputs.add(typeInput);
      nameInputs.add(nameInput);
    }

    builder.setView(layout);

    builder.setPositiveButton(
        android.R.string.ok,
        (dialog, which) -> {
          List<String> newTypes = new ArrayList<>();
          List<String> newNames = new ArrayList<>();

          for (int i = 0; i < typeInputs.size(); i++) {
            // Now get the EditText from TextInputLayout safely
            var typeEditText = typeInputs.get(i).getEditText();
            var nameEditText = nameInputs.get(i).getEditText();
            if (typeEditText != null && nameEditText != null) {
              newTypes.add(typeEditText.getText().toString().trim());
              newNames.add(nameEditText.getText().toString().trim());
            }
          }

          createOverloadedMethod(method, selectedIndices, newTypes, newNames);
        });

    builder.setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.dismiss());
    builder.show();
  }

  private void createOverloadedMethod(
      MethodDeclaration originalMethod,
      List<Integer> paramIndices,
      List<String> newTypes,
      List<String> newNames) {
    try {
      // Create a copy of the original method
      MethodDeclaration overloadedMethod = originalMethod.clone();

      // Remove comments and other extra information
      overloadedMethod.removeComment();

      // Create new list for parameters (only selected parameters)
      NodeList<Parameter> newParameters = new NodeList<>();

      for (int i = 0; i < paramIndices.size(); i++) {
        int paramIndex = paramIndices.get(i);
        Parameter originalParam = originalMethod.getParameter(paramIndex);

        // Create new parameter with modified type and name
        Parameter newParam =
            new Parameter(StaticJavaParser.parseType(newTypes.get(i)), newNames.get(i));

        newParameters.add(newParam);
      }

      // Replace all parameters with new parameters
      overloadedMethod.setParameters(newParameters);

      // Create new body for overloaded method
      String newBody = "{\n    // TODO: Implement overloaded method\n    ";

      if (!originalMethod.getType().asString().equals("void")) {
        newBody += "return " + getDefaultReturnValue(originalMethod.getType().asString()) + ";\n";
      } else {
        newBody += "\n";
      }

      newBody += "}";

      overloadedMethod.setBody(StaticJavaParser.parseBlock(newBody));

      // Change method name if needed (to prevent name conflict)
      // overloadedMethod.setName(originalMethod.getNameAsString() + "Overloaded");

      // Find parent class and add method
      cu.findAll(ClassOrInterfaceDeclaration.class)
          .forEach(
              classDecl -> {
                if (classDecl.getMethods().contains(originalMethod)) {
                  classDecl.addMember(overloadedMethod);
                }
              });

      // Display modified code in EditText
      String modifiedCode = cu.toString();
      et.setText(modifiedCode);

      Toast.makeText(
              context,
              context.getString(R.string.overload_created_successfully),
              Toast.LENGTH_SHORT)
          .show();

    } catch (Exception e) {
      String errorMessage =
          String.format(context.getString(R.string.overload_creation_error), e.getMessage());
      Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
      e.printStackTrace();
    }
  }

  private String getDefaultReturnValue(String returnType) {
    switch (returnType) {
      case "int":
      case "long":
      case "short":
      case "byte":
        return "0";
      case "double":
      case "float":
        return "0.0";
      case "boolean":
        return "false";
      case "char":
        return "'\\0'";
      default:
        return "null";
    }
  }

  private String generateMethodSignature(MethodDeclaration method) {
    StringBuilder signature = new StringBuilder();
    signature
        .append(method.getType().asString())
        .append(" ")
        .append(method.getNameAsString())
        .append("(");

    List<Parameter> parameters = method.getParameters();
    for (int i = 0; i < parameters.size(); i++) {
      if (i > 0) signature.append(", ");
      Parameter param = parameters.get(i);
      signature.append(param.getType().asString()).append(" ").append(param.getNameAsString());
    }

    signature.append(")");
    return signature.toString();
  }

  public String getModifiedCode() {
    return cu != null ? cu.toString() : javaCode;
  }
}
