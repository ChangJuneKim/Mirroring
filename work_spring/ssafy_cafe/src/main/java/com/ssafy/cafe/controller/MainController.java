package com.ssafy.cafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	// 바닥페이지
	@GetMapping("/")
	public String index() {
		return "redirect:/assets/index.html";
	}
	
}
