
public class Main {


    private static void fillStudentRegistry() {

        Student student = new Student();
        student.setBatch("March 2024");
        StudentRegistry.putStudent("March-2024", student);

        IntelligentStudent intelligentStudent = new IntelligentStudent();
        intelligentStudent.setBatch("March-2024");
        StudentRegistry.putStudent("March-2024", intelligentStudent);

    }

    public static void main(String[] args) {

        fillStudentRegistry();

        Student normalStudent =
    }

}