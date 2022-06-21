INSERT INTO groups (name)
VALUES
    ('ABC'),
    ('DEF'),
    ('GHI'),
    ('JKL'),
    ('MNO');


INSERT INTO teacher_position (id, position)
VALUES
    (1, 'PROFESSOR'),
    (2, 'PHD'),
    (3, 'DEAN');

INSERT INTO students (first_name, last_name, faculty, ticket, group_id)
VALUES
    ('Bob', 'MacBob', 'Computer Science', 123, 1),
    ('John', 'MacJohn', 'Computer Science', 321, 1),
    ('Jeff', 'MacJeff', 'Computer Science', 456, 2),
    ('Nick', 'MacNick', 'Computer Science', 654, 2),
    ('Kevin', 'MacKevin', 'Computer Science', 789, 3),
    ('Austin', 'MacAustin', 'Computer Science', 987, 3),
    ('Dirk', 'MacDirk', 'Computer Science', 666, 4),
    ('Ivan', 'MacIvan', 'Computer Science', 333, 4),
    ('Alex', 'MacAlex', 'Computer Science', 999, 5),
    ('Victor', 'MacVictor', 'Computer Science', 111, 5);

INSERT INTO teachers (first_name, last_name, department, position)
VALUES
    ('Antonio', 'Black', 'ADP', 1),
    ('Richard', 'Smith', 'ADP', 2),
    ('Bruno', 'White', 'ADP', 2),
    ('Dave', 'Loveless', 'ADP', 3);

INSERT INTO lessons (name, classroom)
VALUES
    ('Design', 101),
    ('Databases', 102),
    ('Java', 103);

INSERT INTO timetables (lesson_id, teacher_id, group_id, day, time)
VALUES
    (1, 1, 1, 1, '08:45:00'),
    (2, 2, 2, 2, '08:45:00'),
    (3, 3, 3, 3, '08:45:00'),
    (1, 4, 4, 4, '08:45:00'),
    (2, 1, 5, 5, '08:45:00'),
    (3, 2, 1, 1, '12:30:00'),
    (1, 3, 2, 2, '12:30:00'),
    (2, 4, 3, 3, '12:30:00'),
    (3, 1, 4, 4, '12:30:00'),
    (1, 2, 5, 5, '12:30:00');

