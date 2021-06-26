# Host: localhost  (Version 5.5.5-10.4.14-MariaDB)
# Date: 2021-06-14 16:21:21
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "karyawan"
#

DROP TABLE IF EXISTS `karyawan`;
CREATE TABLE `karyawan` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nama_karyawan` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(100) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

#
# Data for table "karyawan"
#

INSERT INTO `karyawan` VALUES (1,'Budi','Laki-Laki','OB','Jakarta Selatan'),(2,'Arya','Laki-Laki','Pelayanan Medik','Pondok Cabe'),(3,'Dewi','Perempuan','Keperawatan','Bojongsari'),(4,'Rina','Perempuan','Tata Usaha Dan Kepegawaian','Depok');

#
# Structure for table "obat"
#

DROP TABLE IF EXISTS `obat`;
CREATE TABLE `obat` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nama_obat` varchar(100) NOT NULL,
  `jenis_obat` varchar(100) NOT NULL,
  `harga` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

#
# Data for table "obat"
#

INSERT INTO `obat` VALUES (1,'Albendazole','Tablet','55000'),(2,'Ambroxol','Tablet','10000'),(3,'Bisolvon','Sirop','15000'),(4,'Chloramphenicol','Salep','30000');

#
# Structure for table "pasien"
#

DROP TABLE IF EXISTS `pasien`;
CREATE TABLE `pasien` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `nama_pasien` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(100) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

#
# Data for table "pasien"
#

INSERT INTO `pasien` VALUES (1,'Renaldi','Laki-Laki','Ciledug'),(2,'Sadeli','Laki-Laki','Bintaro'),(3,'Okta','Laki-Laki','Bintaro'),(4,'Putri','Perempuan','Cinere');
