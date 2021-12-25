<?php
//declare the database
$host="localhost";
$user="root";
$password="";
$db="db1";

$con = mysqli_connect($host,$user,$password, 'db1');
session_start();

//gets username from post

if(isset($_POST['username'])){
    
    $uname=$_POST['username'];
    $password=$_POST['password'];
    
	//checks for the account in the database
	
    $sql="select * from user where fname='".$uname."'AND lname='".$password."' limit 1";
    
    $result=mysqli_query($con, $sql);
    
    if(mysqli_num_rows($result)==1){
		$_SESSION['varname'] = $uname;
		$_SESSION['pass'] = $password;
		sleep(.5);
        echo " You Have Successfully Logged in";
		//brings you to the homepage
		header("Location: homepage.php"); 
  //brings you back to index.php if you are not in the database
exit; 
    }
    else{
        echo " You Have Entered Incorrect Password";
		header("Location: index.php"); 
		exit; 
    }
        
}


?>
<!-- signup link -->
<form method="get" action="homepage.php">
    <input type="text" name="regName" value="">
    <input type="submit">
</form>

