CREATE DATABASE  IF NOT EXISTS `joydrinks` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `joydrinks`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: joydrinks
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `jrecord`
--

DROP TABLE IF EXISTS `jrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jrecord` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `record_num` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `capacity` varchar(45) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `sugar` varchar(45) DEFAULT NULL,
  `ice` varchar(45) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jrecord`
--

LOCK TABLES `jrecord` WRITE;
/*!40000 ALTER TABLE `jrecord` DISABLE KEYS */;
INSERT INTO `jrecord` VALUES (1,1,0,'拿鐵','中杯',90,'正常','正常',2),(2,1,1,'伯爵奶茶','大杯',55,'少糖','少冰',1),(3,2,0,'伯爵奶茶','大杯',55,'正常','正常',1),(4,3,0,'烏龍茶','大杯',50,'無糖','熱',1),(5,3,1,'伯爵奶茶','大杯',55,'半糖','微冰',1),(6,4,0,'拿鐵','中杯',90,'少糖','少冰',1),(7,4,1,'伯爵奶茶','大杯',55,'少糖','去冰',1),(8,4,2,'伯爵紅茶','大杯',45,'半糖','微冰',2),(9,5,0,'伯爵奶茶','大杯',55,'正常','正常',1),(10,5,1,'拿鐵','中杯',90,'正常','正常',1),(11,6,0,'伯爵奶茶','大杯',55,'少糖','微冰',1),(12,6,1,'伯爵奶茶','大杯',55,'半糖','微冰',1),(13,6,2,'烏龍茶','大杯',50,'無糖','正常',1),(14,6,3,'伯爵紅茶','大杯',45,'無糖','少冰',1),(15,7,0,'拿鐵','中杯',90,'微糖','熱',1),(16,7,1,'拿鐵','小杯',65,'微糖','微冰',1);
/*!40000 ALTER TABLE `jrecord` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-17 11:01:20
