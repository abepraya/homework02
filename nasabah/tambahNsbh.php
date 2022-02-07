<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$fullname = $_POST['FullName'];
		$email = $_POST['Email'];
		$age = $_POST['Age'];
		$address = $_POST['Address'];
		$phonenumber = $_POST['PhoneNumber'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_nasabah (fullname,email,age,address,phonenumber) VALUES ('$fullname','$email','$age','$address','$phonenumber')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Nasabah';
		}else{
			echo 'Gagal Menambahkan Nasabah';
		}
		
		mysqli_close($con);
	}
?>