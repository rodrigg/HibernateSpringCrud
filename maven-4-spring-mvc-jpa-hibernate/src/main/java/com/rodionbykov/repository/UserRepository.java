package com.rodionbykov.repository;

import com.rodionbykov.model.User;
import com.rodionbykov.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

}
