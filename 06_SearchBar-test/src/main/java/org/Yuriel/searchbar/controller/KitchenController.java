package org.Yuriel.searchbar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.Yuriel.searchbar.model.BizVO;
import org.Yuriel.searchbar.model.KitchenBranchVO;
import org.Yuriel.searchbar.model.MenuVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/kitchen")
@Log4j
public class KitchenController {
	
	@Inject
	RestTemplate restTemplate;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/lists", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<Map<String, List>> getLists() {
		log.info("Reading lists of kitchen branches, businesses, menus for the autocomplete");
		
		Map<String, List> returnVal = new HashMap<String, List>();
		List<KitchenBranchVO> returnKitchen = null;
		List<BizVO> returnBiz = null;
		List<MenuVO> returnMenu = null;
		String url = "http://localhost/rest/kitchenbranch/";
		
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(url + "kitchenlist", java.util.List.class);
		log.info(responseEntity);
		if(!responseEntity.getBody().isEmpty()) {
			returnKitchen = responseEntity.getBody();
		}
		
		responseEntity = restTemplate.getForEntity(url + "bizlist", java.util.List.class);
		log.info(responseEntity);
		if(!responseEntity.getBody().isEmpty()) {
			returnBiz = responseEntity.getBody();
		}
		
		responseEntity = restTemplate.getForEntity(url + "menulist", java.util.List.class);
		log.info(responseEntity);
		if(!responseEntity.getBody().isEmpty()) {
			returnMenu = responseEntity.getBody();
		}
		
		returnVal.put("kitchenList", returnKitchen);
		returnVal.put("bizList", returnBiz);
		returnVal.put("menuList", returnMenu);
		
		log.info(returnVal);
		
		return new ResponseEntity<Map<String,List>>(returnVal, HttpStatus.OK);
	}
	
//	@GetMapping(value = "/search/{query}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
//	public ResponseEntity<Map<String, List>> searchLists() {
//		log.info("Searching lists of kitchen branches, businesses, menus");
//		
//		Map<String, List> returnVal = new HashMap<String, List>();
//		List<KitchenBranchVO> returnKitchen = null;
//		List<BizVO> returnBiz = null;
//		List<MenuVO> returnMenu = null;
//		String url = "http://localhost/rest/kitchenbranch/";
//		
//		ResponseEntity<List> responseEntity = restTemplate.getForEntity(url + "kitchenlist", java.util.List.class);
//		log.info(responseEntity);
//		if(!responseEntity.getBody().isEmpty()) {
//			returnKitchen = responseEntity.getBody();
//		}
//		
//		responseEntity = restTemplate.getForEntity(url + "bizlist", java.util.List.class);
//		log.info(responseEntity);
//		if(!responseEntity.getBody().isEmpty()) {
//			returnBiz = responseEntity.getBody();
//		}
//		
//		responseEntity = restTemplate.getForEntity(url + "menulist", java.util.List.class);
//		log.info(responseEntity);
//		if(!responseEntity.getBody().isEmpty()) {
//			returnMenu = responseEntity.getBody();
//		}
//		
//		returnVal.put("kitchenList", returnKitchen);
//		returnVal.put("bizList", returnBiz);
//		returnVal.put("menuList", returnMenu);
//		
//		log.info(returnVal);
//		
//		return new ResponseEntity<Map<String,List>>(returnVal, HttpStatus.OK);
//	}
}