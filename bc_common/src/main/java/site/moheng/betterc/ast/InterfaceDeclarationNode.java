package site.moheng.betterc.ast;

public record InterfaceDeclarationNode(
        String name
) implements ASTNode, ASTTypeDeclarationNode {
}
