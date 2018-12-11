CREATE DATABASE  IF NOT EXISTS `surreystack` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `surreystack`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: surreystack
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `comments` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `body` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `post_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FKh4c7lvsc298whoyd4w9ta25cr` (`post_id`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKh4c7lvsc298whoyd4w9ta25cr` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (18,'You\'re wrong i prefer java','2018-12-11 10:50:03',17,16),(19,'This is a good one: https://www.w3schools.com/python/','2018-12-11 10:50:42',19,16),(20,'Try Netbeans depending on what you\'re doing','2018-12-11 10:51:14',23,16),(21,'Pollock is good','2018-12-11 10:51:37',22,16),(22,'Marie Currie','2018-12-11 10:53:03',20,16),(23,'Marie Currie is an icon','2018-12-11 10:57:12',20,18),(24,'no you\'re not','2018-12-11 10:58:14',27,7),(28,'You\'re a admin i\'m \"THE\" admin','2018-12-11 11:44:58',29,7),(29,'I am a comment on someone else\'s post.','2018-12-11 11:47:15',29,21),(30,'Here\'s a comment','2018-12-11 11:52:23',30,16);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `posts` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `body` longtext NOT NULL,
  `date` datetime NOT NULL,
  `title` varchar(300) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `FKs4cmg1y2l0psdmnk2ai71urwn` (`tag_id`),
  KEY `FK5lidm6cqbc7u4xhqpxm898qme` (`user_id`),
  CONSTRAINT `FK5lidm6cqbc7u4xhqpxm898qme` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKs4cmg1y2l0psdmnk2ai71urwn` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (16,'accounting post body','2018-12-08 10:16:27','accounting post title',1,15),(17,'C++ all the way ','2018-12-11 10:44:31','Java or C++',12,15),(18,'I just don\'t get it.','2018-12-11 10:44:56','Can someone help explain abstraction?',12,15),(19,'I want to learn the basics7','2018-12-11 10:47:30','Does anyone know a good tutorial for python',12,15),(20,'I\'d love to hear everyones favourite','2018-12-11 10:48:23','Who is your favourite chemist',8,15),(21,'Who wants to be added to my group chat?','2018-12-11 10:48:44','Nutrition group chat?',9,15),(22,'Mine is Picasso','2018-12-11 10:49:05','Who\'s your favourite artist?',5,15),(23,'CAn anyone reccomend a different IDE','2018-12-11 10:49:48','I am not a fan of eclipse',12,16),(24,'I\'m lost','2018-12-11 10:54:00','Can anyone explain trigonometry to me please',4,16),(26,'Java post body','2018-12-11 10:56:40','Java is so fun',12,18),(27,'i\'m an admin','2018-12-11 10:57:47','Admin Post test',12,18),(29,'I am the admin','2018-12-11 11:43:16','Actual admin post test',1,19),(30,'This is a body','2018-12-11 11:51:48','This is a post',13,21);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `roles` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(30) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `UK_jdhyvh8di85ai37phukfemdnx` (`rolename`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `tags` (
  `tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `UK_t48xdq560gs3gap9g7jg36kgc` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES (1,'accounting'),(5,'art'),(9,'biology'),(8,'chemistry'),(12,'Computer Science'),(7,'dance'),(13,'Deletemeid13'),(11,'drama'),(4,'maths'),(6,'science'),(10,'tag name');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(100) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (7,'admin','$2a$10$0tGSGeD3rtykORF08N1Eb.i9C0P8lW8SdB8sxGYI84gviCAgq.iQG','admin',1),(15,'ignas','$2a$10$YEMdbDSHlaM1Gz3uwUoAXuVwvk9FC32Gewpp09fMreiA3bAk7jr1.','ignas',2),(16,'arun1','$2a$10$tg3Y8nouqy.w9P5uI6049Oqb28LLVjKCMHmrG25VgYrECT7tgGsEa','arun1',2),(17,'liam kenny ','$2a$10$Ux3K5mtDD4xsy5tTbDhKGe7N..ehO0PhhWFPRcSeIJc7.D5BwHs9m','liamk',2),(18,'maddie','$2a$10$lm1dDeV9pnuRtGyfNvN6OeMG1uEYB1bEBpif8ExQahMuZ4zDpDqA.','maddie',2),(19,'tester','$2a$10$ZM269N3.BHQTlVHoPZcvYOm6Gg0AlzRF0SD.fN3zmu.NoUgzsGY4.','tester',1),(21,'user21','$2a$10$JtP8P8IzgsVjo9ulXuxNGenUZ60uJ5ttk/RkyDx2A6WufUJZW6Deu','user21',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-11 11:55:16
