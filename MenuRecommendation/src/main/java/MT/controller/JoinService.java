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
		
		// 0. ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// 1. �Ķ���� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		// vo�� ����
		MemberVO vo = new MemberVO(id, pw, nickname);
		
		// 2. DAO�޼��� ���
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(vo);
		
		// 3. ȸ������ ����/���� �Ǵ�
		if(cnt>0) {
			// ���� -> main����
			response.sendRedirect("main.html");
		}else {
			// ���� -> join����
			response.sendRedirect("join.html");
		}
		
		
		
		
		
	}

}
