CREATE TABLE employee (
    empID BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40),
    emailAddress VARCHAR(40),
    address VARCHAR(40),
    phoneNumber VARCHAR(10),
    position TINYINT
);

CREATE TABLE timeLog (
    logID BIGINT AUTO_INCREMENT PRIMARY KEY,
    empID BIGINT,
    date DATE,
    timeClockedIn DATETIME,
    timeClockedOut DATETIME,
    breakStart DATETIME,
    breakEnd DATETIME,
    FOREIGN KEY(empID) REFERENCES employee(empID) ON DELETE SET NULL
);
