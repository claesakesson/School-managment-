package se.ecutb.claes.akesson.model;

import java.time.LocalDate;
import java.util.List;

public class Course {

    private static int courseCounter;
    private int courseId;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student>students;

    public Course(int courseId, String courseName, LocalDate startDate, int weekDuration, List<Student> students) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

    public Course(String courseName, LocalDate startDate, int weekDuration, List students){
        this(++courseCounter, courseName, startDate, weekDuration, students);
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void register(Student student){
        if(!students.contains(student)){
            students.add(student);

        }


    }

    public void unRegister(Student student){
        students.remove(student);

    }
}
