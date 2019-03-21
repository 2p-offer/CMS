/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.40 : Database - CMS_WY
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `aly_biological` */

DROP TABLE IF EXISTS `aly_biological`;

CREATE TABLE `aly_biological` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wetlandplants` varchar(100) DEFAULT NULL,
  `phytoplankton` varchar(100) DEFAULT NULL,
  `zooplankton` varchar(100) DEFAULT NULL,
  `benthos` varchar(100) DEFAULT NULL,
  `fish` varchar(100) DEFAULT NULL,
  `uptime` varchar(100) DEFAULT NULL,
  `ext` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `aly_biological` */

insert  into `aly_biological`(`id`,`wetlandplants`,`phytoplankton`,`zooplankton`,`benthos`,`fish`,`uptime`,`ext`) values (2,'1200','2000','1400','1300','120',NULL,NULL),(3,'1300','3000','1500','1400','130',NULL,NULL),(4,'1400','1500','1000','1700','110',NULL,NULL);

/*Table structure for table `aly_hydrology` */

DROP TABLE IF EXISTS `aly_hydrology`;

CREATE TABLE `aly_hydrology` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currentspeed` varchar(50) DEFAULT NULL,
  `flowto` varchar(50) DEFAULT NULL,
  `waterlevel` varchar(50) DEFAULT NULL,
  `uptime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `aly_hydrology` */

/*Table structure for table `aly_meteorological` */

DROP TABLE IF EXISTS `aly_meteorological`;

CREATE TABLE `aly_meteorological` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `windspeed` varchar(50) DEFAULT NULL,
  `airtemperature` varchar(50) DEFAULT NULL,
  `precipitation` varchar(50) DEFAULT NULL,
  `evaporation` varchar(50) DEFAULT NULL,
  `radiation` varchar(50) DEFAULT NULL,
  `uptime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `aly_meteorological` */

/*Table structure for table `aly_soil` */

DROP TABLE IF EXISTS `aly_soil`;

CREATE TABLE `aly_soil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnps` varchar(50) DEFAULT NULL,
  `heavymetal` varchar(50) DEFAULT NULL,
  `ph` varchar(50) DEFAULT NULL,
  `saltion` varchar(50) DEFAULT NULL,
  `watercontent` varchar(50) DEFAULT NULL,
  `uptime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `aly_soil` */

/*Table structure for table `aly_waterquality` */

DROP TABLE IF EXISTS `aly_waterquality`;

CREATE TABLE `aly_waterquality` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ph` varchar(50) DEFAULT NULL,
  `dissolvedoxygen` varchar(50) DEFAULT NULL,
  `conductivity` varchar(50) DEFAULT NULL,
  `turbidity` varchar(50) DEFAULT NULL,
  `temperature` varchar(50) DEFAULT NULL,
  `salinity` varchar(50) DEFAULT NULL,
  `ammonianitrogen` varchar(50) DEFAULT NULL,
  `totalphosphorus` varchar(50) DEFAULT NULL,
  `totalnitrogen` varchar(50) DEFAULT NULL,
  `kmno4` varchar(50) DEFAULT NULL,
  `uptime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `aly_waterquality` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
