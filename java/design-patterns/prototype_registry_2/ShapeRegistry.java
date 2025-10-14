import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ShapeRegistry {

    private static final ConcurrentHashMap<String, ShapePrototype> registry = new ConcurrentHashMap<>();

    static {
        // register circle and square prototypes
        ShapePrototype circle = new Circle("Proto");
        ShapePrototype square = new Square("Proto");

        System.out.println("Putting to registry, circle " + circle);
        System.out.println("Putting to registry, square " + square);

        registry.put("circle", circle);
        registry.put("square", square);
    }

    public static ShapePrototype getPrototype(String shapeType) {
        if (registry.containsKey(shapeType)) {
            return registry.get(shapeType).clone();
        }
        return null;
    }

}
