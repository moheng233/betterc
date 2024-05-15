package site.moheng.betterc.ast.ref;

import site.moheng.betterc.ast.ASTRefNode;
import site.moheng.betterc.ast.ASTTypeDeclarationNode;
import site.moheng.betterc.ast.ASTTypeExpressionNode;

public interface TypeRefNode<T extends ASTTypeDeclarationNode> extends ASTRefNode<T>, ASTTypeExpressionNode {
    TypeRefNode<ASTTypeDeclarationNode> UNKNOWN = new TypeRefNode<>() {

    };
}
