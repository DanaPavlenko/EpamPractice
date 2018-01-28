-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema student
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema student
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `student` ;
-- -----------------------------------------------------
-- Schema family_tree
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema family_tree
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `family_tree` ;
USE `student` ;

-- -----------------------------------------------------
-- Table `student`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student`.`region` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `post_number` INT NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(27) NOT NULL,
  `region_id` INT,
  PRIMARY KEY (`id`),
  INDEX `fk_city_region1_idx` (`region_id` ASC),
  CONSTRAINT `fk_city_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `student`.`region` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student`.`school`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student`.`school` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(15) NULL,
  `principal` VARCHAR(40) NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_school_city1_idx` (`city_id` ASC),
  CONSTRAINT `fk_school_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `student`.`city` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student`.`group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_number` INT NOT NULL,
  `group_name` VARCHAR(10) NULL,
  `apply_year` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_ticket` VARCHAR(10) NOT NULL,
  `surname` VARCHAR(15) NOT NULL,
  `name` VARCHAR(10) NOT NULL,
  `father_name` VARCHAR(15) NOT NULL,
  `full_name` VARCHAR(45) GENERATED ALWAYS AS (CONCAT(surname+" "+name+" "+father_name)) VIRTUAL,
  `birth_date` DATE NOT NULL,
  `apply_date` DATE NOT NULL,
  `apply_age` INT GENERATED ALWAYS AS (year(apply_date) - year(birth_date)) VIRTUAL,
  `student_ticket_apply_year` VARCHAR(25) GENERATED ALWAYS AS (CONCAT(student_ticket,"-", year(birth_date))) VIRTUAL,
  `email` VARCHAR(27) NULL,
  `school_id` INT,
  `city_id` INT,
  `group_id` INT,
  PRIMARY KEY (`id`),
  INDEX `fk_student_school_idx` (`school_id` ASC),
  INDEX `fk_student_city1_idx` (`city_id` ASC),
  INDEX `fk_student_group1_idx` (`group_id` ASC),
  CONSTRAINT `fk_student_school`
    FOREIGN KEY (`school_id`)
    REFERENCES `student`.`school` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_student_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `student`.`city` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_student_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `student`.`group` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student`.`subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student`.`subject` (
  `id` INT NOT NULL,
  `name` VARCHAR(27) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student`.`student_has_subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student`.`student_has_subject` (
  `student_id` INT NOT NULL,
  `subject_id` INT NOT NULL,
  PRIMARY KEY (`student_id`, `subject_id`),
  INDEX `fk_student_has_subject_subject1_idx` (`subject_id` ASC),
  INDEX `fk_student_has_subject_student1_idx` (`student_id` ASC),
  CONSTRAINT `fk_student_has_subject_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student`.`student` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_student_has_subject_subject1`
    FOREIGN KEY (`subject_id`)
    REFERENCES `student`.`subject` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

USE `family_tree` ;

-- -----------------------------------------------------
-- Table `family_tree`.`gender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `family_tree`.`gender` (
  `id` INT NOT NULL,
  `gender` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `family_tree`.`family_companion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `family_tree`.`family_companion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NOT NULL,
  `surname` VARCHAR(20) NOT NULL,
  `birth_date` DATE NOT NULL,
  `death_date` DATE NULL,
  `birth_place` VARCHAR(45) NOT NULL,
  `death_place` VARCHAR(45) NULL,
  `marry_date` DATE NOT NULL,
  `full_description` VARCHAR(45) GENERATED ALWAYS AS (CONCAT(name," ",surname," народ.",dayofyear(birth_date)," дня ", year(birth_date)," року")) VIRTUAL,
  `gender_gender` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_family_companion_gender1_idx` (`gender_gender` ASC),
  CONSTRAINT `fk_family_companion_gender1`
    FOREIGN KEY (`gender_gender`)
    REFERENCES `family_tree`.`gender` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `family_tree`.`family_tree`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `family_tree`.`family_tree` (
  `id` INT NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  `surname` VARCHAR(20) NOT NULL,
  `full_name` VARCHAR(35) GENERATED ALWAYS AS (CONCAT(name," ",surname)) VIRTUAL,
  `birth_date` DATE NOT NULL,
  `death_date` DATE NULL,
  `birth_place` VARCHAR(45) NOT NULL,
  `death_place` VARCHAR(45) NULL,
  `credit_card_number` INT NULL,
  `family_companion_id` INT,
  `gender_gender` CHAR(1) NOT NULL,
  `family_tree_id` INT,
  PRIMARY KEY (`id`),
  INDEX `fk_family_tree_family_companion_idx` (`family_companion_id` ASC),
  INDEX `fk_family_tree_gender1_idx` (`gender_gender` ASC),
  INDEX `fk_family_tree_family_tree1_idx` (`family_tree_id` ASC),
  CONSTRAINT `fk_family_tree_family_companion`
    FOREIGN KEY (`family_companion_id`)
    REFERENCES `family_tree`.`family_companion` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_family_tree_gender1`
    FOREIGN KEY (`gender_gender`)
    REFERENCES `family_tree`.`gender` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_family_tree_family_tree1`
    FOREIGN KEY (`family_tree_id`)
    REFERENCES `family_tree`.`family_tree` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `family_tree`.`family_jewelry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `family_tree`.`family_jewelry` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` INT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `indicative_price` DECIMAL(10,2) NOT NULL,
  `min_price` DECIMAL(10,2) NULL,
  `max_price` DECIMAL(10,2) NULL,
  `coef` DECIMAL(10,2) GENERATED ALWAYS AS (SIN(min_price)+COS(max_price)) VIRTUAL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `family_tree`.`family_tree_has_family_jewelry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `family_tree`.`family_tree_has_family_jewelry` (
  `family_tree_id` INT NOT NULL,
  `family_jewelry_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`family_tree_id`, `family_jewelry_id`),
  INDEX `fk_family_tree_has_family_jewelry_family_jewelry1_idx` (`family_jewelry_id` ASC),
  INDEX `fk_family_tree_has_family_jewelry_family_tree1_idx` (`family_tree_id` ASC),
  CONSTRAINT `fk_family_tree_has_family_jewelry_family_tree1`
    FOREIGN KEY (`family_tree_id`)
    REFERENCES `family_tree`.`family_tree` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_family_tree_has_family_jewelry_family_jewelry1`
    FOREIGN KEY (`family_jewelry_id`)
    REFERENCES `family_tree`.`family_jewelry` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
