package coolc;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;


public class UnlexInvoker
{
    private String filename;

    public UnlexInvoker(String filename)
    {
        this.filename = filename;
    }

    public String unlex() throws IOException
    {
        UnlexListener listener = new UnlexListener();
        CharStream s = CharStreams.fromFileName(this.filename);
        CoolUnlexerLexer lexer = new CoolUnlexerLexer(s);
        CommonTokenStream stream = new CommonTokenStream(lexer);
        CoolUnlexerParser parser = new CoolUnlexerParser(stream);

        parser.addParseListener(listener);
        parser.start();

        return listener.builder.toString();
    }
}
