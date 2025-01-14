package abstract_factory.ui_factory;


import abstract_factory.ui_factory.components.button.AndroidButton;
import abstract_factory.ui_factory.components.button.Button;
import abstract_factory.ui_factory.components.text.AndroidText;
import abstract_factory.ui_factory.components.text.Text;

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
