package org.Yuriel.searchbar.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		Map<String, List> returnVal = null;
		String url = "http://localhost/rest/kitchenbranch/alllists";
		
		ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);
		if(!responseEntity.getBody().isEmpty()) {
			returnVal = responseEntity.getBody();
		}	
		log.info(returnVal);
		
		return new ResponseEntity<Map<String,List>>(returnVal, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<Map<String, List>> searchLists(@RequestBody String query) {
		log.info("Searching lists of kitchen branches, businesses, menus");
		System.out.println(query);
		
		Map<String, List> returnVal = null;
		String url = "http://localhost/rest/kitchenbranch/searchlists";
		
		ResponseEntity<Map> responseEntity = restTemplate.postForEntity(url, query, Map.class);
		if(!responseEntity.getBody().isEmpty()) {
			returnVal = responseEntity.getBody();
		}	
		log.info(returnVal);
		
		return new ResponseEntity<Map<String,List>>(returnVal, HttpStatus.OK);
	}
}