package MT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.MemberDAO;
import MT.model.MemberVO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 1. 파라미터 수집
		String MEMBER_ID = request.getParameter("id");
		String MEMBER_PW = request.getParameter("pw");
		String NICK_NM = request.getParameter("nickname");
		// vo로 묶기
		MemberVO vo = new MemberVO(MEMBER_ID, MEMBER_PW, NICK_NM);
		
		// 2. DAO메서드 사용
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(vo);
		
		// 3. 회원가입 성공/실패 판단
		if(cnt>0) {
			// 성공 -> main으로
			response.sendRedirect("main.html");
		}else {
			// 실패 -> join으로
			response.sendRedirect("join.html");
		}
		
		
		
		
		
	}

}
