package factoryMethod.sample.idcard;


import factoryMethod.sample.framework.Product;

public class IDCard extends Product {
    private final String owner;
    private final int serial;

    IDCard(final String owner, final int serial) {
        System.out.println("制作" + owner + "(" + serial + ")" + "的ID卡。");
        this.owner = owner;
        this.serial = serial;
    }

    public void use() {
        System.out.println("使用" + owner + "(" + serial + ")" + "的ID卡。");
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }
}
