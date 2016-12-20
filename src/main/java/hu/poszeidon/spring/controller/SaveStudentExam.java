package hu.poszeidon.spring.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
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
import hu.poszeidon.spring.model.QArepo;
import hu.poszeidon.spring.model.StudentAnswer;
import hu.poszeidon.spring.model.Teszt;
import hu.poszeidon.spring.model.User;
import hu.poszeidon.spring.model.UserRole;
import hu.poszeidon.spring.repositories.UserRepository;
import hu.poszeidon.spring.service.UserService;

/**
 * Servlet implementation class login
 */
@WebServlet("/pages/SaveStudentExam")
public class SaveStudentExam extends InitServlet {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = usv.findByEmail(request.getSession().getAttribute("Username").toString());
		Course course = cserv.findBycourseName(request.getParameter("courseName"));
		StudentAnswer teszt = new StudentAnswer();
		//System.out.println(request.getParameter("sheet"));
		Teszt test = new Teszt();
		/*Vizsga kezdés/vége mentés, rossz start
		Date d = new Date();
		String StartT = request.getParameter("StartTime");
		System.out.println(StartT);
		LocalDateTime ld = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String end = ld.format(formatter);
		
		LocalDateTime StartTime = LocalDateTime.parse(d.getYear()+"-"+(d.getMonth()+1)+"-"+d.getDay()+" "+StartT, formatter);
		LocalDateTime EndTime = LocalDateTime.parse(end, formatter);
		teszt.setStartTime(StartTime);
		teszt.setEndTime(EndTime);
		*/
		JSONObject object = new JSONObject(request.getParameter("sheet"));
		for (Teszt t : course.getTests()){
			if (t.getTestName().equals(object.getString("TestName"))) test = t; 
		}
		
		//System.out.println(test);
		//System.out.println(test.getId());
		teszt.setTestName(test.getTestName());
		teszt.setTestID(test.getId());
		List<Boolean> answerList = new ArrayList<Boolean>();
		
		JSONArray jsonarray = object.getJSONArray("questions");
		for (int i = 0; i < jsonarray.length(); i++) {

			JSONObject question =  (JSONObject) jsonarray.get(i);

			JSONObject ans = question.getJSONObject("Answers");
			JSONArray answerarray = ans.getJSONArray("ans");

			for (int j = 0; j < answerarray.length(); j++) {
				JSONObject answ = answerarray.getJSONObject(j);

				if ((boolean) answ.get("True")) answerList.add(Boolean.TRUE);
				else answerList.add(Boolean.FALSE);
			}

		}


		//System.out.println("studenAnswer<---->"+teszt);
		//System.out.println(test);
		
		teszt.setAnswerList(answerList);
		teszt.examination(test);
		usv.addStudentAnswer(user, teszt);
		
		//System.out.println(teszt);
		
		
		
		
	
	}

}
