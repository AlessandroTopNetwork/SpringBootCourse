-- create database
CREATE DATABASE IF NOT EXISTS `students_traker`;
USE `students_traker`;

--
-- Table structure for table 'students'
--

-- drop table if exists
DROP TABLE IF EXISTS `student`;

-- create table

CREATE TABLE `student` (
    `id` int NOT NULL auto_increment PRIMARY KEY,
    `first_name` VARCHAR(45) default NULL,
    `last_name` VARCHAR(45) default NULL,
    `email` VARCHAR(45) default NULL
);