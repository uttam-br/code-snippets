public class Client {

    public static void main(String[] args) {

        Circle circle1 = (Circle) ShapeRegistry.getPrototype("circle");
        Circle circle2 = (Circle) ShapeRegistry.getPrototype("circle");

        System.out.println("Circle1 : " + circle1);
        System.out.println("Circle2 : " + circle2);

    }

}
