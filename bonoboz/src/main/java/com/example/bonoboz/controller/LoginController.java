package com.example.bonoboz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bonoboz.DAOServies.UserDAOService;
import com.example.bonoboz.domain.User;

@Controller
public class LoginController {

	@Autowired
	UserDAOService UserDAOService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String login() {
		return "login";
	}
}
