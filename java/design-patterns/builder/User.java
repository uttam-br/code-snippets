public class User {


    private String firstName;
    private String lastName;
    private int age;
    private String mobileNumber;
    private String email;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.mobileNumber = builder.mobileNumber;
        this.email = builder.email;
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private int age;
        private String mobileNumber;
        private String email;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
