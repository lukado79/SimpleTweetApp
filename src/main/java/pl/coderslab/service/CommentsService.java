package pl.coderslab.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import pl.coderslab.entity.Comments;
import pl.coderslab.repository.CommentsRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

@Service
@Transactional
public class CommentsService {

	@Autowired
	CommentsRepository commentsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TweetRepository tweetRepository;

	public String findAllComments(Model model) {
		List<Comments> comment = commentsRepository.findOrderByCreated();
		model.addAttribute("comments", comment);
		return "comments";

	}
	
	public String addComment(Model model) {
		model.addAttribute("comment", new Comments());
		return "addComment";
	}
	
	public String addComment(Comments comment, BindingResult result, @PathVariable long id) {
		if(result.hasErrors()) {
			return "addComment";
		}
//		comment.setUser(userRepository.findByUsername(principal.getName()));
		comment.setTweet(tweetRepository.findById(id));
		commentsRepository.save(comment);
		return "redirect:/comments/all";
	}

	public String deleteComment(long id) {
		commentsRepository.deleteById(id);
		return "redirect:/comments/all";

	}
	
	

}
