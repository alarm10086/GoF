package bridge.sample;

public class IncreaseDisplay extends CountDisplay {
    private final int step; // 递增步长

    public IncreaseDisplay(final DisplayImpl impl, final int step) {
        super(impl);
        this.step = step;
    }

    public void increaseDisplay(final int level) {
        int count = 0;
        for (int i = 0; i < level; i++) {
            multiDisplay(count);
            count += step;
        }
    }
}
