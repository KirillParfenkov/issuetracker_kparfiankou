-- MySQL dump 10.13  Distrib 5.5.28, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: IssueTracker
-- ------------------------------------------------------
-- Server version	5.5.28-0ubuntu0.12.04.2

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
-- Table structure for table `Builds`
--

DROP TABLE IF EXISTS `Builds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Builds` (
  `id` bigint(20) unsigned NOT NULL,
  `projectId` bigint(20) unsigned NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `projectId` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Builds`
--

LOCK TABLES `Builds` WRITE;
/*!40000 ALTER TABLE `Builds` DISABLE KEYS */;
INSERT INTO `Builds` VALUES (0,0,'1.0'),(1,0,'1.1'),(2,0,'1.3'),(3,0,'2.0');
/*!40000 ALTER TABLE `Builds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comments`
--

DROP TABLE IF EXISTS `Comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comments` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `issueId` bigint(20) unsigned NOT NULL,
  `autorId` bigint(20) unsigned NOT NULL,
  `content` text,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `issueId` (`issueId`),
  KEY `autorId` (`autorId`),
  CONSTRAINT `Comments_ibfk_1` FOREIGN KEY (`issueId`) REFERENCES `Issues` (`id`),
  CONSTRAINT `Comments_ibfk_2` FOREIGN KEY (`autorId`) REFERENCES `Users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comments`
--

LOCK TABLES `Comments` WRITE;
/*!40000 ALTER TABLE `Comments` DISABLE KEYS */;
INSERT INTO `Comments` VALUES (20,6,1,'Aaaaa','2012-12-03'),(21,6,1,'Bbbb','2012-12-03'),(22,6,1,'GWT est articulÃ© autour d\'un concept original : lors de la phase de dÃ©veloppement, l\'application est Ã©crite en Java de faÃ§on classique, dans un environnement de dÃ©veloppement intÃ©grÃ© Java, et peut Ãªtre dÃ©boguÃ©e avec les outils Java habituels. Une fois l\'application prÃªte Ã  Ãªtre dÃ©ployÃ©e, le compilateur GWT la traduit en pur JavaScript, avec support automatique et transparent pour les principaux navigateurs (Internet Explorer, Firefox, Mozilla, Safari, Opera). Le code JavaScript gÃ©nÃ©rÃ© utilise des techniques d\'HTML dynamique et de manipulation du DOM (Document Object Model) pour les aspects dynamiques de l\'interface.','2012-12-03'),(23,6,1,'GWT est articulÃ© autour d\'un concept original : lors de la phase de dÃ©veloppement, l\'application est Ã©crite en Java de faÃ§on classique, dans un environnement de dÃ©veloppement intÃ©grÃ© Java, et peut Ãªtre dÃ©boguÃ©e avec les outils Java habituels. Une fois l\'application prÃªte Ã  Ãªtre dÃ©ployÃ©e, le compilateur GWT la traduit en pur JavaScript, avec support automatique et transparent pour les principaux navigateurs (Internet Explorer, Firefox, Mozilla, Safari, Opera). Le code JavaScript gÃ©nÃ©rÃ© utilise des techniques d\'HTML dynamique et de manipulation du DOM (Document Object Model) pour les aspects dynamiques de l\'interface.','2012-12-03');
/*!40000 ALTER TABLE `Comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Issues`
--

DROP TABLE IF EXISTS `Issues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Issues` (
  `id` bigint(20) unsigned NOT NULL,
  `statusId` bigint(20) unsigned NOT NULL,
  `typeId` bigint(20) unsigned NOT NULL,
  `priorityId` bigint(20) unsigned NOT NULL,
  `projectId` bigint(20) unsigned NOT NULL,
  `buildId` bigint(20) unsigned NOT NULL,
  `assigneeId` bigint(20) unsigned NOT NULL,
  `createDate` date DEFAULT NULL,
  `createrId` bigint(20) unsigned DEFAULT NULL,
  `modifyDate` date DEFAULT NULL,
  `lastModifierId` bigint(20) unsigned DEFAULT NULL,
  `resolutionId` bigint(20) unsigned DEFAULT NULL,
  `summary` text,
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Issues`
--

LOCK TABLES `Issues` WRITE;
/*!40000 ALTER TABLE `Issues` DISABLE KEYS */;
INSERT INTO `Issues` VALUES (0,0,5,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,'\n			Wrong display headers.\n		','\n			Lorem ipsum dolor sit amet, consectetuer adipiscing elit.\n			Aenean commodo ligula eget dolor. Aenean massa.\n			Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\n			Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.\n		'),(1,0,6,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,'Nulla consequat massa.','Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. '),(2,0,6,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,'Aenean leo ligula, porttitor eu.','Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. '),(3,0,6,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,'Nam quam nunc, blandit vel, luctus pulvinar.','Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante.'),(4,0,5,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,'Etiam sit amet orci eget eros faucibus','Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc.'),(5,0,6,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,'Tiam sit amet orci eget eros faucibus tincidunt. Duis leo.','Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc.'),(6,0,9,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,' Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Curabitur lacinia molestie mauris, vel adipiscing sapien suscipit sit amet. Proin tellus ante, condimentum a laoreet nec, adipiscing id magna. Proin vitae auctor purus. Cras non elit purus, vel vehicula lacus. Integer non massa nec mauris volutpat feugiat id at arcu.'),(7,0,5,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,' Phasellus at nisi varius dolor iaculis molestie non sit amet risus.','Maecenas non lacus vel leo luctus lobortis vel non nulla. Aliquam erat volutpat. In ac risus tortor. Sed nibh turpis, euismod sit amet hendrerit nec, porta ac tellus. Praesent congue, erat quis pulvinar rutrum, sapien ipsum placerat dui, ac ultricies dolor quam et mi. Cras mi diam, elementum in laoreet a, malesuada sit amet est. Nullam suscipit velit nec est lacinia id adipiscing arcu ornare.\n'),(8,0,6,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,' In aliquam, dui et gravida ullamcorper.',' In consequat, diam eu tincidunt gravida, orci dui porta libero, nec interdum tortor lorem vitae lacus. Curabitur ante nibh, consequat non iaculis a, ultrices vel quam. Donec tincidunt ultrices enim, quis elementum velit feugiat molestie. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris bibendum tortor ut libero commodo et ornare lectus tristique. Morbi eget eleifend mauris.'),(9,0,6,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,'Lorem ipsum dolor sit amet.','\n			Lorem ipsum dolor sit amet, consectetuer adipiscing elit.\n			Aenean commodo ligula eget dolor. Aenean massa.\n			Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\n			Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.\n		'),(10,0,6,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,' Donec sit amet dui eget.','Donec sit amet dui eget ipsum rhoncus pellentesque nec eget felis. Sed non lorem lacus. Duis rhoncus leo eget urna malesuada vel rutrum ipsum elementum. Sed facilisis ornare nunc, vel euismod elit interdum sed. Nunc feugiat lobortis tellus, a tincidunt ipsum laoreet sed.'),(11,0,6,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,' Maecenas dui orci.',' Maecenas dui orci, feugiat et aliquet a, ornare ut quam. Donec rhoncus sollicitudin sagittis. Ut rutrum ligula vitae est molestie non condimentum magna tincidunt. Suspendisse gravida pulvinar augue et aliquam. Sed tincidunt lacus ac metus molestie quis interdum urna fringilla.'),(12,0,5,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,'Maecenas dui orci.','Maecenas dui orci, feugiat et aliquet a, ornare ut quam. Donec rhoncus sollicitudin sagittis. Ut rutrum ligula vitae est molestie non condimentum magna tincidunt. Suspendisse gravida pulvinar augue et aliquam. Sed tincidunt lacus ac metus molestie quis interdum urna fringilla.'),(13,0,5,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,'Nullam eleifend turpis nisi.','Nullam eleifend turpis nisi, eget consectetur augue. Sed et nunc massa. Integer consequat massa sit amet felis suscipit eu accumsan magna mollis. Nunc fermentum mattis fermentum. Fusce nibh orci, blandit vitae bibendum at, malesuada eu massa.'),(14,0,6,2,0,0,0,'2012-10-06',1,'2012-10-07',0,0,'Vivamus leo sem.','Vivamus leo sem, interdum quis sollicitudin eget, placerat at quam. Aliquam erat volutpat. Curabitur bibendum quam velit, quis ultricies elit. Duis dapibus nulla eget enim auctor rutrum. Quisque ligula metus, blandit non porttitor eget, lacinia et est.'),(15,1,6,2,0,1,0,'2012-11-13',1,'2012-11-13',1,NULL,'sdfsdf','sdfsdf'),(16,1,5,1,0,2,0,'2012-11-13',1,'2012-11-13',1,NULL,'dfgdfg','dfgdfgdf'),(17,1,6,2,0,2,0,'2012-11-13',1,'2012-11-13',1,NULL,'1111111','1111111'),(18,0,5,0,0,0,0,'2012-11-13',1,'2012-11-13',1,NULL,'22222','222222'),(19,0,6,1,0,2,0,'2012-11-15',1,'2012-11-15',1,NULL,'Nulla fermentum','Pellentesque bibendum felis quis elit sagittis auctor. Mauris tincidunt pulvinar ligula, vel luctus justo pharetra quis. Maecenas non molestie mauris. Aliquam erat volutpat. Nulla fermentum diam eget magna sodales nec pulvinar felis semper. Mauris ipsum dolor, pretium eu tincidunt vitae');
/*!40000 ALTER TABLE `Issues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prioritys`
--

DROP TABLE IF EXISTS `Prioritys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Prioritys` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prioritys`
--

LOCK TABLES `Prioritys` WRITE;
/*!40000 ALTER TABLE `Prioritys` DISABLE KEYS */;
INSERT INTO `Prioritys` VALUES (0,'New'),(1,'Assigned'),(2,'Important'),(3,'Minor'),(4,'123');
/*!40000 ALTER TABLE `Prioritys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Projects`
--

DROP TABLE IF EXISTS `Projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Projects` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `menagerId` bigint(20) unsigned NOT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Projects`
--

LOCK TABLES `Projects` WRITE;
/*!40000 ALTER TABLE `Projects` DISABLE KEYS */;
INSERT INTO `Projects` VALUES (0,'Nulla consequat',1,'\n		');
/*!40000 ALTER TABLE `Projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Resolutions`
--

DROP TABLE IF EXISTS `Resolutions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Resolutions` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resolutions`
--

LOCK TABLES `Resolutions` WRITE;
/*!40000 ALTER TABLE `Resolutions` DISABLE KEYS */;
INSERT INTO `Resolutions` VALUES (0,'Fixed'),(1,'Invalid'),(2,'Wonrfix'),(3,'Worksforme'),(4,'123');
/*!40000 ALTER TABLE `Resolutions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Roles`
--

DROP TABLE IF EXISTS `Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Roles` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Roles`
--

LOCK TABLES `Roles` WRITE;
/*!40000 ALTER TABLE `Roles` DISABLE KEYS */;
INSERT INTO `Roles` VALUES (0,'ADMINISTRATOR'),(1,'USER'),(2,'GUEST');
/*!40000 ALTER TABLE `Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Statuses`
--

DROP TABLE IF EXISTS `Statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Statuses` (
  `id` bigint(20) unsigned DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `id_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Statuses`
--

LOCK TABLES `Statuses` WRITE;
/*!40000 ALTER TABLE `Statuses` DISABLE KEYS */;
INSERT INTO `Statuses` VALUES (0,'New'),(1,'Assigned'),(2,'Progress'),(3,'Resolved'),(4,'Closed'),(5,'Reopend');
/*!40000 ALTER TABLE `Statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Types`
--

DROP TABLE IF EXISTS `Types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Types` (
  `id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Types`
--

LOCK TABLES `Types` WRITE;
/*!40000 ALTER TABLE `Types` DISABLE KEYS */;
INSERT INTO `Types` VALUES (1,'123wse'),(5,'Cosmetic'),(6,'Bug'),(7,'Feature'),(8,'Performance'),(9,'123'),(10,'q3e'),(11,'123');
/*!40000 ALTER TABLE `Types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `id` bigint(20) unsigned NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `roleId` bigint(20) unsigned NOT NULL,
  `emailAddress` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `Users_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `Roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (0,'Tom','Smith',1,'Tom.Smith@gmail.com','1234567'),(1,'Linus','Torvalds',0,'torvalds@klaava.Helsinki.Fi','1234567'),(2,'Bbbbb','Aaaaaf',1,'AddddBbbbbb@aaa.a','1234567'),(3,'Scot','Tom',1,'TomScot@gmail.com','1234567'),(4,'Jon','Smit',0,'Jon.Smit@gmail.com','1234567');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-12-03 17:57:57
