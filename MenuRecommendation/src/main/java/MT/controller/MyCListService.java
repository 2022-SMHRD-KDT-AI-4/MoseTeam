package MT.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.ReplyDAO;
import MT.model.ReplyVO;


@WebServlet("/MyRListService")
public class MyCListService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		String MEMBER_ID = request.getParameter("id");

		ReplyDAO dao = new ReplyDAO();
		List<ReplyVO> list = dao.myList(MEMBER_ID);
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("test2.jsp");
		rd.forward(request, response);
		
		
	}

}
