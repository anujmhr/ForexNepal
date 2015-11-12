-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 12, 2015 at 11:19 AM
-- Server version: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `forexnepal`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE IF NOT EXISTS `bank` (
  `bank_id` int(11) NOT NULL,
  `bank_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`bank_id`, `bank_name`, `address`, `contact_no`, `website`) VALUES
(1, 'Nepal Bank Limited', 'Kathmandu', NULL, 'www.nepalbank.com.np'),
(2, 'Rastriya Banijya Bank Limited', 'Kathmandu', NULL, 'www.rbb.com.np'),
(6, 'Nabil Bank Limited', 'Kathmandu', NULL, 'www.nabilbank.com'),
(7, 'Standard Chartered Bank Limited', 'Kathmandu', NULL, 'www.standardchartered.com.np'),
(8, 'Himalayan Bank Limited', 'Kathmandu', NULL, 'www.himalayanbank.com'),
(9, 'Nepal SBI Bank Limited', 'Kathmandu', NULL, 'www.nepalsbi.com.np'),
(10, 'Nepal Bangladesh Bank Limited', 'Kathmandu', NULL, 'www.nbbl.com.np'),
(11, 'Everest Bank Limited', 'Kathmandu', NULL, 'www.everestbankltd.com'),
(12, 'Bank of Kathmandu Limited', 'Kathmandu', NULL, 'www.bokltd.com'),
(13, 'Nepal Credit and Commerce Bank Limited', 'Bhairawa', NULL, 'Nccbank.com.np'),
(14, 'Lumbini Bank Limited', 'Narayangrah', NULL, 'www.lumbanibank.com');

-- --------------------------------------------------------

--
-- Table structure for table `currency`
--

CREATE TABLE IF NOT EXISTS `currency` (
  `currency_id` int(11) NOT NULL,
  `currency_name` varchar(50) NOT NULL,
  `currency_code` varchar(3) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `currency`
--

INSERT INTO `currency` (`currency_id`, `currency_name`, `currency_code`) VALUES
(1, '(South) Korean Won', 'KRW'),
(2, 'Afghanistan Afghani', 'AFA'),
(3, 'Albanian Lek', 'ALL'),
(4, 'Algerian Dinar', 'DZD'),
(5, 'Andorran Peseta', 'ADP'),
(6, 'Angolan Kwanza', 'AOK'),
(7, 'Argentine Peso', 'ARS'),
(8, 'Armenian Dram', 'AMD'),
(9, 'Aruban Florin', 'AWG'),
(10, 'Australian Dollar', 'AUD'),
(11, 'Bahamian Dollar', 'BSD'),
(12, 'Bahraini Dinar', 'BHD'),
(13, 'Bangladeshi Taka', 'BDT'),
(14, 'Barbados Dollar', 'BBD'),
(15, 'Belize Dollar', 'BZD'),
(16, 'Bermudian Dollar', 'BMD'),
(17, 'Bhutan Ngultrum', 'BTN'),
(18, 'Bolivian Boliviano', 'BOB'),
(19, 'Botswanian Pula', 'BWP'),
(20, 'Brazilian Real', 'BRL'),
(21, 'British Pound', 'GBP'),
(22, 'Brunei Dollar', 'BND'),
(23, 'Bulgarian Lev', 'BGN'),
(24, 'Burma Kyat', 'BUK'),
(25, 'Burundi Franc', 'BIF'),
(26, 'Canadian Dollar', 'CAD'),
(27, 'Cape Verde Escudo', 'CVE'),
(28, 'Cayman Islands Dollar', 'KYD'),
(29, 'Chilean Peso', 'CLP'),
(30, 'Chilean Unidades de Fomento', 'CLF'),
(31, 'Colombian Peso', 'COP'),
(32, 'Communauté Financière Africaine BCEAO - Francs', 'XOF'),
(33, 'Communauté Financière Africaine BEAC, Francs', 'XAF'),
(34, 'Comoros Franc', 'KMF'),
(35, 'Comptoirs Français du Pacifique Francs', 'XPF'),
(36, 'Costa Rican Colon', 'CRC'),
(37, 'Cuban Peso', 'CUP'),
(38, 'Cyprus Pound', 'CYP'),
(39, 'Czech Republic Koruna', 'CZK'),
(40, 'Danish Krone', 'DKK'),
(41, 'Democratic Yemeni Dinar', 'YDD'),
(42, 'Dominican Peso', 'DOP'),
(43, 'East Caribbean Dollar', 'XCD'),
(44, 'East Timor Escudo', 'TPE'),
(45, 'Ecuador Sucre', 'ECS'),
(46, 'Egyptian Pound', 'EGP'),
(47, 'El Salvador Colon', 'SVC'),
(48, 'Estonian Kroon (EEK)', 'EEK'),
(49, 'Ethiopian Birr', 'ETB'),
(50, 'Euro', 'EUR'),
(51, 'Falkland Islands Pound', 'FKP'),
(52, 'Fiji Dollar', 'FJD'),
(53, 'Gambian Dalasi', 'GMD'),
(54, 'Ghanaian Cedi', 'GHC'),
(55, 'Gibraltar Pound', 'GIP'),
(56, 'Gold, Ounces', 'XAU'),
(57, 'Guatemalan Quetzal', 'GTQ'),
(58, 'Guinea Franc', 'GNF'),
(59, 'Guinea-Bissau Peso', 'GWP'),
(60, 'Guyanan Dollar', 'GYD'),
(61, 'Haitian Gourde', 'HTG'),
(62, 'Honduran Lempira', 'HNL'),
(63, 'Hong Kong Dollar', 'HKD'),
(64, 'Hungarian Forint', 'HUF'),
(65, 'Indian Rupee', 'INR'),
(66, 'Indonesian Rupiah', 'IDR'),
(67, 'International Monetary Fund (IMF) Special Drawing ', 'XDR'),
(68, 'Iranian Rial', 'IRR'),
(69, 'Iraqi Dinar', 'IQD'),
(70, 'Irish Punt', 'IEP'),
(71, 'Israeli Shekel', 'ILS'),
(72, 'Jamaican Dollar', 'JMD'),
(73, 'Japanese Yen', 'JPY'),
(74, 'Jordanian Dinar', 'JOD'),
(75, 'Kampuchean (Cambodian) Riel', 'KHR'),
(76, 'Kenyan Schilling', 'KES'),
(77, 'Kuwaiti Dinar', 'KWD'),
(78, 'Lao Kip', 'LAK'),
(79, 'Lebanese Pound', 'LBP'),
(80, 'Lesotho Loti', 'LSL'),
(81, 'Liberian Dollar', 'LRD'),
(82, 'Libyan Dinar', 'LYD'),
(83, 'Macau Pataca', 'MOP'),
(84, 'Malagasy Franc', 'MGF'),
(85, 'Malawi Kwacha', 'MWK'),
(86, 'Malaysian Ringgit', 'MYR'),
(87, 'Maldive Rufiyaa', 'MVR'),
(88, 'Maltese Lira', 'MTL'),
(89, 'Mauritanian Ouguiya', 'MRO'),
(90, 'Mauritius Rupee', 'MUR'),
(91, 'Mexican Peso', 'MXP'),
(92, 'Mongolian Tugrik', 'MNT'),
(93, 'Moroccan Dirham', 'MAD'),
(94, 'Mozambique Metical', 'MZM'),
(95, 'Namibian Dollar', 'NAD'),
(96, 'Nepalese Rupee', 'NPR'),
(97, 'Netherlands Antillian Guilder', 'ANG'),
(98, 'New Yugoslavia Dinar', 'YUD'),
(99, 'New Zealand Dollar', 'NZD'),
(100, 'Nicaraguan Cordoba', 'NIO'),
(101, 'Nigerian Naira', 'NGN'),
(102, 'North Korean Won', 'KPW'),
(103, 'Norwegian Kroner', 'NOK'),
(104, 'Omani Rial', 'OMR'),
(105, 'Pakistan Rupee', 'PKR'),
(106, 'Palladium Ounces', 'XPD'),
(107, 'Panamanian Balboa', 'PAB'),
(108, 'Papua New Guinea Kina', 'PGK'),
(109, 'Paraguay Guarani', 'PYG'),
(110, 'Peruvian Nuevo Sol', 'PEN'),
(111, 'Philippine Peso', 'PHP'),
(112, 'Platinum, Ounces', 'XPT'),
(113, 'Polish Zloty', 'PLN'),
(114, 'Qatari Rial', 'QAR'),
(115, 'Romanian Leu', 'RON'),
(116, 'Russian Ruble', 'RUB'),
(117, 'Rwanda Franc', 'RWF'),
(118, 'Samoan Tala', 'WST'),
(119, 'Sao Tome and Principe Dobra', 'STD'),
(120, 'Saudi Arabian Riyal', 'SAR'),
(121, 'Seychelles Rupee', 'SCR'),
(122, 'Sierra Leone Leone', 'SLL'),
(123, 'Silver, Ounces', 'XAG'),
(124, 'Singapore Dollar', 'SGD'),
(125, 'Slovak Koruna', 'SKK'),
(126, 'Solomon Islands Dollar', 'SBD'),
(127, 'Somali Schilling', 'SOS'),
(128, 'South African Rand', 'ZAR'),
(129, 'Sri Lanka Rupee', 'LKR'),
(130, 'St. Helena Pound', 'SHP'),
(131, 'Sudanese Pound', 'SDP'),
(132, 'Suriname Guilder', 'SRG'),
(133, 'Swaziland Lilangeni', 'SZL'),
(134, 'Swedish Krona', 'SEK'),
(135, 'Swiss Franc', 'CHF'),
(136, 'Syrian Potmd', 'SYP'),
(137, 'Taiwan Dollar', 'TWD'),
(138, 'Tanzanian Schilling', 'TZS'),
(139, 'Thai Baht', 'THB'),
(140, 'Tongan Paanga', 'TOP'),
(141, 'Trinidad and Tobago Dollar', 'TTD'),
(142, 'Tunisian Dinar', 'TND'),
(143, 'Turkish Lira', 'TRY'),
(144, 'Uganda Shilling', 'UGX'),
(145, 'United Arab Emirates Dirham', 'AED'),
(146, 'Uruguayan Peso', 'UYU'),
(147, 'US Dollar', 'USD'),
(148, 'Vanuatu Vatu', 'VUV'),
(149, 'Venezualan Bolivar', 'VEF'),
(150, 'Vietnamese Dong', 'VND'),
(151, 'Yemeni Rial', 'YER'),
(152, 'Yuan (Chinese) Renminbi', 'CNY'),
(153, 'Zaire Zaire', 'ZRZ'),
(154, 'Zambian Kwacha', 'ZMK'),
(155, 'Zimbabwe Dollar', 'ZWD');

-- --------------------------------------------------------

--
-- Table structure for table `exchange_rates`
--

CREATE TABLE IF NOT EXISTS `exchange_rates` (
  `record_id` int(11) NOT NULL,
  `bank_id` int(11) NOT NULL,
  `currency_id` int(11) NOT NULL,
  `unit` int(11) NOT NULL,
  `selling_rate` double DEFAULT NULL,
  `buying_rate` double DEFAULT NULL,
  `forex_date` date NOT NULL,
  `forex_time` time NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exchange_rates`
--

INSERT INTO `exchange_rates` (`record_id`, `bank_id`, `currency_id`, `unit`, `selling_rate`, `buying_rate`, `forex_date`, `forex_time`) VALUES
(1, 8, 77, 1, 0, 345.17, '2015-11-12', '13:24:55'),
(2, 8, 77, 1, 0, 345.17, '2015-11-12', '13:37:42');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`bank_id`);

--
-- Indexes for table `currency`
--
ALTER TABLE `currency`
  ADD PRIMARY KEY (`currency_id`);

--
-- Indexes for table `exchange_rates`
--
ALTER TABLE `exchange_rates`
  ADD PRIMARY KEY (`record_id`),
  ADD KEY `bank_id` (`bank_id`),
  ADD KEY `currency_id` (`currency_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank`
--
ALTER TABLE `bank`
  MODIFY `bank_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `currency`
--
ALTER TABLE `currency`
  MODIFY `currency_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=156;
--
-- AUTO_INCREMENT for table `exchange_rates`
--
ALTER TABLE `exchange_rates`
  MODIFY `record_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `exchange_rates`
--
ALTER TABLE `exchange_rates`
  ADD CONSTRAINT `exchange_rates_ibfk_1` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`),
  ADD CONSTRAINT `exchange_rates_ibfk_2` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`currency_id`),
  ADD CONSTRAINT `exchange_rates_ibfk_3` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`),
  ADD CONSTRAINT `exchange_rates_ibfk_4` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`currency_id`);
--
-- Database: `phpmyadmin`
--

-- --------------------------------------------------------

--
-- Table structure for table `pma__bookmark`
--

CREATE TABLE IF NOT EXISTS `pma__bookmark` (
  `id` int(11) NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Table structure for table `pma__column_info`
--

CREATE TABLE IF NOT EXISTS `pma__column_info` (
  `id` int(5) unsigned NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__designer_coords`
--

CREATE TABLE IF NOT EXISTS `pma__designer_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `v` tinyint(4) DEFAULT NULL,
  `h` tinyint(4) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for Designer';

-- --------------------------------------------------------

--
-- Table structure for table `pma__history`
--

CREATE TABLE IF NOT EXISTS `pma__history` (
  `id` bigint(20) unsigned NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__pdf_pages`
--

CREATE TABLE IF NOT EXISTS `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) unsigned NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__recent`
--

CREATE TABLE IF NOT EXISTS `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Dumping data for table `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{"db":"forexnepal","table":"exchange_rates"},{"db":"forexnepal","table":"bank"},{"db":"forexnepal","table":"currency"}]');

-- --------------------------------------------------------

--
-- Table structure for table `pma__relation`
--

CREATE TABLE IF NOT EXISTS `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_coords`
--

CREATE TABLE IF NOT EXISTS `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT '0',
  `x` float unsigned NOT NULL DEFAULT '0',
  `y` float unsigned NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_info`
--

CREATE TABLE IF NOT EXISTS `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_uiprefs`
--

CREATE TABLE IF NOT EXISTS `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Table structure for table `pma__tracking`
--

CREATE TABLE IF NOT EXISTS `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) unsigned NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin,
  `data_sql` longtext COLLATE utf8_bin,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) unsigned NOT NULL DEFAULT '1'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__userconfig`
--

CREATE TABLE IF NOT EXISTS `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Dumping data for table `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2015-11-05 06:42:35', '{"collation_connection":"utf8mb4_unicode_ci"}');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indexes for table `pma__designer_coords`
--
ALTER TABLE `pma__designer_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indexes for table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indexes for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indexes for table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indexes for table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indexes for table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indexes for table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indexes for table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indexes for table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) unsigned NOT NULL AUTO_INCREMENT;--
-- Database: `test`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_multi_sets`()
    DETERMINISTIC
begin
        select user() as first_col;
        select user() as first_col, now() as second_col;
        select user() as first_col, now() as second_col, now() as third_col;
        end$$

DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
