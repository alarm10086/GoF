package command.sample.drawer;

import command.sample.command.MacroCommand;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrawCanvas extends Canvas implements Drawable {
    // 颜色
    private Color color;
    // 要绘制的圆点的半径
    private int radius;
    // 命令的历史记录
    private final MacroCommand history;

    // 构造函数
    public DrawCanvas(final int width, final int height, final MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
        init();
    }

    // 重新全部绘制
    @Override
    public void paint(final Graphics g) {
        history.execute();
    }

    // 初始化
    @Override
    public void init() {
        color = Color.red;
        radius = 6;
        history.append(new ColorCommand(this, color));
    }

    // 绘制
    @Override
    public void draw(final int x, final int y) {
        final Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void setColor(final Color color) {
        this.color = color;
    }
}
