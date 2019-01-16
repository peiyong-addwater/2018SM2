-- INFO90002 Assignment 2, 2018 sem2, setup script

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- uncomment and run these 3 SCHEMA commands if you are using your own server
-- -----------------------------------------------------
-- DROP SCHEMA IF EXISTS `GroupCalendar` ;
-- CREATE SCHEMA IF NOT EXISTS `GroupCalendar` DEFAULT CHARACTER SET utf8 ;
-- USE `GroupCalendar` ;

-- -----------------------------------------------------
-- Table `Student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Student` ;

CREATE TABLE IF NOT EXISTS `Student` (
  `id` MEDIUMINT UNSIGNED NOT NULL,
  `givenName` VARCHAR(50) NOT NULL,
  `familyName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Groups` ;

CREATE TABLE IF NOT EXISTS `Groups` (
  `id` SMALLINT UNSIGNED NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentInGroup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `StudentInGroup` ;

CREATE TABLE IF NOT EXISTS `StudentInGroup` (
  `StudentId` MEDIUMINT UNSIGNED NOT NULL,
  `groupId` SMALLINT UNSIGNED NOT NULL,
  `whenJoined` TIMESTAMP NOT NULL,
  PRIMARY KEY (`StudentId`, `groupId`),
  INDEX `fk_StudentInGroup_Group1_idx` (`groupId` ASC),
  CONSTRAINT `fk_StudentInGroup_Student1`
    FOREIGN KEY (`StudentId`)
    REFERENCES `Student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_StudentInGroup_Group1`
    FOREIGN KEY (`groupId`)
    REFERENCES `Groups` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Calendar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Calendar` ;

CREATE TABLE IF NOT EXISTS `Calendar` (
  `day` ENUM('Mon', 'Tue', 'Wed', 'Thu', 'Fri') NOT NULL,
  `hour` TINYINT UNSIGNED NOT NULL,
  `description` CHAR(10) NULL,
  PRIMARY KEY (`day`, `hour`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Availability`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Availability` ;

CREATE TABLE IF NOT EXISTS `Availability` (
  `Student` MEDIUMINT UNSIGNED NOT NULL,
  `day` ENUM('Mon', 'Tue', 'Wed', 'Thu', 'Fri') NOT NULL,
  `hour` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`Student`, `day`, `hour`),
  INDEX `fk_Availability_Calendar1_idx` (`day` ASC, `hour` ASC),
  CONSTRAINT `fk_Availability_Student1`
    FOREIGN KEY (`Student`)
    REFERENCES `Student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Availability_Calendar1`
    FOREIGN KEY (`day` , `hour`)
    REFERENCES `Calendar` (`day` , `hour`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO Student VALUES(10001,'Alice','Smith');
INSERT INTO Student VALUES(10002,'Bob','Singh');
INSERT INTO Student VALUES(10003,'Charlie','Nguyen');
INSERT INTO Student VALUES(10004,'Dan','Williams');
INSERT INTO Student VALUES(10005,'Eve','Brown');
INSERT INTO Student VALUES(10006,'Frank','Jones');
INSERT INTO Student VALUES(10007,'Grace','Wilson');
INSERT INTO Student VALUES(10008,'Heidi','Taylor');
INSERT INTO Student VALUES(10009,'Ian','Lee');
INSERT INTO Student VALUES(10010,'Judy','Tran');
INSERT INTO Student VALUES(10011,'Kath','Anderson');
INSERT INTO Student VALUES(10012,'Lee','Thomas');
INSERT INTO Student VALUES(10013,'Mallory','White');
INSERT INTO Student VALUES(10014,'Nick','Johnson');
INSERT INTO Student VALUES(10015,'Olivia','Martin');
INSERT INTO Student VALUES(10016,'Pat','Wang');
INSERT INTO Student VALUES(10017,'Quentin','Chen');
INSERT INTO Student VALUES(10018,'Robbie','Ryan');
INSERT INTO Student VALUES(10019,'Sam','Thompson');
INSERT INTO Student VALUES(10020,'Tracey','Young');

INSERT INTO Groups VALUES(1,'WeLoveDb');
INSERT INTO Groups VALUES(2,'WeHateDb');
INSERT INTO Groups VALUES(3,'Three');
INSERT INTO Groups VALUES(4,'TooBig');
INSERT INTO Groups VALUES(5,'TooSmall');

INSERT INTO Calendar VALUES('Mon',9,'');
INSERT INTO Calendar VALUES('Mon',10,'');
INSERT INTO Calendar VALUES('Mon',11,'');
INSERT INTO Calendar VALUES('Mon',12,'');
INSERT INTO Calendar VALUES('Mon',13,'lunch');
INSERT INTO Calendar VALUES('Mon',14,'');
INSERT INTO Calendar VALUES('Mon',15,'');
INSERT INTO Calendar VALUES('Mon',16,'');
INSERT INTO Calendar VALUES('Tue',9,'');
INSERT INTO Calendar VALUES('Tue',10,'');
INSERT INTO Calendar VALUES('Tue',11,'');
INSERT INTO Calendar VALUES('Tue',12,'');
INSERT INTO Calendar VALUES('Tue',13,'lunch');
INSERT INTO Calendar VALUES('Tue',14,'');
INSERT INTO Calendar VALUES('Tue',15,'');
INSERT INTO Calendar VALUES('Tue',16,'');
INSERT INTO Calendar VALUES('Wed',9,'');
INSERT INTO Calendar VALUES('Wed',10,'');
INSERT INTO Calendar VALUES('Wed',11,'');
INSERT INTO Calendar VALUES('Wed',12,'');
INSERT INTO Calendar VALUES('Wed',13,'lunch');
INSERT INTO Calendar VALUES('Wed',14,'');
INSERT INTO Calendar VALUES('Wed',15,'');
INSERT INTO Calendar VALUES('Wed',16,'');
INSERT INTO Calendar VALUES('Thu',9,'');
INSERT INTO Calendar VALUES('Thu',10,'');
INSERT INTO Calendar VALUES('Thu',11,'');
INSERT INTO Calendar VALUES('Thu',12,'');
INSERT INTO Calendar VALUES('Thu',13,'lunch');
INSERT INTO Calendar VALUES('Thu',14,'');
INSERT INTO Calendar VALUES('Thu',15,'');
INSERT INTO Calendar VALUES('Thu',16,'lecture');
INSERT INTO Calendar VALUES('Fri',9,'');
INSERT INTO Calendar VALUES('Fri',10,'');
INSERT INTO Calendar VALUES('Fri',11,'');
INSERT INTO Calendar VALUES('Fri',12,'lunch');
INSERT INTO Calendar VALUES('Fri',13,'lunch');
INSERT INTO Calendar VALUES('Fri',14,'');
INSERT INTO Calendar VALUES('Fri',15,'');
INSERT INTO Calendar VALUES('Fri',16,'');

INSERT INTO StudentInGroup VALUES(10001,1,'2018-08-1 01-01-01');
INSERT INTO StudentInGroup VALUES(10002,1,'2018-08-2 02-02-02');
INSERT INTO StudentInGroup VALUES(10003,1,'2018-08-3 03-03-03');
INSERT INTO StudentInGroup VALUES(10004,2,'2018-08-4 04-04-04');
INSERT INTO StudentInGroup VALUES(10005,2,'2018-08-5 05-05-05');
INSERT INTO StudentInGroup VALUES(10006,2,'2018-08-6 06-06-06');
INSERT INTO StudentInGroup VALUES(10007,3,'2018-08-7 07-07-07');
INSERT INTO StudentInGroup VALUES(10008,3,'2018-08-8 08-08-08');
INSERT INTO StudentInGroup VALUES(10009,3,'2018-08-9 09-09-09');
INSERT INTO StudentInGroup VALUES(10010,4,'2018-08-10 10-10-10');
INSERT INTO StudentInGroup VALUES(10011,4,'2018-08-11 11-11-11');
INSERT INTO StudentInGroup VALUES(10012,4,'2018-08-12 12-12-12');
INSERT INTO StudentInGroup VALUES(10013,4,'2018-08-13 13-13-13');
INSERT INTO StudentInGroup VALUES(10014,5,'2018-08-14 14-14-14');
INSERT INTO StudentInGroup VALUES(10015,5,'2018-08-15 15-15-15');

INSERT INTO Availability VALUES(10001,'Wed',10);
INSERT INTO Availability VALUES(10002,'Wed',10);
INSERT INTO Availability VALUES(10002,'Wed',11);
INSERT INTO Availability VALUES(10003,'Wed',10);
INSERT INTO Availability VALUES(10003,'Wed',11);
INSERT INTO Availability VALUES(10003,'Wed',13);