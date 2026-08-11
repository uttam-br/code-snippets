package prototype_registry;

import java.util.HashMap;

public class RegistryImpl implements Registry {
    
    private HashMap<String, Prototype> registry = new HashMap<>();

    RegistryImpl() {
        Product product1 = new Product(1, "Product 01");
        Product product2 = new Product(2, "Product 02");

        put(product1.getName(), product1);
        put(product2.getName(), product2);
    }

    @Override
    public Prototype get(String key) {
        if (registry.containsKey(key)) {
            return registry.get(key).clone();
        }
        return null;
    }

    @Override
    public void put(String key, Prototype product) {
        if (registry.containsKey(key)) {
            return;
        }
        registry.put(key, product);
    }

}
