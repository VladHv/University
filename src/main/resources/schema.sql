DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS teacher_position CASCADE;
DROP TABLE IF EXISTS teachers CASCADE;
DROP TABLE IF EXISTS lessons CASCADE;
DROP TABLE IF EXISTS groups CASCADE;
DROP TABLE IF EXISTS timetables CASCADE;

CREATE TABLE groups
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE students
(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    faculty VARCHAR(255),
    ticket INTEGER,
    group_id INTEGER REFERENCES groups (id)
);

CREATE TABLE teacher_position
(
    id INTEGER PRIMARY KEY,
    position VARCHAR(20)
);

CREATE TABLE teachers
(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    department VARCHAR(255),
    position INTEGER REFERENCES teacher_position (id)
);

CREATE TABLE lessons
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    classroom INTEGER
);

CREATE TABLE timetables
(
    id SERIAL PRIMARY KEY,
    lesson_id INTEGER REFERENCES lessons (id),
    teacher_id INTEGER REFERENCES teachers (id),
    group_id INTEGER REFERENCES groups (id),
    day INTEGER,
    time TIME
);
