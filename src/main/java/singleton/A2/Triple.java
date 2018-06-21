package singleton.a2;

public class Triple {
    private static final Triple[] triple = new Triple[]{
            new Triple(0),
            new Triple(1),
            new Triple(2),
    };
    private final int id;

    private Triple(final int id) {
        System.out.println("The instance " + id + " is created.");
        this.id = id;
    }

    public static Triple getInstance(final int id) {
        return triple[id];
    }

    @Override
    public String toString() {
        return "[Triple id=" + id + "]";
    }
}
