-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2022 at 06:59 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_android`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_nasabah`
--

CREATE TABLE `tb_nasabah` (
  `ID` int(11) NOT NULL,
  `FullName` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Age` varchar(25) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `PhoneNumber` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_nasabah`
--

INSERT INTO `tb_nasabah` (`ID`, `FullName`, `Email`, `Age`, `Address`, `PhoneNumber`) VALUES
(1, 'Damian Wayne', 'dwayne@wayne.com', '14', '1007 Mountain Drive, Gotham', '081234567891'),
(2, 'Bruce Wayne', 'bwayne@wayne.com', '40', '1007 Mountain Drive, Gotham', '085714431860'),
(3, 'Dick Grayson', 'dgrayson@wayne.com', '25', '1007 Mountain Drive, Gotham', '085723648898'),
(4, 'Selina Kyle', 'selina.kyle@corps.com', '39', 'Gotham City', '08159209987'),
(5, 'Charles Xavier', 'professor.x@fclass.com', '55', '1407 Graymalkin Lane, Salem Center', '087886610332'),
(6, 'Kitty', 'kitty.x@xmen.com', '22', '1407 Graymalkin Lane, Salem Center', '087886650342'),
(7, 'Barry Allen', 'barthony.allen@starlabs.com', '28', '86475 Gene Lasserre Boulevard', '085738875432');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_nasabah`
--
ALTER TABLE `tb_nasabah`
  ADD PRIMARY KEY (`ID`,`FullName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
