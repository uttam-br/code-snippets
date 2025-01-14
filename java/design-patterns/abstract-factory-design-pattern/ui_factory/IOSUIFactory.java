package ui_factory;

import ui_factory.components.Button.Button;
import ui_factory.components.Button.IOSButton;
import ui_factory.components.Text.IOSText;
import ui_factory.components.Text.Text;

public class IOSUIFactory extends UIFactory {

    public Button getButton() {
        return new IOSButton();
    }

    public Text getText() {
        return new IOSText();
    }

    public Platform getPlatform() {
        return Platform.IOS;
    }

}
