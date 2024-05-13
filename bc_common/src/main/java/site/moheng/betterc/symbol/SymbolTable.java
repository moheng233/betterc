package site.moheng.betterc.symbol;

import com.googlecode.cqengine.ConcurrentIndexedCollection;
import com.googlecode.cqengine.index.hash.HashIndex;
import com.googlecode.cqengine.index.radix.RadixTreeIndex;
import com.googlecode.cqengine.index.unique.UniqueIndex;
import com.googlecode.cqengine.query.QueryFactory;
import org.antlr.v4.runtime.ParserRuleContext;
import site.moheng.betterc.symbol.type.BCTypeSymbol;
import site.moheng.betterc.symbol.variable.BCLocalVariableSymbol;
import site.moheng.betterc.symbol.variable.BCVariableSymbol;

import java.util.Optional;

public class SymbolTable {
    public final ConcurrentIndexedCollection<BCLibrarySymbol> librarySymbols = new ConcurrentIndexedCollection<>();
    public final ConcurrentIndexedCollection<TypeSymbolTableItem> typeSymbols = new ConcurrentIndexedCollection<>();
    public final ConcurrentIndexedCollection<VariableSymbolTableItem> variableSymbols = new ConcurrentIndexedCollection<>();

    public SymbolTable() {
        librarySymbols.addIndex(HashIndex.onAttribute(BCLibrarySymbol.NAMESPACE));
        librarySymbols.addIndex(RadixTreeIndex.onAttribute(BCLibrarySymbol.PATH));

        typeSymbols.addIndex(RadixTreeIndex.onAttribute(TypeSymbolTableItem.NAME));
        typeSymbols.addIndex(HashIndex.onAttribute(TypeSymbolTableItem.LIBRARY));
        typeSymbols.addIndex(HashIndex.onAttribute(TypeSymbolTableItem.SYMBOL));
        typeSymbols.addIndex(HashIndex.onAttribute(TypeSymbolTableItem.SCOPE));
        typeSymbols.addIndex(UniqueIndex.onAttribute(TypeSymbolTableItem.CONTEXT));

        variableSymbols.addIndex(RadixTreeIndex.onAttribute(VariableSymbolTableItem.NAME));
        variableSymbols.addIndex(HashIndex.onAttribute(VariableSymbolTableItem.LIBRARY));
        variableSymbols.addIndex(HashIndex.onAttribute(VariableSymbolTableItem.SYMBOL));
        variableSymbols.addIndex(HashIndex.onAttribute(VariableSymbolTableItem.SCOPE));
        variableSymbols.addIndex(UniqueIndex.onAttribute(VariableSymbolTableItem.CONTEXT));
    }

    public Optional<TypeSymbolTableItem> addTypeSymbol(String name, BCLibrarySymbol library, BCTypeSymbol symbol, ParserRuleContext scope, ParserRuleContext context) {
        final TypeSymbolTableItem item = new TypeSymbolTableItem(name, library, symbol, scope, context);
        if (typeSymbols.add(item)) {
            return Optional.of(item);
        }
        return Optional.empty();
    }

    public Optional<BCTypeSymbol> findTypeSymbol(String name) {
        return Optional.empty();
    }

    public Optional<BCLibrarySymbol> addLibrary(String namespace, String path) {
        final BCLibrarySymbol librarySymbol = BCLibrarySymbol.of(namespace, path);
        if (librarySymbols.add(librarySymbol)) {
            return Optional.of(librarySymbol);
        }
        return Optional.empty();
    }

    public Optional<VariableSymbolTableItem> addLocalVariable(String name, BCLibrarySymbol library, BCTypeSymbol symbol, ParserRuleContext scope, ParserRuleContext context) {
        final BCVariableSymbol variableSymbol = new BCLocalVariableSymbol(symbol, name);
        final VariableSymbolTableItem item = new VariableSymbolTableItem(name, library, variableSymbol, scope, context);
        if (variableSymbols.add(item)) {
            return Optional.of(item);
        }
        return Optional.empty();
    }

    public Optional<BCTypeSymbol> getType(ParserRuleContext context) {
        return getType(context, BCTypeSymbol.class);
    }

    public <T extends BCTypeSymbol> Optional<T> getType(ParserRuleContext context, Class<T> classT) {
        try (final var results = typeSymbols.retrieve(
                QueryFactory.equal(TypeSymbolTableItem.CONTEXT, context)
        )) {
            if (results.isNotEmpty()) {
                return Optional.of(classT.cast(results.uniqueResult().context()));
            }
        }
        return Optional.empty();
    }

    public Optional<BCLibrarySymbol> getLibrary(String namespace, String path) {
        try (final var results = librarySymbols.retrieve(
                QueryFactory.and(
                        QueryFactory.equal(BCLibrarySymbol.NAMESPACE, namespace),
                        QueryFactory.equal(BCLibrarySymbol.PATH, path)
                )
        )) {
            if (results.isNotEmpty()) {
                return Optional.of(results.uniqueResult());
            }
        }
        return Optional.empty();
    }
}
