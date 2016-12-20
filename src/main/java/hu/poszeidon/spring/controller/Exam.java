package hu.poszeidon.spring.controller;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
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
import hu.poszeidon.spring.model.Teszt;
import hu.poszeidon.spring.model.User;
import hu.poszeidon.spring.model.UserRole;
import hu.poszeidon.spring.repositories.UserRepository;
import hu.poszeidon.spring.service.UserService;

/**
 * Servlet implementation class login
 */
@WebServlet("/pages/StartExam")
public class Exam extends InitServlet {
	private static final long serialVersionUID = 2878267318695777395L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Course course = cserv.findBycourseName(request.getParameter("courseName"));
		System.out.println(course);
		List<Teszt> tests = course.getTests();
		Teszt test = new Teszt() ;
		for (Teszt t : tests){
			if(t.getAvailability()!=null){
				test = t;
				System.out.println(t.getTestSheet().get(0).getAnswerOptions());
			}
		}
		JSONObject object = new JSONObject(test);
		response.getWriter().write(object.toString());
		//Date d = new Date();
		//LocalDateTime ld = LocalDateTime.of(d.getYear(), d.getMonth(), d.getDay(), d.getHours(), d.getMinutes(), d.getSeconds());
		//test.setStartTime(ld);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//User user = usv.findByEmail(request.getSession().getAttribute("Username").toString());
		Course course = cserv.findBycourseName(request.getParameter("courseName"));
		Teszt teszt = new Teszt();
		System.out.println(request.getParameter("sheet"));
		
		//System.out.println(request.getParameter("courseName"));
		JSONObject object = new JSONObject(request.getParameter("sheet"));
		System.out.println(object.get("availability"));
		//teszt.setTestName(request.getParameter("TesztName"));
		int year,month,day;
		String[] tmp = object.getString("availability").split("-");
		year = Integer.parseInt(tmp[2]);
		month = Integer.parseInt(tmp[0]);
		day = Integer.parseInt(tmp[1]);
		teszt.setAvailability(new Date(year,month,day));
		teszt.setTestName(object.getString("TestName"));
		List<QArepo> testSheet = new LinkedList<>();
		//QArepo Sheet = new QArepo();
		JSONArray jsonarray = object.getJSONArray("questions");
		for (int i = 0; i < jsonarray.length(); i++) {
			QArepo Sheet = new QArepo();
			JSONObject question =  (JSONObject) jsonarray.get(i);
			Sheet.setQuestion(question.getString("Question"));
			Sheet.setScore(Integer.parseInt(question.getString("Value")));
			JSONObject ans = question.getJSONObject("Answers");
			JSONArray answerarray = ans.getJSONArray("ans");
			List<String> answerOptions = new LinkedList<>();
			List<Boolean> answers = new LinkedList<>();
			for (int j = 0; j < answerarray.length(); j++) {
				JSONObject answ = answerarray.getJSONObject(j);
				answerOptions.add(answ.getString("Answer"));
				if ((boolean) answ.get("True")) answers.add(true);
				else answers.add(false);
			}
			Sheet.setAnswerOptions(answerOptions);
			Sheet.setAnswers(answers);
			testSheet.add(Sheet);
			System.out.println(Sheet);
		}
		teszt.setTestSheet(testSheet);
		
		//usv.delete(user);
		//cserv.save(course);
		course.addTest(teszt);
		cserv.save(course);
		System.out.println(teszt);
		
		//usv.save(user);

		//usv.save(user);
		
		//cserv.save(course);
	}

}
