package builder.a3;

import javax.swing.JFrame;

public class Main {
    public static void main(final String[] args) {
        final FrameBuilder framebuilder = new FrameBuilder();
        final Director director = new Director(framebuilder);
        director.construct();
        final JFrame frame = framebuilder.getResult();
        frame.setVisible(true);
    }
}
