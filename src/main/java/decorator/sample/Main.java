package decorator.sample;

public class Main {
    public static void main(final String[] args) {
        sample();
        a1();
        a2();
    }

    private static void sample() {
        final Display b1 = new StringDisplay("Hello, world.");
        final Display b2 = new SideBorder(b1, '#');
        final Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();
        final Display b4 =
                new SideBorder(
                        new FullBorder(
                                new FullBorder(
                                        new SideBorder(
                                                new FullBorder(
                                                        new StringDisplay("你好，世界。")
                                                ),
                                                '*'
                                        )
                                )
                        ),
                        '/'
                );
        b4.show();
    }

    private static void a1() {
        final Display b1 = new StringDisplay("Hello, world.");
        final Display b2 = new UpDownBorder(b1, '-');
        final Display b3 = new SideBorder(b2, '*');
        b1.show();
        b2.show();
        b3.show();
        final Display b4 =
                new FullBorder(
                        new UpDownBorder(
                                new SideBorder(
                                        new UpDownBorder(
                                                new SideBorder(
                                                        new StringDisplay("你好，世界。"), '*'
                                                ),
                                                '='
                                        ),
                                        '|'
                                ),
                                '/'
                        )
                );
        b4.show();
    }

    private static void a2() {
        final MultiStringDisplay md = new MultiStringDisplay();
        md.add("早上好。");
        md.add("下午好。");
        md.add("晚安，明天见。");
        md.show();

        final Display d1 = new SideBorder(md, '#');
        d1.show();

        final Display d2 = new FullBorder(md);
        d2.show();
    }
}
