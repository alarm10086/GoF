package bridge.sample;

public class Main {
    public static void main(final String[] args) {
        sample();
        a1();
        a2();
        a3();
    }

    private static void sample() {
        final Display d1 = new Display(new StringDisplayImpl("Hello, China."));
        final Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        final CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }

    private static void a1() {
        final RandomCountDisplay d = new RandomCountDisplay(new StringDisplayImpl("Hello, China."));
        d.randomDisplay(10);
    }

    private static void a2() {
        final CountDisplay d = new CountDisplay(new FileDisplayImpl("star.txt"));
        d.multiDisplay(3);
    }

    private static void a3() {
        final IncreaseDisplay d1 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1);
        final IncreaseDisplay d2 = new IncreaseDisplay(new CharDisplayImpl('|', '#', '-'), 2);
        d1.increaseDisplay(4);
        d2.increaseDisplay(6);
    }
}
