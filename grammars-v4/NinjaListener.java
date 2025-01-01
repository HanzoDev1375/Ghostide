// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide2/grammars-v4/Ninja.g4 by ANTLR 4.13.1
package org.antlr.parser.antlr4.ninja;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NinjaParser}.
 */
public interface NinjaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code installRule}
	 * labeled alternative in {@link NinjaParser#install}.
	 * @param ctx the parse tree
	 */
	void enterInstallRule(NinjaParser.InstallRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code installRule}
	 * labeled alternative in {@link NinjaParser#install}.
	 * @param ctx the parse tree
	 */
	void exitInstallRule(NinjaParser.InstallRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link NinjaParser#user}.
	 * @param ctx the parse tree
	 */
	void enterUser(NinjaParser.UserContext ctx);
	/**
	 * Exit a parse tree produced by {@link NinjaParser#user}.
	 * @param ctx the parse tree
	 */
	void exitUser(NinjaParser.UserContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link NinjaParser#forsteament}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(NinjaParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link NinjaParser#forsteament}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(NinjaParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatementWithBlock}
	 * labeled alternative in {@link NinjaParser#ifsteament}.
	 * @param ctx the parse tree
	 */
	void enterIfStatementWithBlock(NinjaParser.IfStatementWithBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatementWithBlock}
	 * labeled alternative in {@link NinjaParser#ifsteament}.
	 * @param ctx the parse tree
	 */
	void exitIfStatementWithBlock(NinjaParser.IfStatementWithBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatementWithoutBlock}
	 * labeled alternative in {@link NinjaParser#ifsteament}.
	 * @param ctx the parse tree
	 */
	void enterIfStatementWithoutBlock(NinjaParser.IfStatementWithoutBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatementWithoutBlock}
	 * labeled alternative in {@link NinjaParser#ifsteament}.
	 * @param ctx the parse tree
	 */
	void exitIfStatementWithoutBlock(NinjaParser.IfStatementWithoutBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pwdStatement}
	 * labeled alternative in {@link NinjaParser#pwdstemant}.
	 * @param ctx the parse tree
	 */
	void enterPwdStatement(NinjaParser.PwdStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pwdStatement}
	 * labeled alternative in {@link NinjaParser#pwdstemant}.
	 * @param ctx the parse tree
	 */
	void exitPwdStatement(NinjaParser.PwdStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code coordinatedStatement}
	 * labeled alternative in {@link NinjaParser#coordinatedstemant}.
	 * @param ctx the parse tree
	 */
	void enterCoordinatedStatement(NinjaParser.CoordinatedStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code coordinatedStatement}
	 * labeled alternative in {@link NinjaParser#coordinatedstemant}.
	 * @param ctx the parse tree
	 */
	void exitCoordinatedStatement(NinjaParser.CoordinatedStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setStatement}
	 * labeled alternative in {@link NinjaParser#setstement}.
	 * @param ctx the parse tree
	 */
	void enterSetStatement(NinjaParser.SetStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setStatement}
	 * labeled alternative in {@link NinjaParser#setstement}.
	 * @param ctx the parse tree
	 */
	void exitSetStatement(NinjaParser.SetStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getStatementWithoutCall}
	 * labeled alternative in {@link NinjaParser#getstement}.
	 * @param ctx the parse tree
	 */
	void enterGetStatementWithoutCall(NinjaParser.GetStatementWithoutCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getStatementWithoutCall}
	 * labeled alternative in {@link NinjaParser#getstement}.
	 * @param ctx the parse tree
	 */
	void exitGetStatementWithoutCall(NinjaParser.GetStatementWithoutCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getStatementWithCall}
	 * labeled alternative in {@link NinjaParser#getstement}.
	 * @param ctx the parse tree
	 */
	void enterGetStatementWithCall(NinjaParser.GetStatementWithCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getStatementWithCall}
	 * labeled alternative in {@link NinjaParser#getstement}.
	 * @param ctx the parse tree
	 */
	void exitGetStatementWithCall(NinjaParser.GetStatementWithCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classStatement}
	 * labeled alternative in {@link NinjaParser#classorinterfacePaser}.
	 * @param ctx the parse tree
	 */
	void enterClassStatement(NinjaParser.ClassStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classStatement}
	 * labeled alternative in {@link NinjaParser#classorinterfacePaser}.
	 * @param ctx the parse tree
	 */
	void exitClassStatement(NinjaParser.ClassStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code interfaceStatement}
	 * labeled alternative in {@link NinjaParser#classorinterfacePaser}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceStatement(NinjaParser.InterfaceStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code interfaceStatement}
	 * labeled alternative in {@link NinjaParser#classorinterfacePaser}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceStatement(NinjaParser.InterfaceStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tryStatementWithBlock}
	 * labeled alternative in {@link NinjaParser#trystemant}.
	 * @param ctx the parse tree
	 */
	void enterTryStatementWithBlock(NinjaParser.TryStatementWithBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tryStatementWithBlock}
	 * labeled alternative in {@link NinjaParser#trystemant}.
	 * @param ctx the parse tree
	 */
	void exitTryStatementWithBlock(NinjaParser.TryStatementWithBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tryStatementWithoutBlock}
	 * labeled alternative in {@link NinjaParser#trystemant}.
	 * @param ctx the parse tree
	 */
	void enterTryStatementWithoutBlock(NinjaParser.TryStatementWithoutBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tryStatementWithoutBlock}
	 * labeled alternative in {@link NinjaParser#trystemant}.
	 * @param ctx the parse tree
	 */
	void exitTryStatementWithoutBlock(NinjaParser.TryStatementWithoutBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code handlerStatement}
	 * labeled alternative in {@link NinjaParser#hanlderstemant}.
	 * @param ctx the parse tree
	 */
	void enterHandlerStatement(NinjaParser.HandlerStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code handlerStatement}
	 * labeled alternative in {@link NinjaParser#hanlderstemant}.
	 * @param ctx the parse tree
	 */
	void exitHandlerStatement(NinjaParser.HandlerStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aslomod}
	 * labeled alternative in {@link NinjaParser#asloruner}.
	 * @param ctx the parse tree
	 */
	void enterAslomod(NinjaParser.AslomodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aslomod}
	 * labeled alternative in {@link NinjaParser#asloruner}.
	 * @param ctx the parse tree
	 */
	void exitAslomod(NinjaParser.AslomodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code runmod}
	 * labeled alternative in {@link NinjaParser#runruner}.
	 * @param ctx the parse tree
	 */
	void enterRunmod(NinjaParser.RunmodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code runmod}
	 * labeled alternative in {@link NinjaParser#runruner}.
	 * @param ctx the parse tree
	 */
	void exitRunmod(NinjaParser.RunmodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code applymod}
	 * labeled alternative in {@link NinjaParser#applyruner}.
	 * @param ctx the parse tree
	 */
	void enterApplymod(NinjaParser.ApplymodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code applymod}
	 * labeled alternative in {@link NinjaParser#applyruner}.
	 * @param ctx the parse tree
	 */
	void exitApplymod(NinjaParser.ApplymodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hashCoommentModel}
	 * labeled alternative in {@link NinjaParser#hashcomment}.
	 * @param ctx the parse tree
	 */
	void enterHashCoommentModel(NinjaParser.HashCoommentModelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hashCoommentModel}
	 * labeled alternative in {@link NinjaParser#hashcomment}.
	 * @param ctx the parse tree
	 */
	void exitHashCoommentModel(NinjaParser.HashCoommentModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link NinjaParser#opentagid}.
	 * @param ctx the parse tree
	 */
	void enterOpentagid(NinjaParser.OpentagidContext ctx);
	/**
	 * Exit a parse tree produced by {@link NinjaParser#opentagid}.
	 * @param ctx the parse tree
	 */
	void exitOpentagid(NinjaParser.OpentagidContext ctx);
}