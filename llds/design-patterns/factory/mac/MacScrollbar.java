package factory.mac;

import factory.components.IScrollbar;

public class MacScrollbar implements IScrollbar {
    
    @Override
    public void scroll() {
        System.out.println("Scrolling on Mac...");
    }

}
