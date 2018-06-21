package abstractFactory.sample;

import abstractFactory.sample.factory.Factory;
import abstractFactory.sample.factory.Link;
import abstractFactory.sample.factory.Page;
import abstractFactory.sample.factory.Tray;

public class Main {
    public static void main(final String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main listfactory.ListFactory");
            System.out.println("Example 2: java Main tablefactory.TableFactory");
            System.exit(0);
        }
        final Factory factory = Factory.getFactory(args[0]);

        final Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        final Link gmw = factory.createLink("光明日报", "http://www.gmw.cn/");

        final Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        final Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
        final Link excite = factory.createLink("Excite", "http://www.excite.com/");
        final Link google = factory.createLink("Google", "http://www.google.com/");

        final Tray traynews = factory.createTray("日报");
        traynews.add(people);
        traynews.add(gmw);

        final Tray trayyahoo = factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo);
        trayyahoo.add(jp_yahoo);

        final Tray traysearch = factory.createTray("检索引擎");
        traysearch.add(trayyahoo);
        traysearch.add(excite);
        traysearch.add(google);

        final Page page = factory.createPage("LinkPage", "杨文轩");
        page.add(traynews);
        page.add(traysearch);
        page.output();
    }
}
