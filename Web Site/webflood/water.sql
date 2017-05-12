-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 04 Mai 2017 à 20:35
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `water`
--

-- --------------------------------------------------------

--
-- Structure de la table `devices`
--

CREATE TABLE `devices` (
  `id_device` varchar(255) NOT NULL,
  `device_name` varchar(255) NOT NULL,
  `water_height` int(10) NOT NULL,
  `device_depth` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `sdevice_date` date NOT NULL,
  `logo_device` varchar(100) NOT NULL,
  `tds_height` int(11) NOT NULL,
  `oxy_height` int(11) NOT NULL,
  `ph_height` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `devices`
--

INSERT INTO `devices` (`id_device`, `device_name`, `water_height`, `device_depth`, `state`, `sdevice_date`, `logo_device`, `tds_height`, `oxy_height`, `ph_height`) VALUES
('2', 'Niveau de L\'eau ', 3, '123', '123', '2017-04-13', 'cap.jpg', 2, 4, 6);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id_user` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(25) NOT NULL,
  `type_user` varchar(255) NOT NULL,
  `id_device` varchar(255) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `profession` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id_user`, `user_name`, `password`, `type_user`, `id_device`, `nom`, `prenom`, `profession`) VALUES
('1', 'admin', 'admin', 'pro', '2', 'Iniesta', 'Andres', 'Professeur');

-- --------------------------------------------------------

--
-- Structure de la table `visit`
--

CREATE TABLE `visit` (
  `id_user` varchar(255) NOT NULL,
  `id_device` varchar(255) NOT NULL,
  `id_user_USERS` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id_device`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- Index pour la table `visit`
--
ALTER TABLE `visit`
  ADD PRIMARY KEY (`id_user`,`id_device`,`id_user_USERS`),
  ADD KEY `FK_visit_id_device` (`id_device`),
  ADD KEY `FK_visit_id_user_USERS` (`id_user_USERS`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `visit`
--
ALTER TABLE `visit`
  ADD CONSTRAINT `FK_visit_id_device` FOREIGN KEY (`id_device`) REFERENCES `devices` (`id_device`),
  ADD CONSTRAINT `FK_visit_id_user` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `FK_visit_id_user_USERS` FOREIGN KEY (`id_user_USERS`) REFERENCES `users` (`id_user`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
