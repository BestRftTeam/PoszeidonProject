package hu.poszeidon.spring.configuration;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import hu.poszeidon.spring.model.Course;
import hu.poszeidon.spring.model.User;
import hu.poszeidon.spring.model.UserRole;
import hu.poszeidon.spring.model.UserRoleType;
import hu.poszeidon.spring.service.CourseService;
import hu.poszeidon.spring.service.UserRoleService;
import hu.poszeidon.spring.service.UserService;




@Configuration
@Import(DbConfiguration.class)
@ComponentScan(basePackages = "hu.poszeidon.spring")
public class AppMain {

	public static void main(String[] args) {
	/*	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppMain.class);
		//UserService service = (UserService) context.getBean("userService");
		//
		UserService service = (UserService) context.getBean("userService");
		
		User sanyi = new User();
		
		sanyi.setFirstName("Kisasd");
		sanyi.setLastName("Ati");
		sanyi.setEmail("kala_pala@gamil.com");
		sanyi.setPassword("xxaaaa");
		sanyi.setPoszId("kat23");
		
		UserRoleService service3 =(UserRoleService) context.getBean("userRoleService");
		sanyi.addUserRole(service3.findByUserRoleType(UserRoleType.TEACHER));
		
		
		
		//sanyi.setUserRoles(service3.findByUserRoleType(UserRoleType.STUDENT));
		
		//service.save(sanyi);

		//sanyi=service.findByPoszId("asd").getFirstName();
		
		//System.out.println("----------------------");
		//System.out.println("valami :"+service.findByPoszId("alm").getFirstName()+"|");
		
		
		
		Course tori = new Course();
		tori.setCourseName("töri");
		
		
		
		CourseService service2 = (CourseService) context.getBean("courseService");
		
//		service2.save(tori);
		
		
//		service.save(sanyi);
		
		
		
		List<Course> courses = service2.findAll();
		System.out.println("----------------------");
		System.out.println("======"+courses.size());
		System.out.println("----------------------");
		for(Course cou : courses){
			System.out.println("======"+cou);
		}

		List<User> users = service.findAll();
		for (User use : users) {
			System.out.println(use);
		}

		System.out.println("asd");
		context.close();*/
	}

}
