package com.leopard.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/order")
public class OrderController {
	@RequestMapping(method = RequestMethod.GET)
	public String getOrderForm() {
		return "order/orderForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String order(@ModelAttribute("orders") OrderCommand orderCommand) {
		System.out.println(orderCommand.getOrderItems());
		System.out.println(orderCommand.getAddress());
		return "order/order";
	}
}
