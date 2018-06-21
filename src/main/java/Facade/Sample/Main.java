package facade.sample;

import facade.sample.pagemaker.PageMaker;

public class Main {
    public static void main(final String[] args) {
        PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");
    }
}
