package site.moheng.betterc.symbol.type;

import lombok.Value;

/**
 * 直接映射到C层的基元类型
 */
@Value(staticConstructor = "of")
public class BCMappingTypeSymbol implements BCTypeSymbol {
    static public BCMappingTypeSymbol VOID = BCMappingTypeSymbol.of("void", "void");
    static public BCMappingTypeSymbol BOOLEAN = BCMappingTypeSymbol.of("bool", "boolean");
    static public BCMappingTypeSymbol INT = BCMappingTypeSymbol.of("int", "int");
    static public BCMappingTypeSymbol FLOAT = BCMappingTypeSymbol.of("float", "float");
    static public BCMappingTypeSymbol CHAR = BCMappingTypeSymbol.of("char", "char");

    String name;
    String mappingName;

    @Override
    public String getMappingName() {
        return mappingName;
    }
}
