package hw14.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactBook {
    private final List<Record> records;

    public ContactBook() {
        this.records = new ArrayList<>();
    }

    public void add(Record record) {
        records.add(record);
    }

    public Record find(String name) {
        Objects.requireNonNull(name);
        for (Record record : records) {
            if (record.getName().equals(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        Objects.requireNonNull(name);
        List<Record> foundRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equals(name)) {
                foundRecords.add(record);
            }
        }
        return foundRecords.isEmpty() ? null : foundRecords;
    }
}
