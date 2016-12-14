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

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#map {
	height: 100%;
}

#floating-panel {
	position: absolute;
	top: 10px;
	left: 200px;
	z-index: 5;
	background-color: #fff;
	padding: 5px;
	border: 1px solid #999;
	text-align: center;
	font-family: 'Roboto', 'sans-serif';
	line-height: 30px;
	padding-left: 10px;
}

.divcss5 {
	border: 1px solid #F00;
	width: 600px;
	height: 400px;
	margin-left:250px;
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
			<a class="navbar-brand">SmartAds</a>
		</div>
		<ul class="nav navbar-nav navbar-left">
			<li ><a href="/frontPage">Home</a></li>
			<li class="active"><a href="/service">Service </a></li>
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
				Find Your Target Customers in Zipcode.
			</p>
		</div>
	</div>

	<div class="container" style="margin-top: 30px">
		<div class="row">
			 <div   class="form-horizontal" >
				<div class="form-group form-group-lg">
					<label class="col-lg-offset-2 col-lg-2 control-label">Product Type</label>
					<div class="col-lg-4">
						<select id="shopping_content" name="shopping_content" class="form-control selectpicker">
							<!-- <option value="0">Books & Audible</option>
							<option value="1">Movies, Music & Games</option>
							<option value="2">Electronics & Computers</option>
							<option value="3">Home, Garden & Tools</option>
							<option value="4">Beauty, Health & Grocery</option>
							<option value="5">Toys, Kids & Baby</option>
							<option value="6">Clothing, Shoes & Jewelry</option>
							<option value="7">Handmade</option>
							<option value="8">Sports & Outdoors</option>
							<option value="9">Automotive & Industrial</option> -->
							<option value="0">Apple MacPro</option>
							<option value="1">Tea</option>
							<option value="2">Cola</option>
							<option value="3">Badmin Racket</option>
						</select>
					</div>
				</div>


				<div class="form-group" style="margin-top: 40px">
					<div class="col-lg-1 col-lg-offset-4">
						<button id="submit" value="Geocode" class="btn btn-primary btn-md">Search</button>
					</div>
				</div>
				
		 	</div> 
		</div>
	</div>


	<!-- Main Body Part -->
	<div class="container">
		<div class="divcss5">
			 
			<div id="map"></div>
		</div>
	</div>
	

 <script>
	function initMap() {
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 8,
				center : {
					lat : 37.339,
					lng : -121.894
				}
			});
			//alert("start");
			setMarker(map);
		}

	function setMarker(resultmap){
		var addresses = getLocations(resultmap);
		function getLocations(resultmap) {
			var locations=new Array();
			document.getElementById('submit').addEventListener('click',
					function() {
						$.ajax({
							url : "/result2",
							tpye : "post",
							data : "shopping_content="+ $("#shopping_content").val(),
							success : function(data) {
								locations = eval(data);
								resultmap = new google.maps.Map(document.getElementById('map'), {
									zoom : 8,
									center : {
										lat : 37.339,
										lng : -121.894
									}
								});
								var addresses=transformlocations(locations, function() {
									//alert("inside callback");
									//alert("check"+addresses.length);
									for (i = 0; i < addresses.length; i++) {
										//alert("check after maker first");
										 var marker = new google.maps.Marker({
											map : resultmap,
											position : addresses[i]

										});
										
										//alert("check after marker:"+i+addresses.length+addresses[i]);
										attachSecretMessage(marker, locations[i].message); 

									}
									//alert("success");
									});
								//alert("result_length:"+addresses.length)
							}
						})
					});
			
			//alert("f6666f"+locations.length);
			return locations;
		}
	}
		
		
		function transformlocations(locations,callback){
			var addresses=[];
			 
			for (var i = 0; i < locations.length;i++) {
				//alert("TSL:"+i+ locations[i].message);
				var geocoder = new google.maps.Geocoder();
				if(geocoder){
					geocoder.geocode(
					{
						'address' : locations[i].zipcode
					},
					function(results, status) {
						//alert("geo:");
						if (status === google.maps.GeocoderStatus.OK) {
							//alert("geology:"+addresses.length);
							addresses.push(results[0].geometry.location);
							if(addresses.length == locations.length) {
								//alert("hh:"+addresses.length+addresses[1]);
		                        if( typeof callback == 'function' ) {
		                            callback();
		                        }else{
		                        	alert("not callback");
		                        }
		                    }
						} else {
							alert('Geocode was not successful for the following reason: '+ status);
						}
					 
				});
				}
			}
			
			//alert("transformAfter"+addresses.length);
			return addresses;
		}
		

		function attachSecretMessage(marker, secretMessage) {
			//alert("secretMessage"+secretMessage);
			var infowindow = new google.maps.InfoWindow({
				content : secretMessage
			});

			marker.addListener('click', function() {
				infowindow.open(marker.get('map'), marker);
			});
		}
		
	</script>
	
	
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCyMXaBqJOWHtGJSATEH_XyV9LBqYV-rYE&callback=initMap" async defer>
	</script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- map end -->


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
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>



</html>