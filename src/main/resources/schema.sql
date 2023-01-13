DROP TABLE IF EXISTS STUDENT;
CREATE TABLE STUDENT
(
    roll_no              INT NOT NULL,
    student_name         VARCHAR(400) NULL,
    allocated_college    VARCHAR(400) NULL,
    allocated_department VARCHAR(400) NULL,
    is_available         boolean NULL,
    CONSTRAINT STUDENT_pk PRIMARY KEY (roll_no)
);
DROP TABLE IF EXISTS DEPARTMENT;
CREATE TABLE DEPARTMENT
(
    department_id   INT     NOT NULL,
    department_name VARCHAR(400) NULL,
    vacancy         int     NOT NULL,
    college_id      INTEGER NOT NULL
);
DROP TABLE IF EXISTS COLLEGE;
CREATE TABLE COLLEGE
(
    college_id   INT NOT NULL,
    college_name VARCHAR(400) NULL,
    location     VARCHAR(400) NULL,
    CONSTRAINT COLLEGE_pk PRIMARY KEY (college_id)
);

