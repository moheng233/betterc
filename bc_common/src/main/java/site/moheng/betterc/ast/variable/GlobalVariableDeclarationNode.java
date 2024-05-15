package site.moheng.betterc.ast.variable;

import site.moheng.betterc.ast.ASTTypeExpressionNode;
import site.moheng.betterc.ast.ASTVariableDeclaration;

public record GlobalVariableDeclarationNode(
        String name,
        ASTTypeExpressionNode type
) implements ASTVariableDeclaration {
}
