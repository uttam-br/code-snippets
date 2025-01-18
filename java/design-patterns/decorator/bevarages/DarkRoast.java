package decorator.bevarages;

import decorator.Bevarage;

public class DarkRoast extends Bevarage {

    @Override
    public double getCost() {
        return 65;
    }

    @Override
    public String getDescription() {
        return "Dark Roast";
    }
}
