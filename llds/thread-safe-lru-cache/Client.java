import src.Cache;

public class Client {

    public static void main(String[] args) {

        Cache cache = new Cache(3);

        cache.put(1, "First");
        cache.put(2, "Second");
        cache.put(3, "Third");
        cache.get(2);
        cache.put(4, "Fourth");
        cache.put(5, "Fifth");
        cache.remove(3);

    }

}

