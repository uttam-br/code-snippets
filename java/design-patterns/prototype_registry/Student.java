package prototype_registry;

public class Student implements Prototype<Student> {

    private int age;
    private String name;
    private String batch;
    private double averageBatchPsp;
    private double studentPsp;

    Student() {
    }

    Student(Student st) {
        this.age = st.age;
        this.name = st.name;
        this.batch = st.batch;
        this.averageBatchPsp = st.averageBatchPsp;
        this.studentPsp = st.studentPsp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public double getAverageBatchPsp() {
        return averageBatchPsp;
    }

    public void setAverageBatchPsp(double averageBatchPsp) {
        this.averageBatchPsp = averageBatchPsp;
    }

    public double getStudentPsp() {
        return studentPsp;
    }

    public void setStudentPsp(double studentPsp) {
        this.studentPsp = studentPsp;
    }

    public void display() {
        System.out.println("I am normal student");
    }

    @Override
    public Student copy() {
        return new Student(this);
    }

}