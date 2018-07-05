package pl.coderslab.controller;

import java.util.List;

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
import pl.coderslab.service.TweetService;

@Controller
public class TweetController {

	@Autowired
	TweetService tweetService;

	@GetMapping("/user/{id}/tweets")
	public String userTweets(@PathVariable long id, Model model) {
		return tweetService.userTweets(id, model);

	}

	@GetMapping("/user/search-tweets/{title}")
	public String searchTweets(@PathVariable String title, Model model) {
		return tweetService.searchTweets(title, model);
	}

	@GetMapping("/tweet/add")
	public String addTweet(Model model) {
		tweetService.addUser(model);
		return "addTweet";
	}

	@PostMapping("/tweet/add")
	public String addTeet(@Valid @ModelAttribute Tweet tweet, BindingResult result) {
		return tweetService.addUsers(tweet, result);

	}

	@GetMapping("/tweet/all")
	public String allTweets(Model model) {
		tweetService.allTweets(model);
		return "allTweets";

	}

	@GetMapping("tweet/delete/{id}")
	public String deleteTweet(@PathVariable long id) {
		tweetService.deleteTweet(id);
		return "redirect:/tweet/all";
	}

	@ModelAttribute("user")
	public List<User> getUsers() {
		return tweetService.getUsers();

	}

}
