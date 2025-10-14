public class Square implements ShapePrototype {

    private final String name;

    public Square(String name) {
        this.name = name;
    }

    public Square clone() {
        return new Square(this.name);
    }

}
