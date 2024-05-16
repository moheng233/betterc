package site.moheng.betterc.ast;

import site.moheng.betterc.antlr.BCParser;

public interface ASTStatementNode extends ASTNode {
    static ASTStatementNode from(BCParser.StatementContext context) {
        return null;
    }
}
