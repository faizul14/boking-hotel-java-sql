-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 25, 2021 at 09:04 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `FBI`
--

-- --------------------------------------------------------

--
-- Table structure for table `kamar`
--

CREATE TABLE `kamar` (
  `kode_kamar` int(11) NOT NULL,
  `jenis_kamar` varchar(25) NOT NULL,
  `tarif_kamar` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `status_kamar` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kamar`
--

INSERT INTO `kamar` (`kode_kamar`, `jenis_kamar`, `tarif_kamar`, `stok`, `status_kamar`) VALUES
(1401, 'DELUX ROOM', 850000, 14, 'READY'),
(1402, 'SUITE ROOM', 1500000, 15, 'READY'),
(1403, 'ROYAL ROOM', 3000000, 9, 'READY'),
(1404, 'EKSEKUTIF ROOM', 4500000, 2, 'READY');

-- --------------------------------------------------------

--
-- Table structure for table `percobaan`
--

CREATE TABLE `percobaan` (
  `id` int(11) NOT NULL,
  `kamar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `riwayat`
--

CREATE TABLE `riwayat` (
  `id_riwayat` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_kamar` int(11) NOT NULL,
  `id_tamu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `riwayat`
--

INSERT INTO `riwayat` (`id_riwayat`, `id_user`, `id_kamar`, `id_tamu`) VALUES
(6, 1, 1401, 29);

-- --------------------------------------------------------

--
-- Table structure for table `tamu`
--

CREATE TABLE `tamu` (
  `id` int(11) NOT NULL,
  `id_kamar` int(11) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `no_ktp` varchar(100) NOT NULL,
  `no_telp` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `jkdb` int(11) NOT NULL,
  `tanggal_cekin` date NOT NULL,
  `tanggal_cekout` date NOT NULL,
  `subtotal` varchar(50) NOT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tamu`
--

INSERT INTO `tamu` (`id`, `id_kamar`, `nama`, `no_ktp`, `no_telp`, `alamat`, `jkdb`, `tanggal_cekin`, `tanggal_cekout`, `subtotal`, `status`) VALUES
(29, 1401, 'faezol', '9899', '8989', 'lotim', 1, '2021-01-07', '2021-01-09', '1700000', 'CEKOUT');

--
-- Triggers `tamu`
--
DELIMITER $$
CREATE TRIGGER `boking_kamar` AFTER INSERT ON `tamu` FOR EACH ROW BEGIN
	UPDATE kamar SET stok = stok-NEW.jkdb
    WHERE kode_kamar = NEW.id_kamar;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `no_telp` varchar(25) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `nama`, `no_telp`, `alamat`) VALUES
(1, 'faezol', 'faezol', 'M. FAEZOL PADLI', '08786360819', 'LOMBOK TIMUR'),
(3, 'itaa', 'itaa', 'ita ristia maulana', '677878990', 'GUNUNG SARI');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kamar`
--
ALTER TABLE `kamar`
  ADD PRIMARY KEY (`kode_kamar`);

--
-- Indexes for table `percobaan`
--
ALTER TABLE `percobaan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `riwayat`
--
ALTER TABLE `riwayat`
  ADD PRIMARY KEY (`id_riwayat`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_kamar` (`id_kamar`),
  ADD KEY `id_tamu` (`id_tamu`);

--
-- Indexes for table `tamu`
--
ALTER TABLE `tamu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_kamar` (`id_kamar`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `percobaan`
--
ALTER TABLE `percobaan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `riwayat`
--
ALTER TABLE `riwayat`
  MODIFY `id_riwayat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tamu`
--
ALTER TABLE `tamu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `riwayat`
--
ALTER TABLE `riwayat`
  ADD CONSTRAINT `riwayat_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `riwayat_ibfk_2` FOREIGN KEY (`id_kamar`) REFERENCES `kamar` (`kode_kamar`) ON UPDATE CASCADE,
  ADD CONSTRAINT `riwayat_ibfk_3` FOREIGN KEY (`id_tamu`) REFERENCES `tamu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tamu`
--
ALTER TABLE `tamu`
  ADD CONSTRAINT `tamu_ibfk_1` FOREIGN KEY (`id_kamar`) REFERENCES `kamar` (`kode_kamar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
