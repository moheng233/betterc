package site.moheng.betterc.ast;

import site.moheng.betterc.ast.method.GlobalMethodDeclarationNode;

import java.util.Set;

public record ProgramNode(
        String namespace,
        String path,
        Set<ImportNode> imports,
        Set<InterfaceDeclarationNode> interfaces,
        Set<StructDeclarationNode> structs,
        Set<GlobalMethodDeclarationNode> methods
) implements ASTNode, ASTScopeNode {
}
