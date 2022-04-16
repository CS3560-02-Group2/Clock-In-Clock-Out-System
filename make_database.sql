CREATE TABLE employee (
    empID INT PRIMARY KEY,
    name VARCHAR(40),
    emailAddress VARCHAR(40),
    address VARCHAR(40),
    phoneNumber INT,
    position TINYINT
);

CREATE TABLE timeLog (
    logID INT PRIMARY KEY,
    empID INT,
    date DATE,
    timeClockedIn DATETIME,
    timeClockedOut DATETIME,
    breakStart DATETIME,
    breakEnd DATETIME,
    FOREIGN KEY(empID) REFERENCES employee(empID) ON DELETE SET NULL
);
