package abstract_factory.ui_factory;

import abstract_factory.ui_factory.components.button.Button;
import abstract_factory.ui_factory.components.button.IOSButton;
import abstract_factory.ui_factory.components.text.IOSText;
import abstract_factory.ui_factory.components.text.Text;

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
