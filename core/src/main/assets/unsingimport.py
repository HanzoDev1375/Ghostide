import sys
import os
from rope.base import libutils, project
from rope.refactor.importutils import ImportOrganizer

def main():
    # باید دقیقاً یک آرگومان بگیریم: مسیر فایل
    if len(sys.argv) != 2:
        print("Usage: python d.py <file_path>")
        sys.exit(1)

    file_path = os.path.abspath(sys.argv[1])
    project_path = os.path.dirname(file_path)  # پرنت فایل

    # ایجاد پروژه
    proj = project.Project(project_path)
    try:
        # گرفتن resource از مسیر فایل
        resource = libutils.path_to_resource(proj, file_path)

        # سازماندهی import ها
        organizer = ImportOrganizer(proj)
        changes = organizer.organize_imports(resource)

        # اعمال تغییرات
        proj.do(changes)

        # حالا فایل رو واقعاً بخونیم
        with open(file_path, "r", encoding="utf-8") as f:
            new_content = f.read()
        print(new_content)

    finally:
        # بستن پروژه
        proj.close()

if __name__ == "__main__":
    main()