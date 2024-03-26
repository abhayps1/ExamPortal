package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	// creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		User local = userRepository.findByUsername(user.getUsername());

		if (local != null) {
			System.out.println("User is already there");
			throw new Exception("User already exists");
		} else {
			// user create

			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);
			local = userRepository.save(user);
		}

		return local;

	}

}
