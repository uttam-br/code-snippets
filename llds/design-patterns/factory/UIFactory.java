package factory;

import factory.components.IButton;
import factory.components.IScrollbar;

public interface UIFactory {
    
    public IButton getButton();
    public IScrollbar getScrollbar();

}
