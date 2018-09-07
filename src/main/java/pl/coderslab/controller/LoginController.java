package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String login(Model model) {
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			return "redirect:/home";
		}
		model.addAttribute(new User());
		return "login";

	}

	@PostMapping("/register")
	public String register(@ModelAttribute User user, BindingResult result) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.addUsers(user, result);
		return "redirect:/login";
	}
}
