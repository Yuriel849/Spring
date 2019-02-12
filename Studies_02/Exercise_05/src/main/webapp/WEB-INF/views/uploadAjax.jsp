<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.fileDrop {
		width: 100%;
		height: 200px;
		border: 1px dotted blue;
	}
	
	small {
		margin-left: 3px;
		font-weight: bold;
		color: gray;
	}
</style>
</head>
<body>
	<h3>Ajax File Upload</h3>
	<div class="fileDrop"></div>
	<div class="uploadedList"></div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		/* 파일을 class="fileDrop"으로 끌어와 놔둬도 아무런 동작이 일어나지 않도록 preventDefault() 한다!
				여기서 기본동작은 파일을 끌어오면 새 창에 파일을 보여주는 것. */
		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		})

		/* 파일을 class="fileDrop"에 드롭했을 때 일어나는 이벤트 */
		$(".fileDrop").on("drop", function(event) {
			event.preventDefault();
			
			var files = event.originalEvent.dataTransfer.files;
					  /*
						"event.originalEvent" -> event가 순수한 DOM 이벤트가 아니지만, 이것을 사용하면 순수한 원래의 DOM 이벤트를 가져온다.
						"event.dataTransfer" -> 이벤트와 같이 전달되는 데이터를 가리킨다.
						"event.dataTransfer.files" -> 전달된 데이터 속의 파일데이터를 찾아낸다.
					  */
			var file = files[0];
			
			console.log(file);
			
			var formData = new FormData();
			formData.append("file", file);
			
			$.ajax({
				url : '/uploadAjax'
				, data : formData
				, dataType : 'text'
		/* FormData 객체에 있는 파일 데이터를 전송하려면 processData, contentType 옵션 모두 false로 설정! */
				, processData : false /* 데이터를 일반적인 query string으로 변환할지를 결정 (default : true) */
				, contentType : false /* 파일은 multipart/form-data 방식으로 전송해야 하기에 false 설정 */
				, type : 'POST'
				, success : function(data) {
					var str = "";
					
					console.log(data);
					console.log(checkImageType(data));
					
					if(checkImageType(data)) {
						str = "<div><a href='displayFile?fileName=" + getImageLink(data) + "'><img src='displayFile?fileName=" + data
								+ "'/></a><small data-src=" + data + ">X</small></div>";
					} else {
						str = "<div><a href='displayFile?fileName=" + data + "'>" + getOriginalName(data) + "</a><small data-src=" + data + ">X</small></div>";
					}
					
					$(".uploadedList").append(str);
				}
			});
		})
		
		$(".uploadedList").on('click', "small", function(event) {
			var that = $(this);
			
			$.ajax({
				url : "deleteFile"
				, type : "post"
				, data : { fileName:$(this).attr("data-src") }
				, dataType : "text"
				, success : function(result) {
					if(result == 'deleted') { that.parent("div").remove(); }
				}
			});
		})
		
		/* 확장자가 존재하는지 확인한다. -> 존재한다면 이미지 파일이다. */
		function checkImageType(fileName) {
			var pattern = /jpg$|gif$|png$|jpeg$/i; /* "i" -> 대소문자 구분 없음을 의미! */
			return fileName.match(pattern);
		}
		
		/* 일반 파일의 이름이 너무 기니까 줄여준다. */
		function getOriginalName(fileName) {
			if(checkImageType(fileName)) { return; } /* 이미지 파일이면 아무 처리도 하지 않고 반환한다. */
			
			var idx = fileName.indexOf("_") + 1; /* idx는 UUID + "_" 이후의 위치를 나타낸다. */
			return fileName.substr(idx); /* 파일명에서 UUID + "_"를 제외한 원래 파일명을 반환한다. */
		}
		
		/* 썸네일이 아니라 원본 이미지를 가져온다. */
		function getImageLink(fileName) {
			if(!checkImageType(fileName)) { return; } /* 이미지 파일이 아니라면 아무 처리도 하지 않고 반환한다. */
			
			var front = fileName.substr(0, 12); /* "/년/월/일" 경로를 추출하는 용도 */
			var end = fileName.substr(14); /* "s_" 이후의 경로를 추출하는 용도 */
			
			return front + end;
		}
	</script>
</body>
</html>