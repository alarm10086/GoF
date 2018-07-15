package command.sample;

import command.sample.command.Command;
import command.sample.command.MacroCommand;
import command.sample.drawer.ColorCommand;
import command.sample.drawer.DrawCanvas;
import command.sample.drawer.DrawCommand;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame implements ActionListener {
    // 绘制的历史记录
    private final MacroCommand history = new MacroCommand();
    // 绘制区域
    private final DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 删除按钮
    private final JButton clearButton = new JButton("clear");
    // 撤销按钮
    private final JButton undoButton = new JButton("undo");
    // 红色按钮
    private final JButton redButton = new JButton("red");
    // 绿色按钮
    private final JButton greenButton = new JButton("green");
    // 蓝色按钮
    private final JButton blueButton = new JButton("blue");

    // 构造函数
    public Main(final String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(final MouseEvent e) {
                final Command cmd = new DrawCommand(canvas, e.getPoint());
                history.append(cmd);
                cmd.execute();
            }
        });
        clearButton.addActionListener(this);
        undoButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);

        final Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(undoButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        final Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

    // ActionListener接口中的方法
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.init();
            canvas.repaint();
        } else if (e.getSource() == undoButton) {
            history.undo();
            canvas.repaint();
        } else if (e.getSource() == redButton) {
            final Command cmd = new ColorCommand(canvas, Color.red);
            history.append(cmd);
            cmd.execute();
        } else if (e.getSource() == greenButton) {
            final Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            cmd.execute();
        } else if (e.getSource() == blueButton) {
            final Command cmd = new ColorCommand(canvas, Color.blue);
            history.append(cmd);
            cmd.execute();
        }
    }

    public static void main(final String[] args) {
        new Main("Command Pattern sample");
    }
}
