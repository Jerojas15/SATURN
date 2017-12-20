DROP DATABASE IF EXISTS `SaturnDB`;
CREATE DATABASE `SaturnDB`;

USE `SaturnDB`;

CREATE TABLE User (
	UserId		int			NOT NULL AUTO_INCREMENT,
    UserType	tinyint		NOT NULL,
    UserName	char(255)	NOT NULL,
    Password 	char(64)	NOT NULL,
    Name		char(255)	NOT NULL,
    LastName 	char(255)	NOT NULL,
    
    PRIMARY KEY (UserId)
);

/*
CREATE TABLE Group (
	
);

CREATE TABLE Available (

);

CREATE TABLE Like (

);

CREATE TABLE Classroom (

);

CREATE TABLE Career (

);

CREATE TABLE Course (

);

CREATE TABLE Session (

);

CREATE TABLE Timetable (

);*/