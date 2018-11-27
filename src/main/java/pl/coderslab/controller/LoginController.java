package pl.coderslab.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.User;

@Controller
public class LoginController {
	


	@GetMapping("/login")
	public String login(HttpSession sess, Model model) {
		return "login";

	}

	@PostMapping("login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession sess, Model model) {
		return "index";
	}

	@GetMapping("/register")
	public String register(Model model) {
		return "register";
	}

	@PostMapping("/registger")
	public String register(@ModelAttribute User user, BindingResult result) {
		return "login";
	}

}
