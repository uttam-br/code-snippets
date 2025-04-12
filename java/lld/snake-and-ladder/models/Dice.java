package models;

public class Dice {

    public int roll() {
        return (int) (5 * Math.random() + 1);
    }

}
