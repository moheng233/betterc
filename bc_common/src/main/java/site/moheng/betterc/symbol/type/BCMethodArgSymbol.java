package site.moheng.betterc.symbol.type;

import lombok.Value;
import lombok.With;

@Value(staticConstructor = "of")
public class BCMethodArgSymbol implements BCTypeSymbol {
    String name;
    @With BCTypeSymbol type;

    /**
     * @return
     */
    @Override
    public String getMappingName() {
        return "";
    }
}
