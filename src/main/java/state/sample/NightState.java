package state.sample;

public class NightState implements State {
    private static final NightState singleton = new NightState();

    private NightState() {                              // 构造函数的可见性是private
    }

    public static State getInstance() {                 // 获取唯一实例
        return singleton;
    }

    @Override
    public void doClock(final Context context, final int hour) {    // 设置时间
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(final Context context) {                // 使用金库
        context.callSecurityCenter("紧急：晚上使用金库！");
    }

    @Override
    public void doAlarm(final Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(晚上)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(final Context context) {              // 正常通话
        context.recordLog("晚上的通话录音");
    }

    @Override
    public String toString() {                          // 显示字符串
        return "[晚上]";
    }
}
