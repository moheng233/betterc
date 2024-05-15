package site.moheng.betterc.ast;

import java.util.List;

public interface ASTMethodHasBodyDeclarationNode extends ASTMethodDeclarationNode {
    List<ASTStatementNode> statements();
}
