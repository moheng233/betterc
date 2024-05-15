package site.moheng.betterc.ast;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.ref.InterfaceRefNode;
import site.moheng.betterc.ast.ref.StructRefNode;

import java.util.List;

public record ImplementDeclarationNode(
        @NonNull BCParser.ImplementDeclarationContext context,
        @NonNull StructRefNode struct,
        @Nullable InterfaceRefNode forInterface,
        @NonNull List<ImplementMethodDeclarationNode> methods
) implements ASTNode, ASTScopeNode, ASTActualNode<BCParser.ImplementDeclarationContext> {
    static @Nullable ImplementDeclarationNode from(@NonNull BCParser.ImplementDeclarationContext context) {
        final var struct = StructRefNode.from(context.struct);
        final var forInterface = InterfaceRefNode.from(context.interface_);
        final var methods = context.methods.stream()
                .map(ImplementMethodDeclarationNode::from)
                .toList();
        return null;
    }
}
