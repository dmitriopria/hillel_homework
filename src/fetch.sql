SELECT * FROM homework;

SELECT l.*, h.name AS homework_name, h.description AS homework_description
FROM lesson l LEFT JOIN homework h ON l.homework_id = h.id;

SELECT l.*, h.name AS homework_name, h.description AS homework_description
FROM lesson l LEFT JOIN homework h ON l.homework_id = h.id
ORDER BY l.updatedAt;

SELECT s.*, l.name AS lesson_name, l.updatedAt AS lesson_updatedAt,
h.name AS homework_name, h.description AS homework_description
FROM schedule s
LEFT JOIN lesson_schedule ls ON s.id = ls.schedule_id
LEFT JOIN lesson l ON ls.lesson_id = l.id
LEFT JOIN homework h ON l.homework_id = h.id;

SELECT s.*, COUNT(ls.lesson_id) AS num_lessons FROM schedule s
LEFT JOIN lesson_schedule ls ON s.id = ls.schedule_id GROUP BY s.id;