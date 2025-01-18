package decorator.addons;

import decorator.AddOn;
import decorator.Bevarage;

public class Mocha extends AddOn {

    Bevarage bevarage;

    public Mocha(Bevarage bevarage) {
        this.bevarage = bevarage;
    }

    @Override
    public double getCost() {
        return 20 + bevarage.getCost();
    }

    @Override
    public String getDescription() {
        return "Mocha added to " + bevarage.getDescription();
    }
}
