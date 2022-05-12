package MT.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import MT.model.BoardDAO;
import MT.model.BoardVO;

@WebServlet("/SearchService")
public class SearchService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ���ڵ�
		request.setCharacterEncoding("euc-kr");

		// �Ķ���� ����
		String search = request.getParameter("search");

		// DAO�޼��� ���
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.search("%"+search+"%");
		
		// ��ü ���ε�
		request.setAttribute("list", list);
		
		// forward������� ������ �̵�
		RequestDispatcher rd = request.getRequestDispatcher("searchList.jsp");
		rd.forward(request, response);
		
	}

}
