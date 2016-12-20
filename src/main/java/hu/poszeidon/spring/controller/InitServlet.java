package hu.poszeidon.spring.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import hu.poszeidon.spring.configuration.DbConfiguration;
import hu.poszeidon.spring.repositories.TesztRepository;
import hu.poszeidon.spring.repositories.UserRepository;
import hu.poszeidon.spring.repositories.UserRoleRepository;
import hu.poszeidon.spring.service.CourseService;
import hu.poszeidon.spring.service.UserRoleService;
import hu.poszeidon.spring.service.UserService;

@Import(DbConfiguration.class)
@ComponentScan(basePackages = "hu.poszeidon.spring")
public class InitServlet extends HttpServlet{
	@Autowired
	public UserService usv;
	@Autowired
	public UserRoleService urs;
	@Autowired
	public CourseService cserv;
	@Autowired
	public TesztRepository trep;

	
    @Override
    public final void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        wac.getAutowireCapableBeanFactory().autowireBean(this);
    }
}
