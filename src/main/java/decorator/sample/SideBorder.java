package decorator.sample;

public class SideBorder extends Border {
    private final char borderChar;                        // 表示装饰边框的字符

    public SideBorder(final Display display, final char ch) {   // 通过构造函数指定Display和装饰边框字符
        super(display);
        this.borderChar = ch;
    }

    @Override
    public int getColumns() {                       // 字符数为字符串字符数加上两侧边框字符数
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {                          // 行数即被装饰物的行数
        return display.getRows();
    }

    @Override
    public String getRowText(final int row) {             // 指定的那一行的字符串为被装饰物的字符串加上两侧的边框的字符
        return borderChar + display.getRowText(row) + borderChar;
    }
}
