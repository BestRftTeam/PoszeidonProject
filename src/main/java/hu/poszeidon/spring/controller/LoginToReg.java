package hu.poszeidon.spring.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginToReg
 */
@WebServlet("/LoginToReg")
public class LoginToReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginToReg() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String site = request.getContextPath() +  "/pages/register.html";
	    response.setStatus(HttpServletResponse.SC_OK);
	    response.getWriter().write(site);

	      // New location to be redirected
	    //response.sendRedirect(site);
	    /*response.setStatus(response.SC_MOVED_PERMANENTLY);
	    response.setHeader("Location", site);*/    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
