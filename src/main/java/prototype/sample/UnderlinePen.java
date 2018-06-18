package prototype.sample;


import prototype.sample.framework.Product;

public class UnderlinePen implements Product {
    private final char ulchar;

    public UnderlinePen(final char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(final String s) {
        final int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(ulchar);
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
