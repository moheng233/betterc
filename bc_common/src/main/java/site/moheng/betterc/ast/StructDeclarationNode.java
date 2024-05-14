package site.moheng.betterc.ast;

public record StructDeclarationNode(
        ProgramNode parent,
        String name
) implements ASTNode, ASTTypeDeclarationNode, ASTScopeNode {
}
