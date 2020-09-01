package Courses;

import AdditionalClasses.IO;
import Users.Student;
import Users.Teacher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Course implements Cloneable, Comparable, Serializable {

    Teacher teacher;
    String courseId;
    int numberOfCredits;

    public static HashMap<String, List<Integer>> marks;

    public Course(Teacher teaacher, String courseId, int numberOfCredits) {
        this.teacher = teacher;
        this.courseId = courseId;
        this.numberOfCredits = numberOfCredits;
        marks = new HashMap<>();
    }

    public void putMark(String studentID, int mark_) {
        Integer mark = new Integer(mark_);
        try {
            marks.get(studentID).add(mark);
        } catch(NullPointerException e) {
            List<Integer> lm = new ArrayList<Integer>();
            lm.add(mark);
            marks.put(studentID,lm);
        }
    }

    public void showMarks(Student student) {
        IO.print(this.getCourseId() + "Marks: ");
        try {
            List<Integer> curMarks = marks.get(student.getLogin());
            for(Integer curMark : curMarks) {
                IO.print(String.valueOf(curMark.intValue()));
            }
        } catch (NullPointerException e) {
            IO.print(e.getMessage());
        }

    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    @Override
    public int compareTo(Object o) {
        return 0; // TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return numberOfCredits == course.numberOfCredits &&
                Objects.equals(teacher, course.teacher) &&
                Objects.equals(courseId, course.courseId) &&
                Objects.equals(marks, course.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacher, courseId, numberOfCredits, marks);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseFile="  +
                ", teacher=" + teacher +
                ", courseId='" + courseId + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                ", marks=" + marks +
                '}';
    }

}
