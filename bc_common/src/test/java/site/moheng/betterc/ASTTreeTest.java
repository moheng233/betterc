package site.moheng.betterc;

import org.junit.jupiter.api.Test;
import site.moheng.betterc.ast.ImportNode;
import site.moheng.betterc.ast.ProgramNode;

class ASTTreeTest {
    @Test
    public void testASTTree() {
        final ASTTree tree = new ASTTree();

        final ProgramNode program = new ProgramNode("test", "test.bc");
        tree.tree.add(program);

        tree.tree.add(new ImportNode(program, "test", "test1.bc", null));
        tree.tree.add(new ImportNode(program, "test", "test2.bc", null));
        tree.tree.add(new ImportNode(program, "test", "test3.bc", null));

        try (var children = tree.findChildren(program, ImportNode.class)) {
            for (final var child : children) {
                System.out.println(child.toString());
            }
        }
    }

}