package chainOfResponsibility.a4;

public class NoSupport extends Support {
    public NoSupport(final String name) {
        super(name);
    }

    @Override
    protected boolean resolve(final Trouble trouble) {     // 解决问题的方法
        return false; // 自己什么也不处理
    }
}
