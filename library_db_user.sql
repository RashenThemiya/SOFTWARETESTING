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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'securePassword','USER','newuser'),(2,NULL,'securePassword123','USER','newuser'),(3,NULL,'securePassword123','USER','newuser'),(4,NULL,'securePassword123','USER','newuser'),(5,NULL,'securePassword123','USER','newuser'),(6,NULL,'securePassword123','USER','newuser'),(7,NULL,'securePassword123','USER','newuser'),(8,NULL,'securePassword123','USER','newuser'),(9,NULL,'securePassword123','USER','newuser'),(10,NULL,'securePassword123','USER','newuser'),(11,NULL,'securePassword123','USER','newuser'),(12,NULL,'securePassword123','USER','newusrer'),(13,NULL,'securePassword123','USER','newusrer'),(14,NULL,'securePassword123','USER','newusrer'),(15,NULL,'securePassword123','USER','newusrer'),(16,NULL,'securePassword123','USER','newusrer'),(17,NULL,'securePassword123','USER','newusrer'),(18,NULL,'$2a$10$0oypV9YdZLdeJ4.8U2LQpeWJCJ6AhFh5dN2pSoNqtBAHvzKgzYoRm','ADMIN','admin'),(19,NULL,'password123','USER','testUser'),(20,NULL,'password123','admin','testUser'),(21,NULL,'password123','admin','testUser'),(22,NULL,'password123','admin','testUser'),(23,NULL,'password123','admin','testUser'),(24,NULL,'password123','admin','testUser'),(25,NULL,'password123','user','testUser2'),(26,NULL,'password123','user','testUser7'),(27,NULL,'adminpassword','admin','admin'),(28,NULL,'adminpassword','admin','admin1'),(29,NULL,'adminpassword','admin','admin1'),(30,NULL,'adminpassword','admin','admin1'),(31,NULL,'adminpassword','admin','admin1'),(32,NULL,'$2a$10$ELwZ/Z2Sn/fwTTOODmkk9.i9QTs55afWMnbp8sCRbLvn8NrsUgKky','admin','admin1'),(33,NULL,'$2a$10$YapWM/Z5NV1AgzfunMzijO0bGvvNdoWqeJ2.jweR7CiigncSvXwya','admin','admin13'),(34,NULL,'$2a$10$b..Qs3KHqCu79F8Y42NT4OzeG.61YAp9vKIF.BFQistPSOME7.CsC','admin','admin13'),(35,NULL,'$2a$10$Kfj4u8sgTMg9FDdMAbW8NumCvn9y72HDFfw983ZBSZ/9WYusZMdse','admin','admin14'),(36,NULL,'$2a$10$ZSAFVjcFmRqGhnPnLTTePuBloqxgcSSsRE9MAyD1RjV6ttZ37KhMS','admin','admin15'),(37,NULL,'$2a$10$pHAf4JOcjnx8pkooay/OfeICGICpFf9DF7mXQbH3ZbUgjGwzh52Wy','admin','newuserr'),(38,NULL,'$2a$10$262YSVCrPbV0m8lr59WWWOT7e/nL7PW8QR8dZtIy6kCg1cGydsmMa','user','user1'),(39,NULL,'$2a$10$pZKQNSPn7dQdaSaqdfuo2eIIYm5ilZ3sf3OL7apxsElXzt9i8DEYm','user','user11'),(40,NULL,'$2a$10$qssvhWPXmVCtoCeEyHO29ezGm3E7162YhrFN5HeLJUYHjcZiCmf3W','admin','user111'),(41,NULL,'$2a$10$E5XdFRPykHN77PGGNoAHquwmsYWWcpSE4I/8Io77.swx/F9lsElUe','user','user141'),(42,NULL,'$2a$10$1RUe1csLczGiJqCbs4kB7.Ou3gsl2ZqxP3j.jktVYvlfBL67iM80W','user','h1'),(43,NULL,'$2a$10$XcMDSjTq25mz5.QiKtQQH.nhyviu6pulYKuZBKs.P1i.iEIN/LeEG','user','hee'),(44,NULL,'$2a$10$QeOHuwjysLN34ZjvLGiIh.N2Gct50ewg.IZS84K576GXIKrvdnAd6','user','20apse4848'),(45,NULL,'$2a$10$iRyg/NX0TuqLX9w98pgWQOpkQAf29ElaS3oMxQ0U531RU7KSNDmL2','user','he'),(46,NULL,'$2a$10$UXxlgA8B81OS7LxmhYzhAewtopIFjiRzDSSKeazL5Y.6S2fiZWwNi','user','testuser123');
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

-- Dump completed on 2024-09-29 21:51:05
