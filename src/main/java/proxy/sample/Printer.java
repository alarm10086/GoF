package proxy.sample;

public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("正在生成Printer的实例");
    }

    public Printer(final String name) {                   // 构造函数
        this.name = name;
        heavyJob("正在生成Printer的实例(" + name + ")");
    }

    @Override
    public void setPrinterName(final String name) {       // 设置名字
        this.name = name;
    }

    @Override
    public String getPrinterName() {                // 获取名字
        return name;
    }

    @Override
    public void print(final String string) {              // 显示带打印机名字的文字
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    private void heavyJob(final String msg) {             // 重活
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("结束。");
    }
}
