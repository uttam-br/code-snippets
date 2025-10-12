public class Main {

    public static void main(String[] args) {

        User user = new User.Builder()
                .firstName("Uttam")
                .lastName("Rabari")
                .email("email@email.com")
                .age(27)
                .mobileNumber("123456789")
                .build();

        System.out.println(user);
    }

}
