package com.rodionbykov.userdirectoryapi.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rodionbykov.userdirectoryapi.model.User;
import com.rodionbykov.userdirectoryapi.service.UserService;

@Controller
@SessionAttributes("loggedUser")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
    private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String home() {
		
		return "about";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute User user, final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
        String message = "";
        
        user = userService.login(user.getLogin(), user.getPasswd());
        if(user.getId() > 0){
        	message = "Welcome, " + user.getFirstName() + " " + user.getLastName() + "!";
        	redirectAttributes.addFlashAttribute("loggedUser", user);
        	mav.setViewName("redirect:/list");
        }else{
        	message = "Login unsuccessful";
        	mav.setViewName("redirect:/login");
        }
                 
        redirectAttributes.addFlashAttribute("message", message);
        return mav;  
	}
	
	@RequestMapping("/logout")
	public ModelAndView logoutUser(SessionStatus status, final RedirectAttributes redirectAttributes, @ModelAttribute("loggedUser") User loggedUser){
		ModelAndView mav = new ModelAndView();
		
	    status.setComplete();
	    userService.logout(loggedUser.getSecurityToken());
	    loggedUser = new User();
	    redirectAttributes.addFlashAttribute("loggedUser", loggedUser);	    
	    redirectAttributes.addFlashAttribute("message", "Logged out");
	    
	    mav.setViewName("redirect:/login");
	    return mav;
	}
	
	@RequestMapping(value="/kick/{id}", method=RequestMethod.GET)
    public ModelAndView kickUser(@PathVariable Integer id, final RedirectAttributes redirectAttributes){	        
	    ModelAndView mav = new ModelAndView("redirect:/list");        
	         
	    User user = userService.kick(id);
	    String message = "User " + user.getFirstName() + " " + user.getLastName() + " was kicked.";
	         
	    redirectAttributes.addFlashAttribute("message", message);
	    return mav;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView userListPage() {
        ModelAndView mav = new ModelAndView("list");
        
        List<User> userList = userService.findAll();
        
        mav.addObject("userList", userList);
        return mav;
    }

	 @RequestMapping(value="/create", method=RequestMethod.GET)
	 public ModelAndView newUserPage() {
	     ModelAndView mav = new ModelAndView("form", "user", new User());
	     return mav;
	 }
	     
	 @RequestMapping(value="/create", method=RequestMethod.POST)
	 	public ModelAndView addUser(@ModelAttribute User user, final RedirectAttributes redirectAttributes){
	         
        ModelAndView mav = new ModelAndView();
        String message = "New user " + user.getFirstName() + " " + user.getLastName() + " was successfully created.";
         
        userService.create(user);
        mav.setViewName("redirect:/list");
                 
        redirectAttributes.addFlashAttribute("message", message);   
        return mav;     
    }
	     
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer id) {
	    ModelAndView mav = new ModelAndView("edit");
	    
	    User user = userService.findById(id);
	    
	    mav.addObject("user", user);
	    return mav;
	}
	     
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user, @PathVariable Integer id, final RedirectAttributes redirectAttributes){	         
	    try{
			ModelAndView mav = new ModelAndView("redirect:/list");	    
		 
		    userService.update(user);
		    String message = "User " + user.getFirstName() + " " + user.getLastName() + " was successfully updated.";
		    
		    redirectAttributes.addFlashAttribute("message", message);   
		    return mav;
	    }catch(Exception e){
	    	ModelAndView mav = new ModelAndView("edit");
		    		    
		    mav.addObject("user", user);
		    
		    String error = "Error happened while updating user";
		    mav.addObject("error", error);
		    
		    return mav;
	    }
	}
	     
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id, final RedirectAttributes redirectAttributes){	        
	    ModelAndView mav = new ModelAndView("redirect:/list");        
	         
	    User user = userService.delete(id);
	    String message = "User " + user.getFirstName() + " " + user.getLastName() + " was successfully deleted.";
	         
	    redirectAttributes.addFlashAttribute("message", message);
	    return mav;
	}
	
}
