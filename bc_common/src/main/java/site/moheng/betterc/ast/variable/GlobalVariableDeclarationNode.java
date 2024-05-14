package site.moheng.betterc.ast.variable;

import site.moheng.betterc.ast.ASTTypeDeclarationNode;
import site.moheng.betterc.ast.ASTVariableDeclaration;
import site.moheng.betterc.ast.ProgramNode;
import site.moheng.betterc.ast.ref.TypeRefNode;

public record GlobalVariableDeclarationNode(
        ProgramNode parent,
        String name,
        TypeRefNode<ASTTypeDeclarationNode> type
) implements ASTVariableDeclaration {
}
