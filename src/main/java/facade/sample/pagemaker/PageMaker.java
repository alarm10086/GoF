package facade.sample.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {   // 防止外部new出PageMaker的实例，所以声明为private方法
    }

    public static void makeWelcomePage(final String mailaddr, final String filename) {
        try {
            final Properties mailprop = Database.getProperties("maildata");
            final String username = mailprop.getProperty(mailaddr);
            final HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to " + username + "'s page!");
            writer.paragraph("欢迎来到" + username + "的主页。");
            writer.paragraph("等着你的邮件哦！");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(final String filename) {
        try {
            final HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Link page");
            final Properties mailprop = Database.getProperties("maildata");
            final Enumeration en = mailprop.propertyNames();
            while (en.hasMoreElements()) {
                final String mailaddr = (String) en.nextElement();
                final String username = mailprop.getProperty(mailaddr, "(unknown)");
                writer.mailto(mailaddr, username);
            }
            writer.close();
            System.out.println(filename + " is created.");
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
