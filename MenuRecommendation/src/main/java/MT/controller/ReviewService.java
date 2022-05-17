package MT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.RestaurantDAO;
import MT.model.ReviewDAO;
import MT.model.ReviewVO;

@WebServlet("/ReviewService")
public class ReviewService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReviewDAO dao = new ReviewDAO();
		RestaurantDAO restdao = new RestaurantDAO();
		
		
		request.setCharacterEncoding("utf-8");
		
		System.out.println(request.getParameter("resrId"));
		System.out.println(request.getParameter("rate"));
		System.out.println(request.getParameter("text"));
		System.out.println(request.getParameter("memberId"));
		
		int REST_ID = Integer.parseInt(request.getParameter("resrId"));
		int REVIEW_LEVEL = Integer.parseInt(request.getParameter("rate"));
		String REVIEW_CONTENT= request.getParameter("text");
		String MEMBER_ID = request.getParameter("memberId");
		
		ReviewVO vo = new ReviewVO(REST_ID, REVIEW_LEVEL, REVIEW_CONTENT, MEMBER_ID);
		
		int cnt = dao.insert(vo);
		
		if(cnt>0) {
			//성공
			System.out.println("리뷰작성 성공");
		}else {
			System.out.println("리뷰작성 실패");
			if(REVIEW_LEVEL==2) {
				// 좋아요
				restdao.getAddCount(REST_ID);				
			}else if(REVIEW_LEVEL==1) {
				// 싫어요
				restdao.getMinusCount(REST_ID);
			}
		}
		
		
	}

}
