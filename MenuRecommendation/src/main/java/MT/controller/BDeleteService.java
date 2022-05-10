package MT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MT.model.BoardDAO;
import MT.model.BoardVO;
import MT.model.MemberDAO;

@WebServlet("/BDeleteService")
public class BDeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		BoardVO vo = (BoardVO)session.getAttribute("vo");
		
		BoardDAO dao = new BoardDAO();
		dao.delete(vo);
		
		response.sendRedirect("comuList.jsp");
		
	}

}
