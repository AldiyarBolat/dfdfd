package DataAndStatickClasses;

import AdditionalClasses.IO;
import Courses.Course;
import Users.Admin;
import Users.TechSupport;
import Users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data implements Serializable, Cloneable {

    static private HashMap<String, User> logins = new HashMap<String, User>(); // key: login value: User
    static private HashMap<String, Course> courses = new HashMap<String, Course>(); // key: name of the course value: Course
    static private List<String> messagesToTeachers = new ArrayList<String>();

    public static void saveData() throws IOException { // Serialization data

        FileOutputStream fs = new FileOutputStream("users.ser");
        ObjectOutputStream os = new ObjectOutputStream(fs);

        os.writeObject(logins);

        os.flush();
        os.close();
        fs.close();

        fs = new FileOutputStream("courses.ser");
        os = new ObjectOutputStream(fs);

        os.writeObject(courses);

        os.flush();
        os.close();
        fs.close();

    }

    public static void loadData() throws IOException, ClassNotFoundException {
        FileInputStream fs =  new FileInputStream("users.ser");
        ObjectInputStream os = new ObjectInputStream(fs);

        logins = (HashMap) os.readObject();

        os.close();
        fs.close();

        fs = new FileInputStream("courses.ser");
        os = new ObjectInputStream(fs);

        courses = (HashMap) os.readObject();

        os.close();
        fs.close();

    }

    public static boolean doesUserExist(String login) { // check
        return logins.containsKey(login);
    }

    public static boolean doesCourseExist(String name) { // check
        return courses.containsKey(name);
    }

    public static User getUser(String login) { // get User by login TODO try catch
        return logins.get(login);
    }

    public static void deleteUser(String login) throws IOException, ClassNotFoundException { // remove User by login
        logins.remove(login);
        saveData();
    }

    public static Course getCourse(String name) {  // get a course by name TODO try catch
        return courses.get(name);
    }

    public static void deleteCourse(String name) throws IOException, ClassNotFoundException { // remove course by name
        courses.remove(name);
        saveData();
    }

    public static boolean isValid(String login, String password) { // login password validation
        if (!logins.containsKey(login)) return false;
        return (logins.get(login).isValid(password));
    }

    public static void createAdmin() {  // Add admin
        logins.put("admin", new Admin("admin", "admin"));
    }
    public static void createTechSupport() {
        logins.put("techsupport", new TechSupport("techsupport", "techsupport"));
    }

    public static void addUser(User user) {
        logins.put(user.getLogin(), user);
        try {
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addMessagForTeacher(String s) {
        messagesToTeachers.add(s);
        try {
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMessageForTeacher() {
        for(String message : messagesToTeachers) {
            IO.print(message);
        }
    }

    public static HashMap<String, User> getLogins() {
        return logins;
    }

    public static void setLogins(HashMap<String, User> logins) {
        Data.logins = logins;
    }

    public static HashMap<String, Course> getCourses() {
        return courses;
    }

    public static void setCourses(HashMap<String, Course> courses) {
        Data.courses = courses;
    }

    public static List<String> getMessagesToTeachers() {
        return messagesToTeachers;
    }

    public static void setMessagesToTeachers(List<String> messagesToTeachers) {
        Data.messagesToTeachers = messagesToTeachers;
    }


    public static void addCourse(Course course) throws IOException {
        courses.put(course.getCourseId(),course);
        saveData();
    }
}