DROP DATABASE IF EXISTS `SaturnDB`;
CREATE DATABASE `SaturnDB`;

USE `SaturnDB`;

CREATE TABLE Career (
    University  char(255)   NOT NULL,
    CareerName  char(255)   NOT NULL,
    Plan        char(255)   NOT NULL,
    PRIMARY KEY(CareerName, Plan)
);

CREATE TABLE Users (
    UserId      int         NOT NULL AUTO_INCREMENT,
    UserType    tinyint     NOT NULL,
    UserName    char(255)   NOT NULL,
    Password    char(64)    NOT NULL,
    Name        char(255)   NOT NULL,
    LastName    char(255)   NOT NULL,
    University  char(255)   NOT NULL,
    CareerName  char(255)   NOT NULL,
    Plan        char(255)   NOT NULL,
    PRIMARY KEY (UserId),
    FOREIGN KEY (CareerName, Plan)
        REFERENCES Career(CareerName, Plan)
);

CREATE TABLE Course (
    CourseId    int         NOT NULL AUTO_INCREMENT,
    CourseCode  char(255)   NOT NULL,
    CourseName  char(255)   NOT NULL,
    Semester    int,
    CareerName  char(255)   NOT NULL,
    Plan        char(255)   NOT NULL,
    PRIMARY KEY(CourseId),
    FOREIGN KEY (CareerName, Plan)
        REFERENCES Career(CareerName, Plan)
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
        REFERENCES Course(CourseId)
);

CREATE TABLE Availability (
    ProfessorId int         NOT NULL,
    StartHour   tinyint     NOT NULL,
    EndHour     tinyint     NOT NULL,
    Day         tinyint     NOT NULL
);

CREATE TABLE Afinity (
    ProfessorId int         NOT NULL,
    CourseId    int         NOT NULL,
    Level       tinyint     NOT NULL
);

CREATE TABLE Classroom (
    ClassroomId int         NOT NULL,
    Capacity    int         NOT NULL,
    ClassroomType int       NOT NULL,
    PRIMARY KEY(ClassroomId)
);

CREATE TABLE Session (
    GroupId     int         NOT NULL,
    Hour        int         NOT NULL,
    Type        char(255)   NOT NULL,
    FOREIGN KEY (GroupId)
        REFERENCES Groups(GroupId)
);

CREATE TABLE Timetable (
    Day         tinyint     NOT NULL,
    StartHour   tinyint     NOT NULL,
    EndHour     tinyint     NOT NULL,
    GroupId     int         NOT NULL,
    ClassroomId int         NOT NULL,
    FOREIGN KEY (GroupId)
        REFERENCES Groups(GroupId),
    FOREIGN KEY (ClassroomId)
        REFERENCES Classroom(ClassroomId)
);