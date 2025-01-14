package abstract_factory.ui_factory;

import abstract_factory.ui_factory.components.button.Button;
import abstract_factory.ui_factory.components.text.Text;

public abstract class UIFactory {

    public abstract Button getButton();

    public abstract Text getText();

    public abstract Platform getPlatform();
}
