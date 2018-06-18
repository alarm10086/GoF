package prototype.sample;

import prototype.sample.framework.Product;

public class MessageBox implements Product {
    private final char decochar;

    public MessageBox(final char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(final String s) {
        final int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + " " + s + " " + decochar);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (final CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
