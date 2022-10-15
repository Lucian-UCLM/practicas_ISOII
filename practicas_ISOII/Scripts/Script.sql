SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Profesor` (
  `dni` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `doctor` BIT NOT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Centro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Centro` (
  `idCentro` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `localizacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCentro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ProfesorUCLM`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ProfesorUCLM` (
  `Profesor_dni` VARCHAR(45) NOT NULL,
  `centroAdscripcion` INT NOT NULL,
  `categoria` INT NOT NULL,
  PRIMARY KEY (`Profesor_dni`),
  INDEX `fk_ProfesorUCLM_Centro1_idx` (`centroAdscripcion` ASC) VISIBLE,
  CONSTRAINT `fk_ProfesorUCLM_Profesor1`
    FOREIGN KEY (`Profesor_dni`)
    REFERENCES `mydb`.`Profesor` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProfesorUCLM_Centro1`
    FOREIGN KEY (`centroAdscripcion`)
    REFERENCES `mydb`.`Centro` (`idCentro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CursoPropio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CursoPropio` (
  `idCursoPropio` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `ECTS` INT NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NOT NULL,
  `tasaMatricula` DOUBLE NOT NULL,
  `edicion` INT NOT NULL,
  `estado` INT NOT NULL,
  `tipo` INT NOT NULL,
  `director` VARCHAR(45) NOT NULL,
  `secretario` VARCHAR(45) NOT NULL,
  `centro` INT NOT NULL,
  PRIMARY KEY (`idCursoPropio`),
  INDEX `fk_CursoPropio_ProfesorUCLM1_idx` (`director` ASC) VISIBLE,
  INDEX `fk_CursoPropio_ProfesorUCLM2_idx` (`secretario` ASC) VISIBLE,
  INDEX `fk_CursoPropio_Centro1_idx` (`centro` ASC) VISIBLE,
  CONSTRAINT `fk_CursoPropio_ProfesorUCLM1`
    FOREIGN KEY (`director`)
    REFERENCES `mydb`.`ProfesorUCLM` (`Profesor_dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CursoPropio_ProfesorUCLM2`
    FOREIGN KEY (`secretario`)
    REFERENCES `mydb`.`ProfesorUCLM` (`Profesor_dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CursoPropio_Centro1`
    FOREIGN KEY (`centro`)
    REFERENCES `mydb`.`Centro` (`idCentro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estudiante` (
  `dni` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `titulacion` VARCHAR(45) NOT NULL,
  `cualificacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Matricula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Matricula` (
  `idMatricula` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `pagado` BIT NOT NULL,
  `tipoPago` INT NOT NULL,
  `estudiante` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMatricula`),
  INDEX `fk_Matricula_Estudiante1_idx` (`estudiante` ASC) VISIBLE,
  INDEX `fk_Matricula_CursoPropio1_idx` (`titulo` ASC) VISIBLE,
  CONSTRAINT `fk_Matricula_Estudiante1`
    FOREIGN KEY (`estudiante`)
    REFERENCES `mydb`.`Estudiante` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matricula_CursoPropio1`
    FOREIGN KEY (`titulo`)
    REFERENCES `mydb`.`CursoPropio` (`idCursoPropio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Materia` (
  `nombre` VARCHAR(45) NOT NULL,
  `horas` DOUBLE NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NOT NULL,
  `responsable` VARCHAR(45) NOT NULL,
  `curso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nombre`),
  INDEX `fk_Materia_Profesor_idx` (`responsable` ASC) VISIBLE,
  INDEX `fk_Materia_CursoPropio1_idx` (`curso` ASC) VISIBLE,
  CONSTRAINT `fk_Materia_Profesor`
    FOREIGN KEY (`responsable`)
    REFERENCES `mydb`.`Profesor` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Materia_CursoPropio1`
    FOREIGN KEY (`curso`)
    REFERENCES `mydb`.`CursoPropio` (`idCursoPropio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ProfesorExterno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ProfesorExterno` (
  `Profesor_dni` VARCHAR(45) NOT NULL,
  `titulacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Profesor_dni`),
  CONSTRAINT `fk_ProfesorExterno_Profesor1`
    FOREIGN KEY (`Profesor_dni`)
    REFERENCES `mydb`.`Profesor` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
