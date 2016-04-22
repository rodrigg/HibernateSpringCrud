package com.rodionbykov.userdirectory.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodionbykov.userdirectory.model.User;
import com.rodionbykov.userdirectory.repository.UserRepository;
import com.rodionbykov.userdirectory.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
 
    @Override
    @Transactional
    public User create(User user) {
        User createdUser = user;
        
        return userRepository.save(createdUser);
    }
     
    @Override
    @Transactional
    public User findById(int id) {
        return userRepository.findOne(id);
    }
 
    @Override
    @Transactional
    public User delete(int id) {
    	User deletedUser = userRepository.findOne(id);
         
    	userRepository.delete(deletedUser);
    	
        return deletedUser;
    }
    
    @Override
    @Transactional
    public User kick(int id) {
    	User kickedUser = userRepository.findOne(id);
         
    	kickedUser.setSecurityToken("");
    	
    	userRepository.save(kickedUser);
    	
        return kickedUser;
    }
 
    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }
 
    @Override
    @Transactional
    public User update(User user) {
    	User updatedUser = userRepository.findOne(user.getId());
         
    	updatedUser.setLogin(user.getLogin());
    	if (user.getPasswd().length() > 0){
    		updatedUser.setPasswd(user.getPasswd());
    	}
    	updatedUser.setFirstName(user.getFirstName());
    	updatedUser.setLastName(user.getLastName());
    	updatedUser.setLevel(user.getLevel());
    	
        return userRepository.save(updatedUser);
    }
    
    public User login(String login, String passwd) {
    	User user = new User();
    	
    	UUID newUserId = UUID.randomUUID();    	
    	
    	try {
    		user = userRepository.findByLoginAndPasswd(login, passwd);
    	}catch(Exception e){
    		//
    	}
    	
        if(user.getId() > 0){
        	user.setSecurityToken(newUserId.toString());
        	userRepository.save(user);
        }
    	
    	return user;
    }

    public User pass(String securitytoken) {
    	
    	User user = userRepository.findBySecurityToken(securitytoken);
    	
    	return user;
    }
    
    public User logout(String securitytoken) {
    	
    	User user = userRepository.findBySecurityToken(securitytoken);
    	
    	user.setSecurityToken("");
    	
    	return userRepository.save(user);
    }
    
}