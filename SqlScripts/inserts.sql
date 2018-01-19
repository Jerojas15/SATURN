INSERT INTO Plans (PlanName) VALUES ("410");
INSERT INTO Plans (PlanName) VALUES ("420");
INSERT INTO Plans (PlanName) VALUES ("430");
INSERT INTO Plans (PlanName) VALUES ("440");
INSERT INTO Plans (PlanName) VALUES ("450");

INSERT INTO Careers (University, CareerName) VALUES ("TEC", "Ing. Computación");
INSERT INTO Careers (University, CareerName) VALUES ("UCR", "Diseño Gráfico");
INSERT INTO Careers (University, CareerName) VALUES ("UNA", "Ing. Electrónica");
INSERT INTO Careers (University, CareerName) VALUES ("UNED", "Administración");
INSERT INTO Careers (University, CareerName) VALUES ("TEC", "Química");

INSERT INTO CareersPlans (CareerId, PlanId) VALUES (1, 1);
INSERT INTO CareersPlans (CareerId, PlanId) VALUES (2, 2);
INSERT INTO CareersPlans (CareerId, PlanId) VALUES (3, 3);
INSERT INTO CareersPlans (CareerId, PlanId) VALUES (4, 4);
INSERT INTO CareersPlans (CareerId, PlanId) VALUES (5, 5);

INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (0, "admin", "admin", "Julio", "Rojas",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (1, "asist", "asist", "Ingrid", "Amador",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (2, "coordX", "coord", "Aurelio", "Sanabria",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (2, "coordY", "coord", "Eddy", "Ramírez",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profA", "prof", "Diego", "Munguia",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profB", "prof", "Maria", "Cross",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profC", "prof", "Erick", "Chacón",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profD", "prof", "Kevin", "Moraga",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profE", "prof", "Roxana", "Reyes",1);

INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC7602", "Redes", 7, 1);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC7841", "Proyecto", 7, 1);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC6821", "Diseño", 5, 1);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC1802", "Intro", 1, 1);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC1803", "Taller", 1, 1);

INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 1, 1, 1, 20);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (30, 2, 2, 1, 20);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 3, 3, 1, 20);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (30, 4, 4, 1, 20);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 5, 5, 1, 20);

INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (1, 9, 18, 0);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (1, 9, 18, 1);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (2, 7, 12, 2);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (2, 7, 12, 3);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (3, 13, 20, 4);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (3, 13, 20, 5);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (4, 14, 17, 6);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (4, 14, 17, 0);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (5, 8, 17, 1);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (5, 8, 17, 2);

INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (1, 1, 1);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (1, 2, 5);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (2, 3, 3);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (2, 4, 5);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (3, 5, 2);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (3, 5, 4);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (4, 1, 4);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (4, 2, 5);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (5, 3, 1);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (5, 4, 4);

INSERT INTO Classrooms (ClassroomId, Capacity, ClassroomType) VALUES (01, 40, 1);
INSERT INTO Classrooms (ClassroomId, Capacity, ClassroomType) VALUES (02, 30, 2);
INSERT INTO Classrooms (ClassroomId, Capacity, ClassroomType) VALUES (03, 20, 1);
INSERT INTO Classrooms (ClassroomId, Capacity, ClassroomType) VALUES (04, 35, 2);
INSERT INTO Classrooms (ClassroomId, Capacity, ClassroomType) VALUES (05, 25, 1);

INSERT INTO Sessions (GroupId, Hour, Type) VALUES (1,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (1,3,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (2,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (2,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (3,1,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (3,4,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (4,5,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (5,3,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (5,2,1);

#INSERT INTO Timetables (Day, StartHour, EndHour, GroupId, ClassroomId) VALUES ();

SELECT * FROM Plans;
SELECT * FROM Careers;
SELECT * FROM CareersPlans;
SELECT * FROM Users;
SELECT * FROM Courses;
SELECT * FROM Groups;
SELECT * FROM Availabilities;
SELECT * FROM Afinities;
SELECT * FROM Classrooms;
SELECT * FROM Sessions;
