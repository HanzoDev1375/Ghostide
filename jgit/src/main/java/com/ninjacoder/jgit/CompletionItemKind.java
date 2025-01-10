package com.ninjacoder.jgit;

public enum CompletionItemKind {
  Identifier(0, 0xffabb6bd),
  Text(0, 0xffabb6bd),
  Method(1, 0xfff4b2be),
  Function(2, 0xfff4b2be),
  Constructor(3, 0xfff4b2be),
  Field(4, 0xfff1c883),
  Variable(5, 0xfff1c883),
  Class(6, 0xff85cce5),
  Interface(7, 0xff99cb87),
  Module(8, 0xff85cce5),
  Property(9, 0xffcebcf4),
  Unit(10),
  Value(11, 0xfff1c883),
  Enum(12, 0xff85cce5),
  Keyword(13, 0xffcc7832),
  Snippet(14),
  Color(15, 0xfff4b2be),
  Reference(17),
  File(16),
  Folder(18),
  EnumMember(19),
  Constant(20, 0xfff1c883),
  Struct(21, 0xffcebcf4),
  Event(22),
  Operator(23, 0xffeaabb6),
  TypeParameter(24, 0xfff1c883),
  User(25),
  Issue(26);

  private int value = 0;
  private long defaultDisplayBackgroundColor = 0;
  private String displayString = "";
  CompletionItemKind(int value, long defaultDisplayBackgroundColor) {
    value = value;
    defaultDisplayBackgroundColor = defaultDisplayBackgroundColor;
    displayString = name().substring(0, 1);
  }

  CompletionItemKind(int value) {
    this(value, 0);
  }

  public String getDisplayChar() {
    return displayString;
  }

  public long getDefaultDisplayBackgroundColor() {
    return this.defaultDisplayBackgroundColor;
  }
}
