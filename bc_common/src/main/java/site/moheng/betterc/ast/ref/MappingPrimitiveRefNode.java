package site.moheng.betterc.ast.ref;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ASTActualNode;
import site.moheng.betterc.ast.mapping.MappingPrimitiveDeclarationNode;

@ToString
@EqualsAndHashCode
@AllArgsConstructor(staticName = "from")
public class MappingPrimitiveRefNode implements TypeRefNode<MappingPrimitiveDeclarationNode>, ASTActualNode<BCParser.TypeExprContext> {
    @NonNull BCParser.TypeExprContext context;

    public @NonNull BCParser.TypeExprContext context() {
        return context;
    }

}
