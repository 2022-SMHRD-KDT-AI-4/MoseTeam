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

import MT.model.BoardDAO;
import MT.model.BoardVO;
import MT.model.ReplyDAO;
import MT.model.ReplyVO;

@WebServlet("/ViewService")
public class ViewService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = new BoardDAO();
		ReplyDAO rdao = new ReplyDAO();
		BoardVO bvo = dao.selectOne(num);
		List<ReplyVO> list = rdao.selectList(num);
		int count = list.size();
		
		
		request.setAttribute("bvo", bvo);
		request.setAttribute("list", list);
		request.setAttribute("count", count);

		RequestDispatcher rd = request.getRequestDispatcher("comuView.jsp");
		rd.forward(request, response);
	}

}
