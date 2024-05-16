package site.moheng.betterc.ast;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.ast.method.GlobalMethodDeclarationNode;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProgramNode implements ASTNode, ASTActualNode<BCParser.ProgramContext>, ASTScopeNode {
    @NonNull private BCParser.ProgramContext context;
    @NonNull private String namespace;
    @NonNull private String path;
    private Set<ImportNode> imports = Set.of();
    private Set<InterfaceDeclarationNode> interfaces = Set.of();
    private Set<StructDeclarationNode> structs = Set.of();
    private Set<GlobalMethodDeclarationNode> methods = Set.of();

    public static ProgramNode from(ASTBuilderContext util, BCParser.ProgramContext context) {
        final var namespace = util.namespace();
        final var path = util.path();
        final var imports = context.imports.stream()
                .map(ImportNode::from)
                .collect(Collectors.toSet());
        final var interfaces = context.interfaces.stream()
                .map(InterfaceDeclarationNode::from)
                .collect(Collectors.toSet());
        final var structs = context.structs.stream()
                .map(StructDeclarationNode::from)
                .collect(Collectors.toSet());
        final var methods = context.methods.stream()
                .map(GlobalMethodDeclarationNode::from)
                .collect(Collectors.toSet());
        return new ProgramNode(context, namespace, path, imports, interfaces, structs, methods);
    }
}
