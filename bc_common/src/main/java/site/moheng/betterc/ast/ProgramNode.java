package site.moheng.betterc.ast;

import lombok.Singular;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.method.GlobalMethodDeclarationNode;

import java.util.Set;

public record ProgramNode(
        BCParser.ProgramContext context,
        String namespace,
        String path,
        @Singular("import_") Set<ImportNode> imports,
        @Singular("interface_") Set<InterfaceDeclarationNode> interfaces,
        @Singular Set<StructDeclarationNode> structs,
        @Singular Set<GlobalMethodDeclarationNode> methods
) implements ASTNode, ASTActualNode<BCParser.ProgramContext>, ASTScopeNode {
    public static ProgramNode from(BCParser.ProgramContext context) {

    }
}
