-- Creazione del database
CREATE DATABASE IF NOT EXISTS `students_traker`;

-- Utilizzo del database
USE `students_traker`;

-- Creazione della tabella "cliente"
CREATE TABLE IF NOT EXISTS `student` (
    `id_student` bigint AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(255),
    `cognome` VARCHAR(255),
    `email` VARCHAR(255)
);

-- Creazione della tabella "acquisto"
CREATE TABLE IF NOT EXISTS `course` (
    `id_course` bigint AUTO_INCREMENT PRIMARY KEY,
    `titolo` varchar(255),
    `insegnante_id` bigint

);

-- Creazione della tabella "course_student" tab di raccordo per relazione many-to-many
CREATE TABLE IF NOT EXISTS `course_student` (
    `course_id` bigint,
    `student_id` bigint,
    PRIMARY KEY(`course_id`, `student_id`),
    CONSTRAINT fk_course_05
    FOREIGN KEY (course_id) REFERENCES course(id_course),
    CONSTRAINT fk_student_05
    FOREIGN KEY (student_id) REFERENCES student(id_student)
);
