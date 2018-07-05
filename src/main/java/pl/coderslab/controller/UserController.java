package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("user/all")
	public String allUsers(Model model) {
		userService.allUsers(model);
		return "allUsers";

	}

	@GetMapping("user/add")
	public String addUser(Model model) {
		userService.addUser(model);
		return "addUser";
	}

	@PostMapping("user/add")
	public String addUsers(@Valid @ModelAttribute User user, BindingResult result) {
		return userService.addUsers(user, result);

	}

	@GetMapping("user/edit/{id}")
	public String editUser(Model model, @PathVariable long id) {
		userService.editUser(model, id);
		return "editUser";
	}

	@PostMapping("user/edit/{id}")
	public String updatePost(@Valid @ModelAttribute User user, BindingResult result) {
		return userService.updatePost(user, result);
	}
}
