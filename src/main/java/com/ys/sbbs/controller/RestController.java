package com.ys.sbbs.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rest")
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	// RestController에서는 @ResponseBody를 생략 가능
	@RequestMapping("/hello")
	public String hello() {
		return "<h1>Hello World!!!</h1>";
	}
}
