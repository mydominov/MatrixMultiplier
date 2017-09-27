SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_list` (
  `user_id` INT NOT NULL,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`matrix`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`matrix` (
  `matrix_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `matrix_name` VARCHAR(45) NULL,
  `matrix_row` INT NULL,
  `matrix_column` INT NULL,
  PRIMARY KEY (`matrix_id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user_list` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`history` (
  `history_id` INT NOT NULL AUTO_INCREMENT,
  `matrix1_id` INT NULL,
  `matrix2_id` INT NULL,
  `matrix_result_id` INT NULL,
  `date` DATETIME NULL,
  PRIMARY KEY (`history_id`),
  INDEX `matrix1_id_idx` (`matrix1_id` ASC),
  INDEX `matrix2_id_idx` (`matrix2_id` ASC),
  INDEX `matrix_result_id_idx` (`matrix_result_id` ASC),
  CONSTRAINT `matrix1_id`
    FOREIGN KEY (`matrix1_id`)
    REFERENCES `mydb`.`matrix` (`matrix_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `matrix2_id`
    FOREIGN KEY (`matrix2_id`)
    REFERENCES `mydb`.`matrix` (`matrix_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `matrix_result_id`
    FOREIGN KEY (`matrix_result_id`)
    REFERENCES `mydb`.`matrix` (`matrix_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`elements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`elements` (
  `element_id` INT NOT NULL AUTO_INCREMENT,
  `row_id` INT NULL,
  `column_id` INT NULL,
  `value` INT NULL,
  `matrix_id` INT NULL,
  PRIMARY KEY (`element_id`),
  INDEX `matrix_id_idx` (`matrix_id` ASC),
  CONSTRAINT `matrix_id`
    FOREIGN KEY (`matrix_id`)
    REFERENCES `mydb`.`matrix` (`matrix_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `mydb`.`user_list` (`user_id`, `login`, `password`) VALUES ('1', 'Admin', 'admin');
INSERT INTO `mydb`.`user_list` (`user_id`, `login`, `password`) VALUES ('2', 'User', 'user');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
