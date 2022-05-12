package MT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.ReviewDAO;
import MT.model.ReviewVO;

@WebServlet("/ReviewService")
public class ReviewService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int REST_ID = Integer.parseInt(request.getParameter("restId"));
		int REVIEW_LEVEL = Integer.parseInt(request.getParameter("rate"));
		String REVIEW_CONTENT= request.getParameter("text");
		String MEMBER_ID = request.getParameter("memberId");
		ReviewVO vo = new ReviewVO(REST_ID, REVIEW_LEVEL, REVIEW_CONTENT, MEMBER_ID);
		
		ReviewDAO dao = new ReviewDAO();
		int cnt = dao.insert(vo);
		
		if(cnt>0) {
			//성공
			System.out.println("리뷰작성 성공");
		}else {
			System.out.println("리뷰작성 실패");
		}
		
	}

}
