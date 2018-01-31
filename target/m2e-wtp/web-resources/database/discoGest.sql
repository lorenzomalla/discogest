-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.1.19-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win32
-- HeidiSQL Versione:            9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database disco_gestione
CREATE DATABASE IF NOT EXISTS `disco_gestione` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `disco_gestione`;

-- Dump della struttura di tabella disco_gestione.carico_serate
CREATE TABLE IF NOT EXISTS `carico_serate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_prodotto` int(11) NOT NULL DEFAULT '0',
  `id_serata` int(11) NOT NULL DEFAULT '0',
  `carico` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_carico_serate_prodotti` (`id_prodotto`),
  KEY `FK_carico_serate_serate` (`id_serata`),
  CONSTRAINT `FK_carico_serate_prodotti` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id`),
  CONSTRAINT `FK_carico_serate_serate` FOREIGN KEY (`id_serata`) REFERENCES `serate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.carico_serate: ~0 rows (circa)
/*!40000 ALTER TABLE `carico_serate` DISABLE KEYS */;
/*!40000 ALTER TABLE `carico_serate` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.categorie_prodotti
CREATE TABLE IF NOT EXISTS `categorie_prodotti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_prodotto` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.categorie_prodotti: ~6 rows (circa)
/*!40000 ALTER TABLE `categorie_prodotti` DISABLE KEYS */;
INSERT INTO `categorie_prodotti` (`id`, `categoria_prodotto`) VALUES
	(1, 'Vodka'),
	(2, 'Rum'),
	(3, 'Champagne'),
	(4, 'Prosecco'),
	(5, 'Analcolico'),
	(6, 'Distillato');
/*!40000 ALTER TABLE `categorie_prodotti` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.comande
CREATE TABLE IF NOT EXISTS `comande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_carico` int(11) DEFAULT NULL,
  `id_prenotazione` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_comande_carico_serate` (`id_carico`),
  KEY `FK_comande_prenotazioni` (`id_prenotazione`),
  CONSTRAINT `FK_comande_carico_serate` FOREIGN KEY (`id_carico`) REFERENCES `carico_serate` (`id`),
  CONSTRAINT `FK_comande_prenotazioni` FOREIGN KEY (`id_prenotazione`) REFERENCES `prenotazioni` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.comande: ~0 rows (circa)
/*!40000 ALTER TABLE `comande` DISABLE KEYS */;
/*!40000 ALTER TABLE `comande` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.info_locale
CREATE TABLE IF NOT EXISTS `info_locale` (
  `titolare` varchar(20) NOT NULL,
  `nome_locale` varchar(150) NOT NULL,
  `p_iva` varchar(11) NOT NULL,
  `indirizzo` varchar(150) DEFAULT NULL,
  `citta` varchar(50) DEFAULT NULL,
  `cap` varchar(5) DEFAULT NULL,
  `provincia` varchar(2) DEFAULT NULL,
  `info_tel` varchar(50) DEFAULT NULL,
  `info_supporto_email` varchar(50) DEFAULT NULL,
  `foto_locale` longblob,
  UNIQUE KEY `proprietario` (`titolare`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.info_locale: ~0 rows (circa)
/*!40000 ALTER TABLE `info_locale` DISABLE KEYS */;
/*!40000 ALTER TABLE `info_locale` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.info_user
CREATE TABLE IF NOT EXISTS `info_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `id_ruoli` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `id_ruoli` (`id_ruoli`),
  CONSTRAINT `info_user_ibfk_1` FOREIGN KEY (`id_ruoli`) REFERENCES `ruoli` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.info_user: ~0 rows (circa)
/*!40000 ALTER TABLE `info_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `info_user` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.locations
CREATE TABLE IF NOT EXISTS `locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_location` varchar(50) NOT NULL,
  `x_view` int(11) NOT NULL DEFAULT '0',
  `y_view` int(11) NOT NULL DEFAULT '0',
  `id_piantina` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK__piantine` (`id_piantina`),
  CONSTRAINT `FK__piantine` FOREIGN KEY (`id_piantina`) REFERENCES `piantine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.locations: ~0 rows (circa)
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.piantine
CREATE TABLE IF NOT EXISTS `piantine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_sala` varchar(50) NOT NULL,
  `mappa_piantina` longblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.piantine: ~0 rows (circa)
/*!40000 ALTER TABLE `piantine` DISABLE KEYS */;
/*!40000 ALTER TABLE `piantine` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.prenotazioni
CREATE TABLE IF NOT EXISTS `prenotazioni` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_tavolo` varchar(50) DEFAULT NULL,
  `id_locations` int(11) DEFAULT NULL,
  `id_stato_tavolo` int(11) DEFAULT NULL,
  `id_serata` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__locations` (`id_locations`),
  KEY `FK_prenotazioni_stato_prenotazione` (`id_stato_tavolo`),
  KEY `FK_prenotazioni_serate` (`id_serata`),
  CONSTRAINT `FK__locations` FOREIGN KEY (`id_locations`) REFERENCES `locations` (`id`),
  CONSTRAINT `FK_prenotazioni_serate` FOREIGN KEY (`id_serata`) REFERENCES `serate` (`id`),
  CONSTRAINT `FK_prenotazioni_stato_prenotazione` FOREIGN KEY (`id_stato_tavolo`) REFERENCES `stato_prenotazione` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.prenotazioni: ~0 rows (circa)
/*!40000 ALTER TABLE `prenotazioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `prenotazioni` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.prodotti
CREATE TABLE IF NOT EXISTS `prodotti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_prodotto` varchar(50) NOT NULL,
  `descrizione_prodotto` varchar(50) NOT NULL,
  `prezzo` double NOT NULL DEFAULT '0',
  `id_categoria_prodotti` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_prodotti_categorie_prodotti` (`id_categoria_prodotti`),
  CONSTRAINT `FK_prodotti_categorie_prodotti` FOREIGN KEY (`id_categoria_prodotti`) REFERENCES `categorie_prodotti` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.prodotti: ~0 rows (circa)
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.ruoli
CREATE TABLE IF NOT EXISTS `ruoli` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ruolo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.ruoli: ~4 rows (circa)
/*!40000 ALTER TABLE `ruoli` DISABLE KEYS */;
INSERT INTO `ruoli` (`id`, `ruolo`) VALUES
	(1, 'Amministratore'),
	(2, 'Sala'),
	(3, 'Office'),
	(4, 'Hostess');
/*!40000 ALTER TABLE `ruoli` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.serate
CREATE TABLE IF NOT EXISTS `serate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `nome_serata` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.serate: ~0 rows (circa)
/*!40000 ALTER TABLE `serate` DISABLE KEYS */;
/*!40000 ALTER TABLE `serate` ENABLE KEYS */;

-- Dump della struttura di tabella disco_gestione.stato_prenotazione
CREATE TABLE IF NOT EXISTS `stato_prenotazione` (
  `id` int(11) NOT NULL,
  `stato_tavolo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella disco_gestione.stato_prenotazione: ~5 rows (circa)
/*!40000 ALTER TABLE `stato_prenotazione` DISABLE KEYS */;
INSERT INTO `stato_prenotazione` (`id`, `stato_tavolo`) VALUES
	(1, 'Disponibile'),
	(2, 'Prenotato'),
	(3, 'Occupato'),
	(4, 'Chiuso'),
	(5, 'Non disponibile');
/*!40000 ALTER TABLE `stato_prenotazione` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
