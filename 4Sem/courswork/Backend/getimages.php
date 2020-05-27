<?php
	$name = $_POST["name"];
	$image = $_POST["image"];
	$decodedImage = base64_decode("$image");
	file_put_contents("/home/arinadrakon/pictures/" . $name , $decodedImage);
	system("python3 /home/arinadrakon/backend/production.py");
?>
