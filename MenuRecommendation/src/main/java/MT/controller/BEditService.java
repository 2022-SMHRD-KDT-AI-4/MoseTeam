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
		
		HttpSession session = request.getSession();
		BoardVO vo = (BoardVO)session.getAttribute("vo");
		int BOARD_NO = vo.getBOARD_NO();
		String BOARD_TITLE = vo.getBOARE_TITLE();
		String BOARD_CONTENT = vo.getBOARD_CONTENT();
		BoardVO bvo = new BoardVO(BOARD_NO, BOARD_TITLE, BOARD_CONTENT);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.update(bvo);
		
		if(cnt>0) {
			// 성공
			System.out.println("정보수정 성공");
			//session덮어쓰기
			session.setAttribute("vo", dao);
			response.sendRedirect("comuList.jsp");
		}else {
			// 실패
			System.out.println("정보수정 실패");
			response.sendRedirect("comuList.jsp");
		}
		
	}

}
