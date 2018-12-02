# Sistem Informasi Farmasi

## Tim Proyek
1. Rico Putra Pradana - 1606892163
2. Mohammad Aulia Hafidh - 
3. Yessica - 
4. Nikmah Salsabila -
5. Athifa Michel - 1606918143

## Checklist Fitur
1. [x] Login

2. [x] Logout

3. [ ] Melihat daftar medical supplies

4. [ ] Web Service menyediakan informasi medical supplies untuk IGD

5. [ ] Melihat detail informasi medical supplies

6. [ ] Menambahkan medical supplies

7. [ ] Mengubah data medical supplies

8. [ ] Menambahkan medical supplies ke inventaris medical supplies sistem rawat jalan

9. [ ] Membuat perencanaan pembelian medical supplies
	- Yang mengajukan perencanaan pembelian adalah Staff Apoteker
	- Ketika pertama kali mengajukan, maka status perancanaan default nya "diajukan"
	- Minggu pertama: 1-7
	- Minggu ketiga: 15-21
	- Sebelum melakukan perencanaan, Staf Apoteker perlu mengecek medical supplies yg habis di SI Lab melalui API yg disediakan oleh SI Lab menggunakan method GET
	
10. [ ] Melihat perencanaan pembelian medical supplies
	- Admin Farmasi yg berperan mengubah status perencanaan menjadi "diproses" dan "tersedia"
	- Ketika status berubah menjadi "tersedia", secara otomatis jumlah Medical Supplies di inventaris SI Farmasi bertambah (terupdate)
	
11. [x] Melihat daftar permintaan medical supplies

12. [ ] Web Service untuk menyediakan kebutuhan medical supplies dari Rawat Inap

13. [ ] Mengubah status permintaan medical supplies

14. [ ] Membuat jadwal staf apoteker jaga

15. [ ] Mengubah jadwal staf apoteker jaga

16. [ ] Melihat jadwal staf apoteker jaga

## Dokumentasi Web Service


## Database
1. [ ] MEDICAL_SUPPLIES
	Merepresentasikan inventaris medical supplies yang terdiri atas obat-obat dan alat-alat kesehatan yang dimiliki SI Farmasi (contoh nama obat: Acarbose).
	- id : bigint (AI)
	- nama : varchar (255)
	- price : bigint
	- jumlah : int
	- id_jenis_medical_supplies : bigint
	- deskripsi : varchar (255)
2. [ ] JENIS_MEDICAL_SUPPLIES
	Merepresentasikan kategori jenis dari medical supplies (contoh jenis obat: obat antidiabetes).
	- id : bigint (AI)
	- jenis_medical_supplies : varchar (255)
	- id_urgent : int
3. [ ] FLAG_URGENT
	Merepresentasikan kategori medical supplies yang urgent (nilai 0 untuk medical supplies yang non urgent dan 1 untuk medical supplies yang urgent). 
	- id : int (AI)
	- flag : smallint
	- deskripsi_flag_urgent : varchar (255)
4. [ ] PERENCANAAN
	Merepresentasikan perencanaan yang dilakukan untuk menambah inventaris medical supplies (status: diajukan, diproses, dan tersedia). 
	- id : bigint (AI)
	- tanggal : time
	- status : varchar (255)
	- id_medical_supplies : bigint
	- jumlah
5. [ ] PERMINTAAN
	Merepresentasikan permintaan medical supplies yang dilakukan Sistem Informasi lain.
	- id : bigint
	- tanggal : time
	- id_medical_supplies : bigint
	- jumlah_medical_supplies : bigint
	- id_jadwal : bigint
	- id_status_permintaan : int
	- id_pasien : int
6. [ ] STATUS PERMINTAAN
	Merepresentasikan kategori dari jenis sebuah permintaan medical supplies (status: pending, diterima, dan ditolak).
	- id : int (AI)
	- nama : varchar (255)
	- deskripsi : varchar (255)
7. [ ] JADWAL_JAGA
	Merepresentasikan daftar jadwal jaga semua staf apoteker.
	- id : bigint (AI)
	- tanggal : time
	- waktu_mulai : time
	- waktu_selesai : time
	- id_staff : int
8. [ ] USER_ROLE
	Role: admin dan staff.
	- username : varchar (255)
	- password : varchar (255)
	- role : varchar (255)


## Constraint
### apa ya
1. Ketika kita menambah inventaris obat SI Rawat Jalan, kita gak perlu tau apakah sana butuh atau enggak. Terserah kita kalo mau nambah kapan aja dan apa aja dan berapa aja

### Perencanaan
kalo diliat2, kalo kita cuma bisa melakukan perencanaan untuk medsup yg habis di SI Lab, itu kurang enak gak sih

karena, di inventaris kita, SI Farmasi, bakalan ada medsup yg URGENT. Jadi, menurut gua, gua perlu revisi lagi

1. Nanti di interface nya, ketika mau melakukan perencanaan, tanyakan dulu apakah medsup yg direncanakan nanti yg sifatnya Urgent atau tidak
2. Kalau sifatnya Urgent, nanti cukup tampilkan atau sediakan daftar pilihan medical supplies yg urgent
3. Kalau sifatnya gak urgent, nanti tampilkan daftar semua medical supplies
4. Kalau urgent, bisa melakukan perencanaan untuk kapan aja
5. Kalau gak urgent, cuma bisa melakukan perencanaan untuk tanggal 1-7 (include) atau 15-21 (include) di setiap bulannya. Saran gue, nanti pas memasukkan tanggal milih aja tanggal nya. Dan ketika user memilih tanggal selain range di atas, dikasih notif ERROR blablabla gitu karena tanggal nya gak sama
6. Urgent maupun gak urgent, nanti sistem langsung ngecek medsup yg habis di SI Lab. Artinya, ketika user pilih salah satu (urgent/ gak urgent) nanti sistem langsung manggil web service yg disediakan oleh SI Lab tsb.
7. Terus, return value dari pemanggilan API itu sifatnya cuma untuk ngasih tau user kalo medsup yg abis di SI Lab itu ini ini ini... dan diharapkan user melakukan perencanaan untuk medsup yg habis tsb dan medsub lain yg user inginkan sesuai  dengan ketentuan di nomer 2-5. 
8. Ketika user tekan tombol submit perencanaan, kalo medsup yg abis ada yg belum ikut direncanakan, user dikasih notifikasi bahwa ada medsub A, B, C yg belum direncanakan. Apakah akan tetap submit atau edit form ulang?
9. Setelah submit, udah deh pikir lagi besok
