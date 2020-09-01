package Users;

import AdditionalClasses.Actions;
import AdditionalClasses.IO;
import AdditionalClasses.PersonData;
import Courses.Course;
import DataAndStatickClasses.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Employee {
    private List<String> courses;

    public Teacher(PersonData personData) {
        super(personData);
        courses = new ArrayList<String>();
    }

    @Override
    public void execute(int value) {
        Scanner scanner = new Scanner(System.in);
        if (value == 1) { // Add a course
            String courseId = Actions.getNewCourseId();
            int credits = Actions.getAmountCredits();
            Course course = new Course(this,courseId,credits);
            try {
                Data.addCourse(course);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (value == 2) { // View courses
            try {
                for (String courseId : courses) {
                    IO.print(courseId);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        if (value == 3) { // Edit courseFile

        }
        if (value == 4) { // Put marks
            String courseId = Actions.getCourseId();
            String studentId = Actions.getLogin();
            Integer newMark = Actions.getMark();

            putMark(courseId,studentId,newMark);

        }
        if (value == 5) { // View messages from ORManager
            Data.printMessageForTeacher();
        }
        if (value == 6) { // Send order to IT support guy
            String order = scanner.nextLine();
            TechSupport.getOrders(order);
        }
    }

    private void putMark(String courseId, String studentId, Integer newMark) {
        Course course = Data.getCourse(courseId);
        course.putMark(studentId,newMark.intValue());
    }
}
