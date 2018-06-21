package memento.sample.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
    private static final String[] fruitsname = {      // 表示水果种类的数组
            "苹果", "葡萄", "香蕉", "橘子",
    };
    private final Random random = new Random();       // 随机数生成器
    private int money;                          // 所持金钱
    private List fruits = new ArrayList();      // 获得的水果

    public Gamer(final int money) {                   // 构造函数
        this.money = money;
    }

    public int getMoney() {                     // 获取当前所持金钱
        return money;
    }

    public void bet() {                         // 投掷骰子进行游戏
        final int dice = random.nextInt(6) + 1;           // 掷骰子
        if (dice == 1) {                            // 骰子结果为1…增加所持金钱
            money += 100;
            System.out.println("所持金钱增加了。");
        } else if (dice == 2) {                     // 骰子结果为2…所持金钱减半
            money /= 2;
            System.out.println("所持金钱减半了。");
        } else if (dice == 6) {                     // 骰子结果为6…获得水果
            final String f = getFruit();
            System.out.println("获得了水果(" + f + ")。");
            fruits.add(f);
        } else {                                    // 骰子结果为3、4、5则什么都不会发生
            System.out.println("什么都没有发生。");
        }
    }

    public Memento createMemento() {                // 拍摄快照
        final Memento m = new Memento(money);
        final Iterator it = fruits.iterator();
        while (it.hasNext()) {
            final String f = (String) it.next();
            if (f.startsWith("好吃的")) {         // 只保存好吃的水果
                m.addFruit(f);
            }
        }
        return m;
    }

    public void restoreMemento(final Memento memento) {   // 撤销
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {                      // 用字符串表示主人公状态
        return "[money = " + money + ", fruits = " + fruits + "]";
    }

    private String getFruit() {                     // 获得一个水果
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}
