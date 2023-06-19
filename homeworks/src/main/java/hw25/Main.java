package hw25;

import hw25.entity.Homework;
import hw25.entity.Lesson;
import hw25.jdbc.LessonDao;

public class Main {
    public static void main(String[] args) {
        Homework mathHomework = new Homework("Do math", "Calculate");
        Lesson lesson = new Lesson("Math", mathHomework);
        LessonDao lessonJdbcOps = new LessonDao();
//        Lesson insertedLesson = lessonJdbcOps.insert(lesson, mathHomework);
//        System.out.println(insertedLesson);
        System.out.println(lessonJdbcOps.getAll());
//        System.out.println(lessonJdbcOps.delete(9L));
        System.out.println(lessonJdbcOps.getOne(4L));
    }
}
