DROP DATABASE IF EXISTS cinemareservation_db;
DROP USER IF EXISTS 'cinemareservation'@'localhost';
CREATE USER 'cinemareservation'@'localhost' IDENTIFIED BY 'password';
CREATE DATABASE cinemareservation_db;
USE cinemareservation_db;
GRANT ALL PRIVILEGES ON cinemareservation_db.* TO 'cinemareservation'@'localhost';
