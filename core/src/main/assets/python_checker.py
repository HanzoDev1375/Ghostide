import ast
import sys
import json
from collections import defaultdict


class AdvancedPythonChecker(ast.NodeVisitor):
    def __init__(self):
        self.issues = []
        self.imports = defaultdict(list)
        self.functions = {}
        self.classes = {}
        self.variables = defaultdict(list)
        self.current_function = None
        self.current_class = None
        self.param_names = []  # برای ذخیره نام پارامترهای فعلی

    def _add_issue(self, issue_type, line, column, message, suggestion=None):
        issue = {"type": issue_type, "line": line, "column": column, "message": message}
        if suggestion:
            issue["suggestion"] = suggestion
        self.issues.append(issue)

    # بررسی importها
    def visit_Import(self, node):
        for alias in node.names:
            self.imports[alias.name].append(node.lineno)
        self.generic_visit(node)

    def visit_ImportFrom(self, node):
        for alias in node.names:
            full_name = f"{node.module}.{alias.name}" if node.module else alias.name
            self.imports[full_name].append(node.lineno)
        self.generic_visit(node)

    # بررسی توابع
    def visit_FunctionDef(self, node):
        self.functions[node.name] = node.lineno
        self.current_function = node.name
        self.param_names = [arg.arg for arg in node.args.args]

        # بررسی docstring
        if not ast.get_docstring(node):
            self._add_issue(
                "warning",
                node.lineno,
                node.col_offset,
                f"Function '{node.name}' is missing a docstring",
                "Add a docstring explaining the function's purpose",
            )

        # بررسی تعداد آرگومان‌ها
        if len(node.args.args) > 5:
            self._add_issue(
                "warning",
                node.lineno,
                node.col_offset,
                f"Function '{node.name}' has too many arguments ({len(node.args.args)})",
                "Consider refactoring into smaller functions or using objects",
            )

        self.generic_visit(node)
        self.current_function = None
        self.param_names = []

    # بررسی کلاس‌ها
    def visit_ClassDef(self, node):
        self.classes[node.name] = node.lineno
        self.current_class = node.name

        if not ast.get_docstring(node):
            self._add_issue(
                "warning",
                node.lineno,
                node.col_offset,
                f"Class '{node.name}' is missing a docstring",
                "Add a docstring explaining the class's purpose",
            )

        self.generic_visit(node)
        self.current_class = None

    # بررسی متغیرها
    def visit_Assign(self, node):
        for target in node.targets:
            if isinstance(target, ast.Name):
                var_name = target.id
                self.variables[var_name].append(node.lineno)

                # بررسی نام‌گذاری
                if self.current_class and var_name.startswith("__"):
                    pass  # نام خصوصی کلاس
                elif var_name.startswith("_") and not var_name.endswith("_"):
                    self._add_issue(
                        "warning",
                        node.lineno,
                        node.col_offset,
                        f"Private-looking variable '{var_name}'",
                        "Use proper encapsulation if this should be private",
                    )

                # Shadowing بررسی
                if var_name in __builtins__.__dict__:
                    self._add_issue(
                        "warning",
                        node.lineno,
                        node.col_offset,
                        f"Variable '{var_name}' shadows a built-in name",
                        "Choose a different name to avoid confusion",
                    )

                # بررسی استفاده از پارامترهای تابع
                if var_name in self.param_names:
                    self._add_issue(
                        "typo",
                        node.lineno,
                        node.col_offset,
                        f"Possible typo in variable name '{var_name}' (similar to parameter name)",
                        "Check if this is a typo or intentional",
                    )
              
        self.generic_visit(node)

    # بررسی فراخوانی‌ها
    def visit_Call(self, node):
        if isinstance(node.func, ast.Name):
            func_name = node.func.id
            if func_name == "eval":
                self._add_issue(
                    "error",
                    node.lineno,
                    node.col_offset,
                    "Use of eval() is dangerous",
                    "Find a safer alternative to eval()",
                )
            elif func_name == 'global':
                self._add_issue(
                    "typo",
                    node.lineno,
                    node.col_offset,
                    "Possible typo in function name 'global'",
                    "Did you mean to use the global keyword instead?",
                )
        self.generic_visit(node)

    # بررسی حلقه‌ها
    def visit_For(self, node):
        if isinstance(node.target, ast.Name) and node.target.id == "_":
            self._add_issue(
                "warning",
                node.lineno,
                node.col_offset,
                "Unused loop variable '_'",
                "Use a meaningful name or explicitly mark as unused with '_'",
            )
        self.generic_visit(node)

    # بررسی استثناها
    def visit_ExceptHandler(self, node):
        if node.name is None:
            self._add_issue(
                "warning",
                node.lineno,
                node.col_offset,
                "Bare except clause",
                "Specify the exception type to avoid catching unexpected exceptions",
            )
        self.generic_visit(node)

    # بررسی نهایی برای موارد استفاده نشده
    def final_checks(self):
        # بررسی importهای استفاده نشده
        for name, lines in self.imports.items():
            used = False
            for node in ast.walk(self.tree):
                if isinstance(node, ast.Name) and node.id == name.split(".")[-1]:
                    used = True
                    break
            if not used:
                for line in lines:
                    self._add_issue(
                        "warning",
                        line,
                        1,
                        f"Unused import '{name}'",
                        "Remove unused imports to keep code clean",
                    )

        # بررسی توابع استفاده نشده
        for func_name, line in self.functions.items():
            if func_name.startswith("_"):
                continue  # توابع خصوصی
            used = False
            for node in ast.walk(self.tree):
                if (
                    isinstance(node, ast.Call)
                    and isinstance(node.func, ast.Name)
                    and node.func.id == func_name
                ):
                    used = True
                    break
            if not used:
                self._add_issue(
                    "warning",
                    line,
                    1,
                    f"Unused function '{func_name}'",
                    "Remove or use the function",
                )


def check_python_code(file_path):
    results = []
    try:
        with open(file_path, "r", encoding="utf-8") as f:
            code = f.read()

        try:
            tree = ast.parse(code)
            checker = AdvancedPythonChecker()
            checker.tree = tree  # برای دسترسی در final_checks
            checker.visit(tree)
            checker.final_checks()
            results = checker.issues
        except SyntaxError as e:
            results.append(
                {
                    "type": "error",
                    "line": e.lineno,
                    "column": e.offset or 1,
                    "message": str(e).split("\n")[0],
                    "suggestion": "Fix the syntax error",
                }
            )

    except Exception as e:
        results.append(
            {
                "type": "error",
                "line": 0,
                "column": 0,
                "message": f"System error: {str(e)}",
                "suggestion": "Check file permissions and content",
            }
        )

    print(json.dumps(results, indent=2, ensure_ascii=False))


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("[]")
        sys.exit(1)
    check_python_code(sys.argv[1])