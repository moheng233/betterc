package site.moheng.betterc.writer;

import org.ainslec.picocog.PicoWriter;
import site.moheng.betterc.symbol.BCLibrarySymbol;

public class BCHeaderWriterContext extends BCWriterContext {
    final PicoWriter writer = new PicoWriter();

    protected BCHeaderWriterContext(BCLibrarySymbol library) {
        super(library);
    }
}
