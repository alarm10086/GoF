package mediator.sample;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;

    public ColleagueTextField(final String text, final int columns) {   // 构造函数
        super(text, columns);
    }

    @Override
    public void setMediator(final Mediator mediator) {            // 保存Mediator
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(final boolean enabled) {      // Mediator下达启用/禁用的指示
        setEnabled(enabled);
        setBackground(enabled ? Color.white : Color.lightGray);
    }

    @Override
    public void textValueChanged(final TextEvent e) {             // 当文字发生变化时通知Mediator
        mediator.colleagueChanged();
    }
}
