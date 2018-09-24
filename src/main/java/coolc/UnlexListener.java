package coolc;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class UnlexListener implements CoolUnlexerListener
{
    public StringBuilder builder = new StringBuilder();

    @Override
    public void exitLines(CoolUnlexerParser.LinesContext ctx) {
        // start: line SEPARATOR content SEPARATOR type SEPARATOR typeID;
        int charposStart = Integer.parseInt(ctx.line().start_index.getText());
        String content = ctx.content().text.getText();

        // build up the string
        builder.insert(charposStart, content);
    }

    @Override
    public void enterStart(CoolUnlexerParser.StartContext ctx)
    {

    }

    @Override
    public void exitStart(CoolUnlexerParser.StartContext ctx)
    {

    }

    @Override
    public void enterLines(CoolUnlexerParser.LinesContext ctx) {

    }

    @Override
    public void enterLine(CoolUnlexerParser.LineContext ctx) {

    }

    @Override
    public void exitLine(CoolUnlexerParser.LineContext ctx)
    {

    }

    @Override
    public void enterContent(CoolUnlexerParser.ContentContext ctx) {

    }

    @Override
    public void exitContent(CoolUnlexerParser.ContentContext ctx) {

    }

    @Override
    public void enterType(CoolUnlexerParser.TypeContext ctx) {

    }

    @Override
    public void exitType(CoolUnlexerParser.TypeContext ctx) {

    }

    @Override
    public void enterTypeID(CoolUnlexerParser.TypeIDContext ctx) {

    }

    @Override
    public void exitTypeID(CoolUnlexerParser.TypeIDContext ctx) {

    }

    @Override
    public void enterCharacters(CoolUnlexerParser.CharactersContext ctx) {

    }

    @Override
    public void exitCharacters(CoolUnlexerParser.CharactersContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }
}

