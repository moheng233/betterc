package site.moheng.betterc;

import com.googlecode.cqengine.attribute.Attribute;
import com.googlecode.cqengine.attribute.MultiValueAttribute;
import com.googlecode.cqengine.attribute.SimpleAttribute;
import com.googlecode.cqengine.attribute.SimpleNullableAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;
import lombok.experimental.UtilityClass;
import site.moheng.betterc.ast.ASTNode;
import site.moheng.betterc.ast.ASTNodeHasNamed;

import java.util.List;

@UtilityClass
public final class ASTUtil {
    public static final SimpleAttribute<ASTNode, Integer> HASHCODE = new SimpleAttribute<>() {
        @Override
        public Integer getValue(final ASTNode object, final QueryOptions queryOptions) {
            return object.hashCode();
        }
    };

    public static final Attribute<ASTNode, Class<?>> CLASS = new SimpleAttribute<>("class") {
        @Override
        public Class<?> getValue(final ASTNode object, final QueryOptions queryOptions) {
            return object.getClass();
        }
    };

    public static final MultiValueAttribute<ASTNode, Class<?>> SUPPORT = new MultiValueAttribute<>() {
        @Override
        public Iterable<Class<?>> getValues(final ASTNode object, final QueryOptions queryOptions) {
            return List.of(object.getClass().getInterfaces());
        }
    };

    public static final Attribute<ASTNode, String> NAME = new SimpleNullableAttribute<>("name") {
        @Override
        public String getValue(final ASTNode object, final QueryOptions queryOptions) {
            if (object instanceof ASTNodeHasNamed named) {
                return named.name();
            }
            return null;
        }
    };
}
