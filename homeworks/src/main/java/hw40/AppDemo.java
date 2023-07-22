package hw40;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "hw40")
public class AppDemo {
    public static void main(String[] args) {
        SpringApplication.run(AppDemo.class, args);
    }
}
