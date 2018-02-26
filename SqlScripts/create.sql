DROP DATABASE IF EXISTS `SaturnDB`;
CREATE DATABASE `SaturnDB`;

USE `SaturnDB`;

CREATE TABLE Plans (
    PlanId       int         NOT NULL AUTO_INCREMENT,
    PlanName     char(255)   NOT NULL,
    PRIMARY KEY(PlanId)
);

CREATE TABLE Careers (
    CareerId    int         NOT NULL AUTO_INCREMENT,
    University  char(255)   NOT NULL,
    CareerName  char(255)   NOT NULL,
    PRIMARY KEY(CareerId)
);

CREATE TABLE CareersPlans (
    CareerId    int         NOT NULL,
    PlanId      int         NOT NULL,
    FOREIGN KEY (CareerId)
        REFERENCES Careers(CareerId),
    FOREIGN KEY (PlanId)
        REFERENCES Plans(PlanId)
);

CREATE TABLE Users (
    UserId      int         NOT NULL AUTO_INCREMENT,
    UserType    tinyint     NOT NULL,
    UserName    char(255)   NOT NULL,
    Password    char(64)    NOT NULL,
    Name        char(255)   NOT NULL,
    LastName    char(255)   NOT NULL,
    CareerId    int         NOT NULL,
    PRIMARY KEY (UserId),
    FOREIGN KEY (CareerId)
        REFERENCES Careers(CareerId)
);

CREATE TABLE Courses (
    CourseId    int         NOT NULL AUTO_INCREMENT,
    CourseCode  char(255)   NOT NULL,
    CourseName  char(255)   NOT NULL,
    Semester    int,
    CareerId    int         NOT NULL,
    PRIMARY KEY(CourseId),
    FOREIGN KEY (CareerId)
        REFERENCES Careers(CareerId)
);

CREATE TABLE Groups (
    GroupId     int         NOT NULL AUTO_INCREMENT,
    Capacity    int         NOT NULL,
    CourseId    int         NOT NULL,
    ProfessorId int         NOT NULL,
    Period      tinyint     NOT NULL,
    GroupNumber int         NOT NULL,
    PRIMARY KEY (GroupId),
    FOREIGN KEY (ProfessorId)
        REFERENCES Users(UserId),
    FOREIGN KEY (CourseId)
        REFERENCES Courses(CourseId)
);

CREATE TABLE Availabilities (
    ProfessorId int         NOT NULL,
    StartHour   tinyint     NOT NULL,
    EndHour     tinyint     NOT NULL,
    Day         tinyint     NOT NULL,
    FOREIGN KEY (ProfessorId)
        REFERENCES Users(UserId)
);

CREATE TABLE Afinities (
    ProfessorId int         NOT NULL,
    CourseId    int         NOT NULL,
    Level       tinyint     NOT NULL,
    FOREIGN KEY (ProfessorId)
        REFERENCES Users(UserId),
    FOREIGN KEY (CourseId)
        REFERENCES Courses(CourseId)
);

CREATE TABLE Classrooms (
    ClassroomId   int       NOT NULL,
    Capacity      int       NOT NULL,
    ClassroomType int		NOT NULL,
    PRIMARY KEY(ClassroomId)
);

CREATE TABLE Sessions (
	SessionId	int			auto_increment NOT NULL,
    GroupId     int         NOT NULL,
    Hour        int         NOT NULL,
    Type        int		    NOT NULL,
    PRIMARY KEY(SessionId),
    FOREIGN KEY (GroupId)
        REFERENCES Groups(GroupId)
);

CREATE TABLE Timetables (
    Day         tinyint     NOT NULL,
    StartHour   tinyint     NOT NULL,
    EndHour     tinyint     NOT NULL,
    GroupId     int         NOT NULL,
    ClassroomId int         NOT NULL,
    TableVersion int		NOT NULL,
    ClassroomType int		NOT NULL,
    FOREIGN KEY (GroupId)
        REFERENCES Groups(GroupId),
    FOREIGN KEY (ClassroomId)
        REFERENCES Classrooms(ClassroomId)
);

Create table LeftSessions (
	GroupId int NOT NULL,
    TableVersion int NOT NULL,
	ClassRoomType int		NOT NULL
);

