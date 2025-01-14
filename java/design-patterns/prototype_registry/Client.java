package prototype_registry;

public class Client {

    public static void main(String[] args) {

        Student normalStudent = StudentRegistry.getStudent("March-2024-Normal");
        normalStudent.setName("Jagan");
        normalStudent.setAge(28);

        IntelligentStudent intelligentStudent = (IntelligentStudent) StudentRegistry.getStudent("March-2024-Intelligent");
        intelligentStudent.setIq(200);
        intelligentStudent.setIntelligentScore(20);

        System.out.println("Done");
    }

}