package state.sample;

public class DayState implements State {
    private static final DayState singleton = new DayState();

    private DayState() {                                // 构造函数的可见性是private
    }

    public static State getInstance() {                 // 获取唯一实例
        return singleton;
    }

    @Override
    public void doClock(final Context context, final int hour) {    // 设置时间
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(final Context context) {                // 使用金库
        context.recordLog("使用金库(白天)");
    }

    @Override
    public void doAlarm(final Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(白天)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(final Context context) {              // 正常通话
        context.callSecurityCenter("正常通话(白天)");
    }

    @Override
    public String toString() {                          // 显示表示类的文字
        return "[白天]";
    }
}
