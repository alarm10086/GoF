package strategy.sample;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private final Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(final int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(final boolean win) {
        won = win;
    }
}
