<?php
//declare the database
$host="localhost";
$user="root";
$password="";
$db="db1";

$con = mysqli_connect($host,$user,$password, 'db1');
session_start();
$uname = $_SESSION['varname'];
$password = $_SESSION['pass'];
echo $uname;
    
echo $password;

    //add 10 points to a persons score
    $sql="SELECT score from user WHERE fname='".$uname."'AND lname='".$password."' limit 1";
	#$sql = "SELECT id, fname, lname, score FROM user";
	$result = mysqli_query($con, $sql);
	
	$row = $result->fetch_assoc();
	$score = (int) $row['score'] + 10;
	echo $score;
	
	$sql="UPDATE user SET score ='" .$score. "'WHERE fname='".$uname."'AND lname='".$password."' limit 1";
	
	if (mysqli_query($con, $sql) === TRUE) {
		echo "Record updated successfully";
		header("Location: game2.php");
	} else {
		echo "Error updating record: ";
}
	
?>

