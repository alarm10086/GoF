package observer.sample;

public class GraphObserver implements Observer {
    @Override
    public void update(final NumberGenerator generator) {
        System.out.print("GraphObserver:");
        final int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (final InterruptedException e) {
        }
    }
}
