package MT.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.ReplyDAO;
import MT.model.ReplyVO;

@WebServlet("/CommentService")
public class CommentService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// ���ڵ�
		request.setCharacterEncoding("utf-8");

		// �Ķ���� ����
		int BOARD_NO = Integer.parseInt(request.getParameter("bodnum"));
		String REPLY_CONTENT = request.getParameter("comment");
		String MEMBER_ID = request.getParameter("id");
		String NICK = request.getParameter("nick");
		ReplyVO rvo = new ReplyVO(BOARD_NO, REPLY_CONTENT, MEMBER_ID, NICK);
		
		System.out.println(BOARD_NO);
		System.out.println(REPLY_CONTENT);
		System.out.println(MEMBER_ID);
		System.out.println(NICK);

		// DAO�޼��� ���
		ReplyDAO dao = new ReplyDAO();
		int cnt = dao.addComment(rvo);
		
		if(cnt>0) {
			System.out.println("��� �ۼ� ����");
			response.sendRedirect("ViewService?num="+BOARD_NO);
		}else {
			System.out.println("��� �ۼ� ����");
			response.sendRedirect("ViewService?num="+BOARD_NO);
		}
		
	}

}
