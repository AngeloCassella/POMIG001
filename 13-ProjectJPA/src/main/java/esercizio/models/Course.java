package esercizio.models;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String teacher;
    @Column(nullable = true)
    private int duration;
    @Column(nullable = true)
    private int max_students;

    public Course() {}

    public Course(int id, String title, String teacher, int duration, int max_students) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
        this.duration = duration;
        this.max_students = max_students;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getMax_students() {
        return max_students;
    }
    public void setMax_students(int max_students) {
        this.max_students = max_students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", teacher='" + teacher + '\'' +
                ", duration=" + duration +
                ", max_students=" + max_students +
                '}';
    }
}
