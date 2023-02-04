package com.human.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyServiceController {
	
	// This creates bean of "component" by spring when required	
	@Autowired
	private CurrencyServiceConfiguration configs;
	
	@RequestMapping("/currency-config")
	public CurrencyServiceConfiguration retreiveAllConfigs() {
		return configs;
	}
}
