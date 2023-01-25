-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `Scuba`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Scuba` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Scuba` (
  `licenseNumber` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `dateOfBirth` DATE NULL,
  PRIMARY KEY (`licenseNumber`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Free`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Free` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Free` (
  `licenseNumber` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `dateOfBirth` VARCHAR(45) NULL,
  PRIMARY KEY (`licenseNumber`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `DivingManager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DivingManager` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `DivingManager` (
  `idDivingManager` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDivingManager`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Diving`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Diving` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Diving` (
  `idDiving` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `divingManager` INT NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDiving`),
  INDEX `divingManager_idx` (`divingManager` ASC) VISIBLE,
  CONSTRAINT `divingManager`
    FOREIGN KEY (`divingManager`)
    REFERENCES `DivingManager` (`idDivingManager`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Course` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Course` (
  `idCourse` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `level` VARCHAR(45) NOT NULL,
  `activity` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCourse`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Booking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Booking` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Booking` (
  `idBooking` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `idScuba` INT NOT NULL,
  `idFree` INT NOT NULL,
  `idDiving` INT NOT NULL,
  `course` INT NOT NULL,
  PRIMARY KEY (`idBooking`),
  INDEX `idScuba_idx` (`idScuba` ASC) VISIBLE,
  INDEX `idFree_idx` (`idFree` ASC) VISIBLE,
  INDEX `idDiving_idx` (`idDiving` ASC) VISIBLE,
  INDEX `Course_B_idx` (`course` ASC) VISIBLE,
  CONSTRAINT `idScuba_B`
    FOREIGN KEY (`idScuba`)
    REFERENCES `Scuba` (`licenseNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idFree_B`
    FOREIGN KEY (`idFree`)
    REFERENCES `Free` (`licenseNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDiving_B`
    FOREIGN KEY (`idDiving`)
    REFERENCES `Diving` (`idDiving`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Course_B`
    FOREIGN KEY (`course`)
    REFERENCES `Course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Equipment` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Equipment` (
  `idEquipment` INT NOT NULL,
  `size` VARCHAR(45) NOT NULL,
  `availability` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`idEquipment`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Renatal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Renatal` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Renatal` (
  `idRenatal` INT NOT NULL AUTO_INCREMENT,
  `startingDate` DATE NOT NULL,
  `EndingDate` DATE NOT NULL,
  `idDiving` INT NOT NULL,
  `idScuba` INT NOT NULL,
  `type` INT NOT NULL,
  `prize` DOUBLE NOT NULL,
  PRIMARY KEY (`idRenatal`),
  INDEX `idDiving_R_idx` (`idDiving` ASC) VISIBLE,
  INDEX `idScuba_R_idx` (`idScuba` ASC) VISIBLE,
  INDEX `type_R_idx` (`type` ASC) VISIBLE,
  CONSTRAINT `idDiving_R`
    FOREIGN KEY (`idDiving`)
    REFERENCES `Diving` (`idDiving`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idScuba_R`
    FOREIGN KEY (`idScuba`)
    REFERENCES `Scuba` (`licenseNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `type_R`
    FOREIGN KEY (`type`)
    REFERENCES `Equipment` (`idEquipment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `LogBook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LogBook` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `LogBook` (
  `idLogBook` INT NOT NULL AUTO_INCREMENT,
  `Scuba` INT NOT NULL,
  `Free` INT NOT NULL,
  `DivingNumer` INT NOT NULL,
  `location` INT NOT NULL,
  `date` DATE NOT NULL,
  `ratingSite` INT NULL,
  `startTime` TIME NULL,
  `exitTime` TIME NULL,
  `maxDepth` INT NULL,
  `visibility (m)` INT NULL,
  `weight (kg)` INT NULL,
  `suit (mm)` INT NULL,
  `O2%` INT NULL,
  `saftyStopTime` TIME NULL,
  `notes` VARCHAR(200) NULL,
  PRIMARY KEY (`idLogBook`),
  INDEX `Scuba_L_idx` (`Scuba` ASC) VISIBLE,
  INDEX `Free_L_idx` (`Free` ASC) VISIBLE,
  CONSTRAINT `Scuba_L`
    FOREIGN KEY (`Scuba`)
    REFERENCES `Scuba` (`licenseNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Free_L`
    FOREIGN KEY (`Free`)
    REFERENCES `Free` (`licenseNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `User` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `User` (
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`email`, `password`))
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
