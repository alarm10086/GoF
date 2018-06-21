package bridge.sample;

import java.util.Random;

public class RandomCountDisplay extends CountDisplay {
    private final Random random = new Random();

    public RandomCountDisplay(final DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(final int times) {
        multiDisplay(random.nextInt(times));
    }
}
