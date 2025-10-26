/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 8.0.18 : Database - projekat_programiranje_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`projekat_programiranje_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `projekat_programiranje_db`;

/*Table structure for table `iznajmljivanje` */

DROP TABLE IF EXISTS `iznajmljivanje`;

CREATE TABLE `iznajmljivanje` (
  `idIznajmljivanje` bigint(30) NOT NULL AUTO_INCREMENT,
  `idZaposlenog` bigint(30) NOT NULL,
  `idPoslovnogPartnera` bigint(30) NOT NULL,
  `cena` bigint(30) NOT NULL,
  PRIMARY KEY (`idIznajmljivanje`),
  KEY `idZaposlenog` (`idZaposlenog`),
  KEY `idPoslovnogPartnera` (`idPoslovnogPartnera`),
  CONSTRAINT `iznajmljivanje_ibfk_1` FOREIGN KEY (`idZaposlenog`) REFERENCES `zaposleni` (`idZaposlenog`),
  CONSTRAINT `iznajmljivanje_ibfk_2` FOREIGN KEY (`idPoslovnogPartnera`) REFERENCES `poslovnipartner` (`idPoslovniPartner`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `iznajmljivanje` */

insert  into `iznajmljivanje`(`idIznajmljivanje`,`idZaposlenog`,`idPoslovnogPartnera`,`cena`) values 
(21,1,3,16000),
(22,1,2,17000),
(23,1,3,14000),
(24,1,2,0);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `idMesta` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idMesta`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `mesto` */

insert  into `mesto`(`idMesta`,`naziv`) values 
(8,'Pancevo'),
(11,'Bg'),
(12,'nis');

/*Table structure for table `poslovnipartner` */

DROP TABLE IF EXISTS `poslovnipartner`;

CREATE TABLE `poslovnipartner` (
  `idPoslovniPartner` bigint(30) NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `idMesta` bigint(30) NOT NULL,
  PRIMARY KEY (`idPoslovniPartner`),
  KEY `idMesto` (`idMesta`),
  CONSTRAINT `poslovnipartner_ibfk_2` FOREIGN KEY (`idMesta`) REFERENCES `mesto` (`idMesta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `poslovnipartner` */

insert  into `poslovnipartner`(`idPoslovniPartner`,`ime`,`prezime`,`idMesta`) values 
(2,'a','a',11),
(3,'Veljko','Cukanic',8);

/*Table structure for table `stavkaiznajmljivanja` */

DROP TABLE IF EXISTS `stavkaiznajmljivanja`;

CREATE TABLE `stavkaiznajmljivanja` (
  `idStavke` bigint(30) NOT NULL AUTO_INCREMENT,
  `idTrotineta` bigint(30) NOT NULL,
  `idIznajmljivanje` bigint(30) NOT NULL,
  `brojSati` bigint(20) NOT NULL,
  `cenaPoSatu` bigint(30) DEFAULT NULL,
  PRIMARY KEY (`idStavke`),
  KEY `idTrotineta` (`idTrotineta`),
  KEY `idIznajmljivanja` (`idIznajmljivanje`),
  CONSTRAINT `stavkaiznajmljivanja_ibfk_1` FOREIGN KEY (`idTrotineta`) REFERENCES `trotinet` (`idTrotineta`),
  CONSTRAINT `stavkaiznajmljivanja_ibfk_2` FOREIGN KEY (`idIznajmljivanje`) REFERENCES `iznajmljivanje` (`idIznajmljivanje`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `stavkaiznajmljivanja` */

insert  into `stavkaiznajmljivanja`(`idStavke`,`idTrotineta`,`idIznajmljivanje`,`brojSati`,`cenaPoSatu`) values 
(21,1,21,6,2000),
(22,1,22,6,2000),
(24,1,22,5,1000),
(25,1,21,2,2000),
(27,1,23,5,2000),
(28,1,23,2,2000);

/*Table structure for table `termindezurstva` */

DROP TABLE IF EXISTS `termindezurstva`;

CREATE TABLE `termindezurstva` (
  `idTerminDezurstva` bigint(20) NOT NULL AUTO_INCREMENT,
  `pocetak` time NOT NULL,
  `kraj` time NOT NULL,
  `trajanje` bigint(20) NOT NULL,
  PRIMARY KEY (`idTerminDezurstva`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `termindezurstva` */

insert  into `termindezurstva`(`idTerminDezurstva`,`pocetak`,`kraj`,`trajanje`) values 
(2,'13:00:00','15:00:00',120),
(3,'06:00:00','07:00:00',60);

/*Table structure for table `trotinet` */

DROP TABLE IF EXISTS `trotinet`;

CREATE TABLE `trotinet` (
  `idTrotineta` bigint(30) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  `cenaPoSatu` bigint(30) NOT NULL,
  PRIMARY KEY (`idTrotineta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `trotinet` */

insert  into `trotinet`(`idTrotineta`,`naziv`,`cenaPoSatu`) values 
(1,'CT',2000);

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `idZaposlenog` bigint(20) NOT NULL AUTO_INCREMENT,
  `imeZaposlenog` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prezimeZaposlenog` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `lozinka` varchar(30) NOT NULL,
  PRIMARY KEY (`idZaposlenog`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`idZaposlenog`,`imeZaposlenog`,`prezimeZaposlenog`,`email`,`lozinka`) values 
(1,'Veljko','Cukanic','veljkocukanic@gmail.com','Veljko');

/*Table structure for table `zaposleni-termin` */

DROP TABLE IF EXISTS `zaposleni-termin`;

CREATE TABLE `zaposleni-termin` (
  `datumTermina` date NOT NULL,
  `idTerminDezurstva` bigint(20) NOT NULL,
  `idZaposlenog` bigint(20) NOT NULL,
  PRIMARY KEY (`datumTermina`,`idTerminDezurstva`,`idZaposlenog`),
  KEY `idZaposlenog` (`idZaposlenog`),
  KEY `idTerminDežurstva` (`idTerminDezurstva`),
  CONSTRAINT `zaposleni-termin_ibfk_2` FOREIGN KEY (`idZaposlenog`) REFERENCES `zaposleni` (`idZaposlenog`),
  CONSTRAINT `zaposleni-termin_ibfk_3` FOREIGN KEY (`idTerminDezurstva`) REFERENCES `termindezurstva` (`idTerminDezurstva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `zaposleni-termin` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
