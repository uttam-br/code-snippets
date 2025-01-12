import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {

    public static Map<String, Student> registry = new HashMap<>();

    public static Student getStudent(String key) {
        if (registry.containsKey(key)) {
            return registry.get(key);
        }
        return null;
    }

    public static void putStudent(String key, Student student) {
        registry.put(key, student);
    }

}
