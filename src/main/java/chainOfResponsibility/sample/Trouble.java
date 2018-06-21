package chainOfResponsibility.sample;

public class Trouble {
    private final int number;             // 问题编号

    public Trouble(final int number) {    // 生成问题
        this.number = number;
    }

    public int getNumber() {        // 获取问题编号
        return number;
    }

    @Override
    public String toString() {      // 代表问题的字符串
        return "[Trouble " + number + "]";
    }
}
