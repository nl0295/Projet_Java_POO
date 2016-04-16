-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 09 Novembre 2015 à 19:11
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `projet_poo`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE IF NOT EXISTS `article` (
  `Id` char(10) DEFAULT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prix` double NOT NULL,
  `Fabricant` varchar(30) NOT NULL,
  `Categorie` varchar(20) NOT NULL,
  `Image` varchar(30) NOT NULL,
  `Description` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `article`
--

INSERT INTO `article` (`Id`, `Nom`, `Prix`, `Fabricant`, `Categorie`, `Image`, `Description`) VALUES
('6472718293', 'HP Pavillon 17,3 pouces Argent', 499, 'HP', 'Ordinateur', 'ordinateur.jpg', 'Ecran 17,3 pouces - 1600x900\r\nStockage et mémoire : disque dur 1000 Go, RAM 8 Go\r\nIntel Pentium N3825U 1.9 Ghz\r\nCarte Graphique : Intel HD'),
('4922367138', 'Playstation 4', 349, 'Sony', 'Console', 'playstation.jpg', 'Plate-forme: PlayStation 4\r\nEdition: Standard\r\nGarantie constructeur : 1 an'),
('2436786678', 'Asus Chromebook C200MA-KX002 P', 199.99, 'Asus', 'Ordinateur', 'ordinateur2.jpg', 'Batterie : jusqu''à 11 heures d''autonomie\r\nProcesseur : Intel Dual-Core Celeron N2830\r\nEcran HD LED ; Caméra 1.2 millions de pixels\r\n1 port(s) HDMI; 1 port(s) USB 2.0; 1 port(s) USB 3.0'),
('5673832221', 'Acer Aspire ES1-512-C8HX PC Po', 329, 'Acer', 'Ordinateur', 'ordinateur3.jpg', 'Stockage et mémoire : disque dur 500 Go, 4 Go de RAM\r\nProcesseur : Intel Celeron N2840 2.16 Ghz\r\nCarte Graphique : Intel HD Graphics\r\n1 port HDMI, 2 ports USB 2.0, 1 port USB 3.0, 1 port Ethernet, 1 prise jack'),
('2988714232', 'Apple Macbook Ordinateur porta', 297, 'Apple', 'Ordinateur', 'ordinateur4.jpg', 'Processeur: Intel Core 2 Duo\r\nStockage: 250 GB'),
('9386274282', 'Office Famille et Etudiant 201', 123.9, 'Microsoft', 'Logiciel', 'logiciel.jpg', 'Ce produit inclut :\r\n-Word\r\n-Excel\r\n-PowerPoint\r\n-OneNote\r\n-Outlook'),
('7823747383', 'Xbox One', 349, 'Microsoft', 'Console', 'console2.jpg', 'Plate-forme: Xbox One\r\nEdition: Standard\r\nGarantie: 6 mois'),
('3829563220', 'Nintendo Wii U 8 Go blanche', 280, 'Nintendo', 'Console', 'console3.jpg', 'Support : Nintendo Wii U\r\nGarantie constructeur : 1 an'),
('5389207493', 'Norton Security 2016 DELUXE', 41.99, 'Symantec', 'Logiciel', 'logiciel2.jpg', 'Logiciel antivirus\r\nEdition: 5 appareils , 1 an'),
('0203921773', 'Bitdefender Total Security Mul', 55.95, 'Bitdefender', 'Logiciel', 'logiciel3.jpg', 'Logiciel antivirus\r\nEdition: 5 appareils, 2 ans ');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
