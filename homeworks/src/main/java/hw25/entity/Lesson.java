package hw25.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Lesson {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private Homework homework;

    public Lesson() {
    }

    public Lesson(String name, Homework homework) {
        this.name = name;
        this.homework = Objects.requireNonNull(homework);
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
        return Objects.equals(id, lesson.id) && Objects.equals(name, lesson.name) && Objects.equals(createdAt, lesson.createdAt) && Objects.equals(homework, lesson.homework);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, homework);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeStamp=" + createdAt +
                ", homework=" + homework +
                "}\n";
    }
}
