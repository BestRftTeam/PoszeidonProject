package hu.poszeidon.spring.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONWriter;
import org.json.simple.JSONObject;

import hu.poszeidon.spring.model.Course;
import hu.poszeidon.spring.model.Learning;
import hu.poszeidon.spring.model.User;
/**
 * Servlet implementation class login
 */
@WebServlet("/pages/Learnings")
public class Learnings extends InitServlet {
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
	      JSONObject obj = new JSONObject();
	      String re = "[";
	      Course course = cserv.findBycourseName(request.getParameter("courseName"));
	      //User user = usv.findByEmail(request.getSession().getAttribute("Username").toString());
	      //System.out.println("user<------>"+request.getSession().getAttribute("Username").toString());
	      //Set<Course> courses = user.getCourses();
	      //System.out.println("courses<------>"+courses.toString());
	      //System.out.println("coursessize<----->"+courses.size());
	      List<Learning> listlearning = course.getLearnings();
	      System.out.println(listlearning.size());
	      for (Learning c : listlearning){
	    	  obj.put("Learning", c.getPath());
	    	  System.out.println(obj);
	    	  re += obj.toString()+",";
	      }
	      //System.out.println(re);
	      re = re.substring(0, re.length()-1);
	      re +=  "]";
	      //System.out.println(re);
			//response.getWriter().write("OK");
		  response.getWriter().write(re);	
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
