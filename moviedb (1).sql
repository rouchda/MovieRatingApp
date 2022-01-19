-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 19, 2022 at 11:33 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moviedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `moviedatabase`
--

CREATE TABLE `moviedatabase` (
  `mId` int(11) NOT NULL,
  `Title` varchar(20) NOT NULL,
  `Rating` float DEFAULT NULL,
  `Actor` varchar(20) NOT NULL,
  `MovieDirector` varchar(20) NOT NULL,
  `Publishing Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `moviedatabase`
--

INSERT INTO `moviedatabase` (`mId`, `Title`, `Rating`, `Actor`, `MovieDirector`, `Publishing Date`) VALUES
(123, 'JUMANJI', 9.6, 'Rock, K.Hart', 'Jake Kasdan', '0000-00-00'),
(174, 'Live Die Repeat', 7.9, 'Tom Cruise, Emily Bl', 'Doug Liman', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `userdatabase`
--

CREATE TABLE `userdatabase` (
  `Id` int(11) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Age` int(11) NOT NULL,
  `Email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userdatabase`
--

INSERT INTO `userdatabase` (`Id`, `Username`, `Age`, `Email`) VALUES
(1, 'Felix Navida', 24, 'FelixN@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `moviedatabase`
--
ALTER TABLE `moviedatabase`
  ADD PRIMARY KEY (`mId`);

--
-- Indexes for table `userdatabase`
--
ALTER TABLE `userdatabase`
  ADD PRIMARY KEY (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
