package factory.windows;

import factory.components.IButton;

public class WindowsButton implements IButton {

    @Override
    public void click() {
        System.out.println("Clicked on Windows");
    }

}
