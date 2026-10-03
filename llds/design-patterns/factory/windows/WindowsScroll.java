package factory.windows;

import factory.components.IScrollbar;

public class WindowsScroll implements IScrollbar {
    
    @Override
    public void scroll() {
        System.out.println("Scrolling on Windows...");
    }

}
