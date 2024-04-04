-- create database

CREATE DATABASE if not exists `employee_directory`;
use `employee_directory`;

-- table 
CREATE table `employee` (
    `id` int not null auto_increment,
    `first_name` VARCHAR(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null,
    primary key(`id`) 

) engine = InnoDB auto_increment=1 default charset=latin1;

-- insert data

INSERT INTO employee (first_name, last_name, email) VALUES ('John', 'Doe', 'john@doe.ud');
INSERT INTO employee (first_name, last_name, email) VALUES ('TEst', 'Two', 'TEst@Two.t');
INSERT INTO employee (first_name, last_name, email) VALUES ('Eddy', 'marphy', 'Eddy@murphy.m');