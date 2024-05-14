package site.moheng.betterc;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.index.radix.RadixTreeIndex;
import com.googlecode.cqengine.persistence.onheap.OnHeapPersistence;
import com.googlecode.cqengine.query.QueryFactory;
import com.googlecode.cqengine.resultset.ResultSet;
import site.moheng.betterc.ast.ASTNode;

public class ASTTree {
    public final ConcurrentIndexedCollection<ASTNode> tree = new ConcurrentIndexedCollection<>(OnHeapPersistence.onPrimaryKey(ASTUtil.HASHCODE));

    public ASTTree() {
        tree.addIndex(HashIndex.onAttribute(ASTUtil.PARENT));
        tree.addIndex(HashIndex.onAttribute(ASTUtil.CLASS));
        tree.addIndex(RadixTreeIndex.onAttribute(ASTUtil.NAME));
    }

    public <T extends ASTNode> ResultSet<T> findChildren(ASTNode node, Class<T> classz) {
        return (ResultSet<T>) tree.retrieve(QueryFactory.and(
                QueryFactory.equal(ASTUtil.PARENT, node),
                QueryFactory.equal(ASTUtil.CLASS, classz)
        ));
    }
}
