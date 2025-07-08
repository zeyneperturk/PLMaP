-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 08, 2025 at 09:11 AM
-- Server version: 9.1.0
-- PHP Version: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `plmap`
--
CREATE DATABASE IF NOT EXISTS `plmap` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `plmap`;

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

DROP TABLE IF EXISTS `artists`;
CREATE TABLE IF NOT EXISTS `artists` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstN` varchar(64) NOT NULL,
  `lastN` varchar(64) NOT NULL,
  `stageN` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `audiobooks`
--

DROP TABLE IF EXISTS `audiobooks`;
CREATE TABLE IF NOT EXISTS `audiobooks` (
  `item_id` int NOT NULL,
  `author` varchar(64) NOT NULL,
  `chapters` int NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `duration`
--

DROP TABLE IF EXISTS `duration`;
CREATE TABLE IF NOT EXISTS `duration` (
  `item_id` int NOT NULL,
  `pl_id` int NOT NULL,
  `sec` int NOT NULL,
  `min` int NOT NULL,
  `hr` int NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `title` varchar(64) NOT NULL,
  `releaseD` varchar(32) NOT NULL,
  `language` varchar(32) NOT NULL,
  `genre` varchar(32) NOT NULL,
  `cover` varchar(64) NOT NULL,
  `pl_id` int NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `fk_items` (`pl_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `playlists`
--

DROP TABLE IF EXISTS `playlists`;
CREATE TABLE IF NOT EXISTS `playlists` (
  `pl_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL,
  `creation` varchar(32) NOT NULL,
  `cover` varchar(128) NOT NULL,
  PRIMARY KEY (`pl_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `podcasts`
--

DROP TABLE IF EXISTS `podcasts`;
CREATE TABLE IF NOT EXISTS `podcasts` (
  `item_id` int NOT NULL,
  `host` int NOT NULL,
  `description` int NOT NULL,
  `episodes` int NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `songs`
--

DROP TABLE IF EXISTS `songs`;
CREATE TABLE IF NOT EXISTS `songs` (
  `item_id` int NOT NULL,
  `artist` int NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `fk_songs2` (`artist`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
