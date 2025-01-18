package decorator.bevarages;

import decorator.Bevarage;

public class Espresso extends Bevarage {

    @Override
    public double getCost() {
        return 40;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}
