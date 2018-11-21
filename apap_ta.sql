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

INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (1, 'Siladex', 30000, 9,1,'Obat batuk dengan merk Siladex.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (2, 'Woods', 32000, 2,1,'Obat batuk dengan merk Woods.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (3, 'Benacol', 15000, 6,1,'Sirup yang dapat menyembuhkan batuk.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (4, 'Selvigon', 29000, 8,1,'Menyembuhkan jenis batuk yang iritatif atau disebabkan oleh alergi.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (5, 'Bodrex', 38000, 13,2,'Obat pusing dengan merk Bodrex.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (6, 'Paramex', 30000, 54,2,'Obat pusing dengan merk Paramex.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (7, 'Panadol', 64000, 37,2,'Obat pusing dengan merk Panadol.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (8, 'Ibuprofen', 38000, 74,3,'Obat demam dengan merk Ibuprofen.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (9, 'Acetaminophen', 57000, 85,3,'Obat demam dengan merk Acetaminophen.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (10, 'Aspirin', 89000, 23,3,'Obat demam dengan merk Aspirin.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (11, 'Clomiphene', 89000, 42,4,'Obat haid dengan merk Clomiphene.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (12, 'Dostinex', 18000, 23,4,'Obat haid dengan merk Dostinex.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (13, 'Acarbose', 73000, 41,5,'Obat antidiabetes dengan merk Acarbose.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (14, 'Glyset', 17000, 72,5,'Obat antidiabetes dengan merk Glyset.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (15, 'Kruk', 29000, 98,6,'Alat bantu jalan yang dapat digunakan satu atau dua (berpasangan) untuk mengatur keseimbangan. Cara penggunaannya disandarkan pada ketiak dan ada juga yang disandarkan pada lengan, sehingga agar seimbang biasanya digunakan secara berpasangan.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (16, 'Walker', 76000, 188,6,'Walker merupakan alat bantu jalan yang memiliki dua gagang sebagai tempat pegangan serta empat kaki sebagai penumpu.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (17, 'Tripod', 48950, 80,6,'Tripod sesuai namanya merupakan alat bantu jalan yang memiliki tiga kaki.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (18, 'Oxygen Concentrator', 32489, 90,7,'Oxygen concentrator adalah alat yang bekerja menghasilkan oksigen murni dari udara bebas.');
INSERT INTO 'medical_supplies' ('id', 'nama', 'price', 'jumlah', 'id_jenis_medical_supplies', 'deskripsi') VALUES (19, 'Nebulizer', 90853, 0,7,'Nebulizer adalah alat yang berfungsi untuk mengubah obat asma yang berbentuk cair menjadi gas.');

-- ---------------------------------------------------------------------------------------------------------

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

INSERT INTO 'jenis_medical_supplies' ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (1, 'Obat batuk', 1);
INSERT INTO 'jenis_medical_supplies' ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (2, 'Obat pusing', 2);
INSERT INTO 'jenis_medical_supplies' ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (3, 'Obat demam', 1);
INSERT INTO 'jenis_medical_supplies' ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (4, 'Obat haid', 2);
INSERT INTO 'jenis_medical_supplies' ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (5, 'Obat antidiabetes', 1);
INSERT INTO 'jenis_medical_supplies' ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (6, 'Alat bantu gerak', 2);
INSERT INTO 'jenis_medical_supplies' ('id', 'jenis_medical_supplies', 'id_urgent') VALUES (7, 'Alat bantu pernapasan', 1);

-- ------------------------------------------------------------------------------------------

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

-- ---------------------------------------------------------------------

--
-- Table structure for table 'permintaan'
--

DROP TABLE IF EXISTS 'permintaan';
CREATE TABLE 'permintaan' (
	'id' bigint NOT NULL,
	'tanggal' date NOT NULL,
	'id_medical_supplies' bigint NOT NULL,
	'jumlah_medical_supplies' bigint NOT NULL,
	'id_jadwal' bigint NOT NULL,
	'id_status_permintaan' int NOT NULL,
	'id_pasien' int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert 'permintaan'
-- 

TRUNCATE TABLE 'permintaan';

--
-- Dumping data for table 'permintaan'
--

INSERT INTO 'permintaan' ('id', 'tanggal', 'id_medical_supplies', 'jumlah_medical_supplies', 'id_jadwal', 'id_status_permintaan', 'id_pasien') VALUES (1, '2018-11-13', 1, 70, 3, 1, 123);
INSERT INTO 'permintaan' ('id', 'tanggal', 'id_medical_supplies', 'jumlah_medical_supplies', 'id_jadwal', 'id_status_permintaan', 'id_pasien') VALUES (2, '2018-11-18', 5, 60, 2, 2, 122);
INSERT INTO 'permintaan' ('id', 'tanggal', 'id_medical_supplies', 'jumlah_medical_supplies', 'id_jadwal', 'id_status_permintaan', 'id_pasien') VALUES (3, '2018-11-22', 10, 50, 10, 1, 124);
INSERT INTO 'permintaan' ('id', 'tanggal', 'id_medical_supplies', 'jumlah_medical_supplies', 'id_jadwal', 'id_status_permintaan', 'id_pasien') VALUES (4, '2018-12-2', 12, 90, 5, 3, 121);
INSERT INTO 'permintaan' ('id', 'tanggal', 'id_medical_supplies', 'jumlah_medical_supplies', 'id_jadwal', 'id_status_permintaan', 'id_pasien') VALUES (5, '2018-12-14', 19, 30, 7, 2, 120);

-- --------------------------------------------------------------------------------------

--
-- Table structure for table 'permintaan_medical_supplies'
--

DROP TABLE IF EXISTS 'permintaan_medical_supplies';
CREATE TABLE 'permintaan_medical_supplies' (
	'id' bigint NOT NULL,
	'id_permintaan' bigint NOT NULL,
	'id_medical_supplies' bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert 'permintaan_medical_supplies'
--

TRUNCATE TABLE 'permintaan_medical_supplies';

--
-- Dumping data for table 'permintaan_medical_supplies'
--

INSERT INTO 'permintaan_medical_supplies' ('id','id_permintaan','id_medical_supplies') VALUES (1,1,1);
INSERT INTO 'permintaan_medical_supplies' ('id','id_permintaan','id_medical_supplies') VALUES (2,2,5);
INSERT INTO 'permintaan_medical_supplies' ('id','id_permintaan','id_medical_supplies') VALUES (3,3,10);
INSERT INTO 'permintaan_medical_supplies' ('id','id_permintaan','id_medical_supplies') VALUES (4,4,12);
INSERT INTO 'permintaan_medical_supplies' ('id','id_permintaan','id_medical_supplies') VALUES (5,5,19);

-- -----------------------------------------------------

-- 
-- Table structure for table 'status_permintaan'
--

DROP TABLE IF EXISTS 'status_permintaan';
CREATE TABLE 'status_permintaan' (
	'id' int NOT NULL,
	'nama' varchar(255) NOT NULL,
	'deskripsi' varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert 'status_permintaan'
--

TRUNCATE TABLE 'status_permintaan';

--
-- Dumping data for table 'status_permintaan'
--

INSERT INTO 'status_permintaan' ('id', 'nama', 'deskripsi') VALUES (1, 'pending', 'permintaan sedang dalam status pending');
INSERT INTO 'status_permintaan' ('id', 'nama', 'deskripsi') VALUES (2, 'diterima', 'permintaan diterima');
INSERT INTO 'status_permintaan' ('id', 'nama', 'deskripsi') VALUES (3, 'ditolak', 'permintaan ditolak');

- ---------------------------------------------------------------------------

--
-- Table structure for table 'jadwal_jaga'
--

DROP TABLE IF EXISTS 'jadwal_jaga';
CREATE TABLE 'jadwal_jaga' (
	'id' bigint NOT NULL,
	'tanggal' date NOT NULL,
	'waktu_mulai' time NOT NULL,
	'waktu_selesai' time NOT NULL,
	'id_staff' int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert 'jadwal_jaga'
--

TRUNCATE TABLE 'jadwal_jaga';

--
-- Dumping data for table 'jadwal jaga'
--

INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (1, '2018-11-20', '8:00:00', '15:59:59', 1);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (2, '2018-11-20', '16:00:00', '23:59:59', 2);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (3, '2018-11-21', '8:00:00', '15:59:59', 3);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (4, '2018-11-21', '16:00:00', '23:59:59', 4);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (5, '2018-11-22', '8:00:00', '15:59:59', 5);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (6, '2018-11-22', '16:00:00', '23:59:59', 6);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (7, '2018-11-23', '8:00:00', '15:59:59', 7);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (8, '2018-11-23', '16:00:00', '23:59:59', 8);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (9, '2018-11-24', '8:00:00', '15:59:59', 9);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (10, '2018-11-24', '16:00:00', '23:59:59', 10);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (11, '2018-11-26', '8:00:00', '15:59:59', 11);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (12, '2018-11-26', '16:00:00', '23:59:59', 12);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (13, '2018-11-27', '8:00:00', '15:59:59', 13);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (14, '2018-11-27', '16:00:00', '23:59:59', 14);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (15, '2018-11-28', '8:00:00', '15:59:59', 15);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (16, '2018-11-28', '16:00:00', '23:59:59', 16);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (17, '2018-11-29', '8:00:00', '15:59:59', 17);
INSERT INTO 'jadwal_jaga' ('id', 'tanggal', 'waktu_mulai', 'waktu_selesai', 'id_staff') VALUES (18, '2018-11-29', '16:00:00', '23:59:59', 18);

-- ------------------------------------------------------------------------

--
-- Table structure for table 'user_role'
--

DROP TABLE IF EXISTS 'user_role';
CREATE TABLE 'user_role' (
	'username' varchar(255) NOT NULL,
	'password' varchar(255) NOT NULL,
	'role' varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert 'user_role'
--

TRUNCATE TABLE 'user_role';

--
-- Dumping data for table 'user_role'
--

INSERT INTO 'user' ('username', 'password', 'role') VALUES ('nikmah.salsabila', 'abcd123', 'ADMIN');
INSERT INTO 'user' ('username', 'password', 'role') VALUES ('athifa.michel', '123abcd', 'STAF');
INSERT INTO 'user' ('username', 'password', 'role') VALUES ('rico.putra', '1a2b3c4d5e', 'ADMIN');

-- ------------------------------------------------------------------------------------------------

--
-- Table structure for table 'perencanaan'
--

DROP TABLE IF EXISTS 'perencanaan';
CREATE TABLE 'perencanaan' (
	'id' bigint NOT NULL,
	'tanggal' date NOT NULL,
	'status' varchar(255) NOT NULL,
	'id_medical_supplies' bigint NOT NULL,
	'jumlah' int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert 'perencanaan'
--

TRUNCATE TABLE 'perencanaan';

--
-- Dumping data for table 'perencanaan'
--

INSERT INTO 'perencanaan' ('id', 'tanggal', 'status', 'id_medical_supplies', 'jumlah') VALUES (1, '2018-11-13', 'diajukan', 1, 30);
INSERT INTO 'perencanaan' ('id', 'tanggal', 'status', 'id_medical_supplies', 'jumlah') VALUES (2, '2018-11-18', 'diajukan', 5, 100);
INSERT INTO 'perencanaan' ('id', 'tanggal', 'status', 'id_medical_supplies', 'jumlah') VALUES (3, '2018-11-22', 'diajukan', 10, 20);
INSERT INTO 'perencanaan' ('id', 'tanggal', 'status', 'id_medical_supplies', 'jumlah') VALUES (4, '2018-12-2', 'diajukan', 12, 50);
INSERT INTO 'perencanaan' ('id', 'tanggal', 'status', 'id_medical_supplies', 'jumlah') VALUES (5, '2018-12-14', 'diajukan', 19, 100);

-- -------------------------------------------------------------------------------------

--
-- Table structure for table 'perencanaan_medical_supplies'
--

DROP TABLE IF EXISTS 'perencanaan_medical_supplies';
CREATE TABLE 'permintaan_medical_supplies' (
	'id' bigint NOT NULL,
	'id_perencanaan' bigint NOT NULL,
	'id_medical_supplies' bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert 'perencanaan_medical_supplies'
--

TRUNCATE TABLE 'perencanaan_medical_supplies';

--
-- Dumping data for table 'perencanaan_medical_supplies'
--

INSERT INTO 'perencanaan_medical_supplies' ('id', 'id_perencanaan', 'id_medical_supplies') VALUES (1,1,1);
INSERT INTO 'perencanaan_medical_supplies' ('id', 'id_perencanaan', 'id_medical_supplies') VALUES (2,2,5);
INSERT INTO 'perencanaan_medical_supplies' ('id', 'id_perencanaan', 'id_medical_supplies') VALUES (3,3,10);
INSERT INTO 'perencanaan_medical_supplies' ('id', 'id_perencanaan', 'id_medical_supplies') VALUES (4,4,12);
INSERT INTO 'perencanaan_medical_supplies' ('id', 'id_perencanaan', 'id_medical_supplies') VALUES (5,5,19);

-- ---------------------------------------------------------

--
-- Set PK and unique key for each table
--

ALTER TABLE 'medical_supplies' 
	ADD PRIMARY KEY ('id'),
	ADD KEY 'nama' ('nama');

ALTER TABLE 'jenis_medical_supplies' 
	ADD PRIMARY KEY ('id'),
	ADD KEY 'jenis_medical_supplies' ('jenis_medical_supplies');

ALTER TABLE 'permintaan' ADD PRIMARY KEY ('id');
ALTER TABLE 'status_permintaan' ADD PRIMARY KEY ('id');
ALTER TABLE 'perencanaan' ADD PRIMARY KEY ('id');
ALTER TABLE 'flag_urgent' ADD PRIMARY KEY ('id');
ALTER TABLE 'jadwal_jaga' ADD PRIMARY KEY ('id');
ALTER TABLE 'permintaan_medical_supplies' ADD PRIMARY KEY ('id');
ALTER TABLE 'perencanaan_medical_supplies' ADD PRIMARY KEY ('id');
ALTER TABLE 'user_role' ADD PRIMARY KEY ('username');

-- ----------------------------------------

--
-- Set Foreign Key
--

ALTER TABLE 'medical_supplies' 
	ADD CONSTRAINT 'medical_supplies_ibfk_1' FOREIGN KEY ('id_jenis_medical_supplies') REFERENCES 'jenis_medical_supplies' ('id') ON UPDATE CASCADE;

ALTER TABLE 'jenis_medical_supplies' 
	ADD CONSTRAINT 'jenis_medical_supplies_ibfk_1' FOREIGN KEY ('id_urgent') REFERENCES 'flag_urgent' ('id') ON UPDATE CASCADE;

ALTER TABLE 'permintaan' 
	ADD CONSTRAINT 'permintaan_ibfk_1' FOREIGN KEY ('id_medical_supplies') REFERENCES 'medical_supplies' ('id') ON UPDATE CASCADE,
	ADD CONSTRAINT 'permintaan_ibfk_2' FOREIGN KEY ('id_jadwal') REFERENCES 'jadwal_jaga' ('id') ON UPDATE CASCADE,
	ADD CONSTRAINT 'permintaan_ibfk_3' FOREIGN KEY ('id_status_permintaan') REFERENCES 'status_permintaan' ('id') ON UPDATE CASCADE;

ALTER TABLE 'perencanaan' 
	ADD CONSTRAINT 'perencanaan_ibfk_1' FOREIGN KEY ('id_medical_supplies') REFERENCES 'medical_supplies' ('id') ON UPDATE CASCADE;

ALTER TABLE 'permintaan_medical_supplies' 
	ADD CONSTRAINT 'permintaan_medical_supplies_ibfk_1' FOREIGN KEY ('id_permintaan') REFERENCES 'permintaan' ('id') ON UPDATE CASCADE,
	ADD CONSTRAINT 'permintaan_medical_supplies_ibfk_2' FOREIGN KEY ('id_medical_supplies') REFERENCES 'medical_supplies' ('id') ON UPDATE CASCADE;

ALTER TABLE 'perencanaan_medical_supplies' 
	ADD CONSTRAINT 'perencanaan_medical_supplies_ibfk_1' FOREIGN KEY ('id_perencanaan') REFERENCES 'perencanaan' ('id') ON UPDATE CASCADE,
	ADD CONSTRAINT 'perencanaan_medical_supplies_ibfk_2' FOREIGN KEY ('id_medical_supplies') REFERENCES 'medical_supplies' ('id') ON UPDATE CASCADE;