Insert into DEPARTMENT(department_id, department_name, vacancy, college_id)
VALUES (1, 'Computer science', 5, 1),
       (2, 'Information technology', 5, 1),
       (3, 'Biotechnology', 5, 2),
       (4, 'Electrical Engineering', 5, 2),
       (5, 'Civil Engineering', 0, 3),
       (6, 'Mechanical Enineering', 5, 3);

INSERT INTO COLLEGE(college_id, college_name, location)
VALUES (1, 'Anna university', 'coimbatore'),
       (2, 'SRM university', 'pondicherry'),
       (3, 'Madras university', 'chennai');

INSERT INTO STUDENT (roll_no, student_name, allocated_college, allocated_department, is_available)
VALUES (1, 'Ram', 'Anna university', 'computer science', false);

INSERT INTO STUDENT(roll_no, student_name, is_available)
values (2, 'Roja', true),
       (3, 'Malli', true),
       (4, 'Priya', true);