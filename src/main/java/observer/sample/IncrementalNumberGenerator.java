package observer.sample;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int number;                     // 当前数值
    private final int end;                        // 结束数值(不包含该值)
    private final int inc;                        // 递增步长

    public IncrementalNumberGenerator(final int start, final int end, final int inc) {
        this.number = start;
        this.end = end;
        this.inc = inc;
    }

    @Override
    public int getNumber() {                // 获取当前数值
        return number;
    }

    @Override
    public void execute() {
        while (number < end) {
            notifyObservers();
            number += inc;
        }
    }
}
