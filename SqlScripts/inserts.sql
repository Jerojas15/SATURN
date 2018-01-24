use SaturnDB;
######CREACION DE CARRERAS###### LISTO
INSERT INTO Plans (PlanName) VALUES ("410");
INSERT INTO Plans (PlanName) VALUES ("420");
INSERT INTO Plans (PlanName) VALUES ("430");

INSERT INTO Careers (University, CareerName) VALUES ("TEC", "Ing. Computación");
INSERT INTO Careers (University, CareerName) VALUES ("UCR", "Diseño Gráfico");
INSERT INTO Careers (University, CareerName) VALUES ("UNA", "Ing. en Sistemas");

INSERT INTO CareersPlans (CareerId, PlanId) VALUES (1, 1);
INSERT INTO CareersPlans (CareerId, PlanId) VALUES (2, 2);
INSERT INTO CareersPlans (CareerId, PlanId) VALUES (3, 3);

#####CREACION DE USUARIOS##### LISTO
#ADMIN Y ASISTENTEs#
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (0, "admin", "admin", "Julio", "Rojas",1);

INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (1, "asistTEC", "asist", "Ingrid", "Amador",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (1, "asistUCR", "asist", "Maria(UCR)", "Lopez",2);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (1, "asistUNA", "asist", "Maria(UNA)", "Lopez",3);

#COORDINADORES#
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (2, "coordTEC", "coord", "Aurelio", "Sanabria",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (2, "coordUCR", "coord", "Eddy(UCR)", "Ramírez",2);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (2, "coordUNA", "coord", "Eddy(UNA)", "Ramírez",3);

#PROFESORES#
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profATEC", "prof", "Diego", "Munguia",1);#5
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profBTEC", "prof", "Maria", "Cross",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profCTEC", "prof", "Erick", "Chacón",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profDTEC", "prof", "Kevin", "Moraga",1);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profETEC", "prof", "Roxana", "Reyes",1);

INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profAUCR", "prof", "Diego(UCR)", "Munguia",2);#5
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profBUCR", "prof", "Maria(UCR)", "Cross",2);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profCUCR", "prof", "Erick(UCR)", "Chacón",2);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profDUCR", "prof", "Kevin(UCR)", "Moraga",2);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profEUCR", "prof", "Roxana(UCR)", "Reyes",2);

INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profAUNA", "prof", "Diego(UNA)", "Munguia",3);#5
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profBUNA", "prof", "Maria(UNA)", "Cross",3);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profCUNA", "prof", "Erick(UNA)", "Chacón",3);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profDUNA", "prof", "Kevin(UNA)", "Moraga",3);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profEUNA", "prof", "Roxana(UNA)", "Reyes",3);

#####CREACION DE CURSOS##### LISTO
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC7602", "Redes", 7, 1);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC7841", "Proyecto", 7, 1);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC6821", "Diseño", 5, 1);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC1802", "Intro", 1, 1);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC1803", "Taller", 1, 1);

INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("DG7602", "Dibujo I", 7, 2);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("DG7841", "Fotografia", 7, 2);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("DG6821", "Diseño de Personajes", 5, 2);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("DG1802", "Dibujo II", 1, 2);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("DG1803", "Dibujo III", 1, 2);

INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IS7602", "Redes", 7, 3);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IS7841", "Proyecto", 7, 3);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IS6821", "Diseño", 5, 3);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IS1802", "Intro", 1, 3);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IS1803", "Taller", 1, 3);

#####CREACION DE GRUPOS##### LISTO
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 1, 8, 1, 20);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (25, 2, 9, 1, 20);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 3, 10, 1, 20);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (25, 4, 11, 1, 20);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 5, 12, 1, 20);

INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 6, 13, 1, 4);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (25, 7, 14, 1, 4);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 8, 15, 1, 4);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (25, 9, 16, 1, 4);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 10, 17, 1, 4);

INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 11, 18, 1, 50);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (25, 12, 19, 1, 50);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 13, 20, 1, 50);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (25, 14, 21, 1, 50);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 15, 22, 1, 50);

#####CREACION DE DISPONIBILIDADES##### LISTO
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (8, 9, 18, 0);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (8, 9, 18, 1);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (9, 7, 12, 2);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (9, 7, 12, 2);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (10, 13, 20, 1);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (10, 13, 20, 5);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (11, 14, 17, 3);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (11, 14, 17, 0);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (12, 8, 17, 4);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (12, 8, 17, 5);

INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (13, 9, 18, 0);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (13, 9, 18, 1);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (14, 7, 12, 5);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (14, 7, 12, 2);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (15, 13, 20, 3);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (15, 13, 20, 4);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (16, 14, 17, 3);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (16, 14, 17, 0);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (17, 8, 17, 1);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (17, 8, 17, 2);

INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (18, 9, 18, 0);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (18, 9, 18, 1);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (19, 7, 12, 2);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (19, 7, 12, 5);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (20, 13, 20, 4);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (20, 13, 20, 3);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (21, 14, 17, 0);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (21, 14, 17, 3);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (22, 8, 17, 2);
INSERT INTO Availabilities (ProfessorId, StartHour, EndHour, Day) VALUES (22, 8, 17, 4);
#####CREACION DE AFINIDADES##### LISTO
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (8, 1, 1);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (8, 2, 5);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (9, 3, 3);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (9, 4, 5);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (10, 5, 2);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (10, 5, 4);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (11, 1, 4);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (12, 2, 5);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (13, 3, 1);
INSERT INTO Afinities (ProfessorId, CourseId, Level) VALUES (14, 4, 4);

#####CREACION DE AULAS ##### LISTO
INSERT INTO Classrooms (ClassroomId, Capacity, ClassroomType) VALUES (01, 40, 1);
INSERT INTO Classrooms (ClassroomId, Capacity, ClassroomType) VALUES (02, 30, 1);
INSERT INTO Classrooms (ClassroomId, Capacity, ClassroomType) VALUES (03, 20, 1);
INSERT INTO Classrooms (ClassroomId, Capacity, ClassroomType) VALUES (04, 35, 1);
INSERT INTO Classrooms (ClassroomId, Capacity, ClassroomType) VALUES (05, 25, 1);


#####CREACION DE SESIONES#####
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (1,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (1,3,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (2,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (2,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (3,1,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (3,4,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (4,5,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (5,3,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (5,2,1);

INSERT INTO Sessions (GroupId, Hour, Type) VALUES (6,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (6,3,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (7,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (7,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (8,1,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (8,4,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (9,5,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (9,3,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (10,3,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (10,3,1);

INSERT INTO Sessions (GroupId, Hour, Type) VALUES (11,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (11,3,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (12,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (12,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (13,1,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (13,4,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (14,5,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (14,3,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (15,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (15,3,1);

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
