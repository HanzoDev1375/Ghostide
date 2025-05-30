package com.ninjacoder.jgit.license.utils;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.comments.BlockComment;
import com.ninjacoder.jgit.license.enums.LicenseType;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class LicenseManager {
  private static final Map<LicenseType, String> LICENSE_TEMPLATES = new HashMap<>();

  static {
    LICENSE_TEMPLATES.put(
        LicenseType.APACHE_2_0,
        "Copyright © %d %s\n"
            + "\n"
            + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
            + "you may not use this file except in compliance with the License.\n"
            + "You may obtain a copy of the License at\n"
            + "\n"
            + "    http://www.apache.org/licenses/LICENSE-2.0\n"
            + "\n"
            + "Unless required by applicable law or agreed to in writing, software\n"
            + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
            + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
            + "See the License for the specific language governing permissions and\n"
            + "limitations under the License.\n"
            + "\n"
            + "Developed by %s");

    LICENSE_TEMPLATES.put(
        LicenseType.MIT,
        "Copyright (c) %d %s\n"
            + "\n"
            + "Permission is hereby granted, free of charge, to any person obtaining a copy\n"
            + "of this software and associated documentation files (the \"Software\"), to deal\n"
            + "in the Software without restriction, including without limitation the rights\n"
            + "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n"
            + "copies of the Software, and to permit persons to whom the Software is\n"
            + "furnished to do so, subject to the following conditions:\n"
            + "\n"
            + "The above copyright notice and this permission notice shall be included in all\n"
            + "copies or substantial portions of the Software.\n"
            + "\n"
            + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n"
            + "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n"
            + "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n"
            + "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n"
            + "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n"
            + "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE\n"
            + "SOFTWARE.\n"
            + "\n"
            + "Developed by %s");

    LICENSE_TEMPLATES.put(
        LicenseType.GPL_3_0,
        "Copyright (C) %d %s\n"
            + "\n"
            + "This program is free software: you can redistribute it and/or modify\n"
            + "it under the terms of the GNU General Public License as published by\n"
            + "the Free Software Foundation, either version 3 of the License, or\n"
            + "(at your option) any later version.\n"
            + "\n"
            + "This program is distributed in the hope that it will be useful,\n"
            + "but WITHOUT ANY WARRANTY; without even the implied warranty of\n"
            + "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n"
            + "GNU General Public License for more details.\n"
            + "\n"
            + "You should have received a copy of the GNU General Public License\n"
            + "along with this program.  If not, see <https://www.gnu.org/licenses/>.\n"
            + "\n"
            + "Developed by %s");
  }

  public static String addLicenseToCode(
      String javaCode, LicenseType licenseType, String authorName, String companyName) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(javaCode);
      String licenseText = generateLicenseText(licenseType, authorName, companyName);
      BlockComment licenseComment = new BlockComment(licenseText);
      cu.addOrphanComment(licenseComment);
      
      if (cu.getPackageDeclaration().isPresent()) {
        cu.getPackageDeclaration().get().addOrphanComment(licenseComment);
      } else {
        cu.addOrphanComment(licenseComment);
      }
      
      return cu.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return javaCode;
    }
}

  private static String generateLicenseText(
      LicenseType licenseType, String authorName, String companyName) {
    int currentYear = Year.now().getValue();
    String template = LICENSE_TEMPLATES.get(licenseType);
    return String.format(template, currentYear, companyName, authorName);
  }
}
