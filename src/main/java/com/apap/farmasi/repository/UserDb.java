package com.apap.farmasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.farmasi.model.UserRoleModel;

@Repository
public interface UserDb extends JpaRepository<UserRoleModel, Long> {
	UserRoleModel findByUsername(String username);
}
