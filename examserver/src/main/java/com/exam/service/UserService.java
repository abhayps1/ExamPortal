package com.exam.service;

import java.util.Set;

import com.exam.models.User;
import com.exam.models.UserRole;

public interface UserService {
	// creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
