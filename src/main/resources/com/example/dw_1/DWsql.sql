-- MySQL Script generated by MySQL Workbench
-- Wed Feb  1 10:08:49 2023
-- Model: New Model    Version: 1.0
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
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Scuba`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Scuba` (
  `licenseNumber` VARCHAR(9) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`licenseNumber`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Free`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Free` (
  `licenseNumber` VARCHAR(9) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`licenseNumber`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DivingManager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DivingManager` (
  `idDivingManager` VARCHAR(9) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDivingManager`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Diving`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Diving` (
  `idDiving` VARCHAR(4) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `divingManager` VARCHAR(9) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDiving`),
  CONSTRAINT `divingManager`
    FOREIGN KEY (`divingManager`)
    REFERENCES `mydb`.`DivingManager` (`idDivingManager`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Course` (
  `idCourse` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `level` VARCHAR(45) NOT NULL,
  `activity` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCourse`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Booking` (
  `idBooking` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `idScuba` VARCHAR(9) NOT NULL,
  `idFree` VARCHAR(9) NOT NULL,
  `idDiving` VARCHAR(4) NOT NULL,
  `course` INT NOT NULL,
  PRIMARY KEY (`idBooking`),
  CONSTRAINT `idScuba_B`
    FOREIGN KEY (`idScuba`)
    REFERENCES `mydb`.`Scuba` (`licenseNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idFree_B`
    FOREIGN KEY (`idFree`)
    REFERENCES `mydb`.`Free` (`licenseNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDiving_B`
    FOREIGN KEY (`idDiving`)
    REFERENCES `mydb`.`Diving` (`idDiving`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Course_B`
    FOREIGN KEY (`course`)
    REFERENCES `mydb`.`Course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Equipment` (
  `idEquipment` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `size` VARCHAR(45) NOT NULL,
  `availability` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `price` DOUBLE NOT NULL,
  `diving` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`idEquipment`),
  CONSTRAINT `diving`
    FOREIGN KEY (`diving`)
    REFERENCES `mydb`.`Diving` (`idDiving`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Renatal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Renatal` (
  `idRenatal` INT NOT NULL AUTO_INCREMENT,
  `idDiving` VARCHAR(4) NOT NULL,
  `idScuba` VARCHAR(9) NOT NULL,
  `idEquip` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`idRenatal`),
  CONSTRAINT `idDiving_R`
    FOREIGN KEY (`idDiving`)
    REFERENCES `mydb`.`Diving` (`idDiving`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idScuba_R`
    FOREIGN KEY (`idScuba`)
    REFERENCES `mydb`.`Scuba` (`licenseNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `type_R`
    FOREIGN KEY (`idEquip`)
    REFERENCES `mydb`.`Equipment` (`idEquipment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LogBook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LogBook` (
  `idLogBook` INT NOT NULL AUTO_INCREMENT,
  `Scuba` VARCHAR(9) NOT NULL,
  `Free` VARCHAR(9) NOT NULL,
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
  CONSTRAINT `Scuba_L`
    FOREIGN KEY (`Scuba`)
    REFERENCES `mydb`.`Scuba` (`licenseNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Free_L`
    FOREIGN KEY (`Free`)
    REFERENCES `mydb`.`Free` (`licenseNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`, `password`, `type`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
