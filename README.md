# Sistem Informasi Farmasi
Sistem Informasi Farmasi (SI Farmasi) merupakan sebuah sistem yang dibuat berdasarkan sebuah kasus yang disediakan oleh tim pengajar matakuliah Arsitektur & Pemrograman Aplikasi Perusahaan (APAP) Semester Gasal Tahun Ajaran 2017/2018 Fakultas Ilmu Komputer Universitas Indonesia. SI Farmasi dibuat untuk memenuhi kebutuhan pengeolaan farmasi di sebuah rumah sakit bayangan. Terdapat 16 fitur yang telah didefinisikan sebelumnya.

## Tim Proyek
1. Rico Putra Pradana
2. Mohammad Aulia Hafidh
3. Yessica
4. Nikmah Salsabila
5. Athifa Michel

## Checklist Fitur
1. Login
2. Logout
3. Melihat daftar medical supplies
4. Web Service menyediakan informasi medical supplies untuk IGD
5. Melihat detail informasi medical supplies
6. Menambahkan medical supplies
7. Mengubah data medical supplies
8. Menambahkan medical supplies ke inventaris medical supplies sistem rawat jalan
9. Membuat perencanaan pembelian medical supplies
10. Melihat perencanaan pembelian medical supplies
11. Melihat daftar permintaan medical supplies
12. Web Service untuk menyediakan kebutuhan medical supplies dari Rawat Inap
13. Mengubah status permintaan medical supplies
14. Membuat jadwal staf apoteker jaga
15. Mengubah jadwal staf apoteker jaga
16. Melihat jadwal staf apoteker jaga

## Database
1. MEDICAL_SUPPLIES
	Merepresentasikan inventaris medical supplies yang terdiri atas obat-obat dan alat-alat kesehatan yang dimiliki SI Farmasi (contoh nama obat: Acarbose).
	- id : bigint (AI)
	- nama : varchar (255)
	- price : bigint
	- jumlah : int
	- id_jenis_medical_supplies : bigint
	- deskripsi : varchar (255)
2. JENIS_MEDICAL_SUPPLIES
	Merepresentasikan kategori jenis dari medical supplies (contoh jenis obat: obat antidiabetes).
	- id : bigint (AI)
	- jenis_medical_supplies : varchar (255)
	- id_urgent : int
3. FLAG_URGENT
	Merepresentasikan kategori medical supplies yang urgent (nilai 0 untuk medical supplies yang non urgent dan 1 untuk medical supplies yang urgent). 
	- id : int (AI)
	- flag : smallint
	- deskripsi_flag_urgent : varchar (255)
4. PERENCANAAN
	Merepresentasikan perencanaan yang dilakukan untuk menambah inventaris medical supplies (status: diajukan, diproses, dan tersedia). 
	- id : bigint (AI)
	- tanggal : time
	- status : varchar (255)
	- id_medical_supplies : bigint
	- jumlah
5. PERMINTAAN
	Merepresentasikan permintaan medical supplies yang dilakukan Sistem Informasi lain.
	- id : bigint
	- tanggal : time
	- id_medical_supplies : bigint
	- jumlah_medical_supplies : bigint
	- id_jadwal : bigint
	- id_status_permintaan : int
	- id_pasien : int
6. STATUS PERMINTAAN
	Merepresentasikan kategori dari jenis sebuah permintaan medical supplies (status: pending, diterima, dan ditolak).
	- id : int (AI)
	- nama : varchar (255)
	- deskripsi : varchar (255)
7. JADWAL_JAGA
	Merepresentasikan daftar jadwal jaga semua staf apoteker.
	- id : bigint (AI)
	- tanggal : time
	- waktu_mulai : time
	- waktu_selesai : time
	- id_staff : int
8. USER_ROLE
	Role: admin dan staff.
	- username : varchar (255)
	- password : varchar (255)
	- role : varchar (255)
