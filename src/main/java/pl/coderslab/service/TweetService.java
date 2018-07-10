package pl.coderslab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;




@Service
@Transactional
public class TweetService {
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	public String userTweets(long id, Model model) {
		List<Tweet> tweet = tweetRepository.findAllByUserId(id);
		model.addAttribute("tweet", tweet);
		return "userTweets";
	}


	public String searchTweets(String title, Model model) {
		List<Tweet> tweets = tweetRepository.findAllWhereTweetLikeOrderByCreated(title);
		model.addAttribute("tweets", tweets);
		return "searchTweet";
	}


	public String addTweet(Model model) {
		model.addAttribute("tweet", new Tweet());
		return "addTweet";
	}


	public String addTweet(Tweet tweet, BindingResult result) {
		if (result.hasErrors()) {
			return "addTweet";
		}

		tweetRepository.save(tweet);
		return "redirect:/tweet/all";

	}


	public String allTweets(Model model) {
		model.addAttribute("tweet", tweetRepository.findAll());
		return "allTweets";

	}


	public String deleteTweet(long id) {
		tweetRepository.deleteById(id);
		return "redirect:/tweet/all";
	}

	
	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

}
