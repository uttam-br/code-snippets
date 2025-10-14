public class Circle implements ShapePrototype {

    private final String name;

    public Circle(String name) {
        this.name = name;
    }

    @Override
    public Circle clone() {
        return new Circle(this.name);
    }

}
