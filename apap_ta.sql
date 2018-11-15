--
-- Database: 'apap_ta'
--
CREATE DATABASE IF NOT EXISTS 'apap_ta' DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE 'apap_ta';

-- --------------------------------------------------------

--
-- Table structure for table 'flag_urgent'
--

DROP TABLE IF EXISTS 'flag_urgent';
CREATE TABLE 'flag_urgent' (
	'id' int NOT NULL,
	'flag' smallint NOT NULL,
	'deskripsi_flag_urgent' varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `flag_urgent`
--

TRUNCATE TABLE 'flag_urgent';

--
-- Dumping data for table 'flag_urgent'
--

INSERT INTO 'flag_urgent' ('id', 'flag', 'deskripsi_flag_urgent') VALUES 
(1, 0, 'Non Urgent'),
(2, 1, 'Urgent');