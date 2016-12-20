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
@WebServlet("/pages/GetStudentAnswers")
public class GetStudentAnswers extends InitServlet {
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
	     
	      User user = usv.findByEmail(request.getSession().getAttribute("Username").toString());

	      System.out.println(user.getCourses());
	      String testname = request.getParameter("testName");

	      
	      StudentAnswer sta = new StudentAnswer();
	      Set<StudentAnswer> sans = user.getTesztAnsewrs();
	      for (StudentAnswer sa : sans){
	    	  if (sa.getTestName().equals(testname)) sta = sa;
	      }
	      List<Boolean> UAnswerList = sta.getAnswerList();
	      
	      for (Boolean ulist : UAnswerList){
	    	 // if (ulist.booleanValue()) obj.put("userAnswer", "T");
	    	 // else obj.put("userAnswer", "F");
	    	  obj.put("userAnswer", ulist.booleanValue());
	    	  re += obj.toString()+",";
	      }
	      re = re.substring(0, re.length()-1);
	      re +=  "]";
	      System.out.println("Valaszok<------>"+re);
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
