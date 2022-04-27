-- Since primary key empID is auto incremented, NULL used in insert
INSERT INTO employee VALUES
    (NULL, "John Doe", 0),
    (NULL, "Some Guy", 0),
    (NULL, "Lena Raine", 0),
    (NULL, "Joe Zeke", 1);

INSERT INTO employee_archv SELECT * FROM employee;