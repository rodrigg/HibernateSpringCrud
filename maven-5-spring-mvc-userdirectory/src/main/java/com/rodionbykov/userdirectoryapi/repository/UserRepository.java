package com.rodionbykov.userdirectoryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodionbykov.userdirectoryapi.model.User;
import com.rodionbykov.userdirectoryapi.repository.custom.UserRepositoryCustom;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

}
