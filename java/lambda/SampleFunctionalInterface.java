

@FunctionalInterface
public interface SampleFunctionalInterface {

    void fun1();

    default void fun2() {
        System.out.println("fun2");
    }

}
