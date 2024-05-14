package site.moheng.betterc.ast.statement;

import site.moheng.betterc.ast.ASTStatementNode;
import site.moheng.betterc.ast.ASTTypeDeclarationNode;
import site.moheng.betterc.ast.ASTVariableDeclaration;
import site.moheng.betterc.ast.ProgramNode;
import site.moheng.betterc.ast.ref.TypeRefNode;

public record VariableDeclarationStatementNode(
        ProgramNode parent,
        String name,
        TypeRefNode<ASTTypeDeclarationNode> type
) implements ASTStatementNode, ASTVariableDeclaration {
}
