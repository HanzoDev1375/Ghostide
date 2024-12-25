package ir.ninjacoder.ghostide.config;

public class CreatorComment {

  /** code by Ninja coder */
  /**
   * This class may be long and tedious, but it is not possible to create a separate language for
   * each nature.
   */

  /** this class Comment Maker from Lang Ghost web ide */

  /**
   * This code works well for JavaScript CSS3 Java and other languages. We use the p tag to identify
   * Java or any other language.
   *
   * <p>
   */
  public static String setCommentFromJava(String code, boolean isParamMod) {
    String[] lineParam = code.split("\n");
    if (isParamMod) {
      var comment = new StringBuilder("/**\n");
      for (String line : lineParam) {
        comment.append(" * @param ").append(line).append("\n");
      }
      return comment.append(" */").toString();
    } else {
      var comment = new StringBuilder("/*\n");
      for (String line : lineParam) {
        comment.append(" * <p> ").append(line).append(" </p>").append("\n");
      }
      return comment.append(" */").toString();
    }
  }

  public static String setCommentFromJava(String code) {
    return setCommentFromJava(code, false);
  }

  /**
   * This code is for commenting text in Python because using 3" is not recommended. This may be
   * considered a string code and confusing the user.
   */
  public static String setCommentLongPython(String code) {
    String[] lineParam = code.split("\n");
    var comment = new StringBuilder("#\n");
    for (String line : lineParam) {
      comment.append(" # @param ").append(line).append("\n");
    }
    return comment.append(" /*").toString();
  }

  /**
   * This code is for hardware XML languages. This code may not work well, but we will update it in
   * later versions and improve its performance.
   */
  public String setCommentFromXml(String text) {
    String[] lines = text.split("\n");
    StringBuilder comment = new StringBuilder("<!--\n");
    for (String line : lines) {
      comment.append("- ").append(line).append("\n");
    }
    return comment.append(" -->").toString();
  }
  // test comment

  /**
   * @param test
   * @return test
   */
}
