package adapter.sample2;

public class Main {
    public static void main(final String[] args) {
        final Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
