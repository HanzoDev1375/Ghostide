import jsbeautifier
import os
import sys

# بررسی اینکه کاربر مسیر فایل رو داده یا نه
if len(sys.argv) < 2:
    print("⚠️ لطفاً مسیر فایل جاوااسکریپت رو وارد کنید.")
    print("مثال: python jsformat.py /storage/emulated/0/apk/index.js")
    sys.exit(1)

file_path = sys.argv[1]

if os.path.exists(file_path):
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()

    # فرمت کردن
    beautified = jsbeautifier.beautify(content)

    # بازنویسی فایل
    with open(file_path, "w", encoding="utf-8") as f:
        f.write(beautified)

    print(f"✅ فایل '{file_path}' با موفقیت زیبا شد.")
else:
    print(f"❌ خطا: فایل در مسیر '{file_path}' پیدا نشد.")