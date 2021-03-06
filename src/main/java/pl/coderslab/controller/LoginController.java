package pl.coderslab.controller;

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
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	TweetService tweetService;

	@GetMapping("/login")
	public String login(HttpSession sess, Model model) {

		if (sess.getAttribute("user") != null) {
			return tweetService.allTweets(model);
		} else {
			sess.invalidate();
			model.addAttribute("user", new User());
			return "login";

		}

	}

	@PostMapping("/login")
	public String login(@RequestParam String password, @RequestParam String username, HttpSession sess, Model model) {

		User user;

		user = userService.findByUsername(username);
		sess.setAttribute("user", user);

		try {
			if (BCrypt.checkpw(password, user.getPassword())) {
				return tweetService.allTweets(model);
			} else {
				return "wrongPassword";
			}
		} catch (NullPointerException e) {
			return "WrongData";
		}

	}

	@GetMapping("/register")
	public String register(HttpSession sess, Model model) {

		if (sess.getAttribute("user") != null) {
			return tweetService.allTweets(model);
		} else {
			sess.invalidate();
			model.addAttribute("user", new User());
			return userService.addUser(model);
		}

	}

	@PostMapping("/register")
	public String register(@ModelAttribute User user, BindingResult result) {
		return userService.addUsers(user, result);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession sess) {
		
		if(sess.getAttribute("user") != null) {
			sess.invalidate();
			return "logout";
		}else {
			return "home";
		}
	}

}
