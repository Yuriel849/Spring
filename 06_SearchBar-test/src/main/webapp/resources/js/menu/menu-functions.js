/* 전역 변수 */
	/* 사용자 ID */
	const custId = 'tjtjtj';
	/* 가게 ID */
	const bizId = $('#main_menu').attr('data-biz-id');

function removeDuplicateBizNames() {
	var bizNames = $('.bizNameRow');
	for(var i = 1; i < bizNames.size(); i++) {
		if(bizNames.eq(i).text() == bizNames.eq(i-1).text()) {
			bizNames.eq(i).remove();
		}
	}
}

function isFavoriteChk() {
	$.ajax({
		type : 'GET'
		, url : 'http://localhost:3001/customer/member/fav/' + custId + '/' + bizId + '.json'
		, contentType : 'application/json'
	  	, success : function(data) {
  			if(data == 1) {
  				$('#likeBiz').removeClass('icon-heart-empty').addClass('icon-heart').siblings('#likeText').text('찜하셨어요!!');
  			}
		}
		, error : function(data) {
			console.log('ERRoR oCCURRED');
			console.log(data);
		}
	});
}

/* 브라우저 히스토리를 이용해서 이동했을 경우 (뒤로가기 앞으로가기 버튼) 페이지를 새로고침한다
레퍼런스 --> https://developer.mozilla.org/en-US/docs/Web/API/PerformanceNavigation
*/
if(performance.navigation.type == 2) {
	location.reload(true);
}

$(document).ready(function() {
/* 페이지 로딩 후 카트에 총 금액 표시하기 */
	var cartTotal = 0;
	for(var i = 0; i < $('.priceData').size(); i++) {
		var price = $('.priceData').eq(i).attr('data-total-price');
		cartTotal += parseInt(price);
	}
	$('.total span').text(cartTotal + '원');

/* 페이지 로딩 후 카트에서 중복되는 가게명 (bizName) 제거하기 */
	removeDuplicateBizNames();
/* 페이지 로딩 후 현재 보고 있는 가게를 현재 로그인되어 있는 고객이 찜했는지 확인하고 반영하기 */
	isFavoriteChk();
/* 페이지 로딩 후 카트 전체선택 해놓기 */
	$('.cartTable .check-order').prop('checked', true);
	$('.table_summary th:eq(0) input').prop('checked', true);
		
/* 옵션 없는 메뉴는 "+" 클릭하면 장바구니에 추가하도록 */
	for(var i = 0; i < $('.dropdown-menu').size(); i++) {
		if($('.dropdown-menu').eq(i).children('div').length == 0) {
		// 옵션이 없으니까 옵션용 팝업을 보여주는 대신 곧바로 카트에 추가할 수 있다 (옵션용 팝업 속 "Add to cart" 버튼과 똑같다)
			$('.dropdown-menu').eq(i).siblings('a').removeClass('dropdown-toggle').addClass('add_to_basket').removeAttr('data-toggle');
		}
	}
	
/* 주문할 메뉴 전체선택하기 */
	$('body').on('click', '.table_summary th:eq(0) input', function() {
		$('.cartTable .check-order').prop('checked', $('.table_summary th:eq(0) input').prop('checked'));
	});
/* 체크박스 하나 클릭시 전체선택 체크박스 1개 해제하기 */
	$('body').on('click', '.cartTable .check-order', function() {
		if($('.table_summary th:eq(0) input').prop('checked') == true) {
			$('.table_summary th:eq(0) input').prop('checked', false);
		}
	});
	
/* "Add to cart" 버튼을 클릭하면 선택한 메뉴와 옵션을 DB에 입력하고 이후 DB에서 카트 정보를 읽어와 표시하기 */
	$('.add_to_basket').on('click', function(event) {
		event.preventDefault();
		
	/* 필수선택 옵션을 선택했는지 확인한다 */
		const divs = $(this).siblings('div');
		for(let i = 0; i < divs.length; i++) {
			if(divs.eq(i).children().children('input').attr('data-required') == "yes") {
				if(divs.eq(i).children().children('input:checked').length == 0) {
					alert("필수 선택 옵션을 선택하셔야 합니다.");
					return;
				}
			}
		}
		
	/* 선택한 메뉴의 ID */
		const menuId = $(this).parents('td').siblings('td:eq(0)').children('h5').attr('data-id');
	/* 선택한 메뉴의 가격 (옵션 제외) */
		const menuPrice = $(this).parents('td').siblings('td:eq(1)').attr('data-price');
	/* 선택한 옵션들 (input tag) */
		const checkedOptions = $(this).siblings('div').children().children('input:checked');
	/* 선택한 옵션을 담을 배열 */
		let optArr = [];
	/* 메뉴와 옵션의 가격 총 합 */
		let totalPrice = 0;		
	/* 선택한 각 옵션의 가격을 optArr 배열에 담는다 */
		$.each(checkedOptions, function(index, item) { optArr.push(checkedOptions.eq(index).siblings('span').attr('data-price')); })
	/* 메뉴 가격과 각 옵션의 가격을 더해서 가격 총 합을 구한다 */
		totalPrice += parseInt(menuPrice);
		$.each(optArr, function(index, item) { totalPrice += parseInt(item); })
/* 		console.log(totalPrice); -> 총 금액 확인하기
		console.log($(this).siblings('div').children().children('input:checked').length); -> 체크한 옵션 개수 확인하기
*/
	/* 선택한 옵션의 개수를 cur변수의 값으로 삼는다. */
		let cur = $(this).siblings('div').children().children('input:checked').length; // 브라우저 콘솔에서 작업용 : $('.add_to_basket').eq(0).siblings('div').children().children('input:checked')
	/* 옵션 정보를 담을 배열 (List<CartDetailVO>에 매핑) */
		let inputOptions = [];
		for(let i = 0; i < cur; i++) {
			id = menuId;
			optName = $(this).siblings('div').children().children('input:checked').eq(i).attr('data-name');
			optId = $(this).siblings('div').children().children('input:checked').eq(i).attr('data-id');
			optPrice = $(this).siblings('div').children().children('input:checked').eq(i).siblings('span').attr('data-price');
			
			inputOptions.push({ menuOptId : optId, menuId : id, menuOptName : optName, menuOptPrice : optPrice });
		}
	/* 비동기 요청하면 CartVOExtended에 매핑되도록 JavaScript 객체 생성 */
		var inputData = {
				custId : custId
				, quantity : 1
				, unitPrice : menuPrice
				, totalAmt : totalPrice
				, kitchenName : '스톡홀름 1호점'
				, bizId : bizId
				, menuId : menuId
				, options : inputOptions
			};
 		$.ajax({
			type : 'POST'
			, url : 'http://localhost:3001/customer/cart/add'
			, dataType : 'json'
			, contentType : 'application/json'
			, data : JSON.stringify(inputData)
	   		, success : function(data) {
	   			$('.cartTable').empty();
	   			cartTotal = 0;
				for(let i = 0; i < data.length; i++) {
	    			$('.cartTable').append('<tr class="bizNameRow"><td colspan="3"><strong>' + data[i].bizName + '</strong></td></tr>' +
	    					'<tr><td style="width: 10%;"><input class="check-order" type="checkbox" name="selectedCart" value="' + data[i].id + '"></td>' +
	    					'<td class="menuData" data-cart-id="' + data[i].id + '"><strong>' + data[i].quantity + 'x</strong> ' +
	    					data[i].menuName + '<span class="pull-right">' + data[i].unitPrice + '원</span></td></tr>');
	    			if(data[i].options != null) {
		    			for(let j = 0; j < data[i].options.length; j++) {
			    			$('.cartTable').append('<tr><td style="width: 10%;"></td><td style="font-size: 11px">'
			    					+ data[i].options[j].menuOptName + '<span class="pull-right">+ ' + data[i].options[j].menuOptPrice + '원</span></td>' +
			    					'<td style="width: 10%;"></td></tr>');
		    			}
	    			}
	    			$('.cartTable').append('<tr><td colspan="2" class="priceData" data-total-price="' + data[i].totalAmt + '">' +
	    					'<strong class="pull-right">합계&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + data[i].totalAmt + '원</strong></td></tr>');
	    			cartTotal += data[i].totalAmt;
				}
				$('.total span').text(cartTotal + '원');
				removeDuplicateBizNames();
			/* 카트에 추가하면 기존에 선택한 체크박스 해제하기 */
				$(this).siblings('div').children().children('input:checked').prop('checked', false);
			/* 카트 체크박스를 default로 전체 선택하기 */
				$('.cartTable .check-order').prop('checked', true);
				$('.table_summary th:eq(0) input').prop('checked', true);
			}
			, error : function(data) {
				console.log('ERRoR oCCURRED');
				console.log(data);
			}
		});
	});

/* 카트의 id="deleteCart" 클릭하면 선택된 항목 삭제하기 */
	$('#deleteCart').on('click', function() {
		const checked = $('.cartTable .check-order:checked');
		let cartId = [];
		for(let i = 0; i < checked.length; i++) {
			cartId[i] = checked.eq(i).parent().siblings('.menuData').attr('data-cart-id');
		}
		
 		$.ajax({
			type : 'DELETE'
			, url : 'http://localhost:3001/customer/cart/delete'
			, dataType : 'json'
			, contentType : 'application/json'
			, data : JSON.stringify({
					custId : custId
					, cartIds : cartId
				})
	   		, success : function(data) {
	   			$('.cartTable').empty();
	   			cartTotal = 0;
				for(let i = 0; i < data.length; i++) {
	    			$('.cartTable').append('<tr class="bizNameRow"><td colspan="3"><strong>' + data[i].bizName + '</strong></td></tr>' +
	    					'<tr><td style="width: 10%;"><input class="check-order" type="checkbox"></td>' +
	    					'<td class="menuData" data-cart-id="' + data[i].id + '"><strong>' + data[i].quantity + 'x</strong> ' +
	    					data[i].menuName + '<span class="pull-right">' + data[i].unitPrice + '원</span></td></tr>');
	    			if(data[i].options != null) {
		    			for(let j = 0; j < data[i].options.length; j++) {
			    			$('.cartTable').append('<tr><td style="width: 10%;"></td><td style="font-size: 11px">'
			    					+ data[i].options[j].menuOptName + '<span class="pull-right">+ ' + data[i].options[j].menuOptPrice + '원</span></td>' +
			    					'<td style="width: 10%;"></td></tr>');
		    			}
	    			}
	    			$('.cartTable').append('<tr><td colspan="2" class="priceData" data-total-price="' + data[i].totalAmt + '">' +
	    					'<strong class="pull-right">합계&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + data[i].totalAmt + '원</strong></td></tr>');
	    			cartTotal += data[i].totalAmt;
				}
				$('.total span').text(cartTotal + '원');
				removeDuplicateBizNames();
			/* 카트 체크박스를 default로 전체 선택하기 */
				$('.cartTable .check-order').prop('checked', true);
				$('.table_summary th:eq(0) input').prop('checked', true);
			}
			, error : function(data) {
				console.log('ERRoR oCCURRED');
				console.log(data);
			}
		});
	});

	
/*명준이형의 흔적*/
/* 카트의 id="orderNow" 클릭하면 선택된 항목 주문하기 */
	/*$('#orderNow').on('click', function() {
		const checked = $('.cartTable .check-order:checked');
		let cartId = [];
		for(let i = 0; i < checked.length; i++) {
			cartId[i] = Number(checked.eq(i).parent().siblings('.menuData').attr('data-cart-id'));
		}
		 카트의 모든 체크박스 해제 
		$('.table_summary th:eq(0) input').prop('checked', false);
		$('.cartTable .check-order').prop('checked', false);
		
			
	});*/
	
/* 찜하기 버튼 누르면 찜을 추가하기 */
	$('body').on('click', $('#likeBiz'), function() {
		if($('#likeBiz').prop('class') == 'icon-heart-empty') { // 찜하지 않은 상태라면 (if empty heart icon)
			$.ajax({
				type : 'POST'
				, url : 'http://localhost:3001/customer/member/fav/add.json'
				, contentType : 'application/json'
				, data : JSON.stringify({
					custId : custId
					, bizId : bizId
					, bizName : '원준이네 통닭집'
					, kitchenName : '리벨점'
				})
			  	, success : function(data) {
		  			if(data == 1) {
		  				$('#likeBiz').removeClass('icon-heart-empty').addClass('icon-heart').siblings('#likeText').text('찜하셨어요!!');
		  				$('#likes').text(parseInt($('#likes').text()) + 1);
		  			}
				}
				, error : function(data) {
					console.log('ERRoR oCCURRED');
					console.log(data);
				}
			});
		} else { // 찜한 상태라면 (if full heart icon)
			$.ajax({
				type : 'DELETE'
				, url : 'http://localhost:3001/customer/member/fav/' + custId + '/' + bizId + '.json'
				, contentType : 'application/json'
			  	, success : function(data) {
		  			$('#likeBiz').removeClass('icon-heart').addClass('icon-heart-empty').siblings('#likeText').text('찜해주세요!!');
		  			$('#likes').text(parseInt($('#likes').text()) - 1);
		  		}
				, error : function(data) {
					console.log('ERRoR oCCURRED');
					console.log(data);
				}
			});
		}
	});
	
});