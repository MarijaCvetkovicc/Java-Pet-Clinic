/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.28-MariaDB : Database - veterinarskaordinacija
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`veterinarskaordinacija` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `veterinarskaordinacija`;

/*Table structure for table `dijagnoza` */

DROP TABLE IF EXISTS `dijagnoza`;

CREATE TABLE `dijagnoza` (
  `SifraDijagnoze` int(11) NOT NULL AUTO_INCREMENT,
  `NazivDijagnoze` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SifraDijagnoze`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `dijagnoza` */

insert  into `dijagnoza`(`SifraDijagnoze`,`NazivDijagnoze`) values 
(1,'stomacni virus'),
(2,'zdrav'),
(3,'prehlada'),
(4,'krpelj'),
(5,'trudnoca'),
(6,'paraziti'),
(7,'depresija'),
(8,'kozne bolesti');

/*Table structure for table `karton` */

DROP TABLE IF EXISTS `karton`;

CREATE TABLE `karton` (
  `SifraKartona` int(11) NOT NULL AUTO_INCREMENT,
  `BrPasosa` varchar(255) DEFAULT NULL,
  `ImePrezimeVlasnika` varchar(255) DEFAULT NULL,
  `ImePacijenta` varchar(255) DEFAULT NULL,
  `BrTelefonaVlasnika` varchar(255) DEFAULT NULL,
  `SifraVrste` int(11) NOT NULL,
  `SifraVeterinara` int(11) NOT NULL,
  PRIMARY KEY (`SifraKartona`),
  KEY `SifraVrste` (`SifraVrste`),
  KEY `SifraVeterinara` (`SifraVeterinara`),
  CONSTRAINT `karton_ibfk_1` FOREIGN KEY (`SifraVrste`) REFERENCES `vrstazivotinje` (`SifraVrste`),
  CONSTRAINT `karton_ibfk_2` FOREIGN KEY (`SifraVeterinara`) REFERENCES `veterinar` (`SifraVeterinara`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `karton` */

insert  into `karton`(`SifraKartona`,`BrPasosa`,`ImePrezimeVlasnika`,`ImePacijenta`,`BrTelefonaVlasnika`,`SifraVrste`,`SifraVeterinara`) values 
(1,'90123589','Nina Nikolic','Zoi','062548796',1,2),
(2,'91254698','Dragana Gagic','Luna','069852147',5,4),
(3,'80321456','Branko Brankic','Bendzi','065412398',2,2),
(4,'32589412','Sonja Markovic','Boki','064123987',3,3),
(11,'20152015','kaca Potic','Dubravka','062547891',1,2),
(14,'12305890','Dijana Lucic','Darko','063215478',5,2),
(17,'12358111','Lajla','Sara','063405405',2,2);

/*Table structure for table `pregled` */

DROP TABLE IF EXISTS `pregled`;

CREATE TABLE `pregled` (
  `SifraPregleda` int(11) NOT NULL AUTO_INCREMENT,
  `DatumPregleda` datetime NOT NULL,
  `SifraKartona` int(11) NOT NULL,
  `SifraDijagnoze` int(11) NOT NULL,
  PRIMARY KEY (`SifraPregleda`),
  KEY `SifraKartona` (`SifraKartona`),
  KEY `SifraDijagnoze` (`SifraDijagnoze`),
  CONSTRAINT `pregled_ibfk_1` FOREIGN KEY (`SifraKartona`) REFERENCES `karton` (`SifraKartona`),
  CONSTRAINT `pregled_ibfk_2` FOREIGN KEY (`SifraDijagnoze`) REFERENCES `dijagnoza` (`SifraDijagnoze`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `pregled` */

insert  into `pregled`(`SifraPregleda`,`DatumPregleda`,`SifraKartona`,`SifraDijagnoze`) values 
(1,'2019-06-20 10:00:00',2,1),
(2,'2019-07-03 17:15:00',3,1),
(3,'2019-09-06 13:00:00',4,6),
(4,'2019-08-12 11:00:00',1,5),
(5,'2019-08-13 00:00:00',3,6),
(6,'2019-09-17 09:59:37',1,4),
(7,'2019-09-10 23:26:52',14,8),
(9,'2019-09-10 23:43:26',14,1),
(10,'2019-09-11 17:06:47',14,1),
(11,'2019-09-18 02:11:00',1,1),
(12,'2019-09-17 00:48:54',11,3),
(13,'2019-09-17 01:54:00',11,1),
(18,'2019-09-17 00:31:00',1,3),
(19,'2019-09-18 06:23:17',3,1),
(20,'2019-09-04 08:59:00',1,1);

/*Table structure for table `stavkapregleda` */

DROP TABLE IF EXISTS `stavkapregleda`;

CREATE TABLE `stavkapregleda` (
  `SifraPregleda` int(11) NOT NULL,
  `RedniBroj` int(11) NOT NULL AUTO_INCREMENT,
  `Cena` double NOT NULL,
  `SifraUsluge` int(11) NOT NULL,
  PRIMARY KEY (`SifraPregleda`,`RedniBroj`),
  KEY `RedniBroj` (`RedniBroj`),
  KEY `SifraUsluge` (`SifraUsluge`),
  CONSTRAINT `stavkapregleda_ibfk_1` FOREIGN KEY (`SifraPregleda`) REFERENCES `pregled` (`SifraPregleda`),
  CONSTRAINT `stavkapregleda_ibfk_2` FOREIGN KEY (`SifraUsluge`) REFERENCES `vrstausluge` (`SifraUsluge`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `stavkapregleda` */

insert  into `stavkapregleda`(`SifraPregleda`,`RedniBroj`,`Cena`,`SifraUsluge`) values 
(1,1,1000,5),
(1,2,800,3),
(2,1,1000,5),
(3,1,2400,2),
(4,1,3000,6),
(4,2,300,3),
(5,1,2400,2),
(9,1,500,3),
(10,1,1000,1),
(11,1,100,1),
(11,2,3000,8),
(11,3,200,3),
(13,1,600,3),
(18,1,1000,5),
(18,2,5000,4),
(19,1,1000,3),
(19,2,2000,1),
(20,1,2000,2),
(20,2,2000,2);

/*Table structure for table `veterinar` */

DROP TABLE IF EXISTS `veterinar`;

CREATE TABLE `veterinar` (
  `BrLicence` varchar(255) DEFAULT NULL,
  `ImePrezimeVeterinara` varchar(255) DEFAULT NULL,
  `BrTelefona` varchar(255) DEFAULT NULL,
  `KorisnickoIme` varchar(255) DEFAULT NULL,
  `Lozinka` varchar(255) DEFAULT NULL,
  `SifraVeterinara` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`SifraVeterinara`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `veterinar` */

insert  into `veterinar`(`BrLicence`,`ImePrezimeVeterinara`,`BrTelefona`,`KorisnickoIme`,`Lozinka`,`SifraVeterinara`) values 
('B123456','Marija Cvetkovic','063405088','Cvetkovic','maja123',1),
('B111111','Luka Lukic','065222111','Lukic','luka123',2),
('B222222','Ana Maric','061225888','Maric','ana123',3),
('B333333','Tara Taric','064222111','Taric','tara123',4);

/*Table structure for table `vrstausluge` */

DROP TABLE IF EXISTS `vrstausluge`;

CREATE TABLE `vrstausluge` (
  `SifraUsluge` int(11) NOT NULL AUTO_INCREMENT,
  `NazivUsluge` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SifraUsluge`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `vrstausluge` */

insert  into `vrstausluge`(`SifraUsluge`,`NazivUsluge`) values 
(1,'Vakcina protiv besnila'),
(2,'Vakcina protiv zaraznih bolesti'),
(3,'Plan dijete'),
(4,'Internisticki pregled'),
(5,'Laboratorijska analiza'),
(6,'Ultrazvucna dijagnostika'),
(7,'Sterilizacija i Kastracija'),
(8,'Porodiljske intervencije');

/*Table structure for table `vrstazivotinje` */

DROP TABLE IF EXISTS `vrstazivotinje`;

CREATE TABLE `vrstazivotinje` (
  `SifraVrste` int(11) NOT NULL AUTO_INCREMENT,
  `NazivVrste` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SifraVrste`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `vrstazivotinje` */

insert  into `vrstazivotinje`(`SifraVrste`,`NazivVrste`) values 
(1,'Macka'),
(2,'Pas'),
(3,'Papagaj'),
(4,'Hrcak'),
(5,'Kornjaca'),
(6,'Guster'),
(7,'Svinja'),
(8,'Ovca'),
(9,'Konj');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
