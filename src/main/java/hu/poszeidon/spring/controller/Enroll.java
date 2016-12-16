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
import hu.poszeidon.spring.model.Course;
import hu.poszeidon.spring.model.User;
import hu.poszeidon.spring.model.UserRole;
import hu.poszeidon.spring.repositories.UserRepository;
import hu.poszeidon.spring.service.UserService;

/**
 * Servlet implementation class login
 */
@WebServlet("/pages/Enroll")
public class Enroll extends InitServlet {
	private static final long serialVersionUID = 2878267318695777395L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
/*

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = usv.findByEmail(request.getSession().getAttribute("Username").toString());
		Course course = cserv.findBycourseName(request.getParameter("Course_Name").toString());
		
		user.addCourse(course);
		System.out.println(course);
		System.out.println(user);
		usv.save(user);


	}

}
