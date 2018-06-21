package observer.sample;

public class Main {
    public static void main(final String[] args) {
        final NumberGenerator generator = new RandomNumberGenerator();
        final Observer observer1 = new DigitObserver();
        final Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
