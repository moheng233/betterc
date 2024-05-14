package site.moheng.betterc.ast;

import site.moheng.betterc.ast.ref.TypeRefNode;

public interface ASTVariableDeclaration extends ASTNodeHasNamed {
    TypeRefNode<ASTTypeDeclarationNode> type();
}
