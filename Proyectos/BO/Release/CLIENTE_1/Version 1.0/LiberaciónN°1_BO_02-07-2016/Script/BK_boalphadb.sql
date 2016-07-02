CREATE DATABASE  IF NOT EXISTS `boalphadb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `boalphadb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: boalphadb
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `capacitador`
--

DROP TABLE IF EXISTS `capacitador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `capacitador` (
  `idCapacitador` int(11) NOT NULL AUTO_INCREMENT,
  `CapacitadorNombre` varchar(45) DEFAULT NULL,
  `CapacitadorApellidos` varchar(45) DEFAULT NULL,
  `CapacitadorCorreo` varchar(45) DEFAULT NULL,
  `CapacitadorDireccion` varchar(45) DEFAULT NULL,
  `CapacitadorMovil` varchar(15) DEFAULT NULL,
  `CapacitadorFijo` varchar(15) DEFAULT NULL,
  `CapacitadorEstado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCapacitador`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capacitador`
--

LOCK TABLES `capacitador` WRITE;
/*!40000 ALTER TABLE `capacitador` DISABLE KEYS */;
INSERT INTO `capacitador` VALUES (1,'Juan','Perez','jperez@mail.com','lima','987654321','1234567','1'),(2,'Carlos','Garcia','carlos@mail.com','miraflores','987456345','3818798','1');
/*!40000 ALTER TABLE `capacitador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `idCargo` int(11) NOT NULL AUTO_INCREMENT,
  `CargoNom` varchar(45) DEFAULT NULL,
  `CargoDesc` varchar(45) DEFAULT NULL,
  `DatetimeIns` datetime DEFAULT NULL,
  PRIMARY KEY (`idCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Administrador','Administrador de Empresa',NULL),(2,'Supervisor','Supervisor',NULL),(3,'Operador','Operador',NULL),(4,'cargo 1','cargo test 1 edit','2015-03-23 14:34:27'),(5,'a','s','2015-03-27 11:33:29');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `CursoNom` varchar(45) NOT NULL,
  `CursoDesc` varchar(45) DEFAULT NULL,
  `CursoPrecio` decimal(14,4) DEFAULT '0.0000',
  `CursoEstado` int(11) DEFAULT NULL,
  `DatetimeIns` datetime DEFAULT NULL,
  PRIMARY KEY (`idCurso`),
  UNIQUE KEY `CursoNom_UNIQUE` (`CursoNom`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'JSF 2 edit','Java Server Faces 2.x ed',750.0000,1,NULL),(2,'Spring','Spring Framework 4',900.0000,1,NULL),(3,'MyBatis','MyBatis 3',400.0000,1,NULL),(4,'Primefaces','Primefaces 5',700.0000,1,'2015-03-22 18:04:56'),(5,'asd','asdsa',1.3000,0,'2015-03-23 10:50:22'),(6,'bb','bbb',100.5000,1,'2015-03-23 11:24:17');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleevento`
--

DROP TABLE IF EXISTS `detalleevento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleevento` (
  `idDetalleEvento` int(11) NOT NULL AUTO_INCREMENT,
  `EventosxCurso_idEventosxCurso` int(11) NOT NULL,
  `DetEventFechaStart` datetime DEFAULT NULL,
  `DetEventFechaEnd` datetime DEFAULT NULL,
  PRIMARY KEY (`idDetalleEvento`),
  KEY `fk_DetalleEvento_EventosxCurso1_idx` (`EventosxCurso_idEventosxCurso`),
  CONSTRAINT `fk_DetalleEvento_EventosxCurso1` FOREIGN KEY (`EventosxCurso_idEventosxCurso`) REFERENCES `eventosxcurso` (`idEventosxCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleevento`
--

LOCK TABLES `detalleevento` WRITE;
/*!40000 ALTER TABLE `detalleevento` DISABLE KEYS */;
INSERT INTO `detalleevento` VALUES (1,1,'2015-03-02 16:38:50','2015-03-13 16:38:50'),(3,2,'2015-03-16 16:38:50','2015-03-27 23:59:59');
/*!40000 ALTER TABLE `detalleevento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `EmpleadoDNI` varchar(8) DEFAULT NULL,
  `EmpleadoNombre` varchar(45) DEFAULT NULL,
  `EmpleadoApellidos` varchar(45) DEFAULT NULL,
  `EmpleadoCorreo` varchar(45) DEFAULT NULL,
  `EmpleadoEstado` int(11) DEFAULT NULL,
  `Cargo_idCargo` int(11) NOT NULL,
  `Empresa_EmpresaRUC` bigint(20) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `fk_Empleado_Cargo_idx` (`Cargo_idCargo`),
  KEY `fk_Empleado_Empresa1_idx` (`Empresa_EmpresaRUC`),
  CONSTRAINT `fk_Empleado_Cargo` FOREIGN KEY (`Cargo_idCargo`) REFERENCES `cargo` (`idCargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Empresa1` FOREIGN KEY (`Empresa_EmpresaRUC`) REFERENCES `empresa` (`EmpresaRUC`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'40722986','FREDY','MAQUERA TICONA','fmaquera@mail.com',1,1,10447715440),(2,'46913397','WILSON','CHILLON BUSTAMANTE','wchillon@mail.com',0,2,10447715440),(3,'24324324','omar edit','garcia','omar@mail.com',1,2,10447715440),(4,'8888888','BRIAN MARLON','DE LA CRUZ YARASCA','BMARLON@MAIL.COM',1,2,10447715440);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `EmpresaRUC` bigint(20) NOT NULL,
  `EmpresaRazonSocial` varchar(45) DEFAULT NULL,
  `EmpresaDireccion` varchar(45) DEFAULT NULL,
  `EmpresaMovil` varchar(15) DEFAULT NULL,
  `EmpresaFijo` varchar(15) DEFAULT NULL,
  `EmpresaPaginaWeb` varchar(30) DEFAULT NULL,
  `EmpresaEmail` varchar(25) DEFAULT NULL,
  `EmpresaEstado` int(11) DEFAULT NULL,
  `DatetimeIns` datetime DEFAULT NULL,
  PRIMARY KEY (`EmpresaRUC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (10447715440,'YATACO SAC','LIMA','123456789','1234567','YATACO.COM','ceo@yataco.com.pe',NULL,NULL),(20513980761,'alpha business sac','LIMA','932432433','3232432','alpha.com','alpha@mail.com',NULL,NULL),(32432432433,'test12 edit','test12','3432432','324324324','test12','test12@a.c',1,NULL);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `idEvento` int(11) NOT NULL AUTO_INCREMENT,
  `EventoNombre` varchar(45) DEFAULT NULL,
  `EventoCuposTotal` int(11) DEFAULT NULL,
  `EventoInscritos` int(11) DEFAULT '0',
  `EventoDisponible` int(11) DEFAULT '0',
  `DatetimeIns` datetime DEFAULT NULL,
  PRIMARY KEY (`idEvento`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Evento 1',1,1,0,'2015-03-26 12:20:42'),(8,'evento 2',14,5,9,'2015-03-26 15:29:45'),(9,'Evento 3',10,0,0,'2015-03-30 16:10:12');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventosxcurso`
--

DROP TABLE IF EXISTS `eventosxcurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventosxcurso` (
  `idEventosxCurso` int(11) NOT NULL AUTO_INCREMENT,
  `Curso_idCurso` int(11) NOT NULL,
  `Evento_idEvento` int(11) NOT NULL,
  `Capacitador_idCapacitador` int(11) NOT NULL,
  `FechaStart` datetime DEFAULT NULL,
  `FechaEnd` datetime DEFAULT NULL,
  PRIMARY KEY (`idEventosxCurso`),
  KEY `fk_EventosxCurso_Curso1_idx` (`Curso_idCurso`),
  KEY `fk_EventosxCurso_Evento1_idx` (`Evento_idEvento`),
  KEY `fk_EventosxCurso_Capacitador1_idx` (`Capacitador_idCapacitador`),
  CONSTRAINT `fk_EventosxCurso_Capacitador1` FOREIGN KEY (`Capacitador_idCapacitador`) REFERENCES `capacitador` (`idCapacitador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EventosxCurso_Curso1` FOREIGN KEY (`Curso_idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EventosxCurso_Evento1` FOREIGN KEY (`Evento_idEvento`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventosxcurso`
--

LOCK TABLES `eventosxcurso` WRITE;
/*!40000 ALTER TABLE `eventosxcurso` DISABLE KEYS */;
INSERT INTO `eventosxcurso` VALUES (1,4,1,1,'2015-03-01 00:00:00','2015-03-10 00:00:00'),(2,3,1,1,'2015-03-14 00:00:00','2015-03-20 00:00:00'),(3,6,1,1,'2015-03-30 00:00:00','2015-03-31 00:00:00'),(4,1,1,1,'2015-03-31 00:00:00','2015-03-31 00:00:00'),(5,5,1,1,'2015-03-26 00:00:00','2015-03-28 00:00:00'),(6,5,1,1,'2015-03-21 00:00:00','2015-03-21 00:00:00');
/*!40000 ALTER TABLE `eventosxcurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscritos`
--

DROP TABLE IF EXISTS `inscritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscritos` (
  `idInscritos` int(11) NOT NULL AUTO_INCREMENT,
  `EventosxCurso_idEventosxCurso` int(11) NOT NULL,
  `Empleado_idEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`idInscritos`),
  KEY `fk_Inscritos_Empleado1_idx` (`Empleado_idEmpleado`),
  KEY `fk_Inscritos_EventosxCurso1_idx` (`EventosxCurso_idEventosxCurso`),
  CONSTRAINT `fk_Inscritos_Empleado1` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inscritos_EventosxCurso1` FOREIGN KEY (`EventosxCurso_idEventosxCurso`) REFERENCES `eventosxcurso` (`idEventosxCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscritos`
--

LOCK TABLES `inscritos` WRITE;
/*!40000 ALTER TABLE `inscritos` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `representante`
--

DROP TABLE IF EXISTS `representante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `representante` (
  `idRepresentante` int(11) NOT NULL AUTO_INCREMENT,
  `RepresentanteNombres` varchar(45) DEFAULT NULL,
  `RepresentanteApellidos` varchar(45) DEFAULT NULL,
  `RepresentanteCorreo` varchar(45) DEFAULT NULL,
  `RepresentanteEstado` int(11) DEFAULT NULL,
  `DatetimeIns` datetime DEFAULT NULL,
  `Empresa_EmpresaRUC` bigint(20) NOT NULL,
  PRIMARY KEY (`idRepresentante`),
  KEY `fk_Representante_Empresa1_idx` (`Empresa_EmpresaRUC`),
  CONSTRAINT `fk_Representante_Empresa1` FOREIGN KEY (`Empresa_EmpresaRUC`) REFERENCES `empresa` (`EmpresaRUC`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `representante`
--

LOCK TABLES `representante` WRITE;
/*!40000 ALTER TABLE `representante` DISABLE KEYS */;
INSERT INTO `representante` VALUES (1,'Luis','Ponte','lponte@mail.com',1,NULL,10447715440),(2,'Jose','Vaca','jvaca@mail.com',1,'2015-03-23 15:41:53',20513980761);
/*!40000 ALTER TABLE `representante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secrole`
--

DROP TABLE IF EXISTS `secrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secrole` (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `DatetimeIns` datetime DEFAULT NULL,
  PRIMARY KEY (`RoleId`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Roles de usuarios de sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secrole`
--

LOCK TABLES `secrole` WRITE;
/*!40000 ALTER TABLE `secrole` DISABLE KEYS */;
INSERT INTO `secrole` VALUES (1,'Administrador','Administrador de Sistema',NULL),(2,'Capacitador','Capacitador',NULL),(3,'Terceros','Terceros',NULL),(4,'test1','test1 desc edit','2015-03-22 14:36:53'),(5,'rol2','rol test2 edit','2015-03-23 10:42:04');
/*!40000 ALTER TABLE `secrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secuser`
--

DROP TABLE IF EXISTS `secuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secuser` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL,
  `Password` blob,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `RoleId` int(11) NOT NULL,
  `Status` char(1) DEFAULT 'A' COMMENT 'A -> Activo\nB -> Bloqueado (Por maximo de intentos realizados)\nI -> Inactivo (Baneado por administrador de sistema)\n',
  `InvalidAttemps` varchar(45) DEFAULT '0',
  `DatetimeIns` datetime DEFAULT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`),
  KEY `fk_roleId_idx` (`RoleId`),
  CONSTRAINT `fk_roleId` FOREIGN KEY (`RoleId`) REFERENCES `secrole` (`RoleId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='Usuarios de Sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secuser`
--

LOCK TABLES `secuser` WRITE;
/*!40000 ALTER TABLE `secuser` DISABLE KEYS */;
INSERT INTO `secuser` VALUES (1,'dolano','¯É3Éùì¨Ωfˆ»ÿ›','Daniel','Olano','dolano@mail.com',1,'A','0','2015-03-21 21:06:38'),(2,'lmessi','¯É3Éùì¨Ωfˆ»ÿ›','Lionel','Messi','lmessi@mail.com',1,'I','0','2015-03-21 21:06:38'),(3,'neymar','¯É3Éùì¨Ωfˆ»ÿ›','Neymar','Junior','neymar@mail.com',2,'A','0','2015-03-21 21:06:38'),(4,'lsuarez','¯É3Éùì¨Ωfˆ»ÿ›','Luis','Suarez','lsuarez@mail.com',3,'I','0','2015-03-21 21:06:38'),(5,'ainiesta','¯É3Éùì¨Ωfˆ»ÿ›','Andres edit','Iniesta','ainiesta@mail.com',3,'A','0','2015-03-21 22:22:47'),(6,'xavi','¯É3Éùì¨Ωfˆ»ÿ›','xavi','hernandez','xavi@mail.com',2,'I','0','2015-03-21 22:26:58'),(7,'irakitic','¯É3Éùì¨Ωfˆ»ÿ›','ivan','ratikic','irakitic@mail.com',3,'A','0','2015-03-21 22:30:44'),(8,'sbusquets','¯É3Éùì¨Ωfˆ»ÿ›','sergio','busquets','sbusquets@mail.com',2,'A','0','2015-03-21 23:08:31'),(17,'gpique','¯É3Éùì¨Ωfˆ»ÿ›','gerard edit','pique','gpique@mail.com',1,'A','0','2015-03-22 01:52:39'),(18,'jalba','¯É3Éùì¨Ωfˆ»ÿ›','jordy','alba','jalba@mail.com',1,'A','0','2015-03-22 02:11:30'),(19,'dalves','¯É3Éùì¨Ωfˆ»ÿ›','Daniel','Alves','dalves@mail.com',1,'A','0','2015-03-22 12:25:27'),(20,'jmascherano','#xÎô¯≥L”‚®','javier','mascherano','jmascherano@mail.com',4,'I','0','2015-03-23 10:40:37');
/*!40000 ALTER TABLE `secuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idUsuarios` int(11) NOT NULL,
  `UsuarioCodigo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUsuarios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'boalphadb'
--

--
-- Dumping routines for database 'boalphadb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-30 18:02:43
