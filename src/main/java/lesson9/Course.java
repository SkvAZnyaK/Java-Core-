package lesson9;

import java.util.Objects;

public class Course {
    private String courseName;
    enum courseName {
        ASTROLOGY, BIOLOGY, CHEMISTRY, JAVA, PHP, GO, HTML
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return courseName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Course course = (Course) object;
        return Objects.equals(courseName, course.courseName);
    }
}