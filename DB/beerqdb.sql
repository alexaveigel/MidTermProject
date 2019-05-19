-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema beerqdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `beerqdb` ;

-- -----------------------------------------------------
-- Schema beerqdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `beerqdb` DEFAULT CHARACTER SET utf8 ;
USE `beerqdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_name_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zip` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `latitude` VARCHAR(45) NULL,
  `longitude` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `drinker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `drinker` ;

CREATE TABLE IF NOT EXISTS `drinker` (
  `id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `gender` VARCHAR(45) NULL,
  `beer_style` VARCHAR(45) NULL,
  `pic_url` VARCHAR(500) NULL,
  `address_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_drinker_user1_idx` (`user_id` ASC),
  INDEX `fk_drinker_address_idx` (`address_id` ASC),
  CONSTRAINT `fk_drinker_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_drinker_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bar` ;

CREATE TABLE IF NOT EXISTS `bar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `message` VARCHAR(500) NULL,
  `address_id` INT NOT NULL,
  `website_url` VARCHAR(500) NULL,
  `logo_url` VARCHAR(500) NULL,
  PRIMARY KEY (`id`, `address_id`),
  INDEX `fk_bar_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_bar_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bar_owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bar_owner` ;

CREATE TABLE IF NOT EXISTS `bar_owner` (
  `id` INT NOT NULL,
  `bar_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  INDEX `fk_bar_owner_bar1_idx` (`bar_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_bar_owner_bar1`
    FOREIGN KEY (`bar_id`)
    REFERENCES `bar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bar_owner_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `brewery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `brewery` ;

CREATE TABLE IF NOT EXISTS `brewery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `logo_url` VARCHAR(500) NULL DEFAULT 'some default value',
  `address_id` INT NOT NULL,
  `website_url` VARCHAR(500) NULL,
  PRIMARY KEY (`id`, `address_id`),
  INDEX `fk_brewery_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_brewery_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `beer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `beer` ;

CREATE TABLE IF NOT EXISTS `beer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `style` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `abv` DOUBLE NOT NULL,
  `brewery_id` INT NOT NULL,
  `description` VARCHAR(300) NULL,
  `approved` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_beer_brewery1_idx` (`brewery_id` ASC),
  CONSTRAINT `fk_beer_brewery1`
    FOREIGN KEY (`brewery_id`)
    REFERENCES `brewery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorite_beer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorite_beer` ;

CREATE TABLE IF NOT EXISTS `favorite_beer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `drinker_id` INT NOT NULL,
  `beer_id` INT NOT NULL,
  `date_added` DATE NOT NULL,
  `comment` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_drinker_has_beer_beer1_idx` (`beer_id` ASC),
  INDEX `fk_drinker_has_beer_drinker1_idx` (`drinker_id` ASC),
  CONSTRAINT `fk_drinker_has_beer_drinker1`
    FOREIGN KEY (`drinker_id`)
    REFERENCES `drinker` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_drinker_has_beer_beer1`
    FOREIGN KEY (`beer_id`)
    REFERENCES `beer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorite_bar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorite_bar` ;

CREATE TABLE IF NOT EXISTS `favorite_bar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bar_id` INT NOT NULL,
  `drinker_id` INT NOT NULL,
  `date_added` DATE NOT NULL,
  `comment` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bar_has_drinker_drinker1_idx` (`drinker_id` ASC),
  INDEX `fk_bar_has_drinker_bar1_idx` (`bar_id` ASC),
  CONSTRAINT `fk_bar_has_drinker_bar1`
    FOREIGN KEY (`bar_id`)
    REFERENCES `bar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bar_has_drinker_drinker1`
    FOREIGN KEY (`drinker_id`)
    REFERENCES `drinker` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bar_inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bar_inventory` ;

CREATE TABLE IF NOT EXISTS `bar_inventory` (
  `bar_id` INT NOT NULL,
  `beer_id` INT NOT NULL,
  PRIMARY KEY (`bar_id`, `beer_id`),
  INDEX `fk_bar_has_beer_beer1_idx` (`beer_id` ASC),
  INDEX `fk_bar_has_beer_bar1_idx` (`bar_id` ASC),
  CONSTRAINT `fk_bar_has_beer_bar1`
    FOREIGN KEY (`bar_id`)
    REFERENCES `bar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bar_has_beer_beer1`
    FOREIGN KEY (`beer_id`)
    REFERENCES `beer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS drinker@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'drinker'@'localhost' IDENTIFIED BY 'drinker';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'drinker'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerqdb`;
INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES (1, 'user@user', 'pass', 'admin');
INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES (2, 'a@user', 'pass', 'user');
INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES (3, 'some@user', 'user', 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerqdb`;
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`, `country`, `latitude`, `longitude`) VALUES (1, '123 Test Street', 'Denver', 'Colorado', '80216', 'United States', '123.456', '654.321');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`, `country`, `latitude`, `longitude`) VALUES (2, '123 Fake Street', 'Denver', 'Colorado', '80216', 'United States', '123.456', '123.456');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`, `country`, `latitude`, `longitude`) VALUES (3, '111 not a street', 'Denver', 'Colorado', '80113', 'United States', '123.456', '123.456');

COMMIT;


-- -----------------------------------------------------
-- Data for table `drinker`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerqdb`;
INSERT INTO `drinker` (`id`, `user_id`, `first_name`, `last_name`, `date_of_birth`, `gender`, `beer_style`, `pic_url`, `address_id`) VALUES (1, 1, 'The', 'Drinker', '1995-01-30', 'Girl', 'IPA', 'pic.com', 1);
INSERT INTO `drinker` (`id`, `user_id`, `first_name`, `last_name`, `date_of_birth`, `gender`, `beer_style`, `pic_url`, `address_id`) VALUES (2, 2, 'A', 'Drinker', '1990-02-22', 'Boy', 'Pilsner', 'pic.com', 1);
INSERT INTO `drinker` (`id`, `user_id`, `first_name`, `last_name`, `date_of_birth`, `gender`, `beer_style`, `pic_url`, `address_id`) VALUES (3, 3, 'Bar', 'Owner', '1990-09-09', 'Girl', 'Stout', 'pic.com', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `bar`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerqdb`;
INSERT INTO `bar` (`id`, `name`, `message`, `address_id`, `website_url`, `logo_url`) VALUES (1, 'The Bar', 'a message', 1, 'url.com', 'logo.com');
INSERT INTO `bar` (`id`, `name`, `message`, `address_id`, `website_url`, `logo_url`) VALUES (2, 'Some Bar', 'no message', 2, 'url.com', 'logo.com');
INSERT INTO `bar` (`id`, `name`, `message`, `address_id`, `website_url`, `logo_url`) VALUES (3, 'Yarp Bar', 'offensive message', 3, 'url.com', 'logo.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `brewery`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerqdb`;
INSERT INTO `brewery` (`id`, `name`, `logo_url`, `address_id`, `website_url`) VALUES (1, 'The Brewery', 'logo.com', 1, 'web.com');
INSERT INTO `brewery` (`id`, `name`, `logo_url`, `address_id`, `website_url`) VALUES (2, 'A Brewery', 'logo.com', 2, 'web.com');
INSERT INTO `brewery` (`id`, `name`, `logo_url`, `address_id`, `website_url`) VALUES (3, 'HOLE', 'logo.com', 3, 'web.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `beer`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerqdb`;
INSERT INTO `beer` (`id`, `style`, `name`, `abv`, `brewery_id`, `description`, `approved`) VALUES (1, 'IPA', 'The Ipa', 7.8, 1, 'hopppy', 1);
INSERT INTO `beer` (`id`, `style`, `name`, `abv`, `brewery_id`, `description`, `approved`) VALUES (2, 'pilsner', 'the pilsner', 5, 2, 'not hoppy', 0);
INSERT INTO `beer` (`id`, `style`, `name`, `abv`, `brewery_id`, `description`, `approved`) VALUES (3, 'stout', 'the stout', 12.2, 1, 'thick', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `favorite_beer`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerqdb`;
INSERT INTO `favorite_beer` (`id`, `drinker_id`, `beer_id`, `date_added`, `comment`) VALUES (1, 1, 1, '2038-01-19', 'No comment');
INSERT INTO `favorite_beer` (`id`, `drinker_id`, `beer_id`, `date_added`, `comment`) VALUES (2, 1, 2, '2025-02-22', 'some comment');
INSERT INTO `favorite_beer` (`id`, `drinker_id`, `beer_id`, `date_added`, `comment`) VALUES (3, 2, 1, '2012-03-03', 'a comment');

COMMIT;


-- -----------------------------------------------------
-- Data for table `favorite_bar`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerqdb`;
INSERT INTO `favorite_bar` (`id`, `bar_id`, `drinker_id`, `date_added`, `comment`) VALUES (1, 1, 1, '2038-01-19', 'no comment');
INSERT INTO `favorite_bar` (`id`, `bar_id`, `drinker_id`, `date_added`, `comment`) VALUES (2, 2, 2, '2020-08-08', 'a comment');
INSERT INTO `favorite_bar` (`id`, `bar_id`, `drinker_id`, `date_added`, `comment`) VALUES (3, 2, 1, '2012-12-12', 'lots of comments');

COMMIT;


-- -----------------------------------------------------
-- Data for table `bar_inventory`
-- -----------------------------------------------------
START TRANSACTION;
USE `beerqdb`;
INSERT INTO `bar_inventory` (`bar_id`, `beer_id`) VALUES (1, 1);
INSERT INTO `bar_inventory` (`bar_id`, `beer_id`) VALUES (1, 2);
INSERT INTO `bar_inventory` (`bar_id`, `beer_id`) VALUES (1, 3);
INSERT INTO `bar_inventory` (`bar_id`, `beer_id`) VALUES (2, 1);
INSERT INTO `bar_inventory` (`bar_id`, `beer_id`) VALUES (2, 2);
INSERT INTO `bar_inventory` (`bar_id`, `beer_id`) VALUES (3, 3);

COMMIT;

