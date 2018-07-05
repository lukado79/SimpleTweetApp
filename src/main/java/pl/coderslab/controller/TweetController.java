package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.service.TweetService;

@Controller
public class TweetController {
	
	@Autowired
	TweetService tweetService;
	
	@GetMapping("/user/{id}/tweets")
	public String userTweets( long id, Model model) {
		tweetService.userTweets(id, model);
		return "userTweets";
	}

	@GetMapping("/user/search-tweets/{title}")
	public String searchTweets(String title, Model model) {
		tweetService.searchTweets(title, model);
		return "searchTweet";
	}

	@GetMapping("/tweet/add")
	public String addUser(Model model) {
		tweetService.addUser(model);
		return "addTweet";
	}

	@PostMapping("/tweet/add")
	public String addUsers(Tweet tweet, BindingResult result) {
		return tweetService.addUsers(tweet, result);


	}

	@GetMapping("/tweet/all")
	public String allTweets(Model model) {
		tweetService.allTweets(model);
		return "allTweets";

	}

	@GetMapping("tweet/delete/{id}")
	public String deleteTweet(long id) {
		tweetService.deleteTweet(id);
		return "redirect:/tweet/all";
	}

	@ModelAttribute("user")
	public List<User> getUsers() {
		return tweetService.getUsers();
	
	}

}
