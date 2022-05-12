package MT.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MT.model.MenuDAO;
import MT.model.MenuVO;

@WebServlet("/MenuService")
public class MenuService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MenuVO menuvo = new MenuVO();
		MenuDAO dao = new MenuDAO();
		
		// 1. 조건에 맞는 메뉴리스트 가져오기
		menuvo = dao.getMenu();
		System.out.println(menuvo.getMenu_id());
		System.out.println(menuvo.getMenu_nm());
		
		request.setAttribute("menuvo", menuvo);
		
		RequestDispatcher rd = request.getRequestDispatcher("randomResult.jsp");
		rd.forward(request, response);
	}
}
