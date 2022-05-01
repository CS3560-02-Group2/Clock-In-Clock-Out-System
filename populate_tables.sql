-- Since primary key empID is auto incremented, NULL used in insert
INSERT INTO employee VALUES
    (NULL, "John Doe", 0),
    (NULL, "Some Guy", 0),
    (NULL, "Lena Raine", 0),
    (NULL, "Joe Zeke", 1),
    (NULL, "Janista Gitbumrungsin", 0),
    (NULL, "Kennedy Janto", 0),
    (NULL, "Duc Nguyen", 1),
    (NULL, "Taylor Vandenberg", 0),
    (NULL, "Alex Gomez", 0);

INSERT INTO employee_archv SELECT * FROM employee;

INSERT INTO shift VALUES
    (4, "2022-04-25", "08:30:02", "18:01:05", "12:00:38", "12:30:44"),
    (1, "2022-04-25", "09:00:00", "17:00:00", "12:00:00", "12:29:59"),
    (2, "2022-04-25", "09:00:23", "17:00:11", "12:00:15", "12:30:15"),
    (3, "2022-04-25", "11:00:10", "17:01:00", "12:00:45", "12:31:00"),
    (7, "2022-04-26", "08:28:10", "18:00:01", "12:00:04", "12:31:00"),
    (9, "2022-04-26", "08:59:50", "17:00:01", "12:01:09", "12:30:18"),
    (6, "2022-04-26", "09:00:10", "17:01:00", "11:59:57", "12:30:00"),
    (5, "2022-04-26", "09:00:15", "17:00:12", "12:00:24", "12:30:39"),
    (8, "2022-04-26", "09:00:51", "17:00:20", "12:00:42", "12:30:10");

INSERT INTO shift_archv SELECT * FROM shift;