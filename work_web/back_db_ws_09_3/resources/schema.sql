-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema daily9_3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema daily9_3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `daily9_3` DEFAULT CHARACTER SET utf8 ;
USE `daily9_3` ;

-- -----------------------------------------------------
-- Table `daily9_3`.`book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `daily9_3`.`book` ;

CREATE TABLE IF NOT EXISTS `daily9_3`.`book` (
  `isbn` INT NOT NULL,
  `author` VARCHAR(50) NULL,
  `title` VARCHAR(200) NOT NULL,
  `price` INT NOT NULL,
  `desc` VARCHAR(500) NULL,
  `img` VARCHAR(255) NULL,
  PRIMARY KEY (`isbn`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daily9_3`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `daily9_3`.`user` ;

CREATE TABLE IF NOT EXISTS `daily9_3`.`user` (
  `id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `pw` VARCHAR(50) NULL,
  `rec_id` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daily9_3`.`satisfaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `daily9_3`.`satisfaction` ;

CREATE TABLE IF NOT EXISTS `daily9_3`.`satisfaction` (
  `book_isbn` INT NOT NULL,
  `user_id` VARCHAR(50) NOT NULL,
  `rating` INT NULL DEFAULT 0,
  `comment` VARCHAR(500) NULL,
  PRIMARY KEY (`book_isbn`, `user_id`),
  INDEX `satisfaction_user_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `satisfaction_book_fk`
    FOREIGN KEY (`book_isbn`)
    REFERENCES `daily9_3`.`book` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `satisfaction_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `daily9_3`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
