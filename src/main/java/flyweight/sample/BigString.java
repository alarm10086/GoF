package flyweight.sample;

public class BigString {
    // 大型文字的数组
    private flyweight.sample.BigChar[] bigchars;

    // 构造函数
    public BigString(final String string) {
        initShared(string);
    }

    // 构造函数
    public BigString(final String string, final boolean shared) {
        if (shared) {
            initShared(string);
        } else {
            initUnshared(string);
        }
    }

    // 共享方式初始化
    private void initShared(final String string) {
        bigchars = new flyweight.sample.BigChar[string.length()];
        final BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    // 非共享方式初始化
    private void initUnshared(final String string) {
        bigchars = new flyweight.sample.BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = new BigChar(string.charAt(i));
        }
    }

    // 显示
    public void print() {
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print();
        }
    }
}
