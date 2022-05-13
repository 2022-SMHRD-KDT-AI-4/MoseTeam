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

@WebServlet("/PopListService")
public class PopListService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// DAO메서드로 글 정보 가져오기
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.popList();
		List<BoardVO> list2 = dao.notice();
		
		// 객체 바인딩
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		// 페이지 이동
		RequestDispatcher rd = request.getRequestDispatcher("popularityList.jsp");
		rd.forward(request,response);
		
	}

}
