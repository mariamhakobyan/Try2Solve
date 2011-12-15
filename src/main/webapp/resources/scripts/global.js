/**********************************************************
 *
 * Copyright by JavaToday.com
 *
 *********************************************************/

window.addEvent('domready', function(){
	var showLoader = function() {
		var contentHeight = $("content").getHeight().toInt() - 20;
		$("loader").setStyles({
			display: 'block',
			height: contentHeight
		});
	}
	var hideLoader = function() {
		$("loader").erase('style');
	}
	
	$$(".pagination li a").addEvent("click", function(e){
		/*
		e.stop();

		showLoader();
		var link = "articles.php" + "?page=" + this.get("data-page").toInt();
		new Request({
			url: link,
			method: 'get',
			onRequest: function(){
				$("loader").set('text', 'loading...');
			},
			onSuccess: function(responseText){
				$("articles").set('html', responseText);
				hideLoader();
			},
			onFailure: function(){
				$("loader").set('text', 'Sorry, your request failed.');
			}
		}).send();
		*/
	});
	
	$$("#tabs li a").addEvent("click", function(e){
		/*
		e.stop();
		showLoader();
		$$("#tabs li").removeClass("on");
		this.getParent("li").addClass("on");
		hideLoader();
		*/
	});
	
	if($("user-profile")) {
		$("user-profile").addEvent("click", function(){
			this.toggleClass("selected");

			var width = this.getWidth().toInt();
			this.getNext("ul#user-dropdown").setStyle("width", width);
			this.getNext("ul#user-dropdown").toggleClass("hidden");
		})
	}
	
	if($("map")) {
		var map,
			$mapEl		= $('#map'),
			address		= 'Yerevan, Armenia',
			lat			= 40.181555,
			lng			= 44.518271,
			point		= new google.maps.LatLng(lat,lng),
			mapOptions 	= {
				zoom						: 14,
				center						: point,
				mapTypeId					: google.maps.MapTypeId.ROADMAP,
				mapTypeControl				: true,
				panControl					: false,
				panControlOptions			: {
					position	: google.maps.ControlPosition.TOP_RIGHT
				},
				zoomControl					: true,
				zoomControlOptions			: {
					style		: google.maps.ZoomControlStyle.SMALL,
					position	: google.maps.ControlPosition.TOP_RIGHT
				},
				streetViewControl			: true,
				streetViewControlOptions	: {
					position	: google.maps.ControlPosition.TOP_RIGHT
				}
			}
		
		map	= new google.maps.Map(document.getElementById("map"), mapOptions);
		//rotate 45 degrees (nicer view!)
		map.setTilt(45);
		
		var coordInfoWindow = new google.maps.InfoWindow({maxWidth : 10}),   
			latlngStr = address + "<br />JavaToday.co";
			coordInfoWindow.setContent(latlngStr);    
			coordInfoWindow.setPosition(point);    
			coordInfoWindow.open(map);
	}
});