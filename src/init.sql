CREATE TABLE homework (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT
);

CREATE TABLE lesson (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  updatedAt TIMESTAMP DEFAULT NOW(),
  homework_id BIGINT NOT NULL,
  constraint homework_id_fk foreign key (homework_id) REFERENCES homework(id)
);

CREATE TABLE schedule (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  updatedAt TIMESTAMP DEFAULT NOW()
);

CREATE TABLE lesson_schedule (
  lesson_id BIGINT REFERENCES lesson(id) ON DELETE CASCADE,
  schedule_id BIGINT REFERENCES schedule(id) ON DELETE CASCADE,
  PRIMARY KEY (lesson_id, schedule_id)
);

INSERT INTO homework (name, description) VALUES
('HW1', 'Complete exercises 1-5'),
('HW2', 'Write a short essay on a given topic');

INSERT INTO lesson (name, homework_id) VALUES
('Lesson 1', 1),
('Lesson 2', 1),
('Lesson 3', 2),
('Lesson 4', 2);

INSERT INTO schedule (name) VALUES
('Schedule 1'),
('Schedule 2');

INSERT INTO lesson_Schedule (lesson_id, schedule_id) VALUES
(1, 1),
(2, 1),
(2, 2);