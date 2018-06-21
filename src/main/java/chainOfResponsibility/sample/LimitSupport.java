package chainOfResponsibility.sample;

public class LimitSupport extends Support {
    private final int limit;                              // 可以解决编号小于limit的问题

    public LimitSupport(final String name, final int limit) {   // 构造函数
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(final Trouble trouble) {    // 解决问题的方法
        if (trouble.getNumber() < limit) {
            return true;
        } else {
            return false;
        }
    }
}
