CREATE DATABASE  IF NOT EXISTS `library_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `library_db`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: library_db
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `available` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `borrowed_by` bigint DEFAULT NULL,
  `borrowed_by_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKawmalkqpuw9wnkprep61moxhr` (`borrowed_by`),
  KEY `FKe19getbnd3lruuvhvwooubipb` (`borrowed_by_id`),
  CONSTRAINT `FKawmalkqpuw9wnkprep61moxhr` FOREIGN KEY (`borrowed_by`) REFERENCES `user` (`id`),
  CONSTRAINT `FKe19getbnd3lruuvhvwooubipb` FOREIGN KEY (`borrowed_by_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (5,'Joshua Bloch',_binary '','Effective Java',NULL,NULL),(7,'F. Scott Fitzgerald',_binary '','The Great Gatsby',NULL,NULL),(10,'Author Name',_binary '','Example Book Title',NULL,NULL),(11,'Author Name',_binary '','Example Book Title',NULL,NULL),(16,'Author Name',_binary '','Example Book Title',NULL,NULL),(17,'Author Name',_binary '\0','Example Book Title',NULL,NULL),(18,'Author Name',_binary '\0','Example Book Title',NULL,NULL),(19,'Author Name',_binary '\0','Example Book Title',NULL,NULL),(27,'hii',_binary '','helo',NULL,NULL),(29,'555',_binary '','he',NULL,NULL),(30,'hh',_binary '','hi',NULL,NULL),(32,'helo',_binary '','hii',NULL,NULL),(33,'rashen',_binary '','photocpy',NULL,NULL),(34,'helo',_binary '','hii',NULL,NULL),(35,'Test Author',_binary '','Selenium Automation',NULL,NULL),(36,'Test Author',_binary '','Selenium Automation',NULL,NULL),(37,'Test Author',_binary '','Selenium Automation',NULL,NULL),(38,'Test Author',_binary '','Selenium Automation',NULL,NULL),(39,'Test Author',_binary '','Selenium Automation',NULL,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-29 21:51:05
