package prototype_registry;

@FunctionalInterface
public interface Prototype<T> {

    T copy();

}
