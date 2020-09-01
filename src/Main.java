import DataAndStatickClasses.Data;
import DataAndStatickClasses.Session;
import Users.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Data.createAdmin();
        Data.saveData();
        //Data.loadData();
        while (true) {
            User user = signIn();
            Session.start(user);
        }

    }

    static User signIn() {
        String login, password;
        while (true) {
            for(int i = 0; i < 100; ++i) System.out.println();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter login:");
            login = scanner.nextLine();

            System.out.println("Enter password:");
            password = scanner.nextLine();

            if (Data.isValid(login, password)) {
                return Data.getUser(login);
            }

            System.out.println("Wrong login or password");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
