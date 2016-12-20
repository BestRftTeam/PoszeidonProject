package hu.poszeidon.spring.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.CookieGenerator;

import hu.poszeidon.spring.configuration.DbConfiguration;
import hu.poszeidon.spring.configuration.PoszeidonConfiguration;
import hu.poszeidon.spring.model.User;
import hu.poszeidon.spring.model.UserRole;
import hu.poszeidon.spring.repositories.UserRepository;
import hu.poszeidon.spring.service.UserService;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends InitServlet {
	private static final long serialVersionUID = 2878267318695777395L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
/*
    @Override
    public final void init(ServletConfig config) throws ServletException {
        super.init(config);
       // WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        //wac.getAutowireCapableBeanFactory().autowireBean(this);
        
        //AbstractApplicationContext context = new AnnotationConfigApplicationContext(PoszeidonConfiguration.class);
		//UserService service = (UserService) context.getBean("userService");
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		System.out.println(Username);
		User user =(User) usv.findByEmail(Username);
		//System.out.println(user.toString()); user.getUserRoles()

		
		if (user==null){
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write("null a user");
		}else{
			if (Password.equals(user.getPassword())){
				String roles = "";
				for (UserRole ur :  user.getUserRoles()){
					roles += ur.getUserRoleType() + ";"; 
				}
				request.getSession().setAttribute("Username", Username);
				request.getSession().setAttribute("role", roles);
				//Cookie cookie = new Cookie("username", user.getEmail());
				response.getWriter().write(request.getContextPath() + "/pages/welcome.html");
				//response.getWriter().write(request.getSession().getAttribute("Username").toString());
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("rossz");
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
