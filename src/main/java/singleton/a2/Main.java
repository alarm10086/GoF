package singleton.a2;

public class Main {
    public static void main(final String[] args) {
        System.out.println("Start.");
        for (int i = 0; i < 9; i++) {
            final Triple triple = Triple.getInstance(i % 3);
            System.out.println(i + ":" + triple);
        }
        System.out.println("End.");
    }
}
