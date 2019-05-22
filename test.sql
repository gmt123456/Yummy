-- MySQL dump 10.13  Distrib 5.7.22, for Win64 (x86_64)
--
-- Host: localhost    Database: yummydb
-- ------------------------------------------------------
-- Server version	5.7.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `accountid` varchar(45) NOT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('1',100402.02399999998);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `addrid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`addrid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫',1),(2,'ËãúËìøÂõ≠Á§æÂå∫',2),(3,'Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫',3);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity` (
  `commid` int(11) NOT NULL AUTO_INCREMENT,
  `comm_type` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `disc_end` date DEFAULT NULL,
  `disc_start` date DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `end` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `resid` int(11) DEFAULT NULL,
  `start` date DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`commid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (1,'COMMODITY',1000,NULL,NULL,0,'2020-05-20','Ëë°ËêÑ',20.1,1000000,'2019-05-20','ea51ff0c-ff37-46bc-853d-c347497803cb.jpg'),(2,'COMMODITY',1000,NULL,NULL,0,'2020-05-20','ËãπÊûú',9.9,1000000,'2019-05-20','b9d60622-0371-4c0e-bbe3-ebcdf6f34f2e.jpg'),(3,'COMMODITY',1000,'2020-05-21','2019-05-21',5,'2020-05-20','ËìùËéì',20,1000000,'2019-05-20','c418debc-1afd-4cfa-8505-28c9d4bc760c.jpg'),(4,'COMMODITY',1000,NULL,NULL,0,'2020-05-20','Ë•øÁìú',5.4,1000000,'2019-05-20','02366ee3-b87e-4f57-aa45-ce21946131c0.jpg'),(5,'PACKAGE',1000,NULL,NULL,0,'2020-05-20','Ëë°ËêÑÈÅáËßÅËãπÊûú',29.9,1000000,'2019-05-20','71a1a911-e34a-4102-a115-b048c30e79c0.jpg'),(6,'COMMODITY',999,NULL,NULL,0,'2020-05-18','Â∞èËõãÁ≥ï',35,1000001,'2019-05-20','b5483980-1652-4a82-a7ee-1997fc56f046.jpg'),(7,'COMMODITY',999,'2020-05-19','2019-05-21',7,'2020-05-18','Â§ßËõãÁ≥ï',200,1000001,'2019-05-20','bdeeabc3-c9fb-4c1f-b45f-26b211298c44.jpg'),(8,'COMMODITY',999,'2020-05-19','2019-05-21',7,'2020-05-18','Ê≥°ËäôÁõíÂ≠ê',59.5,1000001,'2019-05-20','523136b8-7910-4b19-b5cb-ed1bd47e04ba.jpg'),(9,'PACKAGE',999,NULL,NULL,0,'2020-05-18','ÂÖ®ÂÆ∂Ê°∂',402,1000001,'2019-05-20','eefd7f79-d478-450c-a56e-635a010fd561.jpg'),(10,'COMMODITY',1000,NULL,NULL,0,'2020-05-18','ÊãõÁâåÁÉ§È∏°',200.6,1000002,'2019-05-20','9f332fd2-5c93-4f77-b66b-19daf7e09c06.jpg'),(11,'COMMODITY',1000,NULL,NULL,0,'2020-05-18','ÂáèËÑÇËî¨Ëèú',12.4,1000002,'2019-05-20','03881cf9-3a9e-4180-8c95-6d676b724273.jpg'),(12,'COMMODITY',1000,NULL,NULL,0,'2020-05-18','Ê∞¥ÊûúÊ≤ôÊãâ',32.4,1000002,'2019-05-20','5e28a9b1-6567-4169-beaf-c5705c1ce2a9.jpg'),(13,'COMMODITY',1000,NULL,NULL,0,'2020-05-18','‰∏ÄÁ¢óÁ±≥È•≠',2,1000003,'2019-05-20','efb9c003-681f-40b3-9169-bfcf1323fda1.jpg'),(14,'COMMODITY',1000,NULL,NULL,0,'2020-05-18','‰∏ÄÁ¢óÊ±§',5.8,1000003,'2019-05-20','31eee2de-3c6e-40ef-9548-cc3350d5253a.jpg'),(15,'COMMODITY',1000,NULL,NULL,0,'2020-05-18','‰∏Ä‰ªΩËî¨Ëèú',8.8,1000003,'2019-05-20','2ee08fa9-d7fb-429f-b737-043f4671c4e7.jpg'),(16,'COMMODITY',1000,NULL,NULL,0,'2020-05-18','È∏°ËÖø',15,1000003,'2019-05-20','cfb756f8-127d-4033-b4a8-fcad8028be06.jpg'),(17,'COMMODITY',1000,NULL,NULL,0,'2020-05-18','Ë•øÁ∫¢Êüø',9.8,1000003,'2019-05-20','9bfa9ae8-7145-475d-88f9-b77b51497105.jpg'),(18,'PACKAGE',1000,NULL,NULL,0,'2020-05-18','Ëç§Á¥†Êê≠ÈÖç',25.5,1000003,'2019-05-20','ae06e92d-3e1a-419d-a2ae-d93c030c60c2.jpg'),(19,'PACKAGE',1000,NULL,NULL,0,'2020-05-18','Ê∏ÖË∞à‰∏ÄÈ§ê',15.3,1000003,'2019-05-20','a81a217a-ea17-4398-9ce5-84a86ec93f37.jpg'),(20,'COMMODITY',1000,NULL,NULL,0,'2020-05-18','ÊãõÁâåÂíñÂï°',35.5,1000004,'2019-05-20','746ff876-9c8e-46ed-a1c9-0f65db017ce2.jpg'),(21,'COMMODITY',1000,NULL,NULL,0,'2020-05-18','ÂíñÂï°Ë±Ü',5.5,1000004,'2019-05-20','2686ad49-adf4-4cdf-ab76-e579b6312eab.jpg'),(22,'PACKAGE',1000,NULL,NULL,0,'2020-05-18','ÊàëÂÖ®ÈÉΩË¶Å',40.5,1000004,'2019-05-20','274d3021-fd9b-46e2-ade5-aa7f12ffd25e.jpg');
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery` (
  `delID` int(11) NOT NULL AUTO_INCREMENT,
  `orderID` int(11) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `del_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`delID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES (1,2,'2019-03-20 06:36:05','RECEIVE'),(2,2,'2019-03-20 06:36:08','DELIVERY'),(3,2,'2019-03-20 06:36:09','ARRIVE'),(4,1,'2019-03-20 06:36:12','RECEIVE'),(5,1,'2019-03-20 06:36:13','DELIVERY'),(6,1,'2019-03-20 06:36:14','ARRIVE'),(7,9,'2019-03-20 06:40:39','RECEIVE'),(8,9,'2019-03-20 06:40:40','DELIVERY'),(9,9,'2019-03-20 06:40:40','ARRIVE'),(10,10,'2019-03-20 06:41:12','RECEIVE'),(11,10,'2019-03-20 06:41:12','DELIVERY'),(12,10,'2019-03-20 06:41:13','ARRIVE'),(13,5,'2019-03-20 06:41:13','RECEIVE'),(14,5,'2019-03-20 06:41:16','DELIVERY'),(15,5,'2019-03-20 06:41:16','ARRIVE'),(16,17,'2019-03-20 06:51:51','RECEIVE'),(17,17,'2019-03-20 06:51:51','DELIVERY'),(18,17,'2019-03-20 06:51:52','ARRIVE'),(19,16,'2019-03-20 06:51:53','RECEIVE'),(20,16,'2019-03-20 06:51:53','DELIVERY'),(21,16,'2019-03-20 06:51:54','ARRIVE'),(22,15,'2019-03-20 06:51:54','RECEIVE'),(23,15,'2019-03-20 06:51:55','DELIVERY'),(24,15,'2019-03-20 06:51:55','ARRIVE'),(25,14,'2019-03-20 06:51:55','RECEIVE'),(26,14,'2019-03-20 06:51:56','DELIVERY'),(27,14,'2019-03-20 06:51:56','ARRIVE'),(28,13,'2019-03-20 06:51:57','RECEIVE'),(29,13,'2019-03-20 06:51:57','DELIVERY'),(30,13,'2019-03-20 06:51:57','ARRIVE'),(31,12,'2019-03-20 17:34:48','RECEIVE'),(32,12,'2019-03-20 17:34:49','DELIVERY'),(33,12,'2019-03-20 17:34:50','ARRIVE');
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `emailid` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emailid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (1,'H69e1','1344885846@qq.com'),(2,'T9987','gao.gmt@qq.com');
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (22),(22),(22),(22),(22),(22),(22),(22),(22),(22),(22),(22);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inbox`
--

DROP TABLE IF EXISTS `inbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inbox` (
  `inboxid` int(11) NOT NULL AUTO_INCREMENT,
  `reqid` int(11) DEFAULT NULL,
  PRIMARY KEY (`inboxid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inbox`
--

LOCK TABLES `inbox` WRITE;
/*!40000 ALTER TABLE `inbox` DISABLE KEYS */;
/*!40000 ALTER TABLE `inbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `managerid` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`managerid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'123456');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordercomm`
--

DROP TABLE IF EXISTS `ordercomm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordercomm` (
  `order_commid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderid` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `commid` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_commid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordercomm`
--

LOCK TABLES `ordercomm` WRITE;
/*!40000 ALTER TABLE `ordercomm` DISABLE KEYS */;
INSERT INTO `ordercomm` VALUES (1,1,'Ëë°ËêÑÔºà‰∏Ä‰∏≤Ôºâ',1,12,1),(2,1,'ËãπÊûúÔºà‰∏Ä‰∏™Ôºâ',1,6,2),(3,1,'ËãπÊûúÔºà‰∏Ä‰∏™Ôºâ',2,6,2),(4,1,'Ê≤πÊ°ÉÔºà‰∏Ä‰∏™Ôºâ',2,5,5),(5,1,'Ê≤πÊ°ÉËΩ¶ÂéòÂ≠êÂ•óÈ§ê',2,66,6),(6,1,'ËãπÊûúËë°ËêÑÔºà‰∏ÄÁØÆÔºâ',2,25,4),(7,1,'ËΩ¶ÂéòÂ≠ê',2,50,3),(8,1,'Ëë°ËêÑÔºà‰∏Ä‰∏≤Ôºâ',2,12,1),(9,1,'Á¥†È£üÂ∞èËèú',3,13,13),(10,1,'ÊèêÂ≠ê',4,25,14),(11,1,'ÊèêÂ≠ê',5,25,14),(12,1,'Âú£Â•≥Êûú',5,24,16),(13,1,'ÈÖ±Áå™ËπÑ',6,25,21),(14,1,'ÁÇíËä±Ê§∞Ëèú',6,8,19),(15,1,'Êû∏ÊùûÂÖªÁîüÊ±§',7,14,17),(16,1,'ÁÇíËä±Ê§∞Ëèú',7,8,19),(17,1,'ÈÖ±Áå™ËπÑ',7,25,21),(18,1,'Á±≥È•≠Ôºà‰∏Ä‰ªΩÔºâ',8,3,18),(19,1,'ÂáâÊãåË•øÁ∫¢Êüø',8,5,20),(20,1,'ËΩ¶ÂéòÂ≠ê',9,50,3),(21,2,'ÊèêÂ≠ê',10,25,14),(22,9,'„ÄêÊãõÁâå„ÄëÁÉ§È∏°',11,120,12),(23,1,'ËΩ¶ÂéòÂ≠ê',12,50,3),(24,1,'Ê≤πÊ°ÉÔºà‰∏Ä‰∏™Ôºâ',12,5,5),(25,1,'ËçâËéìËõãÁ≥ïÁõíÂ≠ê',13,20,7),(26,1,'Ê∞¥ÊûúÊ¥æ',13,45,9),(27,1,'Êü†Ê™¨Á∫¢Ëå∂',14,16,8),(28,1,'ËçâËéìËõãÁ≥ïÁõíÂ≠ê',15,20,7),(29,1,'Êü†Ê™¨Á∫¢Ëå∂',15,16,8),(30,1,'Ê∞¥ÊûúËõãÁ≥ï',16,70,10),(31,1,'Ê∞¥ÊûúËõãÁ≥ï',17,70,10),(32,1,'Áº§Á∫∑Â•óÈ§ê',17,80,11),(33,2,'ÂíñÂï°',18,20,23),(34,2,'Ëë°ËêÑÔºà‰∏Ä‰∏≤Ôºâ',19,12,1),(35,2,'ËΩ¶ÂéòÂ≠ê',19,50,3),(36,2,'Âú£Â•≥Êûú',20,24,16),(37,1,'‰∏Ä‰ªΩËî¨Ëèú',21,8.8,15),(38,1,'‰∏ÄÁ¢óÁ±≥È•≠',21,2,13),(39,1,'Ë•øÁ∫¢Êüø',21,9.8,17),(40,1,'Ëç§Á¥†Êê≠ÈÖç',21,25.5,18);
/*!40000 ALTER TABLE `ordercomm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `resID` int(11) DEFAULT NULL,
  `numbers` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `arrive` timestamp NULL DEFAULT NULL,
  `amount` double DEFAULT '0',
  `state` varchar(45) DEFAULT 'ÂæÖÊîØ‰ªò',
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,1000000,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:35:00','2019-03-20 06:48:00',14.4,'FINISH'),(2,1,1000000,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:35:33','2019-03-20 06:49:00',145.4,'FINISH'),(3,1,1000002,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:36:53','2019-03-20 06:55:00',13,'FINISH'),(4,1,1000002,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:37:04','2019-03-20 06:56:00',25,'UNSUB'),(5,1,1000002,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:37:41','2019-03-20 06:56:00',49,'FINISH'),(6,1,1000003,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:38:15','2019-03-20 06:59:00',26.4,'UNACCEPTED'),(7,1,1000003,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:38:27','2019-03-20 06:59:00',37.6,'UNACCEPTED'),(8,1,1000003,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:38:38','2019-03-20 06:59:00',8,'UNACCEPTED'),(9,1,1000000,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:39:42','2019-03-20 06:53:00',31.5,'FINISH'),(10,1,1000002,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:40:30','2019-03-20 06:59:00',45,'FINISH'),(11,1,1000002,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:42:03','2019-03-20 07:01:00',972,'FINISH'),(12,1,1000000,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 06:42:28','2019-03-20 06:56:00',32,'FINISH'),(13,2,1000001,'13273652657','ËãúËìøÂõ≠Á§æÂå∫','2019-03-20 06:47:09','2019-03-20 07:02:00',35.7,'FINISH'),(14,2,1000001,'13273652657','ËãúËìøÂõ≠Á§æÂå∫','2019-03-20 06:47:23','2019-03-20 07:02:00',3.3600000000000003,'FINISH'),(15,2,1000001,'13273652657','ËãúËìøÂõ≠Á§æÂå∫','2019-03-20 06:50:48','2019-03-20 07:05:00',7.560000000000001,'FINISH'),(16,2,1000001,'13273652657','ËãúËìøÂõ≠Á§æÂå∫','2019-03-20 06:50:57','2019-03-20 07:05:00',49.00000000000001,'FINISH'),(17,2,1000001,'13273652657','ËãúËìøÂõ≠Á§æÂå∫','2019-03-20 06:51:06','2019-03-20 07:06:00',105.00000000000001,'FINISH'),(18,1,1000004,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 17:32:07','2019-03-20 17:50:00',25.6,'CANCEL'),(19,1,1000000,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 17:32:23','2019-03-20 17:46:00',69.44,'UNSUB'),(20,1,1000002,'1383625143','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-03-20 17:32:40','2019-03-20 17:51:00',38.400000000000006,'FINISH'),(21,3,1000003,'13542345677','Âçó‰∫¨Â§ßÂ≠¶ÈºìÊ•ºÊ†°Âå∫','2019-05-21 03:49:06','2019-05-21 04:10:00',46.1,'CANCEL');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `package` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commid` int(11) DEFAULT NULL,
  `pkgid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
INSERT INTO `package` VALUES (16,1,5),(17,2,5),(18,6,9),(19,7,9),(20,8,9),(21,13,18),(22,15,18),(23,16,18),(24,13,19),(25,17,19),(26,14,19),(27,20,22),(28,21,22);
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_blob_triggers`
--

DROP TABLE IF EXISTS `qrtz_blob_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_blob_triggers`
--

LOCK TABLES `qrtz_blob_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_blob_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_blob_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_calendars`
--

DROP TABLE IF EXISTS `qrtz_calendars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_calendars`
--

LOCK TABLES `qrtz_calendars` WRITE;
/*!40000 ALTER TABLE `qrtz_calendars` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_calendars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_cron_triggers`
--

DROP TABLE IF EXISTS `qrtz_cron_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_cron_triggers`
--

LOCK TABLES `qrtz_cron_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_cron_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_cron_triggers` VALUES ('clusteredScheduler','1','confirmTask','13 41 22 * * ?','Asia/Shanghai'),('clusteredScheduler','10','confirmTask','38 30 20 * * ?','Asia/Shanghai'),('clusteredScheduler','11','confirmTask','06 17 11 * * ?','Asia/Shanghai'),('clusteredScheduler','12','confirmTask','50 39 09 * * ?','Asia/Shanghai'),('clusteredScheduler','13','confirmTask','57 56 22 * * ?','Asia/Shanghai'),('clusteredScheduler','14','confirmTask','55 56 22 * * ?','Asia/Shanghai'),('clusteredScheduler','15','confirmTask','54 56 22 * * ?','Asia/Shanghai'),('clusteredScheduler','16','confirmTask','53 56 22 * * ?','Asia/Shanghai'),('clusteredScheduler','17','confirmTask','51 56 22 * * ?','Asia/Shanghai'),('clusteredScheduler','18','cancelTask','07 34 09 * * ?','Asia/Shanghai'),('clusteredScheduler','2','confirmTask','09 41 22 * * ?','Asia/Shanghai'),('clusteredScheduler','21','cancelTask','06 51 19 * * ?','Asia/Shanghai'),('clusteredScheduler','22','confirmTask','27 54 09 * * ?','Asia/Shanghai'),('clusteredScheduler','26','confirmTask','07 29 12 * * ?','Asia/Shanghai'),('clusteredScheduler','4','task','23 54 10 * * ?','Asia/Shanghai'),('clusteredScheduler','5','confirmTask','16 46 22 * * ?','Asia/Shanghai'),('clusteredScheduler','5','task','39 54 10 * * ?','Asia/Shanghai'),('clusteredScheduler','9','confirmTask','40 45 22 * * ?','Asia/Shanghai');
/*!40000 ALTER TABLE `qrtz_cron_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_fired_triggers`
--

DROP TABLE IF EXISTS `qrtz_fired_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_fired_triggers`
--

LOCK TABLES `qrtz_fired_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_fired_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_fired_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_job_details`
--

DROP TABLE IF EXISTS `qrtz_job_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_job_details`
--

LOCK TABLES `qrtz_job_details` WRITE;
/*!40000 ALTER TABLE `qrtz_job_details` DISABLE KEYS */;
INSERT INTO `qrtz_job_details` VALUES ('clusteredScheduler','1','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','10','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','11','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.CancelOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','12','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','13','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','14','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','15','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','16','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','17','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','18','cancelTask',NULL,'com.gaomt.yummy.utils.quartz.CancelOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','2','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','21','cancelTask',NULL,'com.gaomt.yummy.utils.quartz.CancelOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','22','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.CancelOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','26','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','4','task',NULL,'com.gaomt.yummy.utils.quartz.CancelOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','5','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','5','task',NULL,'com.gaomt.yummy.utils.quartz.CancelOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0'),('clusteredScheduler','9','confirmTask',NULL,'com.gaomt.yummy.utils.quartz.ConfirmOrderJob','0','0','0','0','¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0');
/*!40000 ALTER TABLE `qrtz_job_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_locks`
--

DROP TABLE IF EXISTS `qrtz_locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_locks`
--

LOCK TABLES `qrtz_locks` WRITE;
/*!40000 ALTER TABLE `qrtz_locks` DISABLE KEYS */;
INSERT INTO `qrtz_locks` VALUES ('clusteredScheduler','STATE_ACCESS'),('clusteredScheduler','TRIGGER_ACCESS');
/*!40000 ALTER TABLE `qrtz_locks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_paused_trigger_grps`
--

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_paused_trigger_grps`
--

LOCK TABLES `qrtz_paused_trigger_grps` WRITE;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_scheduler_state`
--

DROP TABLE IF EXISTS `qrtz_scheduler_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_scheduler_state`
--

LOCK TABLES `qrtz_scheduler_state` WRITE;
/*!40000 ALTER TABLE `qrtz_scheduler_state` DISABLE KEYS */;
INSERT INTO `qrtz_scheduler_state` VALUES ('clusteredScheduler','LAPTOP-T8LLN4D41558490895200',1558492476421,10000);
/*!40000 ALTER TABLE `qrtz_scheduler_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simple_triggers`
--

DROP TABLE IF EXISTS `qrtz_simple_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simple_triggers`
--

LOCK TABLES `qrtz_simple_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simple_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simple_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simprop_triggers`
--

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simprop_triggers`
--

LOCK TABLES `qrtz_simprop_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_triggers`
--

DROP TABLE IF EXISTS `qrtz_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_triggers`
--

LOCK TABLES `qrtz_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_triggers` VALUES ('clusteredScheduler','1','confirmTask','1','confirmTask',NULL,1558536073000,1558490896166,5,'WAITING','CRON',1553092573000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','10','confirmTask','10','confirmTask',NULL,1558528238000,1558490896142,5,'WAITING','CRON',1553084738000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0\nx\0'),('clusteredScheduler','11','confirmTask','11','confirmTask',NULL,1558495026000,1558435451384,5,'WAITING','CRON',1552965126000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','12','confirmTask','12','confirmTask',NULL,1558575590000,1558490896249,5,'WAITING','CRON',1553132090000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','13','confirmTask','13','confirmTask',NULL,1558537017000,1558490896232,5,'WAITING','CRON',1553093517000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0\rx\0'),('clusteredScheduler','14','confirmTask','14','confirmTask',NULL,1558537015000,1558490896225,5,'WAITING','CRON',1553093515000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','15','confirmTask','15','confirmTask',NULL,1558537014000,1558490896217,5,'WAITING','CRON',1553093514000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','16','confirmTask','16','confirmTask',NULL,1558537013000,1558490896211,5,'WAITING','CRON',1553093513000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','17','confirmTask','17','confirmTask',NULL,1558537011000,1558490896203,5,'WAITING','CRON',1553093511000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','18','cancelTask','18','cancelTask',NULL,1558575247000,1558490896239,5,'WAITING','CRON',1553131927000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','2','confirmTask','2','confirmTask',NULL,1558536069000,1558490896158,5,'WAITING','CRON',1553092569000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','21','cancelTask','21','cancelTask',NULL,1558525866000,1558439466000,5,'WAITING','CRON',1558439346000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','22','confirmTask','22','confirmTask',NULL,1558576467000,1558490896259,5,'WAITING','CRON',1553046567000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','26','confirmTask','26','confirmTask',NULL,1558499347000,1558435451389,5,'WAITING','CRON',1553055847000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0\Zx\0'),('clusteredScheduler','4','task','4','task',NULL,1558493663000,1558435451370,5,'WAITING','CRON',1551322458000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','5','confirmTask','5','confirmTask',NULL,1558536376000,1558490896196,5,'WAITING','CRON',1553092876000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','5','task','5','task',NULL,1558493679000,1558435451380,5,'WAITING','CRON',1551322474000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0x\0'),('clusteredScheduler','9','confirmTask','9','confirmTask',NULL,1558536340000,1558490896185,5,'WAITING','CRON',1553092840000,0,NULL,0,'¨\Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞\À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇ\Ë\√˚\≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\Ê.≠(v\n\Œ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0orderIDsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0	x\0');
/*!40000 ALTER TABLE `qrtz_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `recordid` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `orderid` int(11) DEFAULT NULL,
  `rec_type` varchar(255) DEFAULT NULL,
  `resid` int(11) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordid`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,14.4,1,'ORDER',1000000,'2019-03-20 06:35:00',1,0),(2,14.4,1,'PAY',1000000,'2019-03-20 06:35:04',1,0),(3,145.4,2,'ORDER',1000000,'2019-03-20 06:35:33',1,0),(4,145.4,2,'PAY',1000000,'2019-03-20 06:35:39',1,0),(5,13,3,'ORDER',1000002,'2019-03-20 06:36:53',1,0),(6,13,3,'PAY',1000002,'2019-03-20 06:36:54',1,0),(7,25,4,'ORDER',1000002,'2019-03-20 06:37:04',1,0),(8,25,4,'PAY',1000002,'2019-03-20 06:37:05',1,0),(9,49,5,'ORDER',1000002,'2019-03-20 06:37:41',1,0),(10,49,5,'PAY',1000002,'2019-03-20 06:37:43',1,0),(11,26.4,6,'ORDER',1000003,'2019-03-20 06:38:15',1,0),(12,26.4,6,'PAY',1000003,'2019-03-20 06:38:16',1,0),(13,37.6,7,'ORDER',1000003,'2019-03-20 06:38:27',1,0),(14,37.6,7,'PAY',1000003,'2019-03-20 06:38:30',1,0),(15,8,8,'ORDER',1000003,'2019-03-20 06:38:38',1,0),(16,8,8,'PAY',1000003,'2019-03-20 06:38:39',1,0),(17,145.4,2,'FINISH',1000000,'2019-03-20 06:39:11',1,0),(18,13,3,'FINISH',1000002,'2019-03-20 06:39:16',1,1),(19,14.4,1,'FINISH',1000000,'2019-03-20 06:39:20',1,1),(20,25,4,'UNSUB',1000002,'2019-03-20 06:39:23',1,1),(21,31.5,9,'ORDER',1000000,'2019-03-20 06:39:42',1,1),(22,31.5,9,'PAY',1000000,'2019-03-20 06:39:43',1,1),(23,45,10,'ORDER',1000002,'2019-03-20 06:40:30',1,1),(24,45,10,'PAY',1000002,'2019-03-20 06:40:31',1,1),(25,49,5,'FINISH',1000002,'2019-03-20 06:41:31',1,1),(26,45,10,'FINISH',1000002,'2019-03-20 06:41:36',1,1),(27,31.5,9,'FINISH',1000000,'2019-03-20 06:41:40',1,1),(28,972,11,'ORDER',1000002,'2019-03-20 06:42:03',1,1),(29,972,11,'PAY',1000002,'2019-03-20 06:42:04',1,1),(30,972,11,'FINISH',1000002,'2019-03-20 06:42:06',1,1),(31,32,12,'ORDER',1000000,'2019-03-20 06:42:28',1,2),(32,32,12,'PAY',1000000,'2019-03-20 06:42:29',1,2),(33,35.7,13,'ORDER',1000001,'2019-03-20 06:47:09',2,3),(34,35.7,13,'PAY',1000001,'2019-03-20 06:47:11',2,3),(35,3.3600000000000003,14,'ORDER',1000001,'2019-03-20 06:47:23',2,3),(36,3.3600000000000003,14,'PAY',1000001,'2019-03-20 06:47:42',2,3),(37,7.560000000000001,15,'ORDER',1000001,'2019-03-20 06:50:48',2,3),(38,7.560000000000001,15,'PAY',1000001,'2019-03-20 06:50:50',2,3),(39,49.00000000000001,16,'ORDER',1000001,'2019-03-20 06:50:57',2,3),(40,49.00000000000001,16,'PAY',1000001,'2019-03-20 06:50:58',2,3),(41,105.00000000000001,17,'ORDER',1000001,'2019-03-20 06:51:06',2,3),(42,105.00000000000001,17,'PAY',1000001,'2019-03-20 06:51:07',2,3),(43,105.00000000000001,17,'FINISH',1000001,'2019-03-20 06:52:04',2,3),(44,49.00000000000001,16,'FINISH',1000001,'2019-03-20 06:52:09',2,1),(45,7.560000000000001,15,'FINISH',1000001,'2019-03-20 06:52:14',2,1),(46,3.3600000000000003,14,'FINISH',1000001,'2019-03-20 06:52:17',2,1),(47,35.7,13,'FINISH',1000001,'2019-03-20 06:52:20',2,1),(48,1176.736,0,'SETTLE',0,'2019-03-20 06:53:26',0,-1),(49,25.6,18,'ORDER',1000004,'2019-03-20 17:32:07',1,2),(50,69.44,19,'ORDER',1000000,'2019-03-20 17:32:23',1,2),(51,38.400000000000006,20,'ORDER',1000002,'2019-03-20 17:32:40',1,2),(52,38.400000000000006,20,'PAY',1000002,'2019-03-20 17:32:51',1,2),(53,38.400000000000006,20,'FINISH',1000002,'2019-03-20 17:32:57',1,2),(54,69.44,19,'PAY',1000000,'2019-03-20 17:33:07',1,2),(55,69.44,19,'UNSUB',1000000,'2019-03-20 17:33:09',1,2),(56,25.6,18,'CANCEL',1000004,'2019-03-20 17:34:07',1,2),(57,34.56000000000001,0,'SETTLE',0,'2019-03-20 17:35:25',0,-1),(58,32,12,'FINISH',1000000,'2019-05-21 02:44:12',1,2),(59,46.1,21,'ORDER',1000003,'2019-05-21 03:49:07',3,0),(60,46.1,21,'CANCEL',1000003,'2019-05-21 03:51:06',3,0);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `reqid` int(11) NOT NULL AUTO_INCREMENT,
  `appr_time` timestamp NULL DEFAULT NULL,
  `new_info` varchar(255) DEFAULT NULL,
  `old_info` varchar(255) DEFAULT NULL,
  `req_time` timestamp NULL DEFAULT NULL,
  `req_type` varchar(255) DEFAULT NULL,
  `resid` int(11) DEFAULT NULL,
  `state` varchar(128) DEFAULT 'PENDING',
  PRIMARY KEY (`reqid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1,'2019-03-20 05:47:30','ÈòøÊ°ëÊ∞¥ÊûúÂ∫ó','R_1000000','2019-03-20 05:45:05','NAME',1000000,'AGREE'),(2,'2019-03-20 05:47:30','Áè†Ê±üË∑Ø(Âú∞ÈìÅÁ´ô)',NULL,'2019-03-20 05:46:56','LOCATE',1000000,'AGREE'),(3,'2019-03-20 05:47:31','Ê∞¥ÊûúÁîüÈ≤ú','ÂÆ∂Â∏∏‰∏≠È§ê','2019-03-20 05:46:57','TYPE',1000000,'AGREE'),(4,'2019-03-20 06:14:11','ÁîúËúúËúú','R_1000001','2019-03-20 06:13:20','NAME',1000001,'AGREE'),(5,'2019-03-20 06:14:11','ËãúËìøÂõ≠(Âú∞ÈìÅÁ´ô)',NULL,'2019-03-20 06:13:58','LOCATE',1000001,'AGREE'),(6,'2019-03-20 06:14:11','ÁîúÁÇπÈ•ÆÂìÅ','ÂÆ∂Â∏∏‰∏≠È§ê','2019-03-20 06:14:03','TYPE',1000001,'AGREE'),(7,'2019-03-20 06:23:17','Ë•øÈ§ê','ÂÆ∂Â∏∏‰∏≠È§ê','2019-03-20 06:22:58','TYPE',1000002,'AGREE'),(8,'2019-03-20 06:23:17','Ë±™ÂçéË•øÈ§ê','R_1000002','2019-03-20 06:22:59','NAME',1000002,'AGREE'),(9,'2019-03-20 06:23:18','ÁéÑÊ≠¶Èó®(Âú∞ÈìÅÁ´ô)',NULL,'2019-03-20 06:23:13','LOCATE',1000002,'AGREE'),(10,'2019-03-20 06:27:19','Â§ßË°åÂÆ´(Âú∞ÈìÅÁ´ô)',NULL,'2019-03-20 06:27:09','LOCATE',1000003,'AGREE'),(11,'2019-03-20 06:27:22','‰∏≠ÂºèÈ•≠È¶Ü','R_1000003','2019-03-20 06:27:17','NAME',1000003,'AGREE'),(12,'2019-03-20 17:29:39','ÁîúÂ§öÂ§ö','ÁîúËúúËúú','2019-03-20 06:53:51','NAME',1000001,'AGREE'),(13,'2019-03-20 17:29:40','ÁéÑÊ≠¶Èó®(Âú∞ÈìÅÁ´ô)','ËãúËìøÂõ≠(Âú∞ÈìÅÁ´ô)','2019-03-20 06:54:06','LOCATE',1000001,'AGREE'),(14,'2019-03-20 17:29:40','ÁîúÁÇπÈ•ÆÂìÅ','ÁîúÁÇπÈ•ÆÂìÅ','2019-03-20 06:54:21','TYPE',1000001,'AGREE'),(15,'2019-03-20 17:29:47','ÂíñÂï°È¶Ü','R_1000004','2019-03-20 17:28:52','NAME',1000004,'AGREE'),(16,'2019-03-20 17:29:48','Êñ∞Ë°óÂè£(Âú∞ÈìÅÁ´ô)',NULL,'2019-03-20 17:28:54','LOCATE',1000004,'AGREE'),(17,'2019-03-20 17:29:48','Ë•øÈ§ê','ÂÆ∂Â∏∏‰∏≠È§ê','2019-03-20 17:29:00','TYPE',1000004,'AGREE');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resaurant`
--

DROP TABLE IF EXISTS `resaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resaurant` (
  `resid` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `locate` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `res_typeid` int(11) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resid`)
) ENGINE=InnoDB AUTO_INCREMENT=1000005 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resaurant`
--

LOCK TABLES `resaurant` WRITE;
/*!40000 ALTER TABLE `resaurant` DISABLE KEYS */;
INSERT INTO `resaurant` VALUES (1000000,32,153.04000000000002,'Áè†Ê±üË∑Ø(Âú∞ÈìÅÁ´ô)','ÈòøÊ°ëÊ∞¥ÊûúÂ∫ó','123456',2,'1664ab0a-a1cb-4e17-b1bc-ccb1fbfe1b9b.jpg'),(1000001,0,160.49600000000007,'ÁéÑÊ≠¶Èó®(Âú∞ÈìÅÁ´ô)','ÁîúÂ§öÂ§ö','123456',3,'6dba68d3-d848-4bb2-803b-7bb735339a67.jpg'),(1000002,0,897.7600000000001,'ÁéÑÊ≠¶Èó®(Âú∞ÈìÅÁ´ô)','Ë±™ÂçéË•øÈ§ê','123456',5,'7181ef96-0191-4626-8478-8f76b005cce3.jpg'),(1000003,0,0,'Â§ßË°åÂÆ´(Âú∞ÈìÅÁ´ô)','‰∏≠ÂºèÈ•≠È¶Ü','123456',1,'d0e3959c-045c-464f-b078-f796f9bd6888.jpg'),(1000004,0,0,'Êñ∞Ë°óÂè£(Âú∞ÈìÅÁ´ô)','ÂíñÂï°È¶Ü','123456',5,'7b6cff62-1d59-49be-81d7-34afecf8bfa9.jpg');
/*!40000 ALTER TABLE `resaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resauranttype`
--

DROP TABLE IF EXISTS `resauranttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resauranttype` (
  `res_typeid` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`res_typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resauranttype`
--

LOCK TABLES `resauranttype` WRITE;
/*!40000 ALTER TABLE `resauranttype` DISABLE KEYS */;
INSERT INTO `resauranttype` VALUES (1,'ÂÆ∂Â∏∏‰∏≠È§ê'),(2,'Ê∞¥ÊûúÁîüÈ≤ú'),(3,'ÁîúÁÇπÈ•ÆÂìÅ'),(4,'Âø´È§êÈõ∂È£ü'),(5,'Ë•øÈ§ê');
/*!40000 ALTER TABLE `resauranttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `addrid` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `numbers` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` varchar(128) DEFAULT 'REGISTERED',
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,1412.7,587.3,9,'1344885846@qq.com',2,'È´òÂçÅ‰∏Ä','1383625143','123456','REGISTERED','1652f358-8aea-4da0-a919-cac6f20090f2.jpg'),(2,2,200.62,1799.38,5,'1@qq.com',1,'Âº†ÂçÅ‰∏Ä','13273652657','123456','REGISTERED','6132858e-e60f-4a8d-8bed-507d0ca40809.jpg'),(3,3,0,2000,0,'gao.gmt@qq.com',0,'U_3','13542345677','123456','REGISTERED','3ce63f8f-cf24-4790-b037-515af63be0ba.jpg');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-22 10:34:39
