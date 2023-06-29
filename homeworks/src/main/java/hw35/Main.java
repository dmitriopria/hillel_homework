package hw35;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

//        Student newStudent = new Student();
//        newStudent.setName("Dima");
//        newStudent.setEmail("dima@example.com");
//        studentDAO.addStudent(newStudent);
//        System.out.println(studentDAO.getStudentById(1));
//
//        Student existingStudent = studentDAO.getStudentById(1);
//        existingStudent.setEmail("updated.email@example.com");
//        studentDAO.updateStudent(existingStudent);
        System.out.println(studentDAO.getStudentById(2));

//        Student studentToDelete = studentDAO.getStudentById(2);
//        studentDAO.deleteStudent(studentToDelete.getId());

        List<Student> allStudents = studentDAO.getAllStudents();
        System.out.println("All students:");
        allStudents.forEach(System.out::println);
    }
}
