/* 이미지 파일인지 확인한다. */
function checkImageType(fileName) {
	var pattern = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}

/* 서버에서 전송된 파일명(fullName)을 이용하여 파일의 경로를 계산한다. */
function getFileInfo(fullName) {
	var fileName; /* 경로와 UUID를 제외한 파일의 이름만을 저장한다. */
	var imgsrc; /* 브라우저에서 보여주는 썸네일 혹은 파일 이미지의 경로를 저장한다. */
	var getLink; /* 브라우저에서 보여주는 원본 파일로의 링크를 저장한다. */
	var fileLink;
	
	/* 이미지일 때와 일반 파일일 때 다르게 처리한다. */
	if(checkImageType(fullName)) {
		imgsrc = "/displayFile?fileName=" + fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0,12);
		var end = fullName.substr(14);
		
		getLink = "/displayFile?fileName=" + front + end;
	} else {
		imgsrc = "/resources/dist/img/file.png";
		fileLink = fullName.substr(12);
		getLink = "/displayFile?fileName=" + fullName;
	}
	
	fileName = fileLink.substr(fileLink.indexOf("_") + 1);
	
	return {fileName : fileName, imgsrc : imgsrc, getLink : getLink, fullName : fullName};
}