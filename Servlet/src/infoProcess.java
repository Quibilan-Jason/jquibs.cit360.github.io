

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class infoProcess
 */
@WebServlet("/infoProcess")
public class infoProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String add=request.getParameter("add");
		String phone=request.getParameter("phone");
		
		System.out.println("The name is:"+name);
		System.out.println("The address is:"+add);
		System.out.println("The phone number is:"+phone);
		
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("add", add);
		request.getSession().setAttribute("phone", phone);
		
		response.sendRedirect("html/course.html");
		
	}

}
