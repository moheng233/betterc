package site.moheng.betterc.ast;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ref.TypeRefNode;

import java.util.List;

@Builder
public record InterfaceMethodDeclarationNode(
        @NonNull BCParser.InterfaceMethodFieldContext context,
        @NonNull String name,
        @NonNull TypeRefNode<?> returnType,
        @Singular List<MethodArgDeclaration> args
) implements ASTNode, ASTMethodDeclarationNode, ASTActualNode<BCParser.InterfaceMethodFieldContext> {
}
