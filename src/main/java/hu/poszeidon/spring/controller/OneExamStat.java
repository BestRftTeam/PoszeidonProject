package hu.poszeidon.spring.controller;

import java.io.IOException;
import java.util.HashSet;
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
@WebServlet("/pages/OneExamStat")
public class OneExamStat extends InitServlet {
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
	      User user = usv.findByEmail(request.getSession().getAttribute("Username").toString());
	      String testName = request.getParameter("examName");
	      Set<Course> courses = user.getCourses();
	      List<Teszt> exams = new LinkedList<>();
	      Set<StudentAnswer> stal =  user.getTesztAnsewrs();
	      
	      List<Double> scoreList = new LinkedList<>();

	      
	      for (StudentAnswer t : stal){
	   		  if (testName.equals(t.getTestName())){
	   			scoreList = t.getScoreList();
	   		  }
	   	  }
	      for (Double d :scoreList){
			  obj.put("Score", d);
			  re += obj.toString()+",";
	      }
	      re = re.substring(0, re.length()-1);
	      re +=  "]";

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
