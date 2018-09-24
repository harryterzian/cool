package coolc;

import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Command(description = "Compiles cool programs",  name = "coolc", version = "coolc 0.01",
mixinStandardHelpOptions = true)

public class CommandLineOptionProcessor implements Runnable {

    final String testcase = "./testcases/arith.cl";

    @Option(names = {"-l", "--lex"}, description = "Perform lexical analysis on the input.")
    private boolean lex;

    @Option(names = {"-u", "--unlex"}, description = "Perform lexical analysis on the input.")
    private boolean unlex;

    @Parameters(index = "0", description = "The file to process.", defaultValue = testcase)
    private String filename;

    @Option(names = {"o", "--output"}, description = "Output the result to the following filename.",
            defaultValue = "a.cl-out")
    private String output;

    @Override
    public void run() {
        if (lex)
        {
            System.out.println("Lexing " + filename);
            LexAndExit(filename, output);
            System.out.println("Wrote lexer output to:");
            System.out.println(new File(output).getAbsolutePath());

        }
        else if (unlex)
        {
            System.out.println("Unlexing " + filename);
            UnlexAndExit(filename, output);
            System.out.println("Wrote unlex output to:");
            System.out.println(new File(output).getAbsolutePath());

        }
        else
        {

        }
    }

    private static void LexAndExit(String inputFilename, String outputFilename)
    {
        LexInvoker lexicalInvoker = new LexInvoker(inputFilename);
        try {

            List<String> strings = lexicalInvoker.lexContents();
            Files.write(Paths.get(outputFilename), strings);

        } catch(IOException e)
        {
            System.err.println("Did not manage to open the " + inputFilename);
            System.err.println("The following error occurred: " + e.getCause());
        }
    }

    private static void UnlexAndExit(String inputFilename, String outputFilename)
    {
        UnlexInvoker unlexer = new UnlexInvoker(inputFilename);
        try
        {
            String unlexedOutput = unlexer.unlex();
            Files.write(Paths.get(outputFilename), unlexedOutput.getBytes());

        } catch (IOException e)
        {
            System.err.println("Did not manage to open the " + inputFilename);
            System.err.println("The following error occurred: " + e.getCause());
        }
    }
}
