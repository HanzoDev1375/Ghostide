import jedi
import sys
import json
import os
import traceback
import sys
import json
import os
import traceback

def get_default_position(code):
    lines = code.splitlines()
    line = len(lines)
    column = len(lines[-1]) if line > 0 else 0
    return line, column


def get_prefix_before_dot(code, line, column):
    lines = code.splitlines()
    if line <= 0 or line > len(lines):
        return ""

    current_line = lines[line - 1]
    if column > len(current_line):
        column = len(current_line)

    last_dot_pos = current_line.rfind(".", 0, column)
    if last_dot_pos == -1:
        return ""

    return current_line[:last_dot_pos]


def main():
    if len(sys.argv) < 2:
        print(json.dumps({"error": "No file path provided"}))
        return

    file_path = sys.argv[1]

    if not os.path.exists(file_path):
        print(json.dumps({"error": "File not found"}))
        return

    with open(file_path, "r", encoding="utf-8") as f:
        code = f.read()

    try:
        # تنظیم مسیر کش (همان‌طور که شما خواستید)
        cache_dir = os.path.expanduser("/data/data/ir.ninjacoder.ghostide/files/lib")
        os.makedirs(cache_dir, exist_ok=True)
        jedi.settings.cache_directory = cache_dir
        script = jedi.Script(code=code, path=file_path)
        line, column = get_default_position(code)
        prefix = get_prefix_before_dot(code, line, column)

        completions = script.complete(line, column)

        result = [
            {
                "label": f"{prefix}.{c.name}" if prefix else c.name,
                "commit": f"{prefix}.{c.name}" if prefix else c.name,
                "desc": c.type,
                "prefix": prefix,
            }
            for c in completions
        ]

        print(json.dumps(result, ensure_ascii=False))

    except Exception as e:
        print(json.dumps({"error": str(e), "traceback": traceback.format_exc()}))


if __name__ == "__main__":
    main()
