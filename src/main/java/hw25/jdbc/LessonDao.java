package hw25.jdbc;

import hw25.entity.Homework;
import hw25.entity.Lesson;
import hw25.exceptions.JdbcOperationException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LessonDao {

    public Lesson insert(final Lesson lesson) {
        Objects.requireNonNull(lesson);
        if (lesson.getId() != null) {
            throw new JdbcOperationException("ID mustn't be provided during th insert operation!");
        }
        String sql = """
                WITH new_homework AS (
                    INSERT INTO homework (name, description) VALUES (?, ?) RETURNING id
                    )
                INSERT INTO lesson (name, homework_id) SELECT ?, id FROM new_homework
                RETURNING lesson.id, lesson.updatedAt, (SELECT id FROM new_homework)
                """;
        try (PreparedStatement prepStatement = DataBaseConnection.getConnection()
                .prepareStatement(sql)) {
            int setIndex = 1;
            prepStatement.setString(setIndex++, lesson.getHomework().getName());
            prepStatement.setString(setIndex++, lesson.getHomework().getDescription());
            prepStatement.setString(setIndex, lesson.getName());
            ResultSet resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                int getIndex = 1;
                lesson.setId(resultSet.getLong(getIndex++));
                lesson.setTimeStamp(resultSet.getTimestamp(getIndex++).toLocalDateTime());
                lesson.getHomework().setId(resultSet.getLong(getIndex));
            } else {
                throw new JdbcOperationException("No rows were inserted!");
            }
            return lesson;
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to insert the lesson!", e);
        }
    }

    public String delete(final Long id) {
        Objects.requireNonNull(id);
        String sql = """
                WITH deleted_homework AS (DELETE FROM lesson WHERE id = ?
                  RETURNING homework_id)
                DELETE FROM homework WHERE id IN (SELECT homework_id FROM deleted_homework)
                 AND NOT EXISTS (SELECT 1 FROM lesson WHERE homework_id = 
                  (SELECT homework_id FROM deleted_homework) AND id <> ?)
                """;
        try (PreparedStatement prepStatement = DataBaseConnection.getConnection()
                .prepareStatement(sql)) {
            int index = 1;
            prepStatement.setLong(index++, id);
            prepStatement.setLong(index, id);
            int result = prepStatement.executeUpdate();
            if (result == 1) {
                return "Lesson and related homework were successfully deleted";
            } else if (result == 0) {
                return "Lesson was successfully deleted. Homework wasn't deleted because " +
                        "other lesson has this homework also.";
            } else {
                throw new JdbcOperationException("No rows were deleted!");
            }
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to delete a lesson by ID: " + id, e);
        }
    }


    public List<Lesson> getAll() {
        List<Lesson> lessons = new ArrayList<>();
        String sql = """
                SELECT l.id, l.name, l.updatedAt, h.id, h.name, h.description
                FROM lesson l LEFT JOIN homework h ON l.homework_id = h.id;
                """;
        try (PreparedStatement prepStatement = DataBaseConnection.getConnection()
                .prepareStatement(sql)) {
            ResultSet resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                int index = 1;
                Lesson lesson = retreiveLesson(resultSet, index);
                lessons.add(lesson);
            }
            return lessons;
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to get all lessons!", e);
        }
    }

    public Lesson getOne(final Long id) {
        Lesson lesson = new Lesson();
        String sql = """
                SELECT l.id, l.name, l.updatedAt, h.id, h.name, h.description
                FROM lesson l LEFT JOIN homework h ON l.homework_id = h.id
                WHERE l.id = ?
                """;
        try (PreparedStatement prepStatement = DataBaseConnection.getConnection()
                .prepareStatement(sql)) {
            int setIndex = 1;
            prepStatement.setLong(setIndex, id);
            ResultSet resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                int getIndex = 1;
                lesson = retreiveLesson(resultSet, getIndex);
            }
            return lesson;
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to get a lesson by ID: " + id, e);
        }
    }

    private Lesson retreiveLesson(ResultSet resultSet, int index) throws SQLException {
        Lesson lesson = new Lesson();
        Homework homework = new Homework();
        lesson.setId(resultSet.getLong(index++));
        lesson.setName(resultSet.getString(index++));
        lesson.setTimeStamp(resultSet.getTimestamp(index++).toLocalDateTime());
        homework.setId(resultSet.getLong(index++));
        homework.setName(resultSet.getString(index++));
        homework.setDescription(resultSet.getString(index));
        lesson.setHomework(homework);
        return lesson;
    }
}
