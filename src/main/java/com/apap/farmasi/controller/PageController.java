package com.apap.farmasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

	@RequestMapping("/")
	private String home() {
		return "home";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";	
	}
}
