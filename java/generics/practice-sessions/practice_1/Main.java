package practice_1;

public class Main {

    public static void main(String[] args) {

        Pair<Integer, User> pair = new Pair<>(1, new User());

        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

        System.out.println(Pair.getKeyAndValueString(2.0));
    }

}
