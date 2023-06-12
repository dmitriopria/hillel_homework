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

    public Lesson insert(final Lesson lesson, final Homework homework) {
        Objects.requireNonNull(lesson);
        Objects.requireNonNull(homework);
        if (lesson.getId() != null) {
            throw new JdbcOperationException("ID mustn't be provided during the insert operation!");
        }
        String sql = SQLQuery.INSERT_LESSON_AND_HOMEWORK_RETURNING_LESSON;
        try (PreparedStatement prepStatement = DataBaseConnection.getConnection()
                .prepareStatement(sql)) {
            int setIndex = 1;
            prepStatement.setString(setIndex++, homework.getName());
            prepStatement.setString(setIndex++, homework.getDescription());
            prepStatement.setString(setIndex, lesson.getName());
            ResultSet resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                int getIndex = 1;
                lesson.setId(resultSet.getLong(getIndex++));
                lesson.setCreatedAt(resultSet.getTimestamp(getIndex++).toLocalDateTime());
                homework.setId(resultSet.getLong(getIndex));
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
        String sql = SQLQuery.DELETE_LESSON_AND_CORRESPONDING_HOMEWORK;
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
        String sql = SQLQuery.SELECT_ALL_LESSONS_WITH_CORRESPONDING_HOMEWORK;
        try (PreparedStatement prepStatement = DataBaseConnection.getConnection()
                .prepareStatement(sql)) {
            ResultSet resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                Lesson lesson = retreiveLesson(resultSet);
                lessons.add(lesson);
            }
            return lessons;
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to get all lessons!", e);
        }
    }

    public Lesson getOne(final Long id) {
        Lesson lesson = new Lesson();
        String sql = SQLQuery.SELECT_LESSON_BY_ID_WITH_CORRESPONDING_HOMEWORK;
        try (PreparedStatement prepStatement = DataBaseConnection.getConnection()
                .prepareStatement(sql)) {
            int index = 1;
            prepStatement.setLong(index, id);
            ResultSet resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                lesson = retreiveLesson(resultSet);
            }
            return lesson;
        } catch (SQLException e) {
            throw new JdbcOperationException("Failed to get a lesson by ID: " + id, e);
        }
    }

    private Lesson retreiveLesson(ResultSet resultSet) throws SQLException {
        Lesson lesson = new Lesson();
        Homework homework = new Homework();
        int index = 1;
        lesson.setId(resultSet.getLong(index++));
        lesson.setName(resultSet.getString(index++));
        lesson.setCreatedAt(resultSet.getTimestamp(index++).toLocalDateTime());
        homework.setId(resultSet.getLong(index++));
        homework.setName(resultSet.getString(index++));
        homework.setDescription(resultSet.getString(index));
        lesson.setHomework(homework);
        return lesson;
    }
}
