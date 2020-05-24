-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: projeto_topico_especiais
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

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
-- Current Database: `projeto_topico_especiais`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `projeto_topico_especiais` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `projeto_topico_especiais`;

--
-- Table structure for table `bandeirinha`
--

DROP TABLE IF EXISTS `bandeirinha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bandeirinha` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bandeirinha`
--

LOCK TABLES `bandeirinha` WRITE;
/*!40000 ALTER TABLE `bandeirinha` DISABLE KEYS */;
INSERT INTO `bandeirinha` VALUES (1,'jose da silva'),(2,'joao da silva');
/*!40000 ALTER TABLE `bandeirinha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campeonato`
--

DROP TABLE IF EXISTS `campeonato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campeonato` (
  `id_campeonato` bigint(20) NOT NULL,
  `data_fim` date NOT NULL,
  `data_inicio` date NOT NULL,
  `nome` varchar(20) NOT NULL,
  `primeiro_colocado` varchar(20) DEFAULT NULL,
  `segundo_colocado` varchar(20) DEFAULT NULL,
  `terceiro_colocado` varchar(20) DEFAULT NULL,
  `tipo_campeonato` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_campeonato`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campeonato`
--

LOCK TABLES `campeonato` WRITE;
/*!40000 ALTER TABLE `campeonato` DISABLE KEYS */;
INSERT INTO `campeonato` VALUES (5,'2020-06-30','2020-06-30','campeonato rua',NULL,NULL,NULL,'MATAMATA');
/*!40000 ALTER TABLE `campeonato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campeonato_jogo`
--

DROP TABLE IF EXISTS `campeonato_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campeonato_jogo` (
  `Campeonato_id_campeonato` bigint(20) NOT NULL,
  `jogos_id_jogo` bigint(20) NOT NULL,
  UNIQUE KEY `UK_g26iby4huqn69syfoyx3rp74d` (`jogos_id_jogo`),
  KEY `FK23jl48gb425gxeohnbnw4ngye` (`Campeonato_id_campeonato`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campeonato_jogo`
--

LOCK TABLES `campeonato_jogo` WRITE;
/*!40000 ALTER TABLE `campeonato_jogo` DISABLE KEYS */;
INSERT INTO `campeonato_jogo` VALUES (5,4);
/*!40000 ALTER TABLE `campeonato_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campeonato_time`
--

DROP TABLE IF EXISTS `campeonato_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campeonato_time` (
  `Campeonato_id_campeonato` bigint(20) NOT NULL,
  `colocacoes_id_time` bigint(20) NOT NULL,
  UNIQUE KEY `UK_c7pnnwmi74os4tx8ulidyid24` (`colocacoes_id_time`),
  KEY `FKli9d31n9c5q5252jydcfvuh1r` (`Campeonato_id_campeonato`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campeonato_time`
--

LOCK TABLES `campeonato_time` WRITE;
/*!40000 ALTER TABLE `campeonato_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `campeonato_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (6),(6),(6),(6);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogador`
--

DROP TABLE IF EXISTS `jogador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogador` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `posicao` varchar(20) NOT NULL,
  `id_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ox57uv73enu8cuk2n40n460v` (`id_time`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogador`
--

LOCK TABLES `jogador` WRITE;
/*!40000 ALTER TABLE `jogador` DISABLE KEYS */;
INSERT INTO `jogador` VALUES (4,'romario silva','atacante',1),(5,'ronaldinho','atacante',2);
/*!40000 ALTER TABLE `jogador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogo`
--

DROP TABLE IF EXISTS `jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogo` (
  `id_jogo` bigint(20) NOT NULL,
  `data` date NOT NULL,
  `hora` time DEFAULT NULL,
  `local` varchar(20) NOT NULL,
  `id_badeira1` bigint(20) DEFAULT NULL,
  `id_badeira2` bigint(20) DEFAULT NULL,
  `id_juiz` bigint(20) DEFAULT NULL,
  `id_resultado` bigint(20) DEFAULT NULL,
  `id_time_casa` bigint(20) DEFAULT NULL,
  `id_visitante` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_jogo`),
  KEY `FKisld84cn66ru1obwjjff4dqv1` (`id_badeira1`),
  KEY `FK5ayy43ao30x0j16nr6po8ndfy` (`id_badeira2`),
  KEY `FKiogfor8vnf97voi2mhtkfqiea` (`id_juiz`),
  KEY `FK6peivfwsi1cuopicicpl2mqb7` (`id_resultado`),
  KEY `FKajiieswyqqlay4h9fdw360nxa` (`id_time_casa`),
  KEY `FKsm29mox08l8hig9s6u3xvuar2` (`id_visitante`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogo`
--

LOCK TABLES `jogo` WRITE;
/*!40000 ALTER TABLE `jogo` DISABLE KEYS */;
INSERT INTO `jogo` VALUES (4,'2020-06-30',NULL,'palestra italia',1,2,3,3,1,2);
/*!40000 ALTER TABLE `jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juiz`
--

DROP TABLE IF EXISTS `juiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `juiz` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juiz`
--

LOCK TABLES `juiz` WRITE;
/*!40000 ALTER TABLE `juiz` DISABLE KEYS */;
INSERT INTO `juiz` VALUES (3,' marcos de souza');
/*!40000 ALTER TABLE `juiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultado`
--

DROP TABLE IF EXISTS `resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resultado` (
  `id_resultado` bigint(20) NOT NULL,
  `empate` bit(1) DEFAULT NULL,
  `perdedor` varchar(20) DEFAULT NULL,
  `vencedor` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_resultado`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultado`
--

LOCK TABLES `resultado` WRITE;
/*!40000 ALTER TABLE `resultado` DISABLE KEYS */;
INSERT INTO `resultado` VALUES (3,_binary '\0','flamengo','Palmeiras');
/*!40000 ALTER TABLE `resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time` (
  `id_time` bigint(20) NOT NULL,
  `nome_time` varchar(20) NOT NULL,
  `pontuacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_time`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (1,'Palmeiras',0),(2,'flamengo',0);
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_jogo`
--

DROP TABLE IF EXISTS `time_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time_jogo` (
  `Time_id_time` bigint(20) NOT NULL,
  `jogos_id_jogo` bigint(20) NOT NULL,
  UNIQUE KEY `UK_aqom07hpy1rworubo6a9dtjo2` (`jogos_id_jogo`),
  KEY `FKmgsllq9tt8womhjqsjq04agwk` (`Time_id_time`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_jogo`
--

LOCK TABLES `time_jogo` WRITE;
/*!40000 ALTER TABLE `time_jogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `time_jogo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-24 17:02:27
