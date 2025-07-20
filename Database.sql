CREATE DATABASE  IF NOT EXISTS `cafemanagementsystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cafemanagementsystem`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: cafemanagementsystem
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
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `branch_id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(100) NOT NULL,
  `email` varchar(254) NOT NULL,
  `Telephone` varchar(20) NOT NULL,
  PRIMARY KEY (`branch_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Kolonnawa','kolonnawagnw@gmail.com','0112445678');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bulk_order`
--

DROP TABLE IF EXISTS `bulk_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bulk_order` (
  `order_id` int NOT NULL,
  `cus_id` int NOT NULL,
  `due_date` date NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `cus_id` (`cus_id`),
  CONSTRAINT `bulk_order_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE,
  CONSTRAINT `bulk_order_ibfk_2` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bulk_order`
--

LOCK TABLES `bulk_order` WRITE;
/*!40000 ALTER TABLE `bulk_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `bulk_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint` (
  `comp_id` int NOT NULL AUTO_INCREMENT,
  `made_date` date NOT NULL,
  `description` text,
  `status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`comp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
INSERT INTO `complaint` VALUES (2,'2025-03-01','This is about my salary','Reviewed');
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `cus_id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `address_line1` varchar(50) NOT NULL,
  `address_line2` varchar(50) NOT NULL,
  `tele` varchar(15) NOT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Amarabandu','Rupasinghe','No 113','Rajagiriya','0781291928');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense`
--

DROP TABLE IF EXISTS `expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense` (
  `expense_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `made_date` date NOT NULL,
  `made_time` time NOT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`expense_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense`
--

LOCK TABLES `expense` WRITE;
/*!40000 ALTER TABLE `expense` DISABLE KEYS */;
INSERT INTO `expense` VALUES (1,'Electricity Bill','2025-03-04','20:15:43',4300.00),(2,'Electricity Bill','2025-03-04','20:45:34',50000.00),(3,'Salary','2025-03-04','22:47:28',610000.00),(4,'Salary','2025-03-04','22:50:45',607000.00),(5,'Salary','2025-03-04','22:56:08',73176.00),(6,'Salary','2025-03-04','22:57:08',84000.00),(7,'Salary','2025-03-04','22:57:59',78500.00),(8,'Supplier','2025-03-05','00:37:04',4310.00);
/*!40000 ALTER TABLE `expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_log`
--

DROP TABLE IF EXISTS `expense_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_log` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `expense_id` int NOT NULL,
  `action` varchar(10) NOT NULL,
  `change_date` date NOT NULL,
  `change_time` time NOT NULL,
  `old_amount` decimal(10,2) DEFAULT NULL,
  `new_amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`log_id`),
  KEY `expense_id` (`expense_id`),
  CONSTRAINT `expense_log_ibfk_1` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_log`
--

LOCK TABLES `expense_log` WRITE;
/*!40000 ALTER TABLE `expense_log` DISABLE KEYS */;
INSERT INTO `expense_log` VALUES (1,1,'Insert','2025-03-04','20:15:43',0.00,128.00),(2,2,'Insert','2025-03-04','20:45:34',0.00,50000.00),(3,1,'Update','2025-03-04','20:45:40',128.00,0.00),(4,1,'Update','2025-03-04','20:50:38',128.00,4300.00),(5,3,'Insert','2025-03-04','22:47:28',0.00,610000.00),(6,4,'Insert','2025-03-04','22:50:45',0.00,607000.00),(7,5,'Insert','2025-03-04','22:56:08',0.00,73176.00),(8,6,'Insert','2025-03-04','22:57:08',0.00,84000.00),(9,7,'Insert','2025-03-04','22:57:59',0.00,78500.00),(10,8,'Insert','2025-03-05','00:37:04',0.00,4310.00);
/*!40000 ALTER TABLE `expense_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory_item`
--

DROP TABLE IF EXISTS `inventory_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory_item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `type` varchar(15) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int NOT NULL,
  `unit` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_item`
--

LOCK TABLES `inventory_item` WRITE;
/*!40000 ALTER TABLE `inventory_item` DISABLE KEYS */;
INSERT INTO `inventory_item` VALUES (1,'Computer','Non-Ingredient',200000.00,3,'pcs'),(4,'Floar','Ingredient',30000.00,100,'kg'),(5,'Cocunut Oil','Ingredient',30000.00,100,'L'),(6,'Computer Table','Non-Ingredient',45600.00,1,'pcs'),(7,'Vanilla Syrup','Ingredient',250.00,21,'L');
/*!40000 ALTER TABLE `inventory_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_product`
--

DROP TABLE IF EXISTS `item_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_product` (
  `product_id` char(20) NOT NULL,
  `item_id` int NOT NULL,
  PRIMARY KEY (`product_id`,`item_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `item_product_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE,
  CONSTRAINT `item_product_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `inventory_item` (`item_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_product`
--

LOCK TABLES `item_product` WRITE;
/*!40000 ALTER TABLE `item_product` DISABLE KEYS */;
INSERT INTO `item_product` VALUES ('PDCT-1000',4);
/*!40000 ALTER TABLE `item_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kot`
--

DROP TABLE IF EXISTS `kot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kot` (
  `kot_id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(20) DEFAULT NULL,
  `order_id` int NOT NULL,
  `user_id` char(20) DEFAULT NULL,
  PRIMARY KEY (`kot_id`),
  KEY `user_id` (`user_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `kot_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `kot_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kot`
--

LOCK TABLES `kot` WRITE;
/*!40000 ALTER TABLE `kot` DISABLE KEYS */;
INSERT INTO `kot` VALUES (1,NULL,1,'USER-1004'),(2,NULL,2,'USER-1004'),(3,NULL,3,'USER-1004'),(4,NULL,4,'USER-1004'),(5,NULL,5,'USER-1004');
/*!40000 ALTER TABLE `kot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_sheet`
--

DROP TABLE IF EXISTS `log_sheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_sheet` (
  `sheet_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(25) NOT NULL,
  `made_date` date NOT NULL,
  `description` text,
  `user_id` char(20) NOT NULL,
  PRIMARY KEY (`sheet_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `log_sheet_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_sheet`
--

LOCK TABLES `log_sheet` WRITE;
/*!40000 ALTER TABLE `log_sheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_sheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `user_id` char(20) NOT NULL,
  `logged_time` time NOT NULL,
  `logged_date` date NOT NULL,
  PRIMARY KEY (`user_id`,`logged_time`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('USER-1001','04:55:59','2025-03-05'),('USER-1001','04:57:39','2025-03-05'),('USER-1001','05:11:13','2025-03-05'),('USER-1001','05:20:34','2025-03-05'),('USER-1001','09:38:32','2025-03-05'),('USER-1001','09:45:52','2025-03-05'),('USER-1001','16:33:21','2025-03-02'),('USER-1001','22:30:38','2025-03-01'),('USER-1003','02:43:55','2025-03-04'),('USER-1003','18:07:53','2025-03-02'),('USER-1003','18:09:47','2025-03-02'),('USER-1006','09:05:27','2025-03-05'),('USER-1006','09:51:13','2025-03-05');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `note_id` int NOT NULL AUTO_INCREMENT,
  `user_id` char(20) NOT NULL,
  `made_date` date NOT NULL,
  `description` text,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`note_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (1,'USER-1001','2025-03-04','Come to my office asap','Pendng');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `made_date` date NOT NULL,
  `made_time` time NOT NULL,
  `order_type` varchar(15) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `amount` decimal(10,2) NOT NULL,
  `service_charge` decimal(10,2) DEFAULT NULL,
  `discount` decimal(5,2) DEFAULT NULL,
  `tax` decimal(5,2) DEFAULT NULL,
  `total` decimal(10,2) NOT NULL,
  `user_id` char(20) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2025-03-05','04:27:50','Pick me','Completed',680.00,100.00,0.00,13.60,793.60,NULL),(2,'2025-03-05','04:35:40','Delivary','Completed',680.00,100.00,0.00,13.60,793.60,NULL),(3,'2025-03-05','04:36:22','Delivary','Completed',1480.00,100.00,0.00,29.60,1609.60,NULL),(4,'2025-03-05','05:45:55','Uber','Completed',680.00,100.00,0.00,13.60,793.60,NULL),(5,'2025-03-05','09:06:45','Pick me','Completed',400.00,100.00,0.00,8.00,508.00,NULL);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` char(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `description` text,
  `price` decimal(10,2) NOT NULL,
  `availability` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('PDCT-1000','Caremal Nut','Regular','Caremal topped dount with penuts',340.00,1),('PDCT-1001','HotDog','Hot-Dogs','Sausage bun with sause',400.00,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_order`
--

DROP TABLE IF EXISTS `product_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_order` (
  `order_id` int NOT NULL,
  `product_id` char(20) NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_order_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE,
  CONSTRAINT `product_order_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_order`
--

LOCK TABLES `product_order` WRITE;
/*!40000 ALTER TABLE `product_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `user_id` char(20) NOT NULL,
  `made_time` time NOT NULL,
  `date` date NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`made_time`),
  CONSTRAINT `report_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `req_id` int NOT NULL AUTO_INCREMENT,
  `made_date` date NOT NULL,
  `description` text,
  `status` varchar(15) DEFAULT NULL,
  `user_id` char(20) DEFAULT NULL,
  `branch_id` int DEFAULT NULL,
  PRIMARY KEY (`req_id`),
  KEY `user_id` (`user_id`),
  KEY `branch_id` (`branch_id`),
  CONSTRAINT `request_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `request_ibfk_2` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1,'2025-03-01','I want a 3 days leave for take care of my mother','Approved','USER-1001',NULL);
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `expense_id` int NOT NULL,
  `user_id` char(20) NOT NULL,
  `bonus` decimal(10,2) NOT NULL DEFAULT '0.00',
  `deductions` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`expense_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`) ON DELETE CASCADE,
  CONSTRAINT `salary_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (7,'USER-1006',4500.00,2500.00);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_log`
--

DROP TABLE IF EXISTS `stock_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_log` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `item_id` int NOT NULL,
  `action` varchar(10) NOT NULL,
  `change_date` date NOT NULL,
  `change_time` time NOT NULL,
  `old_quantity` int DEFAULT NULL,
  `new_quantity` int DEFAULT NULL,
  PRIMARY KEY (`log_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `stock_log_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `inventory_item` (`item_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_log`
--

LOCK TABLES `stock_log` WRITE;
/*!40000 ALTER TABLE `stock_log` DISABLE KEYS */;
INSERT INTO `stock_log` VALUES (1,7,'Insert','2025-03-04','17:37:47',0,10),(2,7,'Update','2025-03-04','17:45:37',10,21);
/*!40000 ALTER TABLE `stock_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `supp_id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `address_line1` varchar(50) NOT NULL,
  `address_line2` varchar(50) DEFAULT NULL,
  `email` varchar(254) NOT NULL,
  PRIMARY KEY (`supp_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'Saman','Edirimuni','Ep 1273477','Second Inning Lane','ediriya@gmail.com');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_contact`
--

DROP TABLE IF EXISTS `supplier_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier_contact` (
  `supp_id` int NOT NULL,
  `tele` varchar(15) NOT NULL,
  PRIMARY KEY (`supp_id`,`tele`),
  CONSTRAINT `supplier_contact_ibfk_1` FOREIGN KEY (`supp_id`) REFERENCES `supplier` (`supp_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_contact`
--

LOCK TABLES `supplier_contact` WRITE;
/*!40000 ALTER TABLE `supplier_contact` DISABLE KEYS */;
INSERT INTO `supplier_contact` VALUES (1,'0754151451'),(1,'0763636123'),(1,'343432');
/*!40000 ALTER TABLE `supplier_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_item`
--

DROP TABLE IF EXISTS `supplier_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier_item` (
  `supp_id` int NOT NULL,
  `item_id` int NOT NULL,
  PRIMARY KEY (`supp_id`,`item_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `supplier_item_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `inventory_item` (`item_id`) ON DELETE CASCADE,
  CONSTRAINT `supplier_item_ibfk_2` FOREIGN KEY (`supp_id`) REFERENCES `supplier` (`supp_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_item`
--

LOCK TABLES `supplier_item` WRITE;
/*!40000 ALTER TABLE `supplier_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_purchase`
--

DROP TABLE IF EXISTS `supplier_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier_purchase` (
  `expense_id` int NOT NULL,
  `item_id` int NOT NULL,
  `supplier_id` int NOT NULL,
  `invoice_number` varchar(50) NOT NULL,
  `discount` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`expense_id`),
  UNIQUE KEY `invoice_number` (`invoice_number`),
  KEY `item_id` (`item_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `supplier_purchase_ibfk_1` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`) ON DELETE CASCADE,
  CONSTRAINT `supplier_purchase_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `inventory_item` (`item_id`) ON DELETE CASCADE,
  CONSTRAINT `supplier_purchase_ibfk_3` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supp_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_purchase`
--

LOCK TABLES `supplier_purchase` WRITE;
/*!40000 ALTER TABLE `supplier_purchase` DISABLE KEYS */;
INSERT INTO `supplier_purchase` VALUES (8,5,1,'INV-12345',250.00);
/*!40000 ALTER TABLE `supplier_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `task_id` int NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `user_id` char(20) NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (2,'Count the inventory','2025-03-03','Pending','USER-1001'),(4,'Watch the match','2025-03-01','Completed','USER-1001');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_sheet`
--

DROP TABLE IF EXISTS `time_sheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_sheet` (
  `user_id` char(20) NOT NULL,
  `date` date NOT NULL,
  `clockin_time` time NOT NULL,
  `clockoff_time` time DEFAULT NULL,
  PRIMARY KEY (`user_id`,`date`),
  CONSTRAINT `time_sheet_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_sheet`
--

LOCK TABLES `time_sheet` WRITE;
/*!40000 ALTER TABLE `time_sheet` DISABLE KEYS */;
INSERT INTO `time_sheet` VALUES ('USER-1001','2025-03-01','17:08:38','17:19:44');
/*!40000 ALTER TABLE `time_sheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` char(20) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `nic` char(15) NOT NULL,
  `address_line1` varchar(50) NOT NULL,
  `address_line2` varchar(50) NOT NULL,
  `email` varchar(254) NOT NULL,
  `role` varchar(20) NOT NULL,
  `password` varchar(70) NOT NULL,
  `salary` decimal(10,2) NOT NULL,
  `salt_no` int NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('USER-1000','Ransilu','Ranasinghe','1234567890','No 123','Kotikawathta','rdinistha@gmail.com','Administrator','6a896a062979aef165d856dabcc5550dbab6ff9be3743773ce72d62822f0fbcc',600000.00,892),('USER-1001','Ransilu','Ranasinghe','2410140144120','Welikada Road','Rajagiriya','rdinistha@gmail.com','Employee','91b0b801a826e7705c8dcbb33fae92377c53f44b1687a848bbeb2a74b3a2d5c4',250000.00,105),('USER-1002','Vidu','Nisalitha','1234567890123','Malwana','Kaduwela','rdinistha@gmail.com','Employee','6d389cd8d6b24bbd68cf399d04ee1e4bead0b6746b767807cbdc4370d2edc7d5',750000.00,405),('USER-1003','Saman','Kumara','1213213243546','No 435','Galahitiyawa','rdinistha@gmail.com','Supervisor','689a79a91c70077e195faad0dd364eaeefe88c5ce253ff5c4a1368f57cecccf4',600000.00,949),('USER-1004','Paul','Wilson','2323545657687','ffgsgth','ghgf','rdinistha@gmail.com','Head Chef','25334f41cb4270d8b96665dd76127d5d75df6920ae7f4ac4daadf399633dc090',4354354.00,665),('USER-1005','tretr','grdgdfgfdggf','5122','fgfg','gdfgdr','denura.minulaka@gmail.com','Employee','c2d054649e1195ef29b44ef9f6ea9646135d382ffab6b2f8bb964d6cfe5e6de3',100.00,303),('USER-1006','Chaniru','Dewnith','1213243546566','kdksdkokf','fdfdfjdjfkjdk','chanirudewnith@gmail.com','Accountant','c7dc976e50583399c0fcafd20b371528f144dae7a2181b066f65f38413a86adc',76500.00,714),('USER-1007','Gawranga','Fenando','8888888888888','kjcdjkdv','hsuhdjh','nikeshalagawranga8@gmail.com','Administrator','7f2d84c300cfedbf85eaf55e62efc909a195d4b956071839c325f20d114d02d5',200.00,703);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_contact`
--

DROP TABLE IF EXISTS `user_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_contact` (
  `user_id` char(20) NOT NULL,
  `tele` varchar(15) NOT NULL,
  PRIMARY KEY (`user_id`,`tele`),
  CONSTRAINT `user_contact_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_contact`
--

LOCK TABLES `user_contact` WRITE;
/*!40000 ALTER TABLE `user_contact` DISABLE KEYS */;
INSERT INTO `user_contact` VALUES ('USER-1000','0712345678'),('USER-1000','0721111111'),('USER-1001','1234384743'),('USER-1001','7362736219'),('USER-1002','0782819191'),('USER-1002','0789753627'),('USER-1003','0761521545'),('USER-1003','0791829120'),('USER-1004','4344234234'),('USER-1004','5435456657'),('USER-1005','1554551'),('USER-1005','55511'),('USER-1006','1212343454'),('USER-1006','7675643534'),('USER-1007','00');
/*!40000 ALTER TABLE `user_contact` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-20 20:02:00
