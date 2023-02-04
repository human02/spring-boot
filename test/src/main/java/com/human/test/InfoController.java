package com.human.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class InfoController {
	
	@RequestMapping("/info")
	public List<Info> retrieveAllInfo(){
		return Arrays.asList(
				new Info("abc","www.github.com/abc"),
				new Info("def","www.github.com/def"),
				new Info("xyz","www.github.com/xyz"),
				new Info("ghi", "www.github.com/ghi"));
	}

}

