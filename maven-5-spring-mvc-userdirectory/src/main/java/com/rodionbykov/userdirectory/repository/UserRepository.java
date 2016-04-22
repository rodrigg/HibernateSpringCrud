package com.rodionbykov.userdirectory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodionbykov.userdirectory.model.User;
import com.rodionbykov.userdirectory.repository.custom.UserRepositoryCustom;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

}
