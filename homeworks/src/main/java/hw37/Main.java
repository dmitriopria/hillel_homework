package hw37;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("hw37");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
    }
}
