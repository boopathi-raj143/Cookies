
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Cookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Cookies
		
		String username=request.getParameter("fullname");
		String password=request.getParameter("email");
		PrintWriter out=response.getWriter();
		out.println("Full Name:"+fullname+"\nEmail:"+email);

		Cookie cookie=new Cookie("fullname",fullname);
		response.addCookie(cookie);
		response.sendRedirect("Cookies1");
		
		
		// URL Rewritting //
		
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String url=request.getParameter("fullname");
		out.println("<a href='Cookies1?username="+url+"'>Click here</a>");
		out.close();
		}catch(Exception e) {e.printStackTrace();}
		RequestDispatcher rs=request.getRequestDispatcher("Cookies1");

		//Hidden Fields //

		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("fullname");
		
		out.print("<form action='Cookies1'>");
		out.print("<input type='hidden' Full Name='fullname' value='"+fullname+"'>");
		out.print("<input type='submit'>");
		out.print("</form>");  
	    	out.close();  
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}