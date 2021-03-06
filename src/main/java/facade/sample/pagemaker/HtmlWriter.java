package facade.sample.pagemaker;

import java.io.IOException;
import java.io.Writer;

class HtmlWriter {
    private final Writer writer;

    public HtmlWriter(final Writer writer) {  // 构造函数
        this.writer = writer;
    }

    public void title(final String title) throws IOException {    // 输出标题
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }

    public void paragraph(final String msg) throws IOException {  // 输出段落
        writer.write("<p>" + msg + "</p>\n");
    }

    public void link(final String href, final String caption) throws IOException {  // 输出超链接
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }

    public void mailto(final String mailaddr, final String username)
            throws IOException {   //  输出邮件地址
        link("mailto:" + mailaddr, username);
    }

    public void close() throws IOException {    // 结束输出HTML
        writer.write("</body>");
        writer.write("</html>\n");
        writer.close();
    }
}
