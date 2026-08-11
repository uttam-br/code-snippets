package prototype_registry;

public class Main {
    
    public static void main(String[] args) {

        Registry registry = new RegistryImpl();

        Product p1 = (Product) registry.get("Product 01");
        Product p2 = (Product) registry.get("Product 01");
        Product p3 = (Product) registry.get("Product 01");
        Product p4 = (Product) registry.get("Product 02");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }

}
