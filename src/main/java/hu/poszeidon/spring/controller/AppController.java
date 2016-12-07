package hu.poszeidon.spring.controller;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import hu.poszeidon.spring.model.User;
import hu.poszeidon.spring.model.UserRole;
import hu.poszeidon.spring.model.UserRoleType;
import hu.poszeidon.spring.service.UserService;

@Controller
@RestController
public class AppController  {
	private UserService usv;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public HttpStatus loginPage(HttpServletRequest request, HttpServletResponse response) {
    	User user = usv.findByEmail(request.getParameter("Username"));
    	if (request.getParameter("Password").equals(user.getPassword()))return HttpStatus.OK;
    	else return HttpStatus.BAD_REQUEST;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public HttpStatus registerPage(HttpServletRequest request, HttpServletResponse response) {
    	 Random rnd = new Random();
    	 Set<UserRole> s = new HashSet<UserRole>();
    	 UserRole ur = new UserRole();
    	 ur.setUserRoleType(UserRoleType.STUDENT);
    	 request.getParameter("Role");
    	 s.add(ur);
    	User user = new User(request.getParameter("First_Name")+request.getParameter("Last_Name")+rnd.nextInt(999999)+1,
    			request.getParameter("First_Name"),request.getParameter("Last_Name"),
    			request.getParameter("Password"),request.getParameter("Email"),
    			s);
    	if (request.getParameter("Password").equals(user.getPassword()))return HttpStatus.OK;
    	else return HttpStatus.BAD_REQUEST;
    }
    
	
	/*
	  @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	    public String homePage(ModelMap model) {
	        model.addAttribute("greeting", "Hi, Welcome to mysite");
	        return "welcome";
	    }
	 
	    @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String adminPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "admin";
	    }
	 
	    @RequestMapping(value = "/db", method = RequestMethod.GET)
	    public String dbaPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "dba";
	    }
	 
	    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "accessDenied";
	    }
	 
	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage() {
	        return "login";
	    }
	 
	    @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        return "redirect:/login?logout";
	    }
	 
	    private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }*/
}
