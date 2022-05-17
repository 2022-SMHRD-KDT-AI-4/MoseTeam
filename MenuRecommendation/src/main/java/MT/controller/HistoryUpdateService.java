package MT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.HistoryDAO;
import MT.model.ReviewVO;

@WebServlet("/HistoryUpdateService")
public class HistoryUpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		//flag : ������ ����, ���� �б⸦ �����ϱ� ���� ���а� 
		// Update : ���� , Delete : ����
		String flag =request.getParameter("action");
		System.out.println(flag);
		
		String review_no = request.getParameter("review_no");
		String review_level = "1";
		String review_content = request.getParameter("review_content");
		
		if(flag.equals("Delete")) {
			// ��, �ı������� ����
			review_level = "0";
			review_content = "";
		}
		
		HistoryDAO dao = new HistoryDAO();
		
		// 1. review_no�� ���䵥���� DB���� �ҷ�����
		ReviewVO vo = dao.getReview(review_no);
		
		// 2. ���� ������ ������ �Ű������� ���� ���
		vo.setREVIEW_LEVEL(Integer.parseInt(review_level));
		vo.setREVIEW_CONTENT(review_content);
		
		// 3. ���������� �� ����
		int res = 0; // �����
		res = dao.UpdateReview(vo);
		
		if(res > 0) {
			System.out.println("�����Դϴ�.");
		}else {
			System.out.println("�����Դϴ�.");
		}
		
		response.sendRedirect("HistoryService?month=1");
	}

}
