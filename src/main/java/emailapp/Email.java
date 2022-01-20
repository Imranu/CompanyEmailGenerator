package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private final int passwordLength = 10;
    private final String companySuffix = "company";
    private String department;
    private int mailboxCap = 500;
    private String email;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.email = generateEmail();
        this.password = randomPassword(this.passwordLength);
        creationMessage();
    }

    private void creationMessage() {
        System.out.println(String.format("Successfully created email for %s %s.",this.firstName, this.lastName));
        System.out.println(String.format("Department: %s", this.department.substring(0,1).toUpperCase(Locale.ROOT) + this.department.substring(1)));
        System.out.println(String.format("Email: %s", this.email));
        System.out.println(String.format("Password: %s", this.password));
    }

    private String setDepartment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: Sales\n2: Development\n3: Accounting");
        System.out.print("Enter Department Code: ");
        switch (scanner.nextInt()) {
            case 1: return "sales";
            case 2: return "development";
            case 3: return "accounting";
            default: return "None";
        }
    }

    private String generateEmail() {
        return new String(firstName.toLowerCase(Locale.ROOT) + "." + lastName.toLowerCase(Locale.ROOT) + "@" + department.substring(0,3) + "." + this.companySuffix + ".org");
    }

    private String randomPassword(int length) {
        String passwordChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789?@!\"£$%&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = passwordChars.charAt((int) (Math.random() * passwordChars.length()));
        }
            return new String(password);
        }

    public void setMailboxCap(int mailboxCap) {
        this.mailboxCap = mailboxCap;
        System.out.println(String.format("Mailbox capacity updated to: %s",this.mailboxCap));
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password) {
        if (password.length() >= this.passwordLength) {
            this.password = password;
            System.out.println(String.format("Password has been changed to: %s",this.password));
        } else {
            System.out.println("Password has not been changed, please create a password that meets Criteria.");
        }
    }

    public int getMailboxCap() { return mailboxCap;}
    public String getAlternateEmail() { return alternateEmail; }

    @Override
    public String toString() {
        return "Email{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", passwordLength=" + passwordLength +
                ", companySuffix='" + companySuffix + '\'' +
                ", department='" + department + '\'' +
                ", mailboxCap=" + mailboxCap +
                ", email='" + email + '\'' +
                ", alternateEmail='" + alternateEmail + '\'' +
                '}';
    }
}
