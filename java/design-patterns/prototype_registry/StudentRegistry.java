package prototype_registry;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {

    public static Map<String, Student> registry = new HashMap<>();

    public static Student getStudent(String key) {
        if (registry.containsKey(key)) {
            return registry.get(key).copy();
        }
        return null;
    }

    public static void putStudent(String key, Student student) {
        registry.put(key, student);
    }

    static {
        Student student = new Student();
        student.setBatch("March 2024");
        StudentRegistry.putStudent("March-2024-Normal", student);

        Student intelligentStudent = new IntelligentStudent();
        intelligentStudent.setBatch("March-2024");
        StudentRegistry.putStudent("March-2024-Intelligent", intelligentStudent);
    }

}
