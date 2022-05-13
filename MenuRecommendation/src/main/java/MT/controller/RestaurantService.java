package MT.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.RestaurantDAO;
import MT.model.RestaurantVO;

@WebServlet("/RestaurantService")
public class RestaurantService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 식당상세정보
		RestaurantDAO dao = new RestaurantDAO();

		request.setCharacterEncoding("EUC-KR");
		String rest_id = request.getParameter("rest_id");
		
		RestaurantVO vo = dao.getRestaurant(rest_id);
		
		request.setAttribute("restaurantVO", vo);

		RequestDispatcher rd = request.getRequestDispatcher("restaurantDetail.jsp");
		rd.forward(request, response);
	}

}
