CREATE TABLE employee (
    empID BIGINT AUTO_INCREMENT PRIMARY KEY,
    fullName VARCHAR(40),
    position TINYINT
);

CREATE TABLE shift (
    empID BIGINT,
    date DATE,
    timeClockedIn TIME,
    timeClockedOut TIME,
    breakStart TIME,
    breakEnd TIME,
    FOREIGN KEY(empID) REFERENCES employee(empID) ON DELETE CASCADE,
    PRIMARY KEY(empID, date)
);

CREATE TABLE employee_archv (
    empID BIGINT PRIMARY KEY,
    fullName VARCHAR(40),
    position TINYINT
);

CREATE TABLE shift_archv (
    empID BIGINT,
    date DATE,
    timeClockedIn TIME,
    timeClockedOut TIME,
    breakStart TIME,
    breakEnd TIME,
    FOREIGN KEY(empID) REFERENCES employee_archv(empID) ON DELETE CASCADE,
    PRIMARY KEY(empID, date)
);