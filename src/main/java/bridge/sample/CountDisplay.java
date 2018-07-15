package bridge.sample;

public class CountDisplay extends Display {
    public CountDisplay(final DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(final int times) {       // 循环显示times次
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
