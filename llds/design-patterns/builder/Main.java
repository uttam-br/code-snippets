package builder;

public class Main {

    public static void main(String[] args) {
        Student student;
        try {
            student = new Student.Builder()
                    .rollNumber(1)
                    .firstName("Uttam")
                    .lastName("Rabari")
                    .build();

            student.display();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
