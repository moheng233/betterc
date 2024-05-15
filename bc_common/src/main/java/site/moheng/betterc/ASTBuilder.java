package site.moheng.betterc;

import site.moheng.betterc.antlr.BCBaseVisitor;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.*;
import site.moheng.betterc.ast.method.GlobalMethodDeclarationNode;

/*
 * 将Antlr的可变CST转换为不可变的AST
 * 尽量重用节点
 */
public class ASTBuilder extends BCBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProgram(final BCParser.ProgramContext ctx) {
        final ProgramNode.ProgramNodeBuilder builder = ProgramNode.builder();

        for (int i = 0; i < ctx.imports.size(); i++) {
            builder.import_((ImportNode) visitImportDeclartion(ctx.imports.get(i)));
        }

        for (int i = 0; i < ctx.interfaces.size(); i++) {
            builder.interface_((InterfaceDeclarationNode) visitInterfaceDeclaration(ctx.interfaces.get(i)));
        }

        for (int i = 0; i < ctx.methods.size(); i++) {
            builder.method((GlobalMethodDeclarationNode) visitMethodDeclaration(ctx.methods.get(i)));
        }

        for (int i = 0; i < ctx.structs.size(); i++) {
            builder.struct((StructDeclarationNode) visitStructDeclaration(ctx.structs.get(i)));
        }

        return builder.build();
    }

    public ASTNode visitImportDeclartion(final BCParser.ImportDeclartionContext ctx) {


        return new ImportNode(ctx.STRING().getText());
    }

    @Override
    public ImplementDeclarationNode visitImplementDeclaration(final BCParser.ImplementDeclarationContext ctx) {

    }
}
