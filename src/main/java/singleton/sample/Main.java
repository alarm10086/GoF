package singleton.sample;

public class Main {
    public static void main(final String[] args) {
        System.out.println("Start.");
        final Singleton obj1 = Singleton.getInstance();
        final Singleton obj2 = Singleton.getInstance();
        if (obj1 == obj2) {
            System.out.println("obj1与obj2是相同的实例。");
        } else {
            System.out.println("obj1与obj2是不同的实例。");
        }
        System.out.println("End.");
    }
}
