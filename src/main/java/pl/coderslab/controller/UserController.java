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

import pl.coderslab.entity.User;
import pl.coderslab.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("user/all")
	public String allUsers(Model model) {
		return userService.allUsers(model);

	}

	@GetMapping("user/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		return userService.deleteUser(id);

	}

	@GetMapping("user/add")
	public String addUser(Model model) {
		return userService.addUser(model);

	}

	@PostMapping("user/add")
	public String addUser(@Valid @ModelAttribute User user, BindingResult result) {
		return userService.addUsers(user, result);

	}

	@GetMapping("user/edit/{id}")
	public String editUser(Model model, @PathVariable long id) {
		return userService.editUser(model, id);

	}

	@PostMapping("user/edit/{id}")
	public String editUser(@Valid @ModelAttribute User user, BindingResult result) {
		return userService.editUser(user, result);
	}

}
