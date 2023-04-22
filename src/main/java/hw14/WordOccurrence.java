package hw14;

import java.util.Objects;

public class WordOccurrence {
    private String name;
    private int occurrence;

    public WordOccurrence(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    @Override
    public String toString() {
        return "WordOccurrence{" +
                "name='" + name + '\'' +
                ", occurrence=" + occurrence +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordOccurrence that = (WordOccurrence) o;
        return occurrence == that.occurrence && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, occurrence);
    }
}
