package hw25.jdbc;

public class SQLQuery {
    public static final String INSERT_LESSON_AND_HOMEWORK_RETURNING_LESSON =
            """
                    WITH new_homework AS (
                        INSERT INTO homework (name, description) VALUES (?, ?) RETURNING id
                        )
                    INSERT INTO lesson (name, homework_id) SELECT ?, id FROM new_homework
                    RETURNING lesson.id, lesson.updated_at, (SELECT id FROM new_homework)
                    """;
    public static final String DELETE_LESSON_AND_CORRESPONDING_HOMEWORK =
            """
                    WITH deleted_homework AS (DELETE FROM lesson WHERE id = ?
                      RETURNING homework_id)
                    DELETE FROM homework WHERE id IN (SELECT homework_id FROM deleted_homework)
                     AND NOT EXISTS (SELECT 1 FROM lesson WHERE homework_id = 
                      (SELECT homework_id FROM deleted_homework) AND id <> ?)
                    """;
    public static final String SELECT_ALL_LESSONS_WITH_CORRESPONDING_HOMEWORK =
            """
                    SELECT l.id, l.name, l.updated_at, h.id, h.name, h.description
                    FROM lesson l LEFT JOIN homework h ON l.homework_id = h.id;
                    """;
    public static final String SELECT_LESSON_BY_ID_WITH_CORRESPONDING_HOMEWORK =
            """
                    SELECT l.id, l.name, l.updated_at, h.id, h.name, h.description
                    FROM lesson l LEFT JOIN homework h ON l.homework_id = h.id
                    WHERE l.id = ?
                    """;
}
