package factory;

import factory.components.IButton;
import factory.components.IScrollbar;

public class Main {

    public static void main(String[] args) {
        UIFactory uiFactory = new MacUIFactory();

        IButton button = uiFactory.getButton();
        IScrollbar scrollbar = uiFactory.getScrollbar();

        button.click();
        scrollbar.scroll();
    }

}
