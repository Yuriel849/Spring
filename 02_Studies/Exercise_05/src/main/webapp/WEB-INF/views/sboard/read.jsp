<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

	<%
		/*
		form tag
			>> 아래에 있는 3개의 button[type="submit"]과 연결해서 POST방식으로 요청을 보내는데 사용한다.
			>> 수정이나 삭제를 하는데 반드시 게시물 번호인 bno가 필요하기 때문에 input[type="hidden"]으로 bno를 넘긴다.
		*/
	%>
	<form role="form" method="post">
		<input type="hidden" name="bno" value="${boardVO.bno}">
	</form>

	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control" value="${boardVO.title}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea rows="3" class="form-control" name="content" readonly="readonly">${boardVO.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly">
		</div>
	</div> <!-- /.box-body -->
	
	<div class="box-footer">
		<button type="submit" class="btn btn-warning">MODIFY</button>
		<button type="submit" class="btn btn-danger">REMOVE</button>
		<button type="submit" class="btn btn-primary">LIST ALL</button>
	</div>


<%@ include file="../include/footer.jsp" %>

<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$(".btn-warning").on("click", function() {
			formObj.attr("action", "/board/modify");
			console.log("modifying. . . ")
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		$(".btn-danger").on("click", function() {
			formObj.attr("action", "/board/remove");
			console.log("deleting. . . ")
			formObj.submit();
		});
		
		$(".btn-primary").on("click", function() {
			self.location = "/board/listAll";
		});
	});
</script>