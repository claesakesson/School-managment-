package se.ecutb.claes.akesson.model;

import se.ecutb.claes.akesson.data_access.CourseDao;
import se.ecutb.claes.akesson.data_access.CourseDaoList;
import se.ecutb.claes.akesson.data_access.StudentDao;
import se.ecutb.claes.akesson.data_access.StudentDaoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SystemMenu {


      private StudentDaoList studentDao = new StudentDaoList();

      private CourseDaoList courseDao = new CourseDaoList();

      public void menu (){

          boolean keepAlive = true;
          while (keepAlive){


              switch (mainMenu()) {
                  case 1:
                      System.out.println(courseDao.findAll());
                      break;
                  case 2:
                      System.out.println(studentDao.findAll());
                      break;
                  case 3:
                      searching();
                      break;
                  case 4:
                      editChoose();
                      break;
                  case 5:
                      keepAlive = false;




              }
          }


    }

    private int editMenu() {
        System.out.println("What do you want to edit?\n" +
                "1. Courses.\n" +
                "2. Students.\n" +
                "3. Return to main menu.\n" +
                "Enter choice: ");
        return Input.getInt();
    }

    private int mainMenu(){
    System.out.println("Welcome!\n" +
            "1. Courses.\n" +
            "2. Student Information.\n" +
            "3. Find Course/Student.\n" +
            "4. Edit Course/Student.\n" +
            "5. Exit Program.\n");
    System.out.println("Make your choice: ");
    return Input.getInt();
}

private int searchOptions() {
    System.out.println("What are you looking for?\n" +
            "1. Courses by name.\n" +
            "2. Courses by date.\n " +
            "3. Student by name.\n" +
            "4. Student by email.\n" +
            "5. Return to main menu\n" +
            "Enter choice:  ");
    return Input.getInt();


}

private int studentEditMenu() {
    System.out.println("What do you want to do?\n" +
            "1. Add Student.\n" +
            "2. Edit Student.\n" +
            "3. Remove Student. \n" +
            "4. Return to main menu\n" +
            "Enter choice:  ");
    return Input.getInt();
}

private int courseEditMenu() {
    System.out.println("What do you want to do?\n" +
            "1. Add Course.\n" +
            "2. Edit Course.\n" +
            "3. Remove Course.\n" +
            "4. Return to main menu\n" +
            "Enter choice:  ");
    return Input.getInt();
}

private void searching(){
          boolean isSearching = true;
          while (isSearching) {
              switch (searchOptions()) {

                  case 1:
                      System.out.println("Enter name: ");
                      String name = Input.getString();
                      System.out.println(courseDao.findByName(name));
                      break;

                  case 2:
                      System.out.println("Enter start date (example: 1991-03-21): ");
                      String date = Input.getString();
                      System.out.println(courseDao.findByDate(LocalDate.parse(date)));
                      break;

                  case 3:
                      System.out.println("Enter name: ");
                      String studentName = Input.getString();
                      System.out.println(studentDao.findByName(studentName));
                      break;

                  case 4:
                      System.out.println("Enter email: ");
                      String email = Input.getString();
                      System.out.println(studentDao.findByEmail(email));
                      break;

                  case 5:
                      isSearching = false;

                      }
              }
}

private void editChoose() {
          boolean isChoosing = true;
          while (isChoosing){
              switch (editMenu()){
                  case 1:
                      editCourse();
                      break;

                  case 2:
                      editStudent();
                      break;

                  case 3:
                      isChoosing = false;
              }

          }
}

private void editCourse() {
          boolean isEditing = true;
          while (isEditing) {
              switch (courseEditMenu()){

                  case 1:
                      System.out.println("Name the course: ");
                      String name = Input.getString();
                      System.out.println("Enter start date: ");
                      LocalDate date = LocalDate.parse(Input.getString());
                      System.out.println("Duration of course?");
                      int duration = Input.getInt();
                      List list = new ArrayList();
                      Course course = new Course(name, date, duration, list);
                      courseDao.saveCourse(course);
                      break;

                  case 2:
                      System.out.println("Enter Course Id: ");
                      int id = Input.getInt();
                      switch (whatToEdit()){
                          case 1:
                              System.out.println("Enter new name: ");
                              courseDao.findById(id).setCourseName(Input.getString());
                              break;

                          case 2:
                              System.out.println("Enter new start date: ");
                              courseDao.findById(id).setStartDate(LocalDate.parse(Input.getString()));
                              break;

                          case 3:
                              System.out.println("Enter new Duration: ");
                              courseDao.findById(id).setWeekDuration(Input.getInt());
                              break;
                      }
                      break;

                  case 3:
                      System.out.println("Enter id of course you want to remove: ");
                      int courseId = Input.getInt();
                      System.out.println(courseDao.findById(courseId).getCourseName() + ". Is now deleted!");
                      courseDao.removeCourse(courseDao.findById(courseId));
                      break;

                  case 4:
                      isEditing = false;
                      break;








              }
          }


}
private int whatToEdit() {
    System.out.println("What do you want to change?\n" +
            "1. Name.\n" +
            "2. Start date.\n" +
            "3. Duration.");
             return Input.getInt();

}

private int whatToEditStudent(){
    System.out.println("What do you want to change?\n" +
            "1. Name. \n" +
            "2. Email.\n" +
            "3. Adress.");
    return Input.getInt();
}

private void editStudent(){
          boolean isEditing = true;
          while (isEditing){
              switch (studentEditMenu()){

                  case 1:
                      System.out.println("Enter student name: ");
                      String name = Input.getString();
                      System.out.println("Enter student email: ");
                      String email = Input.getString();
                      System.out.println("Enter student adress");
                      String adress = Input.getString();
                      Student student = new Student(name, email, adress);
                      studentDao.saveStudent(student);
                      break;

                  case 2:
                      System.out.println("Enter student Id: ");
                      int id = Input.getInt();
                      switch (whatToEditStudent()){

                          case 1:
                              System.out.println("Enter new name: ");
                              studentDao.findById(id).setStudentName(Input.getString());
                              break;

                          case 2:
                              System.out.println("Enter new email: ");
                              studentDao.findById(id).setEmail(Input.getString());
                              break;

                          case 3:
                              System.out.println("Enter new address: ");
                              studentDao.findById(id).setAddress(Input.getString());
                              break;

                          default: isEditing = false;
                      }
              }
          }
}





}
