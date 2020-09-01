package AdditionalClasses;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

public class PersonData implements Comparable, Serializable, Cloneable {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private static final String nameValidation = "Name is not valid";
    private static final String enterName = "Enter the name";
    private static final String surnameValidation = "Surname is not valid";
    private static final String enterSurname = "Enter the surname";
    private static final String end = "Enter ! to cancel";
    private static final String emailValidation = "Email is not valid";
    private static final String enterEmail = "Enter the email";
    private static final String phoneNumberValidation = "phoneNumber is not valid";
    private static final String enterPhoneNumber = "Enter the phone number";
    private static final String phonePattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    public PersonData() {

    }

    public PersonData(String name, String surname, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonData that = (PersonData) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean setName() {
        IO.print(enterName);
        IO.print(end);
        String name = IO.read();
        if (name.equals("!")) return false;
        while (!name.matches("[a-zA-Z]+")) {
            IO.print(nameValidation);
            IO.print(enterName);
            IO.print(end);
            name = IO.read();
            if (name.equals("!")) return false;
        }
        this.name = name;
        return true;
    }

    public boolean setSurname() {
        IO.print(enterSurname);
        IO.print(end);
        String surname = IO.read();
        if (surname.equals("!")) return false;
        while (!surname.matches("[a-zA-Z]+")) {
            IO.print(end);
            IO.print(surnameValidation);
            IO.print(enterSurname);
            surname = IO.read();
            if (surname.equals("!")) return false;
        }
        this.surname = surname;
        return true;
    }

    public boolean setEmail() {
        IO.print(enterEmail);
        IO.print(end);
        String email = IO.read();
        if (email.equals("!")) return false;
        while (!VALID_EMAIL_ADDRESS_REGEX .matcher(email).find()) {
            IO.print(emailValidation);
            IO.print(enterEmail);
            IO.print(end);
            email = IO.read();
            if (email.equals("!")) return false;
        }
        return true;
    }

    public boolean setNumber() {
        IO.print(enterPhoneNumber);
        IO.print(end);
        String number = IO.read();
        if (number.equals("!")) return false;
        while (!number.matches(phonePattern)) {
            IO.print(phoneNumberValidation);
            IO.print(enterPhoneNumber);
            IO.print(end);
            number = IO.read();
            if (number.equals("!")) return false;
        }
        return true;
    }

}
