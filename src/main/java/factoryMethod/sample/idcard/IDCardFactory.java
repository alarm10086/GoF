package factoryMethod.sample.idcard;

import factoryMethod.sample.framework.Factory;
import factoryMethod.sample.framework.Product;

import java.util.HashMap;

public class IDCardFactory extends Factory {
    private final HashMap database = new HashMap();
    private int serial = 100;

    @Override
    protected synchronized Product createProduct(final String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(final Product product) {
        final IDCard card = (IDCard) product;
        database.put(new Integer(card.getSerial()), card.getOwner());
    }

    public HashMap getDatabase() {
        return database;
    }
}
