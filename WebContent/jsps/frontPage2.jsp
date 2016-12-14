<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<style type="text/css">
.sh div {
	height: 100px;
	background: green;
	border: 1px;
}
</style>


<title>SmartAds</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link href="starter-template.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>



<body data-gr-c-s-loaded="true">
	<!-- the navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a  class="navbar-brand" href="/frontPage">SmartAds</a>
		</div>
		
		<ul class="nav navbar-nav navbar-left">
			<li class="active"><a href="/frontPage">Home</a></li>
			<li><a href="/service">Service </a></li>
		</ul>
		
		<c:choose>
			<c:when test="${!empty sessionScope.username}">
				<ul class="nav navbar-nav navbar-right">
					<li><a >${sessionScope.username} </a></li>
					<li><a href="/logout">logout </a></li>
				</ul>
			</c:when>
		
		<c:otherwise>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/login">login </a></li>
				<li><a href="/signUp">sign up</a></li>
			</ul>
		
		</c:otherwise>
		</c:choose>
		
	</div>
	</nav>

	<!-- Main Body Part -->
	<div class="container" style="margin-top: 60px;">
		<div class="starter-template" style="text-align: center">
			<h1>SmartAds</h1>
			<p class="lead">
				Take the Survey About Item You Recently Going to Buy.<br> Get 10% Discount to Use Our Service.
			</p>
			
		</div>
	</div>

	<!-- test dropdown -->

	<div class="container" style="margin-top: 30px">
		<div class="row">
			<form action="/CMPE272/frontPage/receive" class="form-horizontal" method="post">
				<div class="form-group form-group-lg">
					<label class="col-lg-offset-2 col-lg-2 control-label">Zipcode</label>
					<div class="col-lg-4">
						<input type="text" name="zipcode" class="form-control" />
					</div>
				</div>

				<div class="form-group form-group-lg">
					<label class="col-lg-offset-2 col-lg-2 control-label">Income</label>
					<div class="col-lg-4">
						<input type="text" name="income" class="form-control" />
					</div>
				</div>

				<div class="form-group form-group-lg">
					<label class="col-lg-offset-2 col-lg-2 control-label">Age</label>
					<div class="col-lg-4">
						<input type="text" name="age" class="form-control" />
					</div>
				</div>

				<div class="form-group form-group-lg">
					<label class="col-lg-offset-2 col-lg-2 control-label">Gender</label>
					<div class="col-lg-4">
						<select name="gender" class="form-control">
							<option value="male">Male</option>
							<option value="female">Female</option>
						</select>
					</div>
				</div>

				<div class="form-group form-group-lg">
					<label class="col-lg-offset-2 col-lg-2 control-label">Shopping Way</label>
					<div class="col-lg-4">
						<select name="shopping_way" class="form-control">
							<option value="Online">Online</option>
							<option value="Offline">Offline</option>
						</select>
					</div>
				</div>

				<div class="form-group form-group-lg">
					<label class="col-lg-offset-2 col-lg-2 control-label">Shopping Content</label>
					<div class="col-lg-4">
						<select name="shopping_content" class="form-control selectpicker">
							<option value="0">Books & Audible</option>
							<option value="1">Movies, Music & Games</option>
							<option value="2">Electronics & Computers</option>
							<option value="3">Home, Garden & Tools</option>
							<option value="4">Beauty, Health & Grocery</option>
							<option value="5">Toys, Kids & Baby</option>
							<option value="6">Clothing, Shoes & Jewelry</option>
							<option value="7">Handmade</option>
							<option value="8">Sports & Outdoors</option>
							<option value="9">Automotive & Industrial</option>
						</select>
					</div>
				</div>



				<div class="form-group" style="margin-top: 40px">
					<div class="col-lg-1 col-lg-offset-4">
						<!-- 按钮的背景色 -->
						<button type="submit" value="login3" class="btn btn-primary btn-md" style="">Submit</button>
					</div>
				</div>
			</form>


		</div>
	</div>

	<!--  end of container-->

	<%-- 		<div class="container" style="margin-top:30px">
		<div class="row">
			<div class="table-responsive">
				<table
					class="table table-striped table-bordered table-hover col-lg-3">

					<thead>
						<tr>
							<th>ZIP_CODE</th>
							<th>ITEM</th>
						</tr>
					</thead>

					<c:forEach items="${dataAnalysisInfo}" var="cp" varStatus="status">
						<td> ${cp.result_zipcode}</td>
						<td>${cp.result_item}</td>
					</c:forEach>
				</table>
			</div>
		</div>
</div> --%>





	<footer class="footer ">
	<div class="container">
		<hr>
		<div class="row footer-bottom">
			<ul class="list-inline text-center">
				<li><a href="#" target="_blank">PoweredBy CMPE272 Team7</a></li>
				<li>Dec.2016</li>
			</ul>
		</div>
	</div>
	</footer>





	<!-- Bootstrap core JavaScript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>



</html>