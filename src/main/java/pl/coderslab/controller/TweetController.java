package pl.coderslab.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;

@Controller
public class TweetController {

	@Autowired
	TweetService tweetService;

	@Autowired
	TweetRepository tweetRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@GetMapping("/user/{id}/tweets")
	public String userTweets(@PathVariable long id, Model model, HttpSession sess) {
		if (sess.getAttribute("user") != null) {
			return tweetService.userTweets(id, model);
		} else {
			return "access";
		}

	}

	// @GetMapping("/user/search-tweets/{title}")
	// public String searchTweets(@PathVariable String title, Model model) {
	// return tweetService.searchTweets(title, model);
	// }

	@GetMapping("/tweet/add")
	public String addTweet(Model model, HttpSession sess) {
		if (sess.getAttribute("user") != null) {
			return tweetService.addTweet(model);
		} else {
			return "access";
		}

	}

	@PostMapping("/tweet/add")
	public String addTweet(@Valid @ModelAttribute Tweet tweet, BindingResult result, HttpSession sess) {

		User user;

		user = (User) sess.getAttribute("user");

		if (sess.getAttribute("user") != null) {
			tweet.setUser(userRepository.findFirstByUsername(user.getUsername()));
			return tweetService.addTweet(tweet, result);
		} else {

			return "access";
		}

	}

	@GetMapping("/tweet/all")
	public String allTweets(Model model, HttpSession sess) {
		if (sess.getAttribute("user") != null) {
			return tweetService.allTweets(model);
		} else {
			return "access";
		}

	}

	@GetMapping("tweet/delete/{id}")
	public String deleteTweet(@PathVariable long id, HttpSession sess) {

		User user;
		user = (User) sess.getAttribute("user");
		Tweet tweet = tweetRepository.findById(id);

		if (tweet.getUser().getUsername().equals(user.getUsername())) {
			return tweetService.deleteTweet(id);
		} else {
			return "access";
		}

	}

	@GetMapping("tweet/findId/{id}")
	public String tweetById(@PathVariable long id, Model model, HttpSession sess) {

		if (sess.getAttribute("user") != null) {
			return tweetService.tweetById(id, model);
		} else {
			return "access";
		}

	}

	@ModelAttribute("user")
	public List<User> getUsers() {
		return tweetService.getUsers();

	}

}
