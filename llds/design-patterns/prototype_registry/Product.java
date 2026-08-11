package prototype_registry;

public class Product implements Prototype {

    private int id;
    private String name;

    private Product() {
    }

    Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product clone() {
        Product clone = new Product();
        clone.id = this.id;
        clone.name = this.name;
        return clone;
    }


    // getters
    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }


    // setters
    
}
