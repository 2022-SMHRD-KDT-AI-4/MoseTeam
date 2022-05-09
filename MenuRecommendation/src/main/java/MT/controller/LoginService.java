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
		// 1. �Ķ���� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberVO vo = new MemberVO(id, pw);
		
		// 2. DAO �޼���
		MemberDAO dao = new MemberDAO();
		MemberVO mvo = dao.login(vo);
		
		// 3. �α��� ����/���� �Ǵ�
		if(mvo==null) {
			// ����
			System.out.println("�α��� ����");
		}else {
			// ����
			response.sendRedirect("join.html");
			System.out.println("�α��� ����");
			// ������� ���� ���� --> Session �̿�
			HttpSession session = request.getSession();
			session.setAttribute("vo", mvo);
		}
	}

}
