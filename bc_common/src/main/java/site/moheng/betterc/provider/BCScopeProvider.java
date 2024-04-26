package site.moheng.betterc.provider;

import org.antlr.v4.runtime.Token;
import site.moheng.betterc.antlr.BCParser;
import site.moheng.betterc.scope.BCLibraryScope;
import site.moheng.betterc.symbol.type.BCTypeSymbol;

import java.util.HashMap;
import java.util.Map;

public class BCScopeProvider {

    private final BCTypeProvider provider;

    public BCScopeProvider(BCTypeProvider provider) {
        this.provider = provider;
    }

    public BCLibraryScope getScope(BCParser.ProgramContext ctx) {
        final Map<Token, BCTypeSymbol> map = new HashMap<>();

        for (final var struct : ctx.structs) {
//            map.put(struct.name.id, provider.getType(struct));
        }

        return new BCLibraryScope(map);
    }

}
