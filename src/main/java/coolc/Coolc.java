package coolc;

import picocli.CommandLine;


public class Coolc
{
    public static void main(String[] args)
    {
        CommandLine.run(new CommandLineOptionProcessor(), args);
    }
}

