// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide/grammars-v4/SVG.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.svg;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SVGParser}.
 */
public interface SVGListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SVGParser#svg}.
	 * @param ctx the parse tree
	 */
	void enterSvg(SVGParser.SvgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVGParser#svg}.
	 * @param ctx the parse tree
	 */
	void exitSvg(SVGParser.SvgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVGParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(SVGParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVGParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(SVGParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVGParser#footer}.
	 * @param ctx the parse tree
	 */
	void enterFooter(SVGParser.FooterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVGParser#footer}.
	 * @param ctx the parse tree
	 */
	void exitFooter(SVGParser.FooterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVGParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(SVGParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVGParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(SVGParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVGParser#circle}.
	 * @param ctx the parse tree
	 */
	void enterCircle(SVGParser.CircleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVGParser#circle}.
	 * @param ctx the parse tree
	 */
	void exitCircle(SVGParser.CircleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVGParser#rectangle}.
	 * @param ctx the parse tree
	 */
	void enterRectangle(SVGParser.RectangleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVGParser#rectangle}.
	 * @param ctx the parse tree
	 */
	void exitRectangle(SVGParser.RectangleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVGParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(SVGParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVGParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(SVGParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVGParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(SVGParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVGParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(SVGParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVGParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(SVGParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVGParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(SVGParser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVGParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(SVGParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVGParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(SVGParser.AttributeContext ctx);
}