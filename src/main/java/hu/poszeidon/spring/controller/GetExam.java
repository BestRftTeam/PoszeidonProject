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
import hu.poszeidon.spring.model.StudentAnswer;
import hu.poszeidon.spring.model.Teszt;
import hu.poszeidon.spring.model.User;
/**
 * Servlet implementation class login
 */
@WebServlet("/pages/GetExam")
public class GetExam extends InitServlet {
	private static final long serialVersionUID = 2878267318695777395L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
/*	public boolean HasCourse(String CourseName){
		for (Course c : this.getCourses()){
			if (c.getCourseName().equals(CourseName)) return true;
		}
		return false;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      JSONObject obj = new JSONObject();
	      String re = "[";
	      Course course = cserv.findBycourseName(request.getParameter("courseName"));
	      System.out.println(course.getCourseName()+"<---->coursename"+"--------"+course.getCourseLeader()+"<----->courseLeader");
	      User user = usv.findByEmail(course.getCourseLeader());
	      User cuser = usv.findByEmail(request.getSession().getAttribute("Username").toString());
	      System.out.println(user.getCourses());
	      String testname = request.getParameter("testName");
	      obj.put("courseName", course.getCourseName());
	      obj.put("courseLeader", user.getFirstName()+" "+user.getLastName());
	      Teszt test = new Teszt();
	      for (Teszt t :course.getTests()){
	    	  if (t.getTestName().equals(testname)) test = t; 
	      }
	      
	      StudentAnswer sta = new StudentAnswer();
	      Set<StudentAnswer> sans = cuser.getTesztAnsewrs();
	      for (StudentAnswer sa : sans){
	    	  if (sa.getTestName().equals(test.getTestName())) sta = sa;
	      }
	      
	      /*for (Course c : courses){
	    	  obj.put("courseName", c.getCourseName());
	    	  System.out.println(obj);
	    	  re += obj.toString()+",";
	      }*/
	      re = re.substring(0, re.length()-1);
	      re +=  "]";
	      System.out.println("Valaszok<------>"+obj.toJSONString());
		  response.getWriter().write(obj.toJSONString());
		  
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
