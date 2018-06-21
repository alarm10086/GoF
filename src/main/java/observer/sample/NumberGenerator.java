package observer.sample;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
    private final ArrayList<Observer> observers = new ArrayList();        // 保存Observer们

    public void addObserver(final Observer observer) {    // 注册Observer
        observers.add(observer);
    }

    public void deleteObserver(final Observer observer) { // 删除Observer
        observers.remove(observer);
    }

    public void notifyObservers() {               // 向Observer发送通知
        final Iterator it = observers.iterator();
        while (it.hasNext()) {
            final Observer o = (Observer) it.next();
            o.update(this);
        }
    }

    public abstract int getNumber();                // 获取数值

    public abstract void execute();                 // 生成数值
}
