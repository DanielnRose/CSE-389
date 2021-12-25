<html>
<head>
	<title>Homepage</title>
	<link rel="stylesheet" href="homep.css">
</head>
<body>
<!-- navigation bar -->
	<form action="index.php" method="post">
	<header>
			<ul class="nav-bar">
				<li><a href="homepage.php">Home</a></li>
				<li><a href="game1process.php">Deadly Spit</a></li>
				<li><a href="game2process.php">Minecraft</a></li>
				<li><a href="game3process.php">Crazy Taxi</a></li>
				<li><a href="#">Others</a>
				<ul class="inbar">
					<li><a href="#">Game 4</a></li>
					<li><a href="#">Game 5</a></li>
					<li><a href="#">Game 6</a></li>
				</ul></li>
				<li><a href="leaderboard.php">Leaderboard</a></li>
				<li><a href="contact.php">Contact</a></li>
				
				<li><input type="submit" value="Logout" ></li>
				
			</ul>
	</header>
</form>
<?php
session_start();
$username = $_SESSION['varname'];
?>
<p>Welcome <?php echo $username;?>
    </p>


<!-- Three hompage links -->

	<div class="main">
		<div class="wrap">

			<a href="game1process.php"><img src="cat1.png"></a>
			<h3>Deadly Spit II</h3>

		</div>

		<div class="wrap">

			<a href="game2process.php"><img src="mc.png"></a>
			<h3>Minecraft Classic</h3>

		</div>

		<div class="wrap">
			<a href="game3process.php"><img src="taxi2.png"></a>
			<h3>Crazy Taxi</h3>
		</div>

	</div>




</body>
</html>


