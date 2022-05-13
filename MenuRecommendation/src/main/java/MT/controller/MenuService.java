package MT.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.MenuDAO;
import MT.model.MenuVO;
import MT.model.RestaurantDAO;
import MT.model.RestaurantVO;

@WebServlet("/MenuService")
public class MenuService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MenuDAO dao = new MenuDAO();
		RestaurantDAO restdao = new RestaurantDAO();

		// 1. 조건에 맞는 메뉴리스트 가져오기
		MenuVO menuvo = dao.getMenu();
		
		// 2. 메뉴를 가지고 있는 식당리스트 가져오기
		String menu_id = menuvo.getMenu_id();
		List<RestaurantVO> restList = (List) restdao.getMenuRestaurant(menu_id);

		request.setAttribute("menuvo", menuvo);
		request.setAttribute("restList", restList);

		RequestDispatcher rd = request.getRequestDispatcher("randomResult.jsp");
		rd.forward(request, response);
	}
}
