package com.uttara.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet() of Welcome App");
		String name = request.getParameter("uname");
		String a = request.getParameter("age");
		
		System.out.println("Name:"+ name + " Age: "+ a);
		PrintWriter pw = response.getWriter();
		
		if(name==null || name.trim().equals(""))
			pw.write("<html><body><h2>Error..!</h2><b>Please give proper name</b></body></html>");
		else
			try {
				int age = Integer.parseInt(a);
				if(age < 0 || age > 150)
					pw.write("<html><body><h2>Error..!</h2><b>Either dead or not born...</b></body></html>");
				else
				{
					if(age<50)
						pw.write("<html><body><h2>Welcome... YOUNGSTER!</h2><br/><b>Name: "+ name+ "<br/> Age: "+ age+"</b></body></html>");
					else
						pw.write("<html><body><h2>Welcome... OLDIE!</h2><br/><b>Name: "+ name+ "<br/> Age: "+ age+"</b></body></html>");
				}
			}
			catch(NumberFormatException e) {
				e.printStackTrace();
				pw.write("<html><body><h2>Error..!</h2><b>Please give age</b></body></html>");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
