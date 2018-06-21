package builder.a2;

public class Main {
    public static void main(final String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (args[0].equals("plain")) {
            final TextBuilder textbuilder = new TextBuilder();
            final Director director = new Director(textbuilder);
            director.construct();
            final String result = textbuilder.getResult();
            System.out.println(result);
        } else if (args[0].equals("html")) {
            final HTMLBuilder htmlbuilder = new HTMLBuilder();
            final Director director = new Director(htmlbuilder);
            director.construct();
            final String filename = htmlbuilder.getResult();
            System.out.println(filename + "文件编写完成。");
        } else {
            usage();
            System.exit(0);
        }
    }

    public static void usage() {
        System.out.println("Usage: java Main plain      编写纯文本文档");
        System.out.println("Usage: java Main html       编写HTML文档");
    }
}
