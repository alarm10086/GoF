package interpreter.a1;

import interpreter.a1.language.InterpreterFacade;
import interpreter.a1.turtle.TurtleCanvas;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame implements ActionListener {
    private final TurtleCanvas canvas = new TurtleCanvas(400, 400);
    private final InterpreterFacade facade = new InterpreterFacade(canvas);
    private final TextField programTextField = new TextField(
            "program repeat 3 go right go left end end");

    // 构造函数
    public Main(final String title) {
        super(title);

        canvas.setExecutor(facade);

        setLayout(new BorderLayout());

        programTextField.addActionListener(this);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                System.exit(0);
            }
        });

        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();
        parseAndExecute();
        show();
    }

    // 供ActionListener用
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == programTextField) {
            parseAndExecute();
        }
    }

    private void parseAndExecute() {
        final String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        facade.parse(programText);
        canvas.repaint();
    }

    public static void main(final String[] args) {
        new Main("Interpreter Pattern sample");
    }
}
