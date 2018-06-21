package command.sample.drawer;

import command.sample.command.Command;

import java.awt.Point;

public class DrawCommand implements Command {
    // 绘制对象
    protected Drawable drawable;
    // 绘制位置
    private final Point position;

    // 构造函数
    public DrawCommand(final Drawable drawable, final Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    // 执行
    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
