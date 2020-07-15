/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 8.0.20 : Database - starzplay
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`starzplay` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `starzplay`;

/*Table structure for table `methodplans` */

DROP TABLE IF EXISTS `methodplans`;

CREATE TABLE `methodplans` (
  `id` int NOT NULL,
  `paymentmethodid` int NOT NULL,
  PRIMARY KEY (`id`,`paymentmethodid`),
  KEY `paymentmethodid` (`paymentmethodid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `methodplans` */

insert  into `methodplans`(`id`,`paymentmethodid`) values 
(1,3),
(54,4),
(72,4);

/*Table structure for table `paymentmethods` */

DROP TABLE IF EXISTS `paymentmethods`;

CREATE TABLE `paymentmethods` (
  `paymentmethodid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `displayName` varchar(50) DEFAULT NULL,
  `paymentType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`paymentmethodid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `paymentmethods` */

insert  into `paymentmethods`(`paymentmethodid`,`name`,`displayName`,`paymentType`) values 
(3,'credit card','credit card','CREDIT_CARD'),
(4,'alfa_lb','Alfa Lebanon','MOBILE_CARRIER'),
(5,'voucher','Voucher','VOUCHER');

/*Table structure for table `paymentplans` */

DROP TABLE IF EXISTS `paymentplans`;

CREATE TABLE `paymentplans` (
  `id` int NOT NULL,
  `netAmount` float DEFAULT '0',
  `taxAmount` float DEFAULT '0',
  `grossAmount` float DEFAULT '0',
  `currency` varchar(20) DEFAULT NULL,
  `duration` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `paymentplans` */

insert  into `paymentplans`(`id`,`netAmount`,`taxAmount`,`grossAmount`,`currency`,`duration`) values 
(1,5.99,0,5.99,'USD','Month'),
(54,10,0,10,'SAR','Week'),
(72,5.99,0,5.99,'USD','Month');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
