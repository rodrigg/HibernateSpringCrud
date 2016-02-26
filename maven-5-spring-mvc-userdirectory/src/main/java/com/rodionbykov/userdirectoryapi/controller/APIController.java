package com.rodionbykov.userdirectoryapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rodionbykov.userdirectoryapi.exception.DuplicateUserException;
import com.rodionbykov.userdirectoryapi.model.User;
import com.rodionbykov.userdirectoryapi.service.UserService;

@RestController
public class APIController {

	@Autowired
    private UserService userService;
	
	@RequestMapping(value="/users/login", method = RequestMethod.POST)
	public User loginUser(@RequestParam(value="login") String login,
            			  @RequestParam(value="passwd") String passwd) {

		User user = userService.login(login, passwd);
		
        return user;
	}	
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Exception handleException(Exception e) {
	    return e;
	}
	
	@RequestMapping(value="/users/logout", method = RequestMethod.DELETE)
	public User logoutUser(@RequestHeader("x-token") String securitytoken) {

		User user = userService.logout(securitytoken);
		
        return user;
	}
	
	@RequestMapping(value="/users/pingpong", method=RequestMethod.GET)
    public User userPing(@RequestHeader("x-token") String securitytoken) {

		User user = new User();
		try{
			User authUser = userService.pass(securitytoken);
			
			if(authUser.getId() > 0){
				user = authUser;
			}
		}catch(Exception e){
		
		}
		
		return user;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
    public List<User> userList(@RequestHeader("x-token") String securitytoken) {

		List<User> userList = new ArrayList<>();
		
		User authUser = userService.pass(securitytoken);
		
		if(authUser.getId() > 0){
			userList = userService.findAll();
		}
		
		return userList;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
    public User userCreate(@RequestHeader("x-token") String securitytoken, @RequestBody User user) {

		User authUser = userService.pass(securitytoken);
		
		if(authUser.getId() > 0 && authUser.getLevel() > 0){
			userService.create(user);
		}
		
		return user;
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
    public User userObject(@PathVariable("userId") int id, @RequestHeader("x-token") String securitytoken) {
		User user = new User();
		
		User authUser = userService.pass(securitytoken);
		
		if(authUser.getId() > 0){
			user = userService.findById(id);
		}
		
		return user;
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.POST)
    public User userUpdate(@PathVariable("userId") int id, @RequestBody User user, @RequestHeader("x-token") String securitytoken) {
		User updatedUser = user;
		
		User authUser = userService.pass(securitytoken);
		if(authUser.getId() > 0){
			updatedUser = userService.findById(id);
			 
			if(updatedUser.getId() > 0 && authUser.getLevel() > 0){
				updatedUser.setLogin(user.getLogin());
				updatedUser.setPasswd(user.getPasswd());
				updatedUser.setFirstName(user.getFirstName());
				updatedUser.setLastName(user.getLastName());
				updatedUser.setLevel(user.getLevel());
				
				updatedUser = userService.update(updatedUser);
			}
		}
		
		return updatedUser;
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
    public User userDelete(@PathVariable("userId") int id, @RequestHeader("x-token") String securitytoken) {
		User deletedUser = new User();
		
		User authUser = userService.pass(securitytoken);
		if(authUser.getId() > 0 && authUser.getLevel() > 10){
			deletedUser = userService.findById(id);
			
			if(deletedUser.getId() > 0){
				deletedUser = userService.delete(id);
			}
		}
		
		return deletedUser;
	}
	
}