package pl.coderslab.controller;

import java.security.Principal;

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
import pl.coderslab.service.CommentsService;

@Controller
public class CommentsController {

	@Autowired
	CommentsService commentsService;

	@GetMapping("/comment/add/{id}")
	public String addComment(Model model) {
		return commentsService.addComment(model);

	}
	@PostMapping("/comment/add/{id}")
	public String addComment(@Valid @ModelAttribute Comments comment, BindingResult result, @PathVariable long id, Principal principal) {
		return commentsService.addComment(comment, result, id, principal);
	}
	
	@GetMapping("/comments/all")
	public String allComments(Model model) {
		return commentsService.findAllComments(model);
	}
	
	@GetMapping("/comment/delete/{id}")
	public String deleteComment(@PathVariable long id) {
		return commentsService.deleteComment(id);
	}
}
