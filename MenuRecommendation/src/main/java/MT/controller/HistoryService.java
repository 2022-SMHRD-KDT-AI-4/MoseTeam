package MT.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.HistoryDAO;
import MT.model.HistoryVO;

@WebServlet("/HistoryService")
public class HistoryService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("month", "-"+request.getParameter("month")); // 이전이므로 앞에 '-'를 붙여서 값을 넘겨줌

		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("id")) {
				map.put("member_id", cookie.getValue());
			}
		}
		
		HistoryDAO dao = new HistoryDAO();
		List<HistoryVO> hisList = dao.getHistory(map);
		
		request.setAttribute("hisList", hisList);
		
		RequestDispatcher rd = request.getRequestDispatcher("RestaurantHistory.jsp");
		rd.forward(request, response);
	}		
}
