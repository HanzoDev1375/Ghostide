import sys
import json
import jedi

def get_completions(source, line, column):
    try:
        script = jedi.Script(code=source, path='<input>')
        completions = script.complete(line=line, column=column)
        return [{
            'label': c.name,
            'commit': c.name,  # یا c.complete اگر وجود دارد
            'desc': c.docstring or c.type or ''
        } for c in completions]
    except Exception as e:
        print(f"Jedi error: {str(e)}", file=sys.stderr)
        return []

if __name__ == "__main__":
    if len(sys.argv) != 4:
        print("Usage: python autocomplete.py <file_path> <line> <column>", file=sys.stderr)
        sys.exit(1)
    
    file_path = sys.argv[1]
    line = int(sys.argv[2])
    column = int(sys.argv[3])
    
    try:
        with open(file_path, 'r') as f:
            source = f.read()
    except Exception as e:
        print(f"File read error: {str(e)}", file=sys.stderr)
        sys.exit(1)
    
    completions = get_completions(source, line, column)
    print(json.dumps(completions))