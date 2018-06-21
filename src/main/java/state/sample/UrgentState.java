package state.sample;

public class UrgentState implements State {
    private static final UrgentState singleton = new UrgentState();

    private UrgentState() {                             // 构造函数的可见性是private
    }

    public static State getInstance() {                 // 获取唯一实例
        return singleton;
    }

    @Override
    public void doClock(final Context context, final int hour) {    // 设置时间
        // 在设置时间处理中什么都不做                                 
    }

    @Override
    public void doUse(final Context context) {                // 使用金库
        context.callSecurityCenter("紧急:紧急时使用金库！");
    }

    @Override
    public void doAlarm(final Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(紧急时)");
    }

    @Override
    public void doPhone(final Context context) {              // 正常通话
        context.callSecurityCenter("正常通话(紧急时)");
    }

    @Override
    public String toString() {                          // 显示字符串
        return "[紧急时]";
    }
}
