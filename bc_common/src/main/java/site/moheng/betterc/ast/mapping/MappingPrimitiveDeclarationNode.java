package site.moheng.betterc.ast.mapping;

import site.moheng.betterc.ast.ASTTypeDeclarationNode;
import site.moheng.betterc.ast.ProgramNode;

public record MappingPrimitiveDeclarationNode(
        ProgramNode parent,
        String name
) implements ASTTypeDeclarationNode {
}
