
public class Main {


    private static void fillStudentRegistry() {

        Student student = new Student();
        student.setBatch("March 2024");
        StudentRegistry.putStudent("March-2024-Normal", student);

        IntelligentStudent intelligentStudent = new IntelligentStudent();
        intelligentStudent.setBatch("March-2024");
        StudentRegistry.putStudent("March-2024-Intelligent", intelligentStudent);

    }

    public static void main(String[] args) {

        fillStudentRegistry();

        Student normalStudent = StudentRegistry.getStudent("March-2024-Normal").copy();
        normalStudent.setName("Jagan");
        normalStudent.setAge(28);

        IntelligentStudent intelligentStudent = (IntelligentStudent) StudentRegistry.getStudent("March-2024-Intelligent");
        intelligentStudent.setIq(200);
        intelligentStudent.setIntelligentScore(20);

        System.out.println("Done");
    }

}