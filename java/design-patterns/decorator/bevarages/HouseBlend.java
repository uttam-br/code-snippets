package decorator.bevarages;

import decorator.Bevarage;

public class HouseBlend extends Bevarage {

    @Override
    public double getCost() {
        return 80;
    }

    @Override
    public String getDescription() {
        return "House Blend";
    }
}
