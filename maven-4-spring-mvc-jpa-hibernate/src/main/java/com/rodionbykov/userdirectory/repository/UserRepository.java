package com.rodionbykov.userdirectory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodionbykov.userdirectory.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
