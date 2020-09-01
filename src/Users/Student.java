package Users;

import AdditionalClasses.Actions;
import AdditionalClasses.IO;
import AdditionalClasses.PersonData;
import Courses.Course;
import Courses.Transcript;
import DataAndStatickClasses.Data;
import Enums.Degree;

import java.util.Scanner;

public class Student extends User {

    private Degree degree;
    private Transcript transcript;
    private PersonData personData;
    private double gpa;

    public Student(PersonData personData) {
        super();
        this.personData = personData;
        this.degree = Degree.Bachelor;
        transcript = new Transcript();
    }

    public Student() {
        super();
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public PersonData getPersonData() {
        return personData;
    }

    public void setPersonData(PersonData personData) {
        this.personData = personData;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    @Override
    public void execute(int value) {
        Scanner scanner = new Scanner(System.in);
        if (value == 1) { // View courses
            showCourses();
        }
        if (value == 2) { // View transcript
            showTranscript();
        }
        if (value == 3) { // register for a course
            String courseId = Actions.getCourseId();
            transcript.getCourseId().add(courseId);
        }
        if (value == 5) { // View file of course
            showCourseFiles();
        }
    }

    private void showCourseFiles() {

    }

    private void showCourses() {
        try {
            for (String courseName : transcript.getCourseId()) {
                IO.print(courseName);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void showTranscript() {
        try {
            for (String courseId : transcript.getCourseId()) {
                Course course = Data.getCourse(courseId);
                course.showMarks(this);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
