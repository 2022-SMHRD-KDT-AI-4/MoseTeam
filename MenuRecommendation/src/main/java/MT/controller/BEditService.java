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

@WebServlet("/BEditService")
public class BEditService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		System.out.println(request.getParameter("num"));
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("content"));
		
		int BOARD_NO = Integer.parseInt(request.getParameter("num"));
		String BOARD_TITLE = request.getParameter("title");
		String BOARD_CONTENT = request.getParameter("content");
		BoardVO bvo = new BoardVO(BOARD_NO, BOARD_TITLE, BOARD_CONTENT);
		
		HttpSession session = request.getSession();
		BoardVO vo = (BoardVO)session.getAttribute("vo");
		BoardDAO dao = new BoardDAO();
		int cnt = dao.update(bvo);
		
		if(cnt>0) {
			// 성공
			System.out.println("정보수정 성공");
			//session덮어쓰기
			session.setAttribute("vo", dao);
			response.sendRedirect("ListService");
		}else {
			// 실패
			System.out.println("정보수정 실패");
			response.sendRedirect("ListService");
		}
		
	}

}
