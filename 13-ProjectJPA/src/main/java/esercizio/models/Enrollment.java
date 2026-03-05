package esercizio.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollmets")
@NamedQuery(name = "Enrollment.findAll", query = "SELECT e FROM Enrollment e")
@NamedQuery(name = "Enrollment.findAllByUser", query = "SELECT e FROM Enrollment e WHERE e.user = :user")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollmet_id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(nullable = false)
    private LocalDate enrollment_date;

    public Enrollment() {}

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
