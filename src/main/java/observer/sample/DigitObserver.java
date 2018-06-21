package observer.sample;

public class DigitObserver implements Observer {
    @Override
    public void update(final NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (final InterruptedException e) {
        }
    }
}
