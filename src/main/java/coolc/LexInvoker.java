package coolc;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.stringtemplate.v4.ST;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LexInvoker
{
    private String inputFilename;

    public LexInvoker(String inputFilename)
    {
        this.inputFilename = inputFilename;
    }

    public List<String> lexContents() throws IOException
    {
        List<String> templates = InputToLexemeStrings(inputFilename);

        return templates;
    }

    private List<String> InputToLexemeStrings(String inputFilename) throws IOException
    {
        List<String> templates = new ArrayList<>();

        CharStream s = CharStreams.fromFileName(inputFilename);
        CoolLexer lexer = new CoolLexer(s);

        for (Token t : lexer.getAllTokens())
        {
            Integer startIndex = t.getStartIndex() + (t.getLine() - 1);
            Integer stopIndex = t.getStopIndex() + (t.getLine() - 1);
            ST lexOutputTemplate = new ST("[Line]:<t.Line>" +
                                          "(<startIndex>:<stopIndex>) " +
                                          "[Text]:<t.Text> " +
                                          "[Type]:<type_name> " +
                                          "[Type ID]:<t.Type>\n");

            lexOutputTemplate.add("startIndex", startIndex);
            lexOutputTemplate.add("stopIndex", stopIndex);
            lexOutputTemplate.add("t", t);
            lexOutputTemplate.add("type_name",
                                  lexer.getVocabulary().getSymbolicName(t.getType()));

            templates.add(lexOutputTemplate.render());
        }

        return templates;
    }
}
