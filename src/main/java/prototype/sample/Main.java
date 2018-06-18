package prototype.sample;


import prototype.sample.framework.Manager;
import prototype.sample.framework.Product;

public class Main {
    public static void main(final String[] args) {
        // 准备
        final Manager manager = new Manager();
        final UnderlinePen upen = new UnderlinePen('~');
        final MessageBox mbox = new MessageBox('*');
        final MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // 生成
        final Product p1 = manager.create("strong message");
        p1.use("Hello, world.");
        final Product p2 = manager.create("warning box");
        p2.use("Hello, world.");
        final Product p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }
}
