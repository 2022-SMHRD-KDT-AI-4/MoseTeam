package MT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.BoardDAO;
import MT.model.ReviewDAO;
@WebServlet("/RDeleteService")
public class RDeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		ReviewDAO dao = new ReviewDAO();
		System.out.println(num);
		dao.delete(num);
		
		response.sendRedirect("test1.jsp");
		
		
	}

}
