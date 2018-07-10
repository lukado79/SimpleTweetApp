package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import pl.coderslab.entity.UserRole;
import pl.coderslab.repository.UserRoleRepository;

@Service
@Transactional
public class UserRoleService {
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public String allUserRoles(Model model) {
		model.addAttribute("userRoles", userRoleRepository.findAll());
		return "allUserRoles";

	}
	
	public String deleteUserRole(long id) {
		userRoleRepository.deleteById(id);
		return "redirect:/userRole/all";
	}
	
	public String addUserRole(Model model) {
		model.addAttribute("userRole", new UserRole());
		return "addRole";
	}
	
	public String addUserRoles(UserRole userRole, BindingResult result) {
		if (result.hasErrors()) {
			return "addRole";
		}
		userRoleRepository.save(userRole);
		return "redirect:/userRole/all";

	}
	

}
