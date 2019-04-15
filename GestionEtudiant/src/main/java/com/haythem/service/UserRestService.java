package com.haythem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.haythem.entities.Role;
import com.haythem.entities.User;
import com.haythem.repository.RoleRepository;
import com.haythem.repository.UserRepository;

@RestController
@Secured(value= {"ROLE_ADMIN"})
public class UserRestService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public User saveUser(User u) {
		return userRepository.save(u);
	}

	@RequestMapping(value = "/findUsers")
	public Page<User> listusers(int page, int size) {
		return userRepository.findAll(new PageRequest(page, size));

	}

	@RequestMapping(value = "/addRole", method = RequestMethod.GET)
	public Role saveRole(Role r) {
		return roleRepository.save(r);
	}

	@RequestMapping(value = "/findRoles")
	public Page<Role> listRoles(int page, int size) {
		return roleRepository.findAll(new PageRequest(page, size));

	}

	@RequestMapping(value = "/addRoleToUser")
	public User addRoleToUser(String username, String role) {
		User u = userRepository.finddOne(username);
		Role r = roleRepository.finddOne(role);
		u.getRoles().add(r);
		userRepository.save(u);
		return u ;
	}
}
