<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Autocomplete - Read lists of data from DB and portray in categories</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		let source = [];
		$.ajax({
			type : 'GET'
			, url : 'http://localhost:12001/kitchen/lists.json'
			, contentType : 'application/json'
		 	, success : function(data) {
		 		let readData = [];
		 		readData.push(data.kitchenList);
		 		readData.push(data.bizList);
		 		readData.push(data.menuList);
		 		console.log(readData);
		 		for(let i = 0; i < readData.length; i++) {
			 		let readList = readData[i];
			 		console.log(readList);
 			 		for(let j = 0; j < readList.length; j++) {
			 			let readLine = readList[j];
			 			console.log(readLine);
			 			
			 		}
			 		
		 		}
		  	}
			, error : function(data) {
				console.log('ERRoR oCCURRED');
				console.log(data);
			}
		});
		$(function() {
			var availableTags = [ "A for Apple", "A for Ant", "B for Ball",
					"B for Bat", "C for Carrot", "C for Car", "D for Duck",
					"D for Door", "E for Elevator", "E for Egg", "F for Fish",
					"F for Flag", "G for Guitar", "G for Glass", "H for Hammer",
					"H for Hat", "I for Indian", "I for Igloo", "J for Jam",
					"J for Juice", "K for Kangaroo", "K for Key", "L for Ladder",
					"L for Leaf", "M for Monkey", "M for Mouse", "N for Nail",
					"N for Nose", "O for Octopus", "O for Orange", "P for Paint",
					"P for Popcorn", "Q for Question", "Q for Queen",
					"R for Radio", "R for Rake", "S for Saw", "S for Snake",
					"T for Tree", "T for Train", "U for Umbrella", "U for Unicorn",
					"V for Vacuum", "V for Violin", "W for Whale", "W for Watch",
					"X", "Axe", "Box", "Fox", "Y for Yo yo", "Y for Yacht",
					"Z for Zebra" ]
			$("#tags").autocomplete({
				source : availableTags
			});
		});
	})
</script>
</head>
<body>
	<label for="tags">Tags: </label>
	<input id="tags">
</body>
</html>