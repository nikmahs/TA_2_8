--
-- Database: 'apap_ta'
--
CREATE DATABASE IF NOT EXISTS 'apap_ta' DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE 'apap_ta';

-- --------------------------------------------------------

--
-- Table structure for table 'medical_supplies'
--

DROP TABLE IF EXISTS 'medical_supplies';
CREATE TABLE 'medical_supplies' (
	'id' bigint NOT NULL,
	'nama' varchar(255) NOT NULL,
	'price' bigint NOT NULL,
	'jumlah' int NOT NULL,
	'id_jenis_medical_supplies' bigint NOT NULL,
	'deskripsi' varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `medical_supplies`
--

TRUNCATE TABLE 'medical_supplies';

--
-- Dumping data for table 'medical_supplies'
--

INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (1, 'Siladex', 30000, 9,1,'Obat batuk dengan merk Siladex.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (2, 'Woods', 32000, 2,1,'Obat batuk dengan merk Woods.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (3, 'Benacol', 15000, 6,1,'Sirup yang dapat menyembuhkan batuk.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (4, 'Selvigon', 29000, 8,1,'Menyembuhkan jenis batuk yang iritatif atau disebabkan oleh alergi.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (5, 'Bodrex', 38000, 13,2,'Obat pusing dengan merk Bodrex.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (6, 'Paramex', 30000, 54,2,'Obat pusing dengan merk Paramex.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (7, 'Panadol', 64000, 37,2,'Obat pusing dengan merk Panadol.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (8, 'Ibuprofen', 38000, 74,3,'Obat demam dengan merk Ibuprofen.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (9, 'Acetaminophen', 57000, 85,3,'Obat demam dengan merk Acetaminophen.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (10, 'Aspirin', 89000, 23,3,'Obat demam dengan merk Aspirin.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (11, 'Clomiphene', 89000, 42,4,'Obat haid dengan merk Clomiphene.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (12, 'Dostinex', 18000, 23,4,'Obat haid dengan merk Dostinex.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (13, 'Acarbose', 73000, 41,5,'Obat antidiabetes dengan merk Acarbose.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (14, 'Glyset', 17000, 72,5,'Obat antidiabetes dengan merk Glyset.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (15, 'Kruk', 29000, 98,6,'Alat bantu jalan yang dapat digunakan satu atau dua (berpasangan) untuk mengatur keseimbangan. Cara penggunaannya disandarkan pada ketiak dan ada juga yang disandarkan pada lengan, sehingga agar seimbang biasanya digunakan secara berpasangan.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (16, 'Walker', 76000, 188,6,'Walker merupakan alat bantu jalan yang memiliki dua gagang sebagai tempat pegangan serta empat kaki sebagai penumpu.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (17, 'Tripod', 48950, 80,6,'Tripod sesuai namanya merupakan alat bantu jalan yang memiliki tiga kaki.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (18, 'Oxygen Concentrator', 32489, 90,7,'Oxygen concentrator adalah alat yang bekerja menghasilkan oksigen murni dari udara bebas.');
INSERT INTO medical_supplies ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (19, 'Nebulizer', 90853, 0,7,'Nebulizer adalah alat yang berfungsi untuk mengubah obat asma yang berbentuk cair menjadi gas.');

--
-- Table structure for table 'jenis_medical_supplies'
--

DROP TABLE IF EXISTS 'jenis_medical_supplies';
CREATE TABLE 'jenis_medical_supplies' (
	'id' bigint NOT NULL,
	'jenis_medical_supplies' varchar(255) NOT NULL,
	'id_urgent' int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert 'jenis_medical_supplies'
--

TRUNCATE TABLE 'jenis_medical_supplies';

--
-- Dumping data for table 'jenis_medical_supplies'
--

INSERT INTO jenis_medical_supplies ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (1, 'Obat batuk', 1);
INSERT INTO jenis_medical_supplies ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (2, 'Obat pusing', 2);
INSERT INTO jenis_medical_supplies ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (3, 'Obat demam', 1);
INSERT INTO jenis_medical_supplies ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (4, 'Obat haid', 2);
INSERT INTO jenis_medical_supplies ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (5, 'Obat antidiabetes', 1);
INSERT INTO jenis_medical_supplies ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (6, 'Alat bantu gerak', 2);
INSERT INTO jenis_medical_supplies ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (7, 'Alat bantu pernapasan', 1);

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