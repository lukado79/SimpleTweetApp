package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public String allUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "allUsers";

	}

	public String deleteUser(long id) {
		userRepository.deleteById(id);
		return "redirect:/user/all";
	}

	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}

	public String addUsers(User user, BindingResult result) {
		if (result.hasErrors()) {
			return "addUser";
		}
		userRepository.save(user);
		return "redirect:/login";

	}

	public String editUser(Model model, long id) {
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		return "editUser";
	}

	public String editUser(User user, BindingResult result) {
		if (result.hasErrors()) {
			return "editUser";
		} else {
			userRepository.save(user);
			return "redirect:/user/all";
		}
	}
	
	public User findByUsername(String username) {
		User userName = userRepository.findByUsername(username);
		return userName;
		
	}

}
