package decorator.addons;

import decorator.AddOn;
import decorator.Bevarage;

public class Milk extends AddOn {

    Bevarage bevarage;

    public Milk(Bevarage bevarage) {
        this.bevarage = bevarage;
    }

    @Override
    public double getCost() {
        return 10 + bevarage.getCost();
    }

    @Override
    public String getDescription() {
        return "Milk added to " + bevarage.getDescription();
    }
}
