package site.moheng.betterc;

import org.ainslec.picocog.PicoWriter;
import site.moheng.betterc.antlr.BCParser;

public class BCWriter {
    BCPacker packer;
    BCChecker checker;

    BCWriter(BCPacker packer, BCChecker checker) {
        this.packer = packer;
        this.checker = checker;
    }

    public void writeImport(BCParser.ImportDeclartionContext context) {

    }

    public void writeStruct(BCParser.StructDeclarationContext context) {
        
    }

    public PicoWriter write(BCParser.ProgramContext parser) {
        final PicoWriter writer = new PicoWriter();
        write(writer, parser);
        return writer;
    }

    public void write(PicoWriter writer, BCParser.ProgramContext parser) {

    }
}
