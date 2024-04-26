package site.moheng.betterc.symbol.type;

import lombok.Value;
import lombok.With;

/**
 * 在BetterC中实现的结构体字段
 */
@Value(staticConstructor = "of")
public class BCStructFieldSymbol implements BCTypeSymbol {
    String name;
    @With BCTypeSymbol type;

    @Override
    public String getMappingName() {
        return name;
    }
}