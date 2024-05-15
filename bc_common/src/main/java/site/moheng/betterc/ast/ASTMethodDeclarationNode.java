package site.moheng.betterc.ast;

import site.moheng.betterc.antlr.BCParser;

import java.util.List;

public interface ASTMethodDeclarationNode extends ASTNodeHasNamed, ASTTypeDeclarationNode, ASTScopeNode {
    ASTTypeExpressionNode returnType();

    List<MethodArgDeclaration> args();

    record MethodArgDeclaration(
            BCParser.UniArgDefContext context,
            String name,
            ASTTypeExpressionNode type
    ) implements ASTNode, ASTActualNode<BCParser.UniArgDefContext> {
        public static MethodArgDeclaration from(BCParser.UniArgDefContext context) {
            return new MethodArgDeclaration(
                    context.name.getText(),
                    ASTTypeExpressionNode.from(context.type)
            );
        }
    }
}
