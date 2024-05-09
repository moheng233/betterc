package site.moheng.betterc.symbol.type;

public interface BCTypeSymbol {
    static public BCTypeSymbol UNKNOWN = new BCTypeSymbol() {
        @Override
        public String getName() {
            return "unknown";
        }

        @Override
        public String getMappingName() {
            return "unknown";
        }

        @Override
        public boolean isUnknown() {
            return true;
        }
    };

    String getName();

    /**
     * @return 获取映射到C的符号名称
     */
    String getMappingName();

    default boolean isUnknown() {
        return false;
    }

    /**
     * @return
     */
    default BCTypeSymbol compatible(BCTypeSymbol other) {
        return BCTypeSymbol.UNKNOWN;
    }
}
