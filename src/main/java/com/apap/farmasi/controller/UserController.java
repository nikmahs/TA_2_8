package com.apap.farmasi.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.apap.farmasi.model.UserRoleModel;
import com.apap.farmasi.service.UserService;
import com.apap.farmasi.model.PasswordModel;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	public boolean validatePassword (String pass) {
		if(pass.length() >= 8 && Pattern.compile("[a-zA-Z]").matcher(pass).find() && Pattern.compile("[0-9]").matcher(pass).find()) {
			return true;
		}
		return false;
	}
	
	@RequestMapping( value = "/addUser", method = RequestMethod.POST)
	private ModelAndView addUserSubmit(@ModelAttribute UserRoleModel user, RedirectAttributes redirect) {
		String message="";
		
		if(this.validatePassword(user.getPassword())) {
			userService.addUser(user);
			message= null;
		}
		else {
			message="password minimal terdiri dari 8 kata dengan minimal 1 huruf dan angka";
		}
		ModelAndView redirects = new ModelAndView("redirect:/");
		redirect.addFlashAttribute("msg", message);
		return redirects;
	}
	
	
}