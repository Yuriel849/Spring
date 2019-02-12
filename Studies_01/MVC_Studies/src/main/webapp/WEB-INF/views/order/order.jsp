<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 완료</title>
</head>
<body>
	 <h1>주문 내역</h1>
	 <c:forEach var="item" items="${orders.orderItems}">
	 	<div>
	 		상품 ID ${item.itemId} : 상품 수량 ${item.number} : 상품 안내 ${item.remark}
	 	</div>
	 </c:forEach>
	 
	 <h1>배송지</h1>
	 <div>
	 	${orders.address} <!-- Address 객체의 toString() 호출 -->
	 </div>
</body>
</html>