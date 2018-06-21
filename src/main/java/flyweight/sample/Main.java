package flyweight.sample;

public class Main {
    private static final BigString[] bsarray = new BigString[1000];

    public static void main(final String[] args) {
        System.out.println("共享时:");
        testAllocation(true);
        System.out.println("非共享时:");
        testAllocation(false);
    }

    private static void testAllocation(final boolean shared) {
        for (int i = 0; i < bsarray.length; i++) {
            bsarray[i] = new BigString("1212123", shared);
        }
        showMemory();
    }

    private static void showMemory() {
        Runtime.getRuntime().gc();
        final long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("使用内存 = " + used);
    }
}
