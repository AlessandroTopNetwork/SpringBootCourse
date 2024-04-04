-- drop user first if they exist
DROP USER IF EXISTS 'springstudents'@'localhost';

-- now create user with prop privileges
CREATE USER 'springstudents'@'localhost' IDENTIFIED BY 'springstudents';

GRANT ALL PRIVILEGES ON * . * TO 'springstudents'@'localhost';