package site.moheng.betterc.ast;

import site.moheng.betterc.ast.ref.TypeRefNode;

import java.util.List;

public interface ASTMethodDeclarationNode extends ASTNodeHasNamed, ASTTypeDeclarationNode, ASTScopeNode {
    TypeRefNode<?> returnType();

    List<MethodArgDeclaration> args();

    record MethodArgDeclaration(
            String name,
            TypeRefNode<?> type
    ) {

    }
}
