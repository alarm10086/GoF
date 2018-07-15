package strategy.a4;

public class Main {
    public static void main(final String[] args) {
        final String[] data = {
                "Dumpty", "Bowman", "Carroll", "Elfland", "Alice",
        };
        final SortAndPrint sap = new SortAndPrint(data, new QuickSorter());
        sap.execute();
    }
}
