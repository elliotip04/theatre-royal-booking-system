-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: theater
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL,
  `ticket_id` int NOT NULL,
  `ticket_total` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `booking_ticket_id_idx` (`ticket_id`),
  CONSTRAINT `booking_ticket_id` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL,
  `amount` int NOT NULL,
  `remote_transaction_id` int NOT NULL,
  `payment_method` int NOT NULL,
  `booking_id` int NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `payment_booking_id_idx` (`booking_id`),
  CONSTRAINT `payment_booking_id` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performance`
--

DROP TABLE IF EXISTS `performance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performance` (
  `performance_id` int NOT NULL,
  `show_id` int NOT NULL,
  `performance_date` date NOT NULL,
  `matinee_evening` varchar(45) NOT NULL,
  `start_time` time NOT NULL,
  `stall_seats_av` int NOT NULL,
  `circle_seats_av` int NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `price_concession` decimal(15,2) NOT NULL,
  PRIMARY KEY (`performance_id`),
  KEY `performance_show_id_idx` (`show_id`),
  CONSTRAINT `performance_show_id` FOREIGN KEY (`show_id`) REFERENCES `show` (`show_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performance`
--

LOCK TABLES `performance` WRITE;
/*!40000 ALTER TABLE `performance` DISABLE KEYS */;
INSERT INTO `performance` VALUES (1,1,'2022-12-13','Matinee','14:00:00',120,80,20.00,15.00),(2,1,'2022-12-13','Evening','19:00:00',120,80,25.00,18.75),(3,1,'2022-12-14','Matinee','14:00:00',120,80,20.00,15.00),(4,1,'2022-12-14','Evening','19:00:00',120,80,25.00,18.75),(5,2,'2022-12-15','Matinee','13:00:00',120,80,40.00,30.00),(6,2,'2022-12-15','Evening','19:00:00',120,80,50.00,37.50),(7,3,'2022-12-20','Evening','17:00:00',120,80,60.00,45.00),(8,4,'2022-12-27','Evening','17:00:00',120,80,60.00,45.00),(9,5,'2022-01-28','Evening','19:00:00',120,80,35.00,26.25),(10,6,'2023-02-02','Evening','19:30:00',120,80,30.00,22.50),(11,6,'2023-02-03','Evening','19:30:00',120,80,30.00,22.50);
/*!40000 ALTER TABLE `performance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `show`
--

DROP TABLE IF EXISTS `show`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `show` (
  `show_id` int NOT NULL,
  `show_name` varchar(100) NOT NULL,
  `show_type` varchar(45) NOT NULL,
  `show_description` text NOT NULL,
  `show_duration` varchar(45) NOT NULL,
  `show_language` varchar(45) NOT NULL,
  PRIMARY KEY (`show_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `show`
--

LOCK TABLES `show` WRITE;
/*!40000 ALTER TABLE `show` DISABLE KEYS */;
INSERT INTO `show` VALUES (1,'Frozen The Musical','Musical','Prepare to fall in love with Disney’s FROZEN all over again! Incredible special effects, stunning costumes and jaw-dropping scenery bring Elsa and Anna’s journey to life in a whole new way. And with all the beloved songs from the movie – as well as a few surprises from the writers behind Let it Go – you’ll be transported to Arendelle from the moment the curtain rises.','2 hours 15 minutes','English'),(2,'Henry V','Theater','Henry, the young and newly crowned king, is impatient to assert control over the people of England. Having received a humiliating gift from overseas, his bruised ego leads him to double down on a military invasion abroad in a bid to expand his green and pleasant land. But at what devastating cost?','2 hours 30 minutes','English'),(3,'Tosca','Opera','Set in Rome, 1800, Puccini\'s sweeping operatic thriller combines romance, Revolution, and a devastating twist.','3 hours','Italian'),(4,'Carmen','Opera','Carmen: a woman ablaze with passion, surrounded by men possessed by obsession and jealousy. One of opera’s most well-known characters sets herself on a road to tragedy when she meets Don José, a corporal in the army searching for love.','2 hours 45 minutes','English'),(5,'Bright Eyes','Concert','Having returned to live shows for the first time in over a decade this past summer, Bright Eyes are prepared to hit the road again The tour will be a continuation of shows performing songs from their most recent album, Down in the Weeds, Where the World Once Was, as well as selections from across their catalog.','3 hours ','English'),(6,'Stormzy','Concert','Stormzy brings his rescheduled ‘Heavy Is The Head’ tour to our stage, plus support from Rachael Anson.','2 hours 30 minutes','English');
/*!40000 ALTER TABLE `show` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `ticket_id` int NOT NULL,
  `performance_id` int NOT NULL,
  `stall_standard` int NOT NULL,
  `stall_under16` int NOT NULL,
  `stall_student` int NOT NULL,
  `stall_senior` int NOT NULL,
  `circle_standard` int DEFAULT NULL,
  `circle_under16` int NOT NULL,
  `circle_student` int NOT NULL,
  `circle_senior` int NOT NULL,
  `tickets_total` int NOT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `ticket_performance_id_idx` (`performance_id`),
  CONSTRAINT `ticket_performance_id` FOREIGN KEY (`performance_id`) REFERENCES `performance` (`performance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets_sold`
--

DROP TABLE IF EXISTS `tickets_sold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets_sold` (
  `tickets_sold_id` int NOT NULL AUTO_INCREMENT,
  `performance_id` int NOT NULL,
  `booking_id` int NOT NULL,
  `seat_type` varchar(45) NOT NULL,
  `number_of_tickets_sold` int NOT NULL,
  PRIMARY KEY (`tickets_sold_id`),
  KEY `tickets_sold_performance_id_idx` (`performance_id`),
  KEY `tickets_sold_booking_id_idx` (`booking_id`),
  CONSTRAINT `tickets_sold_booking_id` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`),
  CONSTRAINT `tickets_sold_performance_id` FOREIGN KEY (`performance_id`) REFERENCES `performance` (`performance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets_sold`
--

LOCK TABLES `tickets_sold` WRITE;
/*!40000 ALTER TABLE `tickets_sold` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets_sold` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'theater'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-11 18:29:50
