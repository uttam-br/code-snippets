package ui_factory;

public class UIFactoryFactory {

    public static UIFactory getUIFactory(Platform platform) {
        return switch(platform) {
            case ANDROID -> new AndroidUIFactory();
            case IOS -> new IOSUIFactory();
        };
    }

}
