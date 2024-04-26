package site.moheng.betterc.symbol.type;

public interface BCTypeSymbol {
    String getName();

    /**
     * @return 获取映射到C的符号名称
     */
    String getMappingName();
}
