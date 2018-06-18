package adapter.a2;

import java.io.IOException;

public class Main {
    public static void main(final String[] args) {
        final FileIO f = new FileProperties();
        try {
            f.readFromFile("file.txt");
            f.setValue("year", "2004");
            f.setValue("month", "4");
            f.setValue("day", "21");
            f.writeToFile("newfile.txt");
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
