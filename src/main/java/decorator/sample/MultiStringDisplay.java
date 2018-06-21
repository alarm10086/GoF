package decorator.sample;

import java.util.ArrayList;

public class MultiStringDisplay extends Display {
    private final ArrayList body = new ArrayList();       // 要显示的字符串
    private int columns = 0;                        // 最大字符数

    public void add(final String msg) {                   // 添加字符串
        body.add(msg);
        updateColumn(msg);
    }

    @Override
    public int getColumns() {                       // 获取字符数
        return columns;
    }

    @Override
    public int getRows() {                          // 获取行数
        return body.size();
    }

    @Override
    public String getRowText(final int row) {             // 获取指定行的内容
        return (String) body.get(row);
    }

    private void updateColumn(final String msg) {         // 更新字符数
        if (msg.getBytes().length > columns) {
            columns = msg.getBytes().length;
        }
        for (int row = 0; row < body.size(); row++) {
            final int fills = columns - ((String) body.get(row)).getBytes().length;
            if (fills > 0) {
                body.set(row, body.get(row) + spaces(fills));
            }
        }
    }

    private String spaces(final int count) {              // 补上空格
        final StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(' ');
        }
        return buf.toString();
    }
}
