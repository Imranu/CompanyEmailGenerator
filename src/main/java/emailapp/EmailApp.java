package emailapp;

public class EmailApp {

    public static void main(String[] args) {

        Email email = new Email("John", "Smith");
        email.setAlternateEmail("dadwaadw@mail.com");
        System.out.println(email.getAlternateEmail());
        System.out.println(email.toString());
    }

}
