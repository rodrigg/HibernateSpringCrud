package com.rodionbykov.repository.custom;

import java.util.List;

import com.rodionbykov.model.User;

public interface UserRepositoryCustom {

	List<User> findByFirstnameOrLastname(String firstname, String lastname);
	
}
