package site.moheng.betterc.ast.ref;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ASTActualNode;
import site.moheng.betterc.ast.ASTExpressionNode;
import site.moheng.betterc.ast.ASTRefNode;
import site.moheng.betterc.ast.ASTVariableDeclaration;

@ToString
@EqualsAndHashCode
@AllArgsConstructor(staticName = "from")
public class VariableRefNode implements ASTRefNode<ASTVariableDeclaration>, ASTExpressionNode, ASTActualNode<BCParser.VariableAccessRefContext> {
    @NonNull BCParser.VariableAccessRefContext context;

    public @NonNull BCParser.VariableAccessRefContext context() {
        return context;
    }
}
