package Users;

import AdditionalClasses.IO;
import AdditionalClasses.PersonData;
import DataAndStatickClasses.Data;

public class ORManager extends Employee {

    static final String sendMessage = "Enter your message to teachers:";
    static final String end = "Enter ! to cancel";

    static private final String enterLogin = "Enter the login of user";
    static private final String wrongLogin = "User with such login does not exist";

    public ORManager(PersonData personData) {
        super(personData);
    }

    @Override
    public void execute(int value) {
        if (value == 1) { // View info about a student
            IO.print(enterLogin);
            String login = IO.read();
            while(!Data.doesUserExist(login)) {
                IO.print(enterLogin);
                IO.print(wrongLogin);
                login = IO.read();
            }
            User user = Data.getUser(login);
            if(!(user instanceof Student)) {
                IO.print("Given login is not login of the student");
            } else {
                IO.print(user.toString());
            }
        }
        if (value == 2) { // Add a course

        }
        if (value == 3) { // Send a message to the teachers
            IO.print(sendMessage);
            IO.print(end);
            String message = IO.read();
            if (message.equals("!")) return;
            Data.addMessagForTeacher(message);
        }
        if (value == 4) { // View info about a teacher
            IO.print(enterLogin);
            IO.print(end);
            String login = IO.read();
            if (login.equals("!")) return;
            while(!Data.doesUserExist(login)) {
                IO.print(enterLogin);
                IO.print(wrongLogin);
                IO.print(end);
                login = IO.read();
                if (login.equals("!")) return;
            }
            User user = Data.getUser(login);
            if(!(user instanceof Teacher)) {
                IO.print("Given login is not login of the teacher");
            } else {
                IO.print(user.toString());
            }
        }
    }
}
