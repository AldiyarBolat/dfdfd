package Courses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Transcript implements Serializable {

    private List<String> courseId;

    public Transcript() {
        courseId = new ArrayList<>();
    }

    public List<String> getCourseId() {
        return courseId;
    }

    public void setCourseId(List<String> courseId) {
        this.courseId = courseId;
    }

}

