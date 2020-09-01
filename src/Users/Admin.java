package Users;

import AdditionalClasses.IO;
import AdditionalClasses.PersonData;
import DataAndStatickClasses.Data;
import DataAndStatickClasses.Log;

import java.io.IOException;

public class Admin extends User {
    static private final String enterLogin = "Enter the login of user";
    static private final String wrongLogin = "User with such login does not exist";
    static private final String end = "Enter ! sign to exit";


    public Admin(String login, String password) {
        super(login, password);
    }

    @Override
    public void execute(int value) {
        if (value == 1) { // Remove a user
            System.out.println(enterLogin);
            String login = IO.read();
            if (login.equals("!")) return;
            while (!Data.doesUserExist(login)) {
                System.out.println(wrongLogin);
                System.out.println(enterLogin);
                login = IO.read();
                if (login.equals("!")) return;
            }
            try {
                Data.deleteUser(login);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            this.log.add(new Log("Removed a user"));
        }
        if (value == 2) {
            // Add a Student
            PersonData personData = new PersonData();
            if (!personData.setName()) return;
            if (!personData.setSurname()) return;
            if (!personData.setEmail()) return;
            if (!personData.setNumber()) return;
            Student newStudent = new Student(personData);
            if (!newStudent.setLogin()) return;
            if (!newStudent.setPassword()) return;
            Data.addUser(newStudent);

            this.log.add(new Log("Added a student"));
        }
        if (value == 3) {
            System.out.println(enterLogin);
            String login = IO.read();
            if (login.equals("!")) return;
            while (!Data.doesUserExist(login)) {
                System.out.println(wrongLogin);
                System.out.println(enterLogin);
                login = IO.read();
                if (login.equals("!")) return;
            }
            Data.getUser(login).showLog();
        }
        if (value == 4) { // Update info about a user by login
            IO.print(enterLogin);
            String oldLogin = IO.read();
            if (oldLogin.equals("!")) return;
            while(!Data.doesUserExist(oldLogin)) {
                IO.print(wrongLogin);
                IO.print(enterLogin);
                oldLogin = IO.read();
            }

            User user = Data.getUser(oldLogin);
            if (!user.setLogin()) return;
            if (!user.setPassword()) return;
            if (user instanceof Employee || user instanceof Student) {
                PersonData personData = new PersonData();
                if (!personData.setName()) return;
                if (!personData.setSurname()) return;
                if (!personData.setEmail()) return;
                if (!personData.setNumber()) return;

                try {
                    Data.deleteUser(oldLogin);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                if (user instanceof Employee) {
                    Employee employee = (Employee) user;
                    employee.setData(personData);
                    Data.addUser(employee);
                }

                if (user instanceof Student) {
                    Student student = (Student)user;
                    student.setPersonData(personData);
                    Data.addUser(student);
                }
            }


            this.log.add(new Log("Updated the info about a user"));

        }
        if (value == 10) { // Add a teacher
            PersonData personData = new PersonData();
            if (!personData.setName()) return;
            if (!personData.setSurname()) return;
            if (!personData.setEmail()) return;
            if (!personData.setNumber()) return;
            Teacher teacher = new Teacher(personData);
            if (!teacher.setLogin()) return;
            if (!teacher.setPassword()) return;
            if (!teacher.setSalary()) return;
            Data.addUser(teacher);

            this.log.add(new Log("Added a teacher"));
        }
        if (value == 11) { // Add OR Manager
            PersonData personData = new PersonData();
            if (!personData.setName()) return;
            if (!personData.setSurname()) return;
            if (!personData.setEmail()) return;
            if (!personData.setNumber()) return;
            ORManager orManager = new ORManager(personData);
            if (!orManager.setLogin()) return;
            if (!orManager.setPassword()) return;
            if (!orManager.setSalary()) return;
            Data.addUser(orManager);


            this.log.add(new Log("Added an OrManager"));
        }
    }

}
