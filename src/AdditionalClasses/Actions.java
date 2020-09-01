package AdditionalClasses;

import Constants.Strings;
import DataAndStatickClasses.Data;

public class Actions {
    public static String getLogin() {
        IO.print(Strings.enterLogin);
        String login = IO.read();
        while(!Data.doesUserExist(login)) {
            IO.print(Strings.wrongLogin);
            IO.print(Strings.enterLogin);
            login = IO.read();
        }
        return login;
    }
    public static String getCourseId() {
        IO.print(Strings.enterCourse);
        String id = IO.read();
        while(!Data.doesCourseExist(id)) {
            IO.print(Strings.wrongCourse);
            IO.print(Strings.enterCourse);
            id = IO.read();
        }
        return id;
    }
    public static Integer getMark() {
        IO.print(Strings.enterMark);
        String mark = IO.read();
        int mark_ = Integer.parseInt(mark);
        while(!(mark_ >= 1 && mark_ <= 100)) {
            mark = IO.read();
            mark_ = Integer.parseInt(mark);
        }
        return mark_;
    }

    public static String getNewCourseId() {
        IO.print(Strings.enterCourse);
        String newCourseId = IO.read();
        while(Data.doesCourseExist(newCourseId)) {
            IO.print(Strings.courseExist);
            IO.print(Strings.enterCourse);
        }
        return newCourseId;
    }

    public static int getAmountCredits() {
        IO.print(Strings.enterCredits);
        String mark = IO.read();
        boolean isInt;
        while(true) {
            isInt = true;
            for(int i = 0;i < mark.length();i ++) {
                if(!(mark.charAt(i) >= '0' && mark.charAt(i) <= '9')) {
                    isInt = false;
                    break;
                }
            }
            if(isInt) break;
            IO.print(Strings.wrongCredits);
            IO.print(Strings.enterCredits);
            mark = IO.read();
        }
        return Integer.parseInt(mark);
    }
}
