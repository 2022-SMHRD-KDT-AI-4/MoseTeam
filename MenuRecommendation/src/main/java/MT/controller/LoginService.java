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
		// 1. �Ķ���� ����
		String MEMBER_ID = request.getParameter("id");
		String MEMBER_PW = request.getParameter("pw");
		MemberVO vo = new MemberVO(MEMBER_ID,MEMBER_PW);
		
		// 2. DAO �޼���
		MemberDAO dao = new MemberDAO();
		MemberVO mvo = dao.login(vo);
		
		// 3. ��� ���� �غ�
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		
		// 3. �α��� ����/���� �Ǵ�
		if(mvo==null) {
			// ����
			out.print(false);
			System.out.println("�α��� ����");
		}else {
			// ������� ���� ���� --> Session �̿�
			HttpSession session = request.getSession();
			session.setAttribute("vo", mvo);
			
			// ������� ���� ���� --> Cookie �̿�
			Cookie cookie = new Cookie("id", mvo.getMEMBER_ID());
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			
			// ����
			out.print(true);
			System.out.println("�α��� ����");
			
			
		}

		
	}

}
