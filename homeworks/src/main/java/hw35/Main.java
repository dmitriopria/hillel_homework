package hw35;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        LOGGER.info("Retrieving student by ID: 2");
        LOGGER.info(studentDAO.getStudentById(2).toString());

        LOGGER.info("Retrieving all students:");
        List<Student> allStudents = studentDAO.getAllStudents();
        allStudents.forEach(student -> LOGGER.info(student.toString()));
    }
}
