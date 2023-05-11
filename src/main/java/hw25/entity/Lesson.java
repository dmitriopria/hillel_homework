package hw25.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Lesson {
    private Long id;
    private String name;
    private LocalDateTime timeStamp;
    private Homework homework;

    public Lesson() {
    }

    public Lesson(String name, String homeWorkName, String homeWorkDescription) {
        this.name = name;
        this.homework = new Homework(homeWorkName, homeWorkDescription);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id) && Objects.equals(name, lesson.name) && Objects.equals(timeStamp, lesson.timeStamp) && Objects.equals(homework, lesson.homework);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, timeStamp, homework);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeStamp=" + timeStamp +
                ", homework=" + homework +
                "}\n";
    }
}
