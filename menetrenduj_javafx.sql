-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2020. Nov 29. 11:58
-- Kiszolgáló verziója: 10.4.11-MariaDB
-- PHP verzió: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `menetrend_javafx`
--
CREATE DATABASE IF NOT EXISTS `menetrend_javafx` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `menetrend_javafx`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `allomas`
--

CREATE TABLE IF NOT EXISTS `allomas` (
  `allomasSorszam` int(11) NOT NULL AUTO_INCREMENT,
  `nev` varchar(40) NOT NULL,
  `koordinataX` varchar(30) NOT NULL,
  `koordinataY` varchar(30) NOT NULL,
  `vonalSzam` int(11) DEFAULT NULL,
  PRIMARY KEY (`allomasSorszam`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `allomas`
--

INSERT INTO `allomas` (`allomasSorszam`, `nev`, `koordinataX`, `koordinataY`, `vonalSzam`) VALUES
(1, 'Európa liget', '46.273561', '20.147113', NULL),
(2, 'Anna-kút', '46.256150', '20.147643', NULL),
(3, 'Személy pályaudvar', '46.239802', '20.142629', NULL),
(4, 'Tarján', '46.275372', '20.164449', NULL),
(5, 'Kálvária-tér', '46.253312', '20.129755', NULL),
(6, 'Fonógyári út', '46.264005', '20.109662', NULL),
(7, 'Vitéz utca', '46.248486', '20.141120', NULL),
(8, 'Dugonics tér', '46.250602', '20.144552', NULL),
(9, 'Kecskés', '46.239502', '20.117673', NULL),
(10, 'Körtöltés utca', '46.269842', '20.134605', NULL),
(11, 'Rózsa utca', '46.266057', '20.151222', NULL),
(12, 'Gyermekkórház', '46.243875', '20.161027', NULL),
(13, 'Vértói út', '46.274284', '20.141291', NULL),
(14, 'Bartók tér', '46.254649', '20.143755', NULL),
(15, 'Lugas utca', '46.267031', '20.170985', NULL),
(16, 'Makkosház', '46.272411', '20.147274', NULL),
(17, 'Berlini körút', '46.261365', '20.149744', NULL),
(18, 'Víztorony tér', '46.270331', '20.163977', NULL),
(19, 'Csatár utca', '46.263782', '20.208096', NULL),
(20, 'Fő tér', '46.263253', '20.180319', NULL),
(21, 'Mars tér (üzletsor)', '46.258019', '20.140305', NULL),
(22, 'Gabonakutató', '46.244669', '20.157204', NULL),
(23, 'Vértó', '46.272090', '20.143056', NULL),
(24, 'Személyi pályaudvar', '46.240661', '20.142976', NULL),
(25, 'Fő tér', '46.263296', '20.180761', NULL),
(26, 'Erdő utca', '46.260879', '20.171403', NULL),
(27, 'Vadaspark', '46.254497', '20.118703', NULL),
(28, 'Bakay N. utca', '46.255057', '20.138658', NULL),
(29, 'Huszár utca', '46.256420', '20.135010', NULL),
(30, 'Széchenyi tér', '46.257777', '20.131061', NULL),
(31, 'Klinikák', '46.245988', '20.147481', NULL),
(32, 'Mars-tér (Szt. Rókus tér)', '46.258957', '20.140791', NULL),
(33, 'Füvészkert', '46.232890', '20.155699', NULL),
(34, 'Mars-tér (Mikszáth utca)', '46.256255', '20.141829', NULL),
(35, 'Katalin utca', '46.232201', '20.190346', NULL),
(36, 'Napfényfürdő', '46.249663', '20.159695', NULL),
(37, 'Szegedi Ipari Logisztikai Központ', '46.286540', '20.085751', NULL),
(38, 'Rókusi víztorony', '46.268600', '20.134706', NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `erint`
--

CREATE TABLE IF NOT EXISTS `erint` (
  `erkezesiIdoPerc` int(11) NOT NULL,
  `erintSorszam` int(11) NOT NULL AUTO_INCREMENT,
  `allomasSorszam` int(11) DEFAULT NULL,
  `vonalSorszam` int(11) DEFAULT NULL,
  PRIMARY KEY (`erintSorszam`),
  KEY `allomasSorszam` (`allomasSorszam`),
  KEY `vonalSorszam` (`vonalSorszam`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `erint`
--

INSERT INTO `erint` (`erkezesiIdoPerc`, `erintSorszam`, `allomasSorszam`, `vonalSorszam`) VALUES
(0, 1, 1, 1),
(13, 2, 2, 1),
(21, 3, 3, 1),
(0, 4, 3, 2),
(13, 5, 2, 2),
(21, 6, 1, 2),
(0, 7, 4, 3),
(19, 8, 5, 3),
(27, 9, 6, 3),
(0, 10, 6, 4),
(19, 11, 5, 4),
(27, 12, 4, 4),
(0, 13, 4, 5),
(14, 14, 7, 5),
(21, 15, 9, 5),
(0, 16, 9, 6),
(14, 17, 7, 6),
(21, 18, 4, 6),
(0, 19, 10, 9),
(8, 20, 11, 9),
(17, 21, 12, 9),
(0, 22, 12, 10),
(8, 23, 11, 10),
(17, 24, 10, 10),
(0, 25, 28, 19),
(3, 26, 29, 19),
(8, 27, 30, 19),
(0, 28, 30, 20),
(3, 29, 29, 20),
(8, 30, 28, 20),
(0, 31, 16, 21),
(18, 32, 2, 21),
(24, 33, 31, 21),
(0, 34, 31, 22),
(18, 35, 2, 22),
(24, 36, 16, 22),
(0, 37, 23, 7),
(11, 38, 14, 7),
(22, 39, 15, 7),
(0, 40, 15, 8),
(11, 41, 14, 8),
(22, 42, 23, 8),
(0, 43, 18, 23),
(10, 44, 2, 23),
(16, 45, 31, 23),
(0, 46, 31, 24),
(10, 47, 2, 24),
(16, 48, 18, 24),
(0, 49, 16, 11),
(7, 50, 17, 11),
(26, 51, 18, 11),
(0, 52, 18, 12),
(7, 53, 17, 12),
(26, 54, 16, 12),
(0, 55, 32, 25),
(10, 56, 30, 25),
(13, 57, 33, 25),
(0, 58, 33, 26),
(10, 59, 30, 26),
(13, 60, 32, 26),
(0, 61, 34, 27),
(7, 62, 37, 27),
(19, 63, 35, 27),
(0, 64, 35, 28),
(7, 65, 37, 28),
(19, 66, 34, 28),
(0, 67, 19, 13),
(8, 68, 20, 13),
(18, 69, 21, 13),
(0, 70, 21, 14),
(8, 71, 20, 14),
(18, 72, 19, 14),
(0, 73, 22, 15),
(19, 74, 23, 15),
(37, 75, 24, 15),
(0, 76, 24, 16),
(19, 77, 23, 16),
(37, 78, 22, 16),
(0, 79, 25, 17),
(4, 80, 26, 17),
(28, 81, 27, 17),
(0, 82, 27, 18),
(4, 83, 26, 18),
(28, 84, 25, 18),
(0, 85, 36, 29),
(20, 86, 37, 29),
(34, 87, 15, 29),
(0, 88, 15, 30),
(20, 89, 37, 30),
(34, 90, 36, 30);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `jarat`
--

CREATE TABLE IF NOT EXISTS `jarat` (
  `vonalSorszam` int(11) DEFAULT NULL,
  `jaratSorszam` int(11) NOT NULL AUTO_INCREMENT,
  `jarmuSorszam` int(11) DEFAULT NULL,
  `indulasiIdo` char(5) NOT NULL,
  `napTipusSorszam` int(11) DEFAULT NULL,
  `rokkantHelyekSzama` int(11) NOT NULL,
  `ulohelyekSzama` int(11) NOT NULL,
  `csuklos` tinyint(1) NOT NULL,
  `alacsonyPadlos` tinyint(1) NOT NULL,
  `kerekparSzallitasiLehetoseg` tinyint(1) NOT NULL,
  PRIMARY KEY (`jaratSorszam`),
  KEY `vonalSorszam` (`vonalSorszam`),
  KEY `jarmuSorszam` (`jarmuSorszam`),
  KEY `napTipusSorszam` (`napTipusSorszam`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `jarat`
--

INSERT INTO `jarat` (`vonalSorszam`, `jaratSorszam`, `jarmuSorszam`, `indulasiIdo`, `napTipusSorszam`, `rokkantHelyekSzama`, `ulohelyekSzama`, `csuklos`, `alacsonyPadlos`, `kerekparSzallitasiLehetoseg`) VALUES
(1, 1, 1, '08:00', 1, 2, 50, 0, 1, 1),
(1, 2, 2, '08:10', 1, 1, 60, 0, 0, 0),
(1, 3, 3, '08:20', 4, 0, 50, 0, 1, 1),
(2, 4, 1, '08:25', 5, 2, 50, 0, 1, 1),
(2, 5, 2, '08:40', 1, 0, 60, 0, 1, 0),
(2, 6, 3, '08:50', 2, 1, 50, 0, 1, 1),
(3, 7, 4, '09:00', 2, 0, 40, 0, 1, 0),
(3, 8, 5, '09:15', 1, 1, 45, 0, 1, 0),
(3, 9, 6, '09:45', 1, 2, 40, 0, 1, 0),
(4, 10, 4, '09:50', 6, 1, 40, 0, 1, 0),
(4, 11, 5, '10:20', 7, 0, 45, 0, 1, 0),
(4, 12, 6, '10:30', 1, 2, 40, 0, 0, 0),
(5, 13, 7, '06:00', 3, 0, 55, 0, 1, 0),
(5, 14, 8, '06:10', 3, 2, 45, 0, 0, 0),
(5, 15, 9, '06:22', 1, 1, 55, 0, 1, 0),
(6, 16, 7, '06:25', 1, 0, 55, 0, 1, 0),
(6, 17, 8, '06:40', 8, 1, 45, 0, 0, 0),
(6, 18, 9, '06:48', 9, 2, 55, 0, 1, 0),
(7, 19, 10, '08:00', 1, 0, 45, 0, 1, 0),
(7, 20, 11, '08:35', 2, 2, 60, 1, 1, 1),
(7, 21, 12, '09:00', 2, 0, 60, 1, 0, 1),
(8, 22, 10, '09:02', 1, 0, 45, 0, 1, 0),
(8, 23, 11, '09:35', 1, 2, 60, 1, 1, 1),
(8, 24, 12, '09:40', 10, 0, 60, 1, 0, 1),
(9, 25, 13, '11:25', 4, 0, 60, 1, 1, 1),
(9, 26, 14, '11:52', 1, 2, 60, 1, 1, 1),
(9, 27, 15, '12:00', 3, 0, 45, 0, 1, 0),
(10, 28, 13, '12:04', 3, 2, 60, 1, 1, 1),
(10, 29, 14, '12:32', 1, 0, 60, 1, 1, 1),
(10, 30, 15, '12:40', 1, 2, 50, 0, 1, 0),
(11, 31, 16, '08:00', 5, 0, 60, 1, 0, 1),
(11, 32, 17, '08:24', 6, 0, 60, 1, 0, 1),
(11, 33, 18, '08:43', 1, 2, 60, 1, 1, 1),
(12, 34, 16, '08:45', 2, 0, 60, 1, 0, 1),
(12, 35, 17, '09:15', 2, 0, 60, 1, 0, 1),
(12, 36, 18, '09:19', 1, 0, 60, 1, 1, 1),
(13, 37, 19, '07:12', 1, 2, 45, 0, 1, 0),
(13, 38, 20, '07:34', 7, 0, 50, 0, 0, 0),
(13, 39, 21, '07:56', 8, 0, 50, 0, 1, 0),
(14, 40, 19, '08:00', 1, 2, 50, 0, 1, 0),
(14, 41, 20, '08:15', 3, 0, 45, 0, 0, 0),
(14, 42, 21, '08:34', 3, 2, 45, 0, 1, 0),
(15, 43, 22, '21:00', 1, 0, 45, 0, 1, 0),
(15, 44, 23, '21:36', 1, 2, 45, 0, 1, 0),
(15, 45, 24, '21:48', 9, 0, 50, 0, 1, 0),
(16, 46, 22, '21:52', 10, 2, 45, 0, 1, 0),
(16, 47, 23, '22:13', 1, 0, 45, 0, 1, 0),
(16, 48, 24, '22:30', 2, 0, 45, 0, 1, 0),
(17, 49, 25, '06:24', 2, 0, 45, 0, 1, 0),
(17, 50, 26, '06:52', 1, 0, 50, 0, 1, 0),
(17, 51, 27, '07:06', 1, 0, 50, 0, 0, 0),
(18, 52, 25, '07:11', 4, 2, 50, 0, 1, 0),
(18, 53, 26, '07:20', 5, 2, 50, 0, 1, 0),
(18, 54, 27, '07:46', 1, 2, 50, 0, 0, 0),
(19, 55, 28, '08:30', 3, 0, 55, 1, 1, 0),
(19, 56, 29, '09:00', 3, 0, 45, 1, 1, 1),
(19, 57, 30, '09:30', 1, 2, 35, 0, 0, 1),
(20, 58, 28, '09:31', 1, 1, 55, 0, 0, 1),
(20, 59, 29, '09:45', 6, 0, 40, 0, 0, 1),
(20, 60, 30, '10:00', 7, 0, 45, 1, 1, 0),
(21, 61, 31, '10:00', 1, 2, 50, 1, 1, 1),
(21, 62, 32, '10:05', 2, 1, 45, 1, 1, 0),
(21, 63, 33, '10:10', 2, 0, 55, 0, 0, 1),
(22, 64, 31, '10:28', 1, 1, 50, 0, 0, 1),
(22, 65, 32, '10:38', 1, 1, 40, 1, 1, 1),
(22, 66, 33, '10:25', 8, 0, 50, 0, 0, 1),
(23, 67, 34, '12:00', 9, 1, 55, 1, 1, 0),
(23, 68, 35, '12:10', 1, 2, 60, 1, 1, 1),
(23, 69, 36, '12:20', 3, 2, 35, 0, 0, 0),
(24, 70, 34, '12:25', 3, 2, 45, 1, 1, 0),
(24, 71, 35, '12:35', 1, 1, 35, 0, 0, 0),
(24, 72, 36, '12:45', 1, 1, 50, 0, 0, 0),
(25, 73, 37, '16:00', 10, 0, 40, 1, 1, 1),
(25, 74, 38, '16:05', 4, 0, 50, 1, 1, 1),
(25, 75, 39, '16:10', 1, 2, 45, 0, 0, 0),
(26, 76, 37, '16:13', 2, 1, 50, 0, 0, 0),
(26, 77, 38, '16:35', 2, 1, 40, 1, 1, 0),
(26, 78, 39, '16:40', 1, 2, 55, 0, 0, 0),
(27, 79, 40, '09:45', 1, 1, 40, 0, 0, 1),
(27, 80, 41, '10:00', 5, 0, 45, 1, 0, 0),
(27, 81, 42, '10:15', 6, 0, 50, 0, 1, 1),
(28, 82, 40, '10:20', 1, 2, 35, 1, 1, 1),
(28, 83, 41, '10:30', 3, 0, 45, 0, 0, 0),
(28, 84, 42, '10:35', 3, 0, 50, 0, 0, 0),
(29, 85, 43, '14:20', 1, 0, 45, 1, 1, 0),
(29, 86, 44, '14:35', 1, 0, 50, 0, 0, 1),
(29, 87, 45, '14:55', 7, 0, 40, 0, 0, 1),
(30, 88, 43, '15:00', 8, 0, 50, 0, 0, 0),
(30, 89, 44, '15:10', 1, 2, 35, 0, 0, 0),
(30, 90, 45, '15:30', 2, 2, 45, 0, 0, 0);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `jarmu`
--

CREATE TABLE IF NOT EXISTS `jarmu` (
  `jarmuSorszam` int(11) NOT NULL AUTO_INCREMENT,
  `tipus` varchar(30) NOT NULL,
  `uzemeltetesiKoltseg` float NOT NULL,
  `ulohelyekSzama` int(11) NOT NULL,
  `csuklos` tinyint(1) NOT NULL,
  `alacsonyPadlos` tinyint(1) NOT NULL,
  `kerekparSzallitasiLehetoseg` tinyint(1) NOT NULL,
  `javitasSzukseges` tinyint(1) NOT NULL,
  `rokkantHelyekSzama` int(11) NOT NULL,
  PRIMARY KEY (`jarmuSorszam`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `jarmu`
--

INSERT INTO `jarmu` (`jarmuSorszam`, `tipus`, `uzemeltetesiKoltseg`, `ulohelyekSzama`, `csuklos`, `alacsonyPadlos`, `kerekparSzallitasiLehetoseg`, `javitasSzukseges`, `rokkantHelyekSzama`) VALUES
(1, 'villamos', 97.68, 50, 0, 1, 1, 1, 2),
(2, 'villamos', 97.68, 60, 0, 0, 0, 1, 0),
(3, 'villamos', 97.68, 50, 0, 1, 1, 1, 2),
(4, 'villamos', 101.75, 40, 0, 0, 0, 1, 0),
(5, 'villamos', 101.75, 45, 0, 1, 0, 0, 0),
(6, 'villamos', 101.75, 40, 0, 0, 0, 1, 0),
(7, 'villamos', 101.75, 55, 0, 1, 0, 1, 0),
(8, 'villamos', 101.75, 45, 0, 0, 0, 1, 0),
(9, 'villamos', 101.75, 55, 0, 1, 0, 1, 0),
(10, 'troli', 111.84, 45, 0, 1, 0, 0, 2),
(11, 'troli', 111.84, 60, 1, 1, 1, 1, 2),
(12, 'troli', 111.84, 60, 1, 0, 1, 1, 0),
(13, 'troli', 78.49, 60, 1, 1, 1, 1, 2),
(14, 'troli', 78.49, 60, 1, 1, 1, 1, 2),
(15, 'troli', 78.49, 45, 0, 1, 0, 0, 2),
(16, 'troli', 111.84, 60, 1, 0, 1, 1, 0),
(17, 'troli', 111.84, 60, 1, 0, 1, 1, 0),
(18, 'troli', 111.84, 60, 1, 1, 1, 1, 2),
(19, 'busz', 203.95, 45, 0, 1, 0, 1, 2),
(20, 'busz', 203.95, 50, 0, 0, 0, 1, 0),
(21, 'busz', 203.95, 50, 0, 1, 0, 0, 2),
(22, 'busz', 203.95, 45, 0, 1, 0, 1, 2),
(23, 'busz', 203.95, 45, 0, 1, 0, 1, 2),
(24, 'busz', 203.95, 50, 0, 1, 0, 1, 2),
(25, 'busz', 142.49, 45, 0, 1, 0, 1, 2),
(26, 'busz', 142.49, 50, 0, 1, 0, 1, 2),
(27, 'busz', 142.49, 50, 0, 0, 0, 0, 0),
(28, 'troli', 109.08, 55, 1, 1, 0, 1, 0),
(29, 'troli', 109.08, 45, 1, 1, 1, 1, 2),
(30, 'troli', 109.08, 35, 0, 0, 1, 1, 2),
(31, 'troli', 145.44, 50, 1, 1, 1, 1, 2),
(32, 'troli', 145.44, 45, 1, 1, 0, 1, 1),
(33, 'troli', 145.44, 55, 0, 0, 1, 0, 0),
(34, 'troli', 122.21, 55, 1, 1, 0, 1, 1),
(35, 'troli', 122.21, 60, 1, 1, 1, 1, 2),
(36, 'troli', 122.21, 35, 0, 0, 0, 1, 2),
(37, 'busz', 115.14, 40, 1, 1, 1, 1, 0),
(38, 'busz', 115.14, 50, 1, 1, 1, 1, 0),
(39, 'busz', 115.14, 45, 0, 0, 0, 1, 2),
(40, 'busz', 136.35, 40, 0, 0, 1, 0, 1),
(41, 'busz', 136.35, 45, 1, 0, 0, 1, 0),
(42, 'busz', 136.35, 50, 0, 1, 1, 1, 0),
(43, 'busz', 122.21, 45, 1, 1, 0, 1, 0),
(44, 'busz', 122.21, 50, 0, 0, 1, 1, 0),
(45, 'busz', 122.21, 40, 0, 0, 1, 1, 0);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `naptipus`
--

CREATE TABLE IF NOT EXISTS `naptipus` (
  `napTipusSorszam` int(11) NOT NULL AUTO_INCREMENT,
  `leiras` varchar(70) NOT NULL,
  PRIMARY KEY (`napTipusSorszam`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `naptipus`
--

INSERT INTO `naptipus` (`napTipusSorszam`, `leiras`) VALUES
(1, 'munkanap'),
(2, 'munkaszüneti nap'),
(3, 'szabadnap'),
(4, 'tanév tartalma alatt munkanapokon'),
(5, 'nyári tanszünetben munkanapokon'),
(6, 'szabad és munkaszüneti napokon'),
(7, 'tanszünetben munkanapokon'),
(8, 'iskolai előadási napokon'),
(9, 'szabadnapok kivételével naponta'),
(10, 'munkaszüneti napok kivételével naponta');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `vonal`
--

CREATE TABLE IF NOT EXISTS `vonal` (
  `vonalSorszam` int(11) NOT NULL AUTO_INCREMENT,
  `vonalSzam` int(11) NOT NULL,
  `vonalBetujel` varchar(2) NOT NULL,
  `kezdoAllomasSorszam` int(11) DEFAULT NULL,
  `vegAllomasSorszam` int(11) DEFAULT NULL,
  `uzemanyagTipusa` varchar(15) NOT NULL,
  `vonalTipusa` varchar(10) NOT NULL,
  `vonalHossza` float NOT NULL,
  PRIMARY KEY (`vonalSorszam`),
  KEY `kezdoAllomasSorszam` (`kezdoAllomasSorszam`),
  KEY `vegAllomasSorszam` (`vegAllomasSorszam`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `vonal`
--

INSERT INTO `vonal` (`vonalSorszam`, `vonalSzam`, `vonalBetujel`, `kezdoAllomasSorszam`, `vegAllomasSorszam`, `uzemanyagTipusa`, `vonalTipusa`, `vonalHossza`) VALUES
(1, 2, '', 1, 3, 'elektromos áram', 'villamos', 7),
(2, 2, '', 3, 1, 'elektromos áram', 'villamos', 7),
(3, 3, 'F', 4, 6, 'elektromos áram', 'villamos', 5),
(4, 3, 'F', 6, 4, 'elektromos áram', 'villamos', 5),
(5, 4, '', 4, 9, 'elektromos áram', 'villamos', 6),
(6, 4, '', 9, 4, 'elektromos áram', 'villamos', 6),
(7, 9, '', 13, 15, 'elektromos áram', 'troli', 8),
(8, 9, '', 15, 13, 'elektromos áram', 'troli', 8),
(9, 5, '', 10, 12, 'elektromos áram', 'troli', 11),
(10, 5, '', 12, 10, 'elektromos áram', 'troli', 11),
(11, 19, '', 16, 18, 'elektromos áram', 'troli', 9),
(12, 19, '', 18, 16, 'elektromos áram', 'troli', 9),
(13, 73, 'Y', 19, 21, 'gázolaj', 'busz', 10.25),
(14, 73, 'Y', 21, 19, 'gázolaj', 'busz', 10.25),
(15, 90, '', 22, 24, 'gázolaj', 'busz', 7.5),
(16, 90, '', 24, 22, 'gázolaj', 'busz', 7.5),
(17, 90, 'F', 25, 27, 'gázolaj', 'busz', 9),
(18, 90, 'F', 27, 25, 'gázolaj', 'busz', 9),
(19, 7, 'A', 28, 30, 'elektromos áram', 'troli', 2.2),
(20, 7, 'A', 30, 28, 'elektromos áram', 'troli', 2.2),
(21, 8, '', 16, 31, 'elektromos áram', 'troli', 6.5),
(22, 8, '', 31, 16, 'elektromos áram', 'troli', 6.5),
(23, 10, '', 18, 31, 'elektromos áram', 'troli', 5.4),
(24, 10, '', 31, 18, 'elektromos áram', 'troli', 5.4),
(25, 70, '', 32, 33, 'gázolaj', 'busz', 5.8),
(26, 70, '', 33, 32, 'gázolaj', 'busz', 5.8),
(27, 71, 'A', 34, 35, 'gázolaj', 'busz', 6.9),
(28, 71, 'A', 35, 34, 'gázolaj', 'busz', 6.9),
(29, 90, 'H', 37, 15, 'gázolaj', 'busz', 9.2),
(30, 90, 'H', 15, 37, 'gázolaj', 'busz', 9.2);

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `erint`
--
ALTER TABLE `erint`
  ADD CONSTRAINT `erint_ibfk_1` FOREIGN KEY (`allomasSorszam`) REFERENCES `allomas` (`allomasSorszam`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `erint_ibfk_2` FOREIGN KEY (`vonalSorszam`) REFERENCES `vonal` (`vonalSorszam`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `jarat`
--
ALTER TABLE `jarat`
  ADD CONSTRAINT `jarat_ibfk_1` FOREIGN KEY (`vonalSorszam`) REFERENCES `jarat` (`jaratSorszam`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `jarat_ibfk_2` FOREIGN KEY (`jarmuSorszam`) REFERENCES `jarat` (`jaratSorszam`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `jarat_ibfk_3` FOREIGN KEY (`napTipusSorszam`) REFERENCES `jarat` (`jaratSorszam`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Megkötések a táblához `vonal`
--
ALTER TABLE `vonal`
  ADD CONSTRAINT `vonal_ibfk_1` FOREIGN KEY (`kezdoAllomasSorszam`) REFERENCES `allomas` (`allomasSorszam`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `vonal_ibfk_2` FOREIGN KEY (`vegAllomasSorszam`) REFERENCES `allomas` (`allomasSorszam`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
