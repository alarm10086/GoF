package singleton.A3_1;

public class Main extends Thread {
    public static void main(final String[] args) {
        System.out.println("Start.");
        new Main("A").start();
        new Main("B").start();
        new Main("C").start();
        System.out.println("End.");
    }

    public void run() {
        final Singleton obj = Singleton.getInstance();
        System.out.println(getName() + ": obj = " + obj);
    }

    public Main(final String name) {
        super(name);
    }
}
