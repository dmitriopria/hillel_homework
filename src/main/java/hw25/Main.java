package hw25;

import hw25.entity.Lesson;
import hw25.jdbc.LessonDao;

public class Main {
    public static void main(String[] args) {
        Lesson lesson = new Lesson("Math", "Do Math", "Calculate");
        LessonDao lessonJdbcOps = new LessonDao();
//        Lesson insertedLesson = lessonJdbcOps.insert(lesson);
//        System.out.println(insertedLesson);
        System.out.println(lessonJdbcOps.getAll());
//        System.out.println(lessonJdbcOps.delete(6L));
        System.out.println(lessonJdbcOps.getOne(4L));
    }
}
