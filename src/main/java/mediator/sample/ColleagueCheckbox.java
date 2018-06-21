package mediator.sample;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
    private Mediator mediator;

    public ColleagueCheckbox(final String caption, final CheckboxGroup group,
            final boolean state) {  // 构造函数
        super(caption, group, state);
    }

    @Override
    public void setMediator(final Mediator mediator) {            // 保存Mediator
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(final boolean enabled) {      // Mediator下达启用/禁用指示
        setEnabled(enabled);
    }

    @Override
    public void itemStateChanged(final ItemEvent e) {             // 当状态发生变化时通知Mediator
        mediator.colleagueChanged();
    }
}
