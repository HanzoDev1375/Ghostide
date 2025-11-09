import ast
import sys
import json
from collections import defaultdict


class PythonCodeAnalyzer(ast.NodeVisitor):
    def __init__(self):
        self.elements = []
        self.current_class = None

    def _add_element(self, element_type, name, line, column, end_line=None, end_column=None):
        element = {
            "type": element_type,
            "name": name,
            "line": line,
            "column": column
        }
        if end_line is not None:
            element["end_line"] = end_line
        if end_column is not None:
            element["end_column"] = end_column
        self.elements.append(element)

    def visit_ClassDef(self, node):
        self.current_class = node.name
        self._add_element(
            "class", 
            node.name, 
            node.lineno, 
            node.col_offset,
            node.end_lineno,
            node.end_col_offset
        )
        self.generic_visit(node)
        self.current_class = None

    def visit_FunctionDef(self, node):
        full_name = f"{self.current_class}.{node.name}" if self.current_class else node.name
        element_type = "method" if self.current_class else "function"
        
        self._add_element(
            element_type,
            full_name,
            node.lineno,
            node.col_offset,
            node.end_lineno,
            node.end_col_offset
        )
        
        # Add the parameters as well
        for arg in node.args.args:
            self._add_element(
                "parameter",
                arg.arg,
                arg.lineno if hasattr(arg, 'lineno') else node.lineno,
                arg.col_offset if hasattr(arg, 'col_offset') else node.col_offset
            )
        
        self.generic_visit(node)

    def visit_Assign(self, node):
        for target in node.targets:
            if isinstance(target, ast.Name):
                self._add_element(
                    "variable",
                    target.id,
                    target.lineno,
                    target.col_offset
                )
            elif isinstance(target, ast.Attribute):
                # Handle attribute assignments (e.g., self.x = 5)
                self._add_element(
                    "attribute",
                    target.attr,
                    target.lineno,
                    target.col_offset
                )
        self.generic_visit(node)

    def visit_AnnAssign(self, node):
        if isinstance(node.target, ast.Name):
            self._add_element(
                "variable",
                node.target.id,
                node.target.lineno,
                node.target.col_offset
            )
        self.generic_visit(node)

    def visit_Import(self, node):
        for alias in node.names:
            self._add_element(
                "import",
                alias.name,
                node.lineno,
                node.col_offset
            )
        self.generic_visit(node)

    def visit_ImportFrom(self, node):
        for alias in node.names:
            full_name = f"{node.module}.{alias.name}" if node.module else alias.name
            self._add_element(
                "import",
                full_name,
                node.lineno,
                node.col_offset
            )
        self.generic_visit(node)


def analyze_python_code(file_path):
    results = []
    try:
        with open(file_path, "r", encoding="utf-8") as f:
            code = f.read()

        try:
            tree = ast.parse(code)
            analyzer = PythonCodeAnalyzer()
            analyzer.visit(tree)
            results = analyzer.elements
        except SyntaxError as e:
            results.append({
                "type": "error",
                "line": e.lineno,
                "column": e.offset or 1,
                "message": str(e).split("\n")[0]
            })

    except Exception as e:
        results.append({
            "type": "error",
            "line": 0,
            "column": 0,
            "message": f"System error: {str(e)}"
        })

    print(json.dumps(results, indent=2, ensure_ascii=False))


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("[]")
        sys.exit(1)
    analyze_python_code(sys.argv[1])