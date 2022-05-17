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
		//flag : 데이터 수정, 삭제 분기를 구분하기 위한 구분값 
		// Update : 수정 , Delete : 삭제
		String flag =request.getParameter("action");
		System.out.println(flag);
		
		String review_no = request.getParameter("review_no");
		String review_level = "1";
		String review_content = request.getParameter("review_content");
		
		if(flag.equals("Delete")) {
			// 평가, 후기정보만 지움
			review_level = "0";
			review_content = "";
		}
		
		HistoryDAO dao = new HistoryDAO();
		
		// 1. review_no로 리뷰데이터 DB에서 불러오기
		ReviewVO vo = dao.getReview(review_no);
		
		// 2. 리뷰 정보에 가져온 매개변수의 값을 담기
		vo.setREVIEW_LEVEL(Integer.parseInt(review_level));
		vo.setREVIEW_CONTENT(review_content);
		
		// 3. 리뷰정보로 글 수정
		int res = 0; // 결과값
		res = dao.UpdateReview(vo);
		
		if(res > 0) {
			System.out.println("성공입니다.");
		}else {
			System.out.println("실패입니다.");
		}
		
		response.sendRedirect("HistoryService?month=1");
	}

}
