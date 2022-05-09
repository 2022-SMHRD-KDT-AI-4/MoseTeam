package MT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MT.model.MemberDAO;
import MT.model.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 1. 파라미터 수집
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberVO vo = new MemberVO(id, pw);
		
		// 2. DAO 메서드
		MemberDAO dao = new MemberDAO();
		MemberVO mvo = dao.login(vo);
		
		// 3. 로그인 성공/실패 판단
		if(mvo==null) {
			// 실패
			System.out.println("로그인 실패");
		}else {
			// 성공
			response.sendRedirect("join.html");
			System.out.println("로그인 성공");
			// 사용자의 정보 유지 --> Session 이용
			HttpSession session = request.getSession();
			session.setAttribute("vo", mvo);
		}
	}

}
