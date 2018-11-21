package com.apap.farmasi.service;

import com.apap.farmasi.model.UserRoleModel;

public interface UserService {
	UserRoleModel addUser(UserRoleModel user);
	public String encrypt(String password);
	UserRoleModel findUserByUsername(String name);
	void changePassword(UserRoleModel user, String passBaru);
}
