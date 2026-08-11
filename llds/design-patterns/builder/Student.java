package builder;

public class Student {

    private int rollNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
   
    private Student(Builder builder) {
        this.rollNumber = builder.rollNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }

    public void display() {
        System.out.println("**** STUDENT INFO ****");
        System.out.println("Roll number: " + this.rollNumber);
        System.out.println("First name: " + this.firstName);
        System.out.println("Last name: " + this.lastName);
        if (this.email != null) {
            System.out.println("Email: " + this.email);
        }
        if (this.address != null) {
            System.out.println("Address: " + this.address);
        }
        if (this.phoneNumber != null) {
            System.out.println("Phone: " + this.phoneNumber);
        }
        System.out.println();
    }
    
    public static class Builder {

        private int rollNumber;
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private String phoneNumber;

        public Builder() {}

        public Builder rollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phoneNBuilder(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Student build() throws Exception {
            if (this.rollNumber == 0) {
                throw new Exception("Roll number is missing");
            }

            return new Student(this);
        }
    }

}
