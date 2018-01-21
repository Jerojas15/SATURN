INSERT INTO Plans (PlanName) VALUES ("410");
INSERT INTO Plans (PlanName) VALUES ("420");
INSERT INTO Careers (University, CareerName) VALUES ("TEC", "Ing. Computación");
INSERT INTO Careers (University, CareerName) VALUES ("UCR", "Diseño Gráfico");
INSERT INTO CareersPlans (CareerId, PlanId) VALUES (1, 1);
INSERT INTO CareersPlans (CareerId, PlanId) VALUES (2, 2);
INSERT INTO Users (UserType, UserName, Password, Name, LastName, CareerId) VALUES (3, "profATEC", "prof", "Diego", "Munguia",1);
INSERT INTO Courses (CourseCode, CourseName, Semester, CareerId) VALUES ("IC7602", "Redes", 7, 1);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (20, 1, 1, 1, 20);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (1,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (1,3,1);
INSERT INTO Groups (Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (25, 1, 1, 1, 20);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (2,2,1);
INSERT INTO Sessions (GroupId, Hour, Type) VALUES (2,2,1);








