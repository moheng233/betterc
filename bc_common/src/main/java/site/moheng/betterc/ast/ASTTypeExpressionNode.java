package site.moheng.betterc.ast;

import site.moheng.betterc.antlr.BCParser;

public interface ASTTypeExpressionNode extends ASTNode {
    static ASTTypeExpressionNode from(BCParser.TypeExprContext context) {
        return null;
    }
}
