package decorator;

import decorator.addons.Mocha;
import decorator.bevarages.HouseBlend;

public class Client {

    public static void main(String[] args) {

        Bevarage houseBlend = new HouseBlend();
        System.out.println(houseBlend.getDescription() + " " + houseBlend.getCost());

        Bevarage houseBlendWithMocha = new Mocha(houseBlend);
        System.out.println(houseBlendWithMocha.getDescription() + " " + houseBlendWithMocha.getCost());

    }

}
