package strategy.sample;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private final Random random;

    public RandomStrategy(final int seed) {
        random = new Random(seed);
    }

    @Override
    public void study(final boolean win) {
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }
}
