package pl.coderslab.controller;

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

import pl.coderslab.entity.Comments;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentsRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.CommentsService;

@Controller
public class CommentsController {

	@Autowired
	CommentsService commentsService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CommentsRepository commentsRepository;

	@GetMapping("/comment/add/{id}")
	public String addComment(Model model, HttpSession sess) {

		if (sess.getAttribute("user") != null) {
			return commentsService.addComment(model);
		} else {
			return "access";
		}

	}

	@PostMapping("/comment/add/{id}")
	public String addComment(@Valid @ModelAttribute Comments comment, BindingResult result, @PathVariable long id,
			HttpSession sess) {

		User user;
		user = (User) sess.getAttribute("user");

		if (sess.getAttribute("user") != null) {
			comment.setUser(userRepository.findFirstByUsername(user.getUsername()));
			return commentsService.addComment(comment, result, id);
		} else {
			return "access";
		}

	}

	@GetMapping("/comments/all")
	public String allComments(Model model, HttpSession sess) {

		if (sess.getAttribute("user") != null) {
			return commentsService.findAllComments(model);
		} else {
			return "access";
		}

	}

	@GetMapping("/comment/delete/{id}")
	public String deleteComment(@PathVariable long id, HttpSession sess) {

		User user;

		user = (User) sess.getAttribute("user");

		Comments comments = commentsRepository.findById(id);

		if (comments.getUser().getUsername().equals(user.getUsername())) {
			return commentsService.deleteComment(id);
		} else {
			return "access";
		}

	}
}
