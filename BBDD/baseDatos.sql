/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `projectdawa` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `projectdawa`;

CREATE TABLE IF NOT EXISTS `cd` (
  `Referencia` int(11) NOT NULL,
  `Titulo` varchar(45) DEFAULT NULL,
  `Autor` varchar(45) DEFAULT NULL,
  `Ano` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Referencia`),
  CONSTRAINT `Referencia` FOREIGN KEY (`Referencia`) REFERENCES `item` (`referencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `cliente` (
  `email` varchar(45) NOT NULL,
  `tarjeta` varchar(16) DEFAULT NULL,
  `vip` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`email`),
  KEY `tarjeta` (`tarjeta`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`email`) REFERENCES `usuario` (`Email`),
  CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`tarjeta`) REFERENCES `tarjeta` (`Numero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `inventario` (
  `Referencia` int(11) NOT NULL,
  `Stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`Referencia`),
  CONSTRAINT `RefItem` FOREIGN KEY (`Referencia`) REFERENCES `item` (`referencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `item` (
  `Referencia` int(11) NOT NULL,
  `Precio` decimal(18,2) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL,
  PRIMARY KEY (`Referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `itemspedido` (
  `id` int(11) NOT NULL,
  `Referencia` int(11) NOT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`Referencia`,`id`),
  KEY `Referencia_idx` (`Referencia`),
  KEY `id_idx` (`id`),
  CONSTRAINT `ReferenciaItem` FOREIGN KEY (`Referencia`) REFERENCES `item` (`Referencia`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Precio` decimal(18,2) DEFAULT NULL,
  `Fecha` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Email_idx` (`Email`),
  CONSTRAINT `Email` FOREIGN KEY (`Email`) REFERENCES `usuario` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `tarjeta` (
  `Numero` varchar(16) NOT NULL,
  `Vencimiento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Numero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `usuario` (
  `Nombre` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Contrasena` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `valoracion` (
  `email` varchar(45) NOT NULL,
  `referencia` int(11) NOT NULL,
  `valoracion` int(11) DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`,`referencia`),
  KEY `referencia_idx` (`referencia`),
  CONSTRAINT `item` FOREIGN KEY (`referencia`) REFERENCES `item` (`Referencia`),
  CONSTRAINT `usuario` FOREIGN KEY (`email`) REFERENCES `usuario` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
