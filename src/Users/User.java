package Users;

import AdditionalClasses.IO;
import DataAndStatickClasses.Data;
import DataAndStatickClasses.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract public class User implements Comparable, Serializable, Cloneable {

    private static String loginExist = "Such login already exits";
    private static String enterLogin = "Enter login";
    private static String enterPassword = "Enter password";
    String login;
    String password;
    public List<Log> log = new ArrayList<Log>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        log = new ArrayList<Log>();
    }

    public static String hashPass(String password) {
        return Objects.hash(password) + "";
    }

    public void showLog() {
       for(Log log : this.log) {
           IO.print(log.toString());
       }
    }

    public User() {
        log = new ArrayList<Log>();
    }

    public boolean isPasswordValid(String s) {
        return password.equals(s);
    }

    public abstract void execute(int value);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Object o) {
        return 0; // TODO write compare to
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isValid(String password) {
        return this.password.equals(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean setLogin() {
        IO.print(enterLogin);
        String login = IO.read();
        if (login.equals("!")) return false;
        while (Data.doesUserExist(login)) {
            IO.print(loginExist);
            IO.print(enterLogin);
            login = IO.read();
            if (login.equals("!")) return false;
        }
        this.login = login;
        return true;
    }

    public boolean setPassword() {
        IO.print(enterPassword);
        String password = IO.read();
        if (password.equals("!")) return false;
        this.password = password;
        return true;
    }
}
