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

import pl.coderslab.entity.UserRole;
import pl.coderslab.service.UserRoleService;

@Controller
public class UserRoleController {
	@Autowired
	UserRoleService userRoleService;

	@GetMapping("userRole/all")
	public String allUserRoles(Model model) {
		return userRoleService.allUserRoles(model);

	}

	@GetMapping("userRole/delete/{id}")
	public String deleteUserRole(@PathVariable long id) {
		return userRoleService.deleteUserRole(id);

	}

	@GetMapping("userRole/add")
	public String addUserRole(Model model) {
		return userRoleService.addUserRole(model);

	}

	@PostMapping("userRole/add")
	public String addUserRole(@Valid @ModelAttribute UserRole userRole, BindingResult result) {
		return userRoleService.addUserRoles(userRole, result);

	}

}
