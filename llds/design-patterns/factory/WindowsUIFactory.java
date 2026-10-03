package factory;

import factory.components.IButton;
import factory.components.IScrollbar;
import factory.windows.WindowsButton;
import factory.windows.WindowsScroll;

public class WindowsUIFactory implements UIFactory {

    @Override
    public IButton getButton() {
        WindowsButton button = new WindowsButton();
        return button;
    }

    @Override
    public IScrollbar getScrollbar() {
        WindowsScroll scrollbar = new WindowsScroll();
        return scrollbar;
    }

}
