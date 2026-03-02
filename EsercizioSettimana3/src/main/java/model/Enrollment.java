package model;

import java.time.LocalDate;

public class Enrollment {

    private int id;
    private User user;
    private Course course;
    private LocalDate enrollment_date;

    public Enrollment(User user, Course course) {
        this.user = user;
        this.course = course;
        this.enrollment_date = LocalDate.now();
    }

    public Enrollment(int id, User user, Course course, LocalDate enrollment_date) {
        this.id = id;
        this.user = user;
        this.course = course;
        this.enrollment_date = enrollment_date;
    }

    public int getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public LocalDate getEnrollment_date() {
        return enrollment_date;
    }
    public void setEnrollment_date(LocalDate enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", user=" + user +
                ", course=" + course +
                ", enrollment_date=" + enrollment_date +
                '}';
    }
}
