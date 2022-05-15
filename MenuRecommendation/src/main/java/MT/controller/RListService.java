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
import MT.model.ReviewDAO;
import MT.model.ReviewVO;

@WebServlet("/RListService")
public class RListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 수집
		String REST_ID = request.getParameter("id");
		System.out.println(REST_ID);

		// DAO메서드 사용
		ReviewDAO dao = new ReviewDAO();
		List<ReviewVO> list = dao.search(REST_ID);
		
		// 객체 바인딩
		request.setAttribute("list", list);
		
		// forward방식으로 페이지 이동
		RequestDispatcher rd = request.getRequestDispatcher("test2.jsp");
		rd.forward(request, response);
		
	}

}
