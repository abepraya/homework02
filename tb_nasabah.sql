-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2022 at 03:31 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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

CREATE TABLE `tb_nsabah` (
  `ID` int(11) NOT NULL,
  `FullName` varchar(255) NOT NULL,
  `Age` varchar(25) NOT NULL
  `Email` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `PhoneNumber` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_nasabah`
--

INSERT INTO `tb_nasabah` (`ID`, `FullName`, `Email`, `Age`,`Address`,`PhoneNumber`) VALUES
(1, 'Damian Wayne', 'dwayne@wayne.com','14','1007 Mountain Drive, Gotham', '081234567891'),
(2, 'Bruce Wayne', 'bwayne@wayne.com','40','1007 Mountain Drive, Gotham', '085714431860'),
(3, 'Dick Grayson', 'dgrayson@wayne.com','25','1007 Mountain Drive, Gotham', '085723648898'),
(4, 'Selina Kyle','selina.kyle@corps.com','39', 'Gotham City', '08159209987'),
(5, 'Charles Xavier','proffesor.x@fclass.com','55', '1407 Graymalkin Lane, Salem Center', '087886610332'),
(6, 'Kitty','kitty@xmen.com','22', '1407 Graymalkin Lane, Salem Center', '087886650342'),
(7, 'Barry Allen','barthony.allen@starlabs.com','28', '86475 Gene Lasserre Boulevard', '085738875432')

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_nasabah`
--
ALTER TABLE `tb_nasabah`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_nasabah`
--
ALTER TABLE `tb_nasabah`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
