<html>
<head>
	<title> </title>
    <style>
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
		iframe{
            margin-top: 2%;
            margin-left: 32.5%;
            margin-right: auto;
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
					<li><a href="leaderboard.php">Leaderboard</a></li>
					<li><a href="contact.php">Contact</a></li>
					<li><input type="submit" value="Logout"></li>
					
				</ul>
		</header>
	</form>
<!-- we added the gane with an iframe -->
<iframe src="https://funhtml5games.com?embed=crazytaxi" style="width:750px;height:750px;border:none;" frameborder="0" scrolling="no"></iframe>

</body>
</html>