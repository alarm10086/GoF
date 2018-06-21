package composite.sample;

public class Main {
    public static void main(final String[] args) {
        sample();
        a2();
    }

    private static void sample() {
        try {
            System.out.println("Making root entries...");
            final Directory rootdir = new Directory("root");
            final Directory bindir = new Directory("bin");
            final Directory tmpdir = new Directory("tmp");
            final Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.printList();

            System.out.println("");
            System.out.println("Making user entries...");
            final Directory yuki = new Directory("yuki");
            final Directory hanako = new Directory("hanako");
            final Directory tomura = new Directory("tomura");
            usrdir.add(yuki);
            usrdir.add(hanako);
            usrdir.add(tomura);
            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));
            hanako.add(new File("memo.tex", 300));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
            rootdir.printList();
        } catch (final FileTreatmentException e) {
            e.printStackTrace();
        }
    }

    private static void a2() {
        try {
            final Directory rootdir = new Directory("root");

            final Directory usrdir = new Directory("usr");
            rootdir.add(usrdir);

            final Directory yuki = new Directory("yuki");
            usrdir.add(yuki);

            final composite.sample.File file = new File("Composite.java", 100);
            yuki.add(file);
            rootdir.printList();

            System.out.println("");
            System.out.println("file = " + file.getFullName());
            System.out.println("yuki = " + yuki.getFullName());
        } catch (final FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
