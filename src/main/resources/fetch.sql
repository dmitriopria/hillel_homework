SELECT id, name, description FROM homework;

SELECT l.id, l.name, l.updated_at, l.homework_id, h.name AS homework_name, h.description AS homework_description
FROM lesson l LEFT JOIN homework h ON l.homework_id = h.id;

SELECT l.id, l.name, l.updated_at, l.homework_id, h.name AS homework_name, h.description AS homework_description
FROM lesson l LEFT JOIN homework h ON l.homework_id = h.id
ORDER BY l.updated_at;

SELECT s.id, s.name, s.updated_at, l.name AS lesson_name, l.updated_at AS lesson_updated_at,
h.name AS homework_name, h.description AS homework_description
FROM schedule s
LEFT JOIN lesson_schedule ls ON s.id = ls.schedule_id
LEFT JOIN lesson l ON ls.lesson_id = l.id
LEFT JOIN homework h ON l.homework_id = h.id;

SELECT s.id, s.name, s.updated_at, COUNT(ls.lesson_id) AS num_lessons FROM schedule s
LEFT JOIN lesson_schedule ls ON s.id = ls.schedule_id GROUP BY s.id;