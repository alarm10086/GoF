package chainOfResponsibility.a4;

public abstract class Support {
    private final String name;                    // 解决问题的实例的名字
    private Support next;                   // 要推卸给的对象

    public Support(final String name) {           // 生成解决问题的实例
        this.name = name;
    }

    public Support setNext(final Support next) {  // 设置要推卸给的对象
        this.next = next;
        return next;
    }

    public void support(final Trouble trouble) {
        for (Support obj = this; true; obj = obj.next) {
            if (obj.resolve(trouble)) {
                obj.done(trouble);
                break;
            } else if (obj.next == null) {
                obj.fail(trouble);
                break;
            }
        }
    }

    @Override
    public String toString() {              // 显示字符串
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble); // 解决问题的方法

    protected void done(final Trouble trouble) {  // 解决
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(final Trouble trouble) {  // 未解决
        System.out.println(trouble + " cannot be resolved.");
    }
}
