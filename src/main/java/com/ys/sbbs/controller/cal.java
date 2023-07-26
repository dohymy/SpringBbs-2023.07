package com.ys.sbbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sbbs/basic")
public class cal {
	@GetMapping("/cal")
	public String calGet() {
		return "basic/cal";
	}
	@ResponseBody
	@PostMapping("/cal")
	public int calPost(int num1, int num2, String op) {
		int result;
		if(op == "+") {
			result = num1 + num2;
		} else if (op == "-") {
			result = num1 - num2;
		}  else if (op == "*") {
			result = num1 * num2;
		} else {
			result = num1 / num2;
		}
		return result; 
	}
}
