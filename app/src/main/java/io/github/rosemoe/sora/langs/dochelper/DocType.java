package io.github.rosemoe.sora.langs.dochelper;

public class DocType {
  /*
  code by ninja coder try to using Ghost web ide
  */

  public DocType() {} /*
     * getNev
     */

  public String Space() {
    return "  ";
  }

  public String getTab() {
    return "\n";
  }

  public String getCss3() {
    return "html{\n	color : blue;\n	background-color : #ff000000;\n	position : relative;\n	padding : 0px;\n	top :0px;\n	bottom :0px;\n	left : 0px;\n	text-align : left;\n}\n";
  }

  public String getHtml5() {
    return "<!DOCTYPE html>\n<html lang=\"en\"> \n  <head> \n    <meta charset=\"UTF-8\"> \n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n    <title>Document</title> \n  </head> \n  <body>  \n  </body>\n</html>";
  }

  public String cssColor(String colors) {
    switch (colors) {
      case "red":
        return "#ff0000";
      case "blue":
        return "#01E4F9";
      case "green":
        return "#01F960";
      default:
        return "0";
    }
  }
}
