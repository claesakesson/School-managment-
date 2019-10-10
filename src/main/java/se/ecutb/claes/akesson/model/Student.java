package se.ecutb.claes.akesson.model;

public class Student {
    private static int studentCounter;
    private int studentId;
    private String studentName;
    private String email;
    private String address;

    public Student(int studentId, String studentName, String email, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.address = address;
    }

    public Student(String studentName, String email, String address) {
        this(++studentCounter, studentName, email, address);
    }


    public int getStudentId() {
        return studentId;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
