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
		
		// 페이지 호출위치 구분
		// Main : menu_id를 파라미터로 가지고 들어옴
		// Category : codeList를 파라미터로 가지고 들어옴
		request.setCharacterEncoding("EUC-KR");
		String menu_id = request.getParameter("menu_id");
		
		// 메뉴 가져오기
		MenuVO menuvo = new MenuVO();
		if(menu_id == null) {
			menuvo = dao.getMenu();
		}else {
			menuvo = dao.getIconMenu(menu_id);
		}
		
		// 2. 결정된 메뉴를 판매하고 있는 식당 리스트와 판매 메뉴리스트(2개) 가져오기
		menu_id = menuvo.getMenu_id();
		List<RestaurantVO> restList = (List) restdao.getMenuRestaurant(menu_id);

		request.setAttribute("menuvo", menuvo);
		request.setAttribute("restList", restList);

		RequestDispatcher rd = request.getRequestDispatcher("randomResult.jsp");
		rd.forward(request, response);
	}
}
