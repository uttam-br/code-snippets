package ui_factory;

import ui_factory.components.Button.AndroidButton;
import ui_factory.components.Button.Button;
import ui_factory.components.Text.AndroidText;
import ui_factory.components.Text.Text;

public class AndroidUIFactory extends UIFactory {

    public Button getButton() {
        return new AndroidButton();
    }

    public Text getText() {
        return new AndroidText();
    }

    public Platform getPlatform() {
        return Platform.ANDROID;
    }

}
