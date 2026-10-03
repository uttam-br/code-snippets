package factory.mac;

import factory.components.IButton;

public class MacButton implements IButton {
    
    @Override
    public void click() {
        System.out.println("Clicked on Mac...");
    }

}
