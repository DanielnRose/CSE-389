


<html>
<head>
    <title>Contact</title>
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

        .wrap{
            background: transparent;
            padding-top: 15%;
            height: 600px;
        }
        .wrap h1{
            color: white;
            text-align: center;
        }

        .wrap .fbox{
            width: 600px;
            margin: auto;
            padding-left: 20px;
        }
        .wrap .design{
            width: 100%;
            background: transparent;
            box-sizing: border-box;
            display: block;
            color: white;
            outline: none;
            border-color: transparent;
            padding-top: 20px;
            padding-left: 40px;
            margin-top: 20px;
            font-size: 20px;
        }


    </style>
<form action="index.php" method="post">
</head>
<body>

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
                <li><a href="#">Contact</a></li>
				<li><input type="submit" value="Logout" ></li>
				</form>
            </ul>
    </header>
</form>
    <div class="wrap">
        <h1>Contact</h1>
        <form action="" method="post" class="fbox">
            <input type="text" name="fullname" placeholder="Full name" class="design" required>
            <input type="email" name="email" placeholder="cool@gmail.com" class="design" required>
            <textarea name="Information" placeholder="Type your message here" class="design"></textarea>

            <input type="submit" value="Submit" class="design">

        </form>
    </div>



</body>
</html>