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
<style>
	.ui-autocomplete-category {
		font-weight: bold;
		padding: .2em .4em;
		margin: .8em 0 .2em;
		line-height: 1.5;
	}
</style>
</head>
<body>
	<div>
		<label for="searchbar">Search : </label>
		<input id="searchbar">
		<input id="searchBtn" type="button" value="검색">
	</div>
	
	<div id="searchResults">
		<p>THIS IS THE SEARCHRESULTS DIV</p>
	</div>
	
	<script>
		$(document).ready(function() {
			let source = [];
			$.ajax({
				type : 'GET'
				, url : 'http://localhost:12001/kitchen/lists.json'
				, contentType : 'application/json'
			 	, success : function(data) {
			 		let readList, category;
			 		for(let i = 0; i < 3; i++) {
		 				if(i == 0) {
			 				readList = data.kitchenList;
			 				category = "지점";
			 			}
		 				if(i == 1) {
		 					readList = data.bizList;
		 					category = "가게";
			 			}
			 			if(i == 2) {
			 				readList = data.menuList;
		 					category = "메뉴";
		 				}
				 			for(let j = 0; j < readList.length; j++) {
					 		let readLine = readList[j];
					 		source.push({label: readLine.name, category: category});				 		
				 		}
		 			}
			  	}
				, error : function(data) {
					console.log('ERRoR oCCURRED');
					console.log(data);
				}
			});

			$.widget( "custom.catcomplete", $.ui.autocomplete, {
				_create: function() {
		    		this._super();
			        this.widget().menu( "option", "items", "> :not(.ui-autocomplete-category)" );
				},
				_renderMenu: function( ul, items ) {
		    		var that = this, currentCategory = " ";
		        	$.each( items, function( index, item ) {
			        	var li;
			        	if ( item.category != currentCategory ) {
			        		ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
		    	    		currentCategory = item.category;
		        		}
		        		li = that._renderItemData( ul, item );
			        	if ( item.category ) {
			        		li.attr( "aria-label", item.category + " : " + item.label );
			        	}
		    	    });
				}
			});

			$("#searchbar").catcomplete({
				delay : 0
				, source : source
			});
			
		/* 검색창에 입력 후 검색하기 클릭하면... */
			$('#searchBtn').on('click', () => {
				$.ajax({
					type : 'POST'
					, url : 'http://localhost:12001/kitchen/search.json'
					, contentType : 'application/json'
					, data : {
						query : $('#searchbar').val()
					}
				 	, success : function(data) {
				 		console.log(data);
				 		$('#searchResults').append('<div>' + data + '</div>');
				  	}
					, error : function(data) {
						console.log('ERRoR oCCURRED');
						console.log(data);
					}
				});
			});
		});
	</script>
</body>
</html>