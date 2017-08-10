package com.huawei.hicloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping(value="/test/arg", method=RequestMethod.GET)
	public Object testArgGet(@RequestParam HashMap<String, Object> arg) {
		
		logger.info("GET arg: " + arg);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("key00", "value00");
		map.put("key01", "value01");
		map.put("key02", "value02");
		
		HashMap<String,Object> map2 = new HashMap<>();
		map2.put("keys", map);
		return map2;
	}
	
	@RequestMapping(value="/test/arg", method=RequestMethod.POST)
	public Object testArgPost(@RequestBody HashMap<String, Object> arg) {
		
		logger.info("POST arg: " + arg);
		
		return null;
	}
}
