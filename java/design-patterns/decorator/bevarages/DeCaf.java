package decorator.bevarages;

import decorator.Bevarage;

public class DeCaf extends Bevarage {

    @Override
    public double getCost() {
        return 50;
    }

    @Override
    public String getDescription() {
        return "DeCaf";
    }
}
