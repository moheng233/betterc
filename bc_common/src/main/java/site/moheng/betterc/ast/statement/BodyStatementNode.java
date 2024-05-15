package site.moheng.betterc.ast.statement;

import lombok.Builder;
import lombok.Singular;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ASTActualNode;
import site.moheng.betterc.ast.ASTStatementNode;

import java.util.Set;

@Builder
public record BodyStatementNode(
        BCParser.BodyStatementContext context,
        @Singular Set<ASTStatementNode> statements
) implements ASTStatementNode, ASTActualNode<BCParser.BodyStatementContext> {
}
