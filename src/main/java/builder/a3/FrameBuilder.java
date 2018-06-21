package builder.a3;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameBuilder extends Builder implements ActionListener {
    private final JFrame frame = new JFrame();
    private final Box box = new Box(BoxLayout.Y_AXIS);

    @Override
    public void makeTitle(final String title) {
        frame.setTitle(title);
    }

    @Override
    public void makeString(final String str) {
        box.add(new JLabel(str));
    }

    @Override
    public void makeItems(final String[] items) {
        final Box innerbox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < items.length; i++) {
            final JButton button = new JButton(items[i]);
            button.addActionListener(this);
            innerbox.add(button);
        }
        box.add(innerbox);
    }

    @Override
    public void close() {
        frame.getContentPane().add(box);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public JFrame getResult() {
        return frame;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
