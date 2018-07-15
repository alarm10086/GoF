package interpreter.sample;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(final String[] args) {
        try {
            final BufferedReader reader = new BufferedReader(new FileReader("program.txt"));
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println("text = \"" + text + "\"");
                final Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
