-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 09, 2025 at 12:36 PM
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `duration`
--

INSERT INTO `duration` (`item_id`, `pl_id`, `sec`, `min`, `hr`) VALUES
(4, 4, 4, 4, 4),
(7, 7, 5, 6, 7);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`item_id`, `type`, `title`, `releaseD`, `language`, `genre`, `cover`, `pl_id`) VALUES
(4, 's', 'şluılkjmö', 'dsf', 'hvnvz', 'vxcbg', 'gfndxfv', 4),
(5, 's', 'şluılkjmö', 'dsf', 'hvnvz', 'vxcbg', 'gfndxfv', 6),
(6, 's', 'jfgvc', 'ergdsfg', 'fdsgadfg', 'dfgs', 'a', 7),
(7, 's', 'lksfjkl', 'jdslkdj', 'ksdjks', 'djsk', 'a', 7);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `playlists`
--

INSERT INTO `playlists` (`pl_id`, `title`, `creation`, `cover`) VALUES
(5, 'bcd', '2025-07-09', 'C:\\Users\\zeynep\\Desktop\\blond.jpg'),
(6, 'cde', '2025-07-09', 'C:\\Users\\zeynep\\Desktop\\blond.jpg'),
(7, 'abc', '2025-07-09', 'C:\\Users\\zeynep\\Desktop\\blond.jpg');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `songs`
--

DROP TABLE IF EXISTS `songs`;
CREATE TABLE IF NOT EXISTS `songs` (
  `item_id` int NOT NULL,
  `artist` varchar(64) NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `songs`
--

INSERT INTO `songs` (`item_id`, `artist`) VALUES
(4, 'dfdhgk'),
(5, 'fsdvx'),
(6, 'dsfasd'),
(7, 'sdcsd');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `audiobooks`
--
ALTER TABLE `audiobooks`
  ADD CONSTRAINT `fk_audiobooks` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`) ON DELETE CASCADE;

--
-- Constraints for table `duration`
--
ALTER TABLE `duration`
  ADD CONSTRAINT `fk_duration` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `podcasts`
--
ALTER TABLE `podcasts`
  ADD CONSTRAINT `fk_podcasts` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`) ON DELETE CASCADE;

--
-- Constraints for table `songs`
--
ALTER TABLE `songs`
  ADD CONSTRAINT `fk_songs` FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
