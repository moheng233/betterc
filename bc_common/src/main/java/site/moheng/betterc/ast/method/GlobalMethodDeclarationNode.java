package site.moheng.betterc.ast.method;

import site.moheng.betterc.ast.ASTMethodDeclarationNode;
import site.moheng.betterc.ast.ProgramNode;
import site.moheng.betterc.ast.ref.TypeRefNode;

import java.util.List;

public record GlobalMethodDeclarationNode(
        ProgramNode parent,
        String name,
        TypeRefNode<?> returnType,
        List<MethodArgDeclaration> args
) implements ASTMethodDeclarationNode {


}
