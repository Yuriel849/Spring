<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

	<%
		/*
		form tag
			>> 아래에 있는 3개의 button[type="submit"]과 연결해서 POST방식으로 요청을 보내는데 사용한다.
			>> 수정이나 삭제를 하는데 반드시 게시물 번호인 bno가 필요하기 때문에 input[type="hidden"]으로 bno를 넘긴다.
		*/
	%>
	<form role="form" action="modifyPage" method="post">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">BNO</label>
				<input type="text" name="bno" class="form-control" value="${boardVO.bno}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">TITLE</label>
				<input type="text" name="title" class="form-control" value="${boardVO.title}">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">CONTENT</label>
				<textarea rows="3" class="form-control" name="content">${boardVO.content}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">WRITER</label>
				<input type="text" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly">
			</div>
		</div> <!-- /.box-body -->
	</form>

	<div class="box-footer">
		<button type="submit" class="btn btn-primary">SAVE</button>
		<button type="submit" class="btn btn-warning">CANCEL</button>
	</div>


<%@ include file="../include/footer.jsp" %>

<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		
		console.log(formObj);

		$(".btn-primary").on("click", function() {
			formObj.submit();
		});
		
		$(".btn-warning").on("click", function() {
			self.location = "/board/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
		});
	});
</script>