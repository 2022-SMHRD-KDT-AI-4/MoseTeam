package MT.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.BoardDAO;
import MT.model.BoardVO;
import MT.model.PushVO;

@WebServlet("/GoodAddService")
public class GoodAddService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// board_no 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		int push = 0;
		
		// selectOne으로 board_no, member_id 가져오기
		BoardDAO dao = new BoardDAO();
		BoardVO bvo = dao.selectOne(num);
		int BOARD_NO = bvo.getBOARD_NO();
		String MEMBER_ID = bvo.getMEMBER_ID();
		
		// 추천한적 있는지 확인
		PushVO pvo = new PushVO(BOARD_NO,MEMBER_ID);
		System.out.println(pvo.getBOARD_NO());
		System.out.println(pvo.getMEMBER_ID());
		
		int cnt = dao.goodCheck(pvo);
		
		// 추천 관련
		if(cnt==1) {
			dao.goodAdd(pvo);
			System.out.println("추천성공");
		}else {
			System.out.println("추천실패");
		}

		// 페이지 돌아가기
		BoardVO back = dao.selectOne(num);
		
		request.setAttribute("bvo", bvo);
		
		RequestDispatcher rd = request.getRequestDispatcher("comuView.jsp");
		rd.forward(request, response);
		
		
	}

}
