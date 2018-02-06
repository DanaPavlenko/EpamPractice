drop database student_db;

create database if not exists Student_DB;
use Student_DB;

CREATE TABLE Mentor (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar (50) NOT NULL 
);

CREATE TABLE Speciality (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar (30) NOT NULL 
);

CREATE TABLE Scholarship (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	type varchar (15) NOT NULL ,
	size int NOT NULL 
);

CREATE TABLE _Subject (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar (50) NOT NULL 
);

CREATE TABLE Control_type (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar (15) NOT NULL 
);

CREATE TABLE Semestr (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY 
);

CREATE TABLE Groups (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar (15) NULL 
);

CREATE TABLE Student(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    surname varchar (15) NOT NULL,
	name varchar (15) NOT NULL,
    birth_date DATE NOT NULL,
    apply_date DATE NOT NULL,
    address varchar (40) NULL,
    groups_id INT NOT NULL,
    scholarship_id INT NULL,
    speciality_id INT NOT NULL
    
);

CREATE TABLE Mentor_has_subject (
    mentor_id INT NOT NULL,
    subject_id INT NOT NULL,
PRIMARY KEY (mentor_id, subject_id)
);

CREATE TABLE Student_has_subject (
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    control_type_id INT NOT NULL,
    semestr_id INT NOT NULL,
    points_100 INT NOT NULL,
    points_5 INT GENERATED ALWAYS AS       (CASE   
                                            WHEN points_100 BETWEEN 88 AND 100 THEN 5
										    WHEN points_100 BETWEEN 71 AND 87 THEN 4
                                            WHEN points_100 BETWEEN 50 AND 70 THEN 3
                                            ELSE 2 END) VIRTUAL,
PRIMARY KEY (student_id, subject_id)
);

ALTER TABLE mentor_has_subject
ADD CONSTRAINT fk_mentor_has_subject_mentor
    FOREIGN KEY (mentor_id)
REFERENCES mentor(id),
 ADD CONSTRAINT fk_mentor_has_subject_subject
    FOREIGN KEY (subject_id)
    REFERENCES _subject (id);
 

ALTER TABLE student_has_subject
 ADD CONSTRAINT fk_student_has_subject_subject
    FOREIGN KEY (subject_id)
    REFERENCES _subject (id),
 ADD CONSTRAINT fk_student_has_subject_student
    FOREIGN KEY (student_id)
REFERENCES student(id),
   ADD CONSTRAINT fk_student_has_subject_control_type
    FOREIGN KEY (control_type_id)
REFERENCES control_type(id),
ADD CONSTRAINT fk_student_has_subject_semestr
    FOREIGN KEY (subject_id)
REFERENCES _subject(id);

ALTER TABLE student
 ADD CONSTRAINT fk_student_groups
    FOREIGN KEY (groups_id)
    REFERENCES groups (id),
 ADD CONSTRAINT fk_student_scholarship
    FOREIGN KEY (scholarship_id)
REFERENCES scholarship(id),
ADD CONSTRAINT fk_student_speciality
    FOREIGN KEY (speciality_id)
REFERENCES speciality(id);



#---Product------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
 insert into Control_type values(1, 'exam');
 insert into Control_type values(2,'credit');
 insert into Semestr (id) values(1), (2), (3), (4), (5), (6), (7), (8);
 insert into _Subject values (2, 'Physics'), (3, 'English'), (4, 'Programming'), (5, 'Computer systems'), (6, 'Crossplatform programming'), (7, 'Operation systems'), (8, 'Ecology'), (9, 'Economics');
 insert into Speciality values(1, 'Computer Engineering'), (2, 'Computer Science'), (3, 'Programming engineering'), (4, 'System engineering');
 insert into Scholarship values(1, 'usual', 1250);
 insert into Scholarship values(2, 'high', 1530);
 insert into Scholarship values(3, 'preferential', 1700);
 insert into Groups values (1, 'KI-43'), (2, 'KI-46'), (3, 'KI-41'), (4, 'PI-33'), (5, 'CS-50');
 insert into Mentor values(1, 'Melnyk Anatolii'), (2, 'Golembo Vadym'), (3, 'Paramud Yaroslav'), (4, 'Glukhov Valeriy'), (5, 'Dunets Roman'), (6, 'Kudriavtsev Oleksandr');
 insert into Student values(1, 'Yarchak', 'Taras', '1996-02-27', '2014-08-27', 'Shmal-Stotskogo', 3, NULL, 1);
 insert into Student values(2, 'Shmal', 'Taras', '1996-12-27', '2014-08-27', 'Sulymy', 2, NULL, 1);
 insert into Student values(3, 'Isholyk', 'Sergiy', '1996-05-20', '2014-08-23', 'Lukasha', 2, 1, 1);
 insert into Student values(4, 'Zhekokos', 'Kokos', '1996-11-03', '2014-08-29', 'Shevchenka', 1, 2, 4);
 insert into Student values(5, 'Huba', 'Yarina', '1995-10-07', '2013-08-29', 'Franka', 2, 3, 2);
 insert into Mentor_has_subject values (2, 3);
 insert into Mentor_has_subject values (6, 2);
 insert into Mentor_has_subject values (5, 9);
 insert into Mentor_has_subject values (2, 4);
 insert into Mentor_has_subject values (3, 5);
 insert into Mentor_has_subject values (1, 4);
 insert into Mentor_has_subject values (4, 2);
 insert into Student_has_subject (student_id, subject_id, control_type_id, semestr_id, points_100) values (1, 5, 1, 8, 34);
 insert into Student_has_subject (student_id, subject_id, control_type_id, semestr_id, points_100) values (2, 3, 2, 7, 56);
 insert into Student_has_subject (student_id, subject_id, control_type_id, semestr_id, points_100) values (3, 6, 2, 5, 80);
 insert into Student_has_subject (student_id, subject_id, control_type_id, semestr_id, points_100) values (4, 2, 1, 1, 72);
 insert into Student_has_subject (student_id, subject_id, control_type_id, semestr_id, points_100) values (5, 7, 2, 4, 93);

