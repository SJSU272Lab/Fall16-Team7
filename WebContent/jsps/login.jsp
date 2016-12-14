<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">

body, html{
    height: 100%;
 	background-repeat: no-repeat;
 	background-color: #d3d3d3;
 	font-family: 'Oxygen', sans-serif;
}

.main{
 	margin-top: 70px;
}

h1.title { 
	font-size: 50px;
	font-family: 'Passion One', cursive; 
	font-weight: 400; 
}

hr{
	width: 10%;
	color: #fff;
}

.form-group{
	margin-bottom: 15px;
}

label{
	margin-bottom: 15px;
}

input,
input::-webkit-input-placeholder {
    font-size: 11px;
    padding-top: 3px;
}

.main-login{
 	background-color: #fff;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

}

.main-center{
 	margin-top: 30px;
 	margin: 0 auto;
 	max-width: 330px;
    padding: 40px 40px;

}

.login-button{
	margin-top: 5px;
}

.login-register{
	font-size: 11px;
	text-align: center;
}



/* main.css */
root {
    display: block;
}

body {
    font-family: sans-serif;
}


#userID {
    text-align: right;
}

#html5images {
    text-align: center;
}

#html5images img {
    width: 64px;
    height: 64px;
}

h2 {
    text-align: center;
}

table {
    text-align: center;
    padding: 5;
    border-spacing: 10;
    margin: auto;
}


.label {
    vertical-align: top;
    text-align: left;
}

.label p {
    color: blue;
}

.value {
    vertical-align: central;
    background-color: #E8E8E8;
    text-align: left;

}

#resultID, #newBid {
    text-align: center;
}

#comboID {
     width: 300px;
}

.innertable {
    text-align: center;
    padding: 5;
    border-spacing: 10;
}

.centered {
    text-align: center;
}


/* main.css end */

</style>


<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- Website CSS style -->
<!-- <link rel="stylesheet" type="text/css" href="assets/css/main.css"> -->

<!-- Website Font style -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

<title>Admin</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand">SmartAds</a>
		</div>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="/frontPage">Home</a></li>
			<li><a href="/service">Service </a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="active"><a href="/login">login </a></li>
			<li><a href="/signUp">sign up</a></li>
		</ul>
	</div>
	</nav>


	<div class="container" style="margin-top:50px">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">Login</h1>
					<!-- <hr/> -->
				</div>
			</div>
			
			<div class="main-login main-center">
				<form action="/login" class="form-horizontal" method="post" >
					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Username</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span> 
								<input type="text" class="form-control" name="username"  placeholder="Enter your Username" />
							</div>
						</div>
						
					</div>

					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span> 
								<input type="password" class="form-control" name="password"  placeholder="Enter your Password" />
							
							</div>
							
						</div>
					</div>
					
					<div class="form-group" style="color:red;">${error} </div>

					

					<div class="form-group ">
						<button id="submit" type="submit" type="button" class="btn btn-primary btn-lg btn-block login-button" ">Login</button>
					</div>
					
					<div class="login-register">
						<a href="/signUp">Sign up</a>
					</div>
					
					
					
				</form>
			</div>
		</div>
	</div> <!-- end of container -->
	
	<!-- check the login part -->
	<script>

		//var attempt = 3; // Variable to count number of attempts.
		// Below function Executes on click of login button.
		function validate() {
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var user = {
		            username:username,
		            mobileIpt:password
		        };
			
				$.ajax({
					url:"/validate",
					tpye:"post",
					data:user,
					success:function(data){  
	                    var verified=eval(data); 
	                    if(verified=='success'){
	                    	alert("sususususu");
	                    }else{
	                    	alert("xxxxxxxxx");
	                    }
					}
				})
			
			
			
		}
	</script>
	
	

	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>