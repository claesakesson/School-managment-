package se.ecutb.claes.akesson.data_access;

import se.ecutb.claes.akesson.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {

    private static List<Student>students;

    public StudentDaoList(){
        students = new ArrayList<>();
    }

    @Override
    public Student saveStudent(Student student) {
        if (!students.contains(student)){
            students.add(student);
        }
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        for (Student student : students){
            if(student.getEmail().equalsIgnoreCase(email)){
                return student;

            }
        }return null;

    }

    @Override
    public List<Student> findByName(String name) {
       List<Student>tempList = new ArrayList<>();
        for(Student student : students){
            if(student.getStudentName()==name){
                tempList.add(student);

            }
        }return tempList;
    }

    @Override
    public Student findById(int Id) {
       for(Student student : students){
           if(student.getStudentId()==Id){
               return student;
           }
       }return null;
    }

    @Override
    public List<Student> findAll() {

        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return students.remove(student);
    }


    }

