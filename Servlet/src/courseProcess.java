

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class courseProcess
 */
@WebServlet("/courseProcess")
public class courseProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String course=request.getParameter("course");
		String id=request.getParameter("id");
				
		System.out.println("The name is:"+course);
		System.out.println("The address is:"+id);
				
		request.getSession().setAttribute("course", course);
		request.getSession().setAttribute("id", id);
				
		response.sendRedirect("jsp/printout.jsp");
		
	}

}
