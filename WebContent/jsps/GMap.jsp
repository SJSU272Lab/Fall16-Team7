
<!DOCTYPE html>
<html>
<head>
<title>Geocoding service</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<style>
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
}
</style>
</head>
<body>
	<div class="divcss5">
		<div id="floating-panel">
			<div ng-app="myApp">
				<input id="submit" type="button" value="Geocode">
			</div>
		</div>
		<div id="map"></div>
	</div>
	<script>
	//init the print	
	function initMap() {
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 8,
				center : {
					lat : 37.339,
					lng : -121.894
				}
			});
			var geocoder = new google.maps.Geocoder();

			document.getElementById('submit').addEventListener('click',
					function() {
						$.ajax({
							url:"/SpringMVCTest3/result2",
							tpye:"post",
							success:function(data){  
			                    var addresses=eval(data); 
			                    geocodeAddress(geocoder, map,addresses);
			                }
						})
					});
		}

	
	//get the geo according to the address
		function geocodeAddress(geocoder, resultsMap, addresses) {	
			var mas1=new Array(addresses.length);
			for(var k=0;k<addresses.length;k++){
				mas1[k]=addresses[k].message.toString();
				alert("message:"+mas1[k])
			}
			alert("mas1:"+mas1.length)
			
			
		for (var j = 0; j < addresses.length; ++j) {		
			geocoder.geocode(
						{
							'address' : addresses[j].zipcode
						},
						function(results, status) {
							if (status === google.maps.GeocoderStatus.OK) {
								resultsMap.setCenter(results[0].geometry.location);
								var marker = new google.maps.Marker({
									map : resultsMap,
									position : results[0].geometry.location
								});
								
								attachSecretMessage(marker, mas1[j]);
								
							} else {
								alert('Geocode was not successful for the following reason: '+ status);
							}
						});
			}
		}
	
	
	
		function attachSecretMessage(marker, secretMessage) {
	        var infowindow = new google.maps.InfoWindow({
	          content: secretMessage
	        });

	        marker.addListener('click', function() {
	          infowindow.open(marker.get('map'), marker);
	        });
		}
	</script>
	
	
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCyMXaBqJOWHtGJSATEH_XyV9LBqYV-rYE&callback=initMap"
		async defer>
		
	</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</body>
</html>