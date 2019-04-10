CREATE DATABASE  IF NOT EXISTS `projectdawa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `projectdawa`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projectdawa
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
-- Table structure for table `cd`
--

DROP TABLE IF EXISTS `cd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cd` (
  `Referencia` int(11) NOT NULL,
  `Titulo` varchar(45) DEFAULT NULL,
  `Autor` varchar(45) DEFAULT NULL,
  `Ano` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Referencia`),
  CONSTRAINT `Referencia` FOREIGN KEY (`Referencia`) REFERENCES `item` (`referencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cd`
--

LOCK TABLES `cd` WRITE;
/*!40000 ALTER TABLE `cd` DISABLE KEYS */;
INSERT INTO `cd` VALUES (1,'bohemian rhapsody','Queen','1975'),(2,'thriller','Michael Jackson','1982'),(3,'nevermind','Nirvana','1991'),(4,'highway to hell','ACDC','1979');
/*!40000 ALTER TABLE `cd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `inventario` (
  `Referencia` int(11) NOT NULL,
  `Stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`Referencia`),
  CONSTRAINT `RefItem` FOREIGN KEY (`Referencia`) REFERENCES `item` (`referencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
INSERT INTO `inventario` VALUES (1,5),(2,3),(3,8),(4,1);
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `item` (
  `Referencia` int(11) NOT NULL,
  `Precio` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`Referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,3.50),(2,3.50),(3,4.60),(4,13.20);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemspedido`
--

DROP TABLE IF EXISTS `itemspedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `itemspedido` (
  `id` int(11) NOT NULL,
  `Referencia` int(11) NOT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`Referencia`,`id`),
  KEY `Referencia_idx` (`Referencia`) /*!80000 INVISIBLE */,
  KEY `id_idx` (`id`),
  CONSTRAINT `ReferenciaItem` FOREIGN KEY (`Referencia`) REFERENCES `item` (`referencia`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemspedido`
--

LOCK TABLES `itemspedido` WRITE;
/*!40000 ALTER TABLE `itemspedido` DISABLE KEYS */;
INSERT INTO `itemspedido` VALUES (2,1,1),(3,2,2),(4,2,1),(1,3,1),(4,4,1);
/*!40000 ALTER TABLE `itemspedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Precio` decimal(18,2) DEFAULT NULL,
  `Fecha` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Email_idx` (`Email`),
  CONSTRAINT `Email` FOREIGN KEY (`Email`) REFERENCES `usuario` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,4.60,'02/04/2019','miguel@mail.com'),(2,3.50,'12/03/2019','miguel@mail.com'),(3,7.00,'02/04/2019','ra@mail.com'),(4,16.70,'02/04/2019','carlos@mail.com');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tarjeta` (
  `Numero` varchar(16) NOT NULL,
  `Vencimiento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
INSERT INTO `tarjeta` VALUES ('1111111111111111','12/21'),('2222222222222222','12/21'),('3333333333333333','12/21'),('4444444444444444','12/21'),('5555555555555555','12/21');
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `Nombre` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Contrasena` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `VIP` tinyint(4) DEFAULT '0',
  `Tipo` varchar(45) DEFAULT 'Cliente',
  `Tarjeta` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`Email`),
  KEY `Tarjeta_idx` (`Tarjeta`),
  CONSTRAINT `Tarjeta` FOREIGN KEY (`Tarjeta`) REFERENCES `tarjeta` (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('Admin','admin@mail.com','1234','falsa 1234',NULL,'admin','5555555555555555'),('Carlos','carlos@mail.com','1111','falsa 1234',0,'Cliente','3333333333333333'),('Fernando','fer@mail.com','1111','falsa 1234',0,'Cliente','4444444444444444'),('Miguel','miguel@mail.com','1111','falsa 1234',1,'Cliente','1111111111111111'),('Raquel','ra@mail.com','1111','falsa 1234',1,'Cliente','2222222222222222');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoracion`
--

DROP TABLE IF EXISTS `valoracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `valoracion` (
  `email` varchar(45) NOT NULL,
  `referencia` int(11) NOT NULL,
  `valoracion` int(11) DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`,`referencia`),
  KEY `referencia_idx` (`referencia`),
  CONSTRAINT `item` FOREIGN KEY (`referencia`) REFERENCES `item` (`referencia`),
  CONSTRAINT `usuario` FOREIGN KEY (`email`) REFERENCES `usuario` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoracion`
--

LOCK TABLES `valoracion` WRITE;
/*!40000 ALTER TABLE `valoracion` DISABLE KEYS */;
/*!40000 ALTER TABLE `valoracion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-10 17:51:38
