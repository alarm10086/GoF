package chainOfResponsibility.sample;

public class SpecialSupport extends Support {
    private final int number;                                 // 只能解决指定编号的问题

    public SpecialSupport(final String name, final int number) {    // 构造函数
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(final Trouble trouble) {        // 解决问题的方法
        if (trouble.getNumber() == number) {
            return true;
        } else {
            return false;
        }
    }
}
