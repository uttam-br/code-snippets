package prototype_registry;

public interface Registry {
    
    public Prototype get(String key);

    public void put(String key, Prototype prototype);

}
