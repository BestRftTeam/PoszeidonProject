package hu.poszeidon.spring.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Import;

import hu.poszeidon.spring.configuration.DbConfiguration;
import hu.poszeidon.spring.model.User;
import hu.poszeidon.spring.model.UserRole;
import hu.poszeidon.spring.model.UserRoleType;
import hu.poszeidon.spring.service.UserService;

/**
 * Servlet implementation class Register
 */
@WebServlet("/pages/Register")
public class Register extends InitServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   	 Random rnd = new Random();
    	 Set<UserRole> s = new HashSet<UserRole>();
    	 UserRole ur = new UserRole();
    	 switch (request.getParameter("Role")){
    	 case "Student":{
    		 ur = urs.findByUserRoleType(UserRoleType.STUDENT);
    		 //ur.setUserRoleType(UserRoleType.STUDENT);
    		 //ur.setId(1);
    		 break;
    	 }
    	 case "Teacher":{
    		 ur = urs.findByUserRoleType(UserRoleType.TEACHER);
    		 //ur.setUserRoleType(UserRoleType.TEACHER);
    		 //ur.setId(2);
    		 break;
    	 }
    	 case "Parent":{
    		 ur = urs.findByUserRoleType(UserRoleType.PARENT);
    		 //ur.setUserRoleType(UserRoleType.PARENT);
    		 //ur.setId(3);
    		 break;
    	 }
    	 }
    	User user = new User(request.getParameter("First_Name")+request.getParameter("Last_Name")+rnd.nextInt(999999)+1,
    			request.getParameter("First_Name"),request.getParameter("Last_Name"),
    			request.getParameter("Password"),request.getParameter("Email"));
    	System.out.println(request.getParameter("Password")+"<------>"+user.getPassword());
    	System.out.println(ur.toString());
    	System.out.println(user.toString());
    	
    	if (request.getParameter("Password").equals(user.getPassword())) {
    		response.setStatus(HttpServletResponse.SC_OK);
    		user.addUserRole(ur);
    		//usv.findByPoszId(user.getPoszId()).addUserRole(ur);
    		System.out.println(user.toString());
    		usv.save(user);
    		return;}
    	else {response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    		
    	return;}
	}

}
