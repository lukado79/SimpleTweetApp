package pl.coderslab.controller;

import java.nio.file.attribute.UserPrincipalLookupService;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String login(HttpSession sess, Model model) {
		return "login";

	}

	@PostMapping("login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession sess, Model model) {

		User user;

		user = userService.findByUsername(username);
		sess.setAttribute("user", user);

		if (BCrypt.checkpw(password, user.getPassword())) {
			return "index";
		} else {
			return "wrongPassword";
		}

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
