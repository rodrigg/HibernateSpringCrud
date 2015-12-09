package com.rodionbykov.userdirectory.repository.custom;

import java.util.List;

import com.rodionbykov.userdirectory.model.User;

public interface UserRepositoryCustom {

	List<User> findByFirstnameOrLastname(String firstname, String lastname);
	
}
