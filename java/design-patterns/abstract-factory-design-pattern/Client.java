import ui_factory.Platform;
import ui_factory.UIFactory;
import ui_factory.UIFactoryFactory;
import ui_factory.components.Button.Button;
import ui_factory.components.Text.Text;

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
