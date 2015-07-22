package com.amazon.internal.appstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppStoreController {

	@RequestMapping("/")
	@ResponseBody
	public String helloWorld() {
		return "Hello World";
	}

	@RequestMapping("/vm")
	public String vm() {
		return "example";
	}

}
