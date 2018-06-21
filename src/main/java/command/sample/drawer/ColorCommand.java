package command.sample.drawer;

import command.sample.command.Command;

import java.awt.Color;

public class ColorCommand implements Command {
    // 描画对象
    protected Drawable drawable;
    // 颜色
    private final Color color;

    // 构造函数
    public ColorCommand(final Drawable drawable, final Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    // 执行
    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
