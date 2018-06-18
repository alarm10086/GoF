package factoryMethod.sample;

import factoryMethod.sample.framework.Factory;
import factoryMethod.sample.framework.Product;
import factoryMethod.sample.idcard.IDCardFactory;

public class Main {
    public static void main(final String[] args) {
        final Factory factory = new IDCardFactory();
        final Product card1 = factory.create("小明");
        final Product card2 = factory.create("小红");
        final Product card3 = factory.create("小刚");
        card1.use();
        card2.use();
        card3.use();
    }
}
