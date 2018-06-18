package adapter.sample2;

public class PrintBanner extends Print {
    private final Banner banner;

    public PrintBanner(final String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
