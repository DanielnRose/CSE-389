<html>
<head>
	<style>
		table{
			font-family: arial, sans-serif;
			border-collapse: collapse;
			width 100%;
			margin-left: 37%;
			margin-right: auto;
		}

		td,th {
			boarder: 1px solid #dddddd;
			text-align: left;
			padding: 10px;
			padding-left: 90px;
			color: white;
		}

		tr:nth-child(even){
				background-color: #gray;
		}
        body{
                margin: 0;
                padding: 0;
                background-size: cover;
                background-position: center;
                background-attachment: fixed;
                background-repeat: no-repeat;
                background-color: #1B2124;
        }

        header{
            background-color: #1B2124;
        }

        header ul{
            list-style: none;
            float: right;
        }
        header .nav-bar li{
            width: 170px;
            text-align: center;
            float: left;    
        }

        header .nav-bar li a{
            text-decoration: none;
            line-height: 40px;
            font-size: 27px;
            color: white;
            padding: 0 10px;
        }

        header .nav-bar a:hover{
            background-color: #e74c3c;
            transition: 1s;
        }

        header .nav-bar li .inbar li{
            display: none;
        }

        header .nav-bar li:hover .inbar li{
            display: block;
        }

        .nav-bar input[value="Logout"]{
            color: white;
            background:transparent;
            font-size: 20px;
            outline: none;
        }
    </style>
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
					<li><a href="#">Leaderboard</a></li>
					<li><a href="contact.php">Contact</a></li>
					<li><input type="submit" value="Logout"></li>
					
				</ul>
		</header>
	</form>



</body>
</html>


<?php
//declare the database
$servername= 'localhost';
$username = 'root';
$password = '';
$dbname = 'db1';


$conn = new mysqli($servername, $username, $password, $dbname);
$sql = "SELECT id, fname, lname, score FROM user";
$result = $conn->query($sql);

//goes through the database and prints the usernames and scores


if ($result->num_rows > 0){
	
echo "<table>";
	while ($row = $result->fetch_assoc()){
		echo " <tr><td> Username: ". $row["fname"].  "</td><td> Score: " . $row["score"]. "</td><td>"; 
	}
	
echo "</table>";
} else {
	echo "0 results";
}
$conn->close();
?>