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
@WebServlet("/pages/OneExam")
public class OneExam extends InitServlet {
	private static final long serialVersionUID = 2878267318695777395L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      JSONObject obj = new JSONObject();
	      String re = "[";
	      
	      User user = usv.findByEmail(request.getSession().getAttribute("Username").toString());
	      Teszt test = trep.findBytestName(request.getParameter("examName"));
	      Course course = new Course();
	      StudentAnswer sta = new StudentAnswer();
	      Set<StudentAnswer> lsta = user.getTesztAnsewrs();
	      for (StudentAnswer ls : lsta){
	    	  if (ls.getTestName().equals(test.getTestName())) sta = ls;
	      }
	      Set<Course> lcourse = user.getCourses();
	      for (Course c : lcourse){
	    	  List<Teszt> tmp = c.getTests();
	    	  for (Teszt t: tmp){
	    		  if (t.getTestName().equals(test.getTestName())) course = c;
	    	  }
	      }
	      
	      System.out.println(user.getCourses());
	      
	      User cleader = usv.findByEmail(course.getCourseLeader());
	      
	      
	      obj.put("courseName", course.getCourseName());
	      obj.put("courseLeader", cleader.getFirstName()+" "+cleader.getLastName());
	      obj.put("score", sta.getSumScore());
	      /*for (Course c : courses){
	    	  obj.put("courseName", c.getCourseName());
	    	  System.out.println(obj);
	    	  re += obj.toString()+",";
	      }*/
	      re = re.substring(0, re.length()-1);
	      re +=  "]";
	      System.out.println(obj.toJSONString());
		  response.getWriter().write(obj.toJSONString());
		  //response.getWriter().write(request.getSession().getAttribute("role").toString());
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
