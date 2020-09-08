
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(300) NOT NULL,
  `CPF` CHAR(11) NOT NULL,
  `Sexo` CHAR(1) NOT NULL,
  `DataNascimento` VARCHAR(20) NOT NULL,
  `Voluntario` BOOLEAN NOT NULL,
  PRIMARY KEY (`idPessoa`));


CREATE TABLE IF NOT EXISTS `mydb`.`Instituicao` (
  `idInstituicao` INT NOT NULL,
  `País` VARCHAR(300) NOT NULL,
  `NomeVacina` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idInstituicao`));


CREATE TABLE IF NOT EXISTS `mydb`.`Vacina` (
  `idVacina` INT NOT NULL AUTO_INCREMENT,
  `EstagioPesquisa` CHAR(1) NOT NULL,
  `PaisOrigem` VARCHAR(100) NOT NULL,
  `NomePesquisador` VARCHAR(300) NOT NULL,
  `NomeVoluntario` VARCHAR(300) NOT NULL,
  `DataInicio` VARCHAR(20) NOT NULL,
  `Instituicao_idInstituicao` INT NOT NULL,
  PRIMARY KEY (`idVacina`, `Instituicao_idInstituicao`),
  INDEX `fk_Vacina_Instituicao1_idx` (`Instituicao_idInstituicao` ASC) VISIBLE,
  CONSTRAINT `fk_Vacina_Instituicao1`
    FOREIGN KEY (`Instituicao_idInstituicao`)
    REFERENCES `mydb`.`Instituicao` (`idInstituicao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `mydb`.`Pesquisador` (
  `idPesquisador` INT NOT NULL AUTO_INCREMENT,
  `Instituicao` VARCHAR(300) NOT NULL,
  `Nome` VARCHAR(300) NOT NULL,
  `CPF` CHAR(11) NOT NULL,
  `Sexo` CHAR(1) NOT NULL,
  `DataNascimento` VARCHAR(20) NOT NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  `Instituicao_idInstituicao` INT NOT NULL,
  PRIMARY KEY (`idPesquisador`, `Instituicao_idInstituicao`),
  INDEX `fk_Pesquisador_Pessoa_idx` (`Pessoa_idPessoa` ASC) VISIBLE,
  INDEX `fk_Pesquisador_Instituicao1_idx` (`Instituicao_idInstituicao` ASC) VISIBLE,
  CONSTRAINT `fk_Pesquisador_Pessoa`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `mydb`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pesquisador_Instituicao1`
    FOREIGN KEY (`Instituicao_idInstituicao`)
    REFERENCES `mydb`.`Instituicao` (`idInstituicao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `mydb`.`PessoaVacinada` (
  `Pessoa_idPessoa` INT NOT NULL,
  `Vacina_idVacina` INT NOT NULL,
  `Reacao` CHAR(1) NOT NULL,
  `DataVacinacao` DATE NOT NULL,
  PRIMARY KEY (`Pessoa_idPessoa`, `Vacina_idVacina`),
  INDEX `fk_Pessoa_has_Vacina_Vacina1_idx` (`Vacina_idVacina` ASC) VISIBLE,
  INDEX `fk_Pessoa_has_Vacina_Pessoa1_idx` (`Pessoa_idPessoa` ASC) VISIBLE,
  CONSTRAINT `fk_Pessoa_has_Vacina_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `mydb`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoa_has_Vacina_Vacina1`
    FOREIGN KEY (`Vacina_idVacina`)
    REFERENCES `mydb`.`Vacina` (`idVacina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


