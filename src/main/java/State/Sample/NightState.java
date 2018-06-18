package State.Sample;

import Interpreter.Sample.Context;

public class NightState implements State {
    private static NightState singleton = new NightState();
    private NightState() {                              // 构造函数的可见性是private
    }
    public static State getInstance() {                 // 获取唯一实例
        return singleton;
    }
    public void doClock(Interpreter.Sample.Context context, int hour) {    // 设置时间
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    public void doUse(Interpreter.Sample.Context context) {                // 使用金库
        context.callSecurityCenter("紧急：晚上使用金库！");
    }
    public void doAlarm(Interpreter.Sample.Context context) {              // 按下警铃
        context.callSecurityCenter("按下警铃(晚上)");
    }
    public void doPhone(Context context) {              // 正常通话
        context.recordLog("晚上的通话录音");
    }
    public String toString() {                          // 显示表示类的文字
        return "[晚上]";
    }
}
