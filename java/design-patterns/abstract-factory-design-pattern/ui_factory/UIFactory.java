package ui_factory;

import ui_factory.components.Button.Button;
import ui_factory.components.Text.Text;

public abstract class UIFactory {

    public abstract Button getButton();

    public abstract Text getText();

    public abstract Platform getPlatform();
}
