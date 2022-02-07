<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Dari Variable 
		$id = $_POST['id'];
		$fullname = $_POST['FullName'];
		$email = $_POST['Email'];
		$age = $_POST['Age'];
		$address = $_POST['Address'];
		$phonenumber = $_POST['PhoneNumber'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE tb_nasabah SET fullname = '$fullname', email = '$email', age = '$age', address = '$address',phonenumber = '$phonenumber' WHERE id = $id;";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Nasabah';
		}else{
			echo 'Gagal Update Data Nasabah';
		}
		
		mysqli_close($con);
	}
?>