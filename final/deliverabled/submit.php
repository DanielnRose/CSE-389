<?php
//declare the database
$x=$_POST['username'];
$y=$_POST['password'];
$servername= 'localhost';
$username = 'root';
$password = '';
$dbname = 'db1';


$conn = new mysqli($servername, $username, $password, $dbname);

//echo "Connection successful!" . "<bc>";

//add username and password into database
$sql = "INSERT INTO user (fname, lname) VALUES ('$x', '$y')";

if($conn->query($sql) === TRUE){
// echo "Signup Sucessful";
} else {
 echo "<bc> Error: " .  $sql . "<br>" . $conn->error;
}

?> 

<html>
<head>
	<title>submit</title>
	<link rel="stylesheet" href="sub.css">

</head>

<body>

<!-- go back to index.php-->
	<header class = "welcome">
		<h1> sign up successful</h1><br>
		
		<a href="index.php" class="button">Log in</a>

	</header>







</body>
</html>