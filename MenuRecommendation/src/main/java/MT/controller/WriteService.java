package MT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultTextUI;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/WriteService")
public class WriteService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �������
		// => C:\Users\smhrd\Desktop\web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MenuRecommendation\comuFileImg
		String savePath = request.getServletContext().getRealPath("comuFileImg");
		// �ִ�ũ��(5�ް�����Ʈ)
		int maxSize = 5 * 1024 * 1024;
		String encoding = "euc-kr";
		
		// MultipartRequest ����
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		
		// �Ķ���� ����
		String BOARD_TITLE = multi.getParameter("title");
		String BOARE_CONTENT = multi.getParameter("content");
		// ������ ���� �� �ϱ�
		
	}

}
