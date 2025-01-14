package abstract_factory;

import abstract_factory.ui_factory.Platform;
import abstract_factory.ui_factory.UIFactory;
import abstract_factory.ui_factory.UIFactoryFactory;
import abstract_factory.ui_factory.components.button.Button;
import abstract_factory.ui_factory.components.text.Text;

public class Client {

    public static void main(String[] args) {

        System.out.println("Client Code");

        UIFactory uiFactory = UIFactoryFactory.getUIFactory(Platform.IOS);

        Button button = uiFactory.getButton();
        System.out.println(button.name());

        Text text = uiFactory.getText();
        System.out.println(text.name());

    }

}
