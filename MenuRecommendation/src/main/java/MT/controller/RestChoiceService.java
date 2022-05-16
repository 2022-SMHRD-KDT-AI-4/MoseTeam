package MT.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.ReviewDAO;

@WebServlet("/RestChoiceService")
public class RestChoiceService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rest_id", request.getParameter("rest_id"));
		map.put("member_id", "test");
		//map.put("member_id", (String) request.getSession().getAttribute("id"));
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		ReviewDAO dao = new ReviewDAO();
		if (dao.insertReview(map) > 0) {
			out.print("¼º°ø");
		}
	}
}
