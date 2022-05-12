package MT.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import MT.model.BoardDAO;
import MT.model.BoardVO;

@WebServlet("/SearchService")
public class SearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 인코딩
		request.setCharacterEncoding("euc-kr");

		// 파라미터 수집
		String search = request.getParameter("search");

		// DAO메서드 사용
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.search("%"+search+"%");
		
		// 객체 바인딩
		request.setAttribute("list", list);
		
		// forward방식으로 페이지 이동
		RequestDispatcher rd = request.getRequestDispatcher("searchList.jsp");
		rd.forward(request, response);
		
	}

}
