package MT.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
		request.setCharacterEncoding("UTF-8");
		// 1. 파라미터 수집
		String MEMBER_ID = request.getParameter("id");
		String MEMBER_PW = request.getParameter("pw");
		MemberVO vo = new MemberVO(MEMBER_ID,MEMBER_PW);
		
		// 2. DAO 메서드
		MemberDAO dao = new MemberDAO();
		MemberVO mvo = dao.login(vo);
		
		// 3. 결과 응답 준비
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		
		// 3. 로그인 성공/실패 판단
		if(mvo==null) {
			// 실패
			out.print(false);
			System.out.println("로그인 실패");
		}else {
			// 사용자의 정보 유지 --> Session 이용
			HttpSession session = request.getSession();
			session.setAttribute("vo", mvo);
			
			// 사용자의 정보 유지 --> Cookie 이용
			Cookie cookie = new Cookie("id", mvo.getMEMBER_ID());
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			
			// 성공
			out.print(true);
			System.out.println("로그인 성공");
			
			
		}

		
	}

}
