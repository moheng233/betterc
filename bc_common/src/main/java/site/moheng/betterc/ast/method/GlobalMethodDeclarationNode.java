package site.moheng.betterc.ast.method;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ASTActualNode;
import site.moheng.betterc.ast.ASTMethodHasBodyDeclarationNode;
import site.moheng.betterc.ast.ASTStatementNode;
import site.moheng.betterc.ast.ASTTypeExpressionNode;

import java.util.List;

@Builder
public record GlobalMethodDeclarationNode(
        @NonNull BCParser.MethodDeclarationContext context,
        String name,
        ASTTypeExpressionNode returnType,
        @Singular List<MethodArgDeclaration> args,
        @Singular List<ASTStatementNode> statements
) implements ASTMethodHasBodyDeclarationNode, ASTActualNode<BCParser.MethodDeclarationContext> {


}
