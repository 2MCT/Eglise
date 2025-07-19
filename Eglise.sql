-- MySQL dump 10.13  Distrib 8.0.42, for Linux (x86_64)
--
-- Host: localhost    Database: Eglise
-- ------------------------------------------------------
-- Server version	8.0.42-0ubuntu0.24.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `EGLISE`
--

DROP TABLE IF EXISTS `EGLISE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EGLISE` (
  `ideglise` varchar(4) NOT NULL,
  `design` varchar(100) DEFAULT NULL,
  `solde` int DEFAULT NULL,
  PRIMARY KEY (`ideglise`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EGLISE`
--

LOCK TABLES `EGLISE` WRITE;
/*!40000 ALTER TABLE `EGLISE` DISABLE KEYS */;
INSERT INTO `EGLISE` VALUES ('EGL1','EKAR Saint François Xavier Tanambao',100000);
/*!40000 ALTER TABLE `EGLISE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ENTREE`
--

DROP TABLE IF EXISTS `ENTREE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ENTREE` (
  `identree` int NOT NULL AUTO_INCREMENT,
  `motif` varchar(100) DEFAULT NULL,
  `montant_entree` int DEFAULT NULL,
  `date_entree` date DEFAULT NULL,
  PRIMARY KEY (`identree`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ENTREE`
--

LOCK TABLES `ENTREE` WRITE;
/*!40000 ALTER TABLE `ENTREE` DISABLE KEYS */;
INSERT INTO `ENTREE` VALUES (1,'Rakitra',100000,'2025-07-18'),(2,'Rakitra',20000,'2025-07-18');
/*!40000 ALTER TABLE `ENTREE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SORTIE`
--

DROP TABLE IF EXISTS `SORTIE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SORTIE` (
  `idsortie` int NOT NULL AUTO_INCREMENT,
  `motif` varchar(100) DEFAULT NULL,
  `montant_sortie` int DEFAULT NULL,
  `date_sortie` date DEFAULT NULL,
  PRIMARY KEY (`idsortie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SORTIE`
--

LOCK TABLES `SORTIE` WRITE;
/*!40000 ALTER TABLE `SORTIE` DISABLE KEYS */;
/*!40000 ALTER TABLE `SORTIE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-19 17:54:06
