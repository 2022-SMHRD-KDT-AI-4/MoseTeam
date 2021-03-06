package MT.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.BoardDAO;
import MT.model.BoardVO;

@WebServlet("/MyBListService")
public class MyBListService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		String MEMBER_ID = request.getParameter("id");

		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.myList(MEMBER_ID);
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("test2.jsp");
		rd.forward(request, response);
		
		
		
	}

}
