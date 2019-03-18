<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문</h1>
	<form method="post">
		상품1 - ID. <input type="text" name="orderItems[0].itemId">
		상품1 - NO. <input type="text" name="orderItems[0].number">
		상품1 - RE. <input type="text" name="orderItems[0].remark">
		<br>
		상품2 - ID. <input type="text" name="orderItems[1].itemId">
		상품2 - NO. <input type="text" name="orderItems[1].number">
		상품2 - RE. <input type="text" name="orderItems[1].remark">
		<br>
		상품3 - ID. <input type="text" name="orderItems[2].itemId">
		상품3 - NO. <input type="text" name="orderItems[2].number">
		상품3 - RE. <input type="text" name="orderItems[2].remark">
		<br>
		배송지 - POSTAL_CODE. <input type="text" name="address.zipcode">
		배송지 - ADDR_DEFAULT. <input type="text" name="address.address1">
		배송지 - ADDR_DETAILED. <input type="text" name="address.address2">
		<br>
		<input type="submit">
	</form>
</body>
</html>