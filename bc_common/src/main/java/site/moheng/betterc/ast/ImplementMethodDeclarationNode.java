package site.moheng.betterc.ast;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.With;
import site.moheng.betterc.antlr.BCParser;

import java.util.List;

@Builder
public record ImplementMethodDeclarationNode(
        @With @NonNull BCParser.ImplementMethodContext context,
        @NonNull String name,
        @NonNull ASTTypeExpressionNode returnType,
        @Singular List<MethodArgDeclaration> args,
        @Singular List<ASTStatementNode> statements
) implements ASTNode, ASTMethodHasBodyDeclarationNode, ASTActualNode<BCParser.ImplementMethodContext> {

    public static ImplementMethodDeclarationNode from(@NonNull BCParser.ImplementMethodContext context) {
        final var method = context.methodDeclaration();
        final var name = method.name.getText();
        final var returnType = ASTTypeExpressionNode.from(method.returnValue);
        final var args = method.args.stream()
                .map(MethodArgDeclaration::from)
                .toList();
        final var statements = method.body.statements.stream()
                .map(ASTStatementNode::from)
                .toList();
        return ImplementMethodDeclarationNode.builder()
                .context(context)
                .name(name)
                .returnType(returnType)
                .args(args)
                .statements(statements)
                .build();
    }
}
