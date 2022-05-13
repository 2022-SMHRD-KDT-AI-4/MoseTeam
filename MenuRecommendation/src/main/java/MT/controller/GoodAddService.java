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
		
		// board_no �Ķ���� ��������
		int num = Integer.parseInt(request.getParameter("num"));
		int push = 0;
		
		// selectOne���� board_no, member_id ��������
		BoardDAO dao = new BoardDAO();
		BoardVO bvo = dao.selectOne(num);
		int BOARD_NO = bvo.getBOARD_NO();
		String MEMBER_ID = bvo.getMEMBER_ID();
		
		// ��õ���� �ִ��� Ȯ��
		PushVO pvo = new PushVO(BOARD_NO,MEMBER_ID);
		System.out.println(pvo.getBOARD_NO());
		System.out.println(pvo.getMEMBER_ID());
		
		int cnt = dao.goodCheck(pvo);
		
		// ��õ ����
		if(cnt==1) {
			dao.goodAdd(pvo);
			System.out.println("��õ����");
		}else {
			System.out.println("��õ����");
		}

		// ������ ���ư���
		BoardVO back = dao.selectOne(num);
		
		request.setAttribute("bvo", bvo);
		
		RequestDispatcher rd = request.getRequestDispatcher("comuView.jsp");
		rd.forward(request, response);
		
		
	}

}
