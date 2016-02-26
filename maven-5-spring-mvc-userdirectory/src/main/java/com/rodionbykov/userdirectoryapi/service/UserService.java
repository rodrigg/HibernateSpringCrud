package com.rodionbykov.userdirectoryapi.service;

import java.util.List;

import com.rodionbykov.userdirectoryapi.model.User;

public interface UserService {

	public User create(User user);
    public User delete(int id);
    public User kick(int id);
    public List<User> findAll();
    public User update(User user);
    public User findById(int id);
    public User login(String login, String passwd);
    public User pass(String securitytoken);
    public User logout(String securitytoken);
	
}
