package mediator.sample;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    public ColleagueButton(final String caption) {
        super(caption);
    }

    @Override
    public void setMediator(final Mediator mediator) {            // 保存Mediator
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(final boolean enabled) {      // Mediator下达启用/禁用的指示
        setEnabled(enabled);
    }
}
