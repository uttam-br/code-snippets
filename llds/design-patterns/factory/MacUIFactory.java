package factory;

import factory.components.IButton;
import factory.components.IScrollbar;
import factory.mac.MacButton;
import factory.mac.MacScrollbar;

public class MacUIFactory implements UIFactory {
    
    @Override
    public IButton getButton() {
        return new MacButton();
    }

    @Override
    public IScrollbar getScrollbar() {
        return new MacScrollbar();
    }

}
