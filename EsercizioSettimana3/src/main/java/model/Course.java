package model;

public class Course {

    private int id;
    private String title;
    private String teacher;
    private int duration;
    private int max_students;

    public Course(String title, String teacher, int duration, int max_students) {
        this.title = title;
        this.teacher = teacher;
        this.duration = duration;
        this.max_students = max_students;
    }

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
