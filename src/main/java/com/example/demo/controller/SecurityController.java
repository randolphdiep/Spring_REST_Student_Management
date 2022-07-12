package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class SecurityController {

	@Autowired
	BCryptPasswordEncoder pwEncoder;

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("")
	public String viewHomePage() {
		return "login";
	}

//	@GetMapping("/login")
//	public String showLoginForm() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//			return "login";
//		}
//		return "redirect:/list";
//	}

	@PostMapping(value = "/add")
	public void saveNewAccount(@RequestBody User newAccount) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User newUser = userRepository.findByUserName(newAccount.getUserName());
		if (newUser == null) {
			String encodedPassword = passwordEncoder.encode(newAccount.getPassword());
			newAccount.setPassword(encodedPassword);
			userService.save(newAccount);
		}
	}
	
	@GetMapping("/show")
	public List<User> showUser() {
		return (List<User>) userRepository.findAll();
	}
	
}
