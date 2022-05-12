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

import MT.model.BoardDAO;
import MT.model.BoardVO;

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
		MultipartRequest multi = new MultipartRequest(request,
													savePath,
													maxSize,
													encoding,
													new DefaultFileRenamePolicy());
		
		// �Ķ���� ����
		String BOARD_TITLE = multi.getParameter("title");
		String WRITER = multi.getParameter("writer");
		String MEMBER_ID = multi.getParameter("id");
		String BOARD_CONTENT = multi.getParameter("content");
		
		String FILE_NAME = multi.getFilesystemName("file");
		System.out.println(FILE_NAME);
		
		BoardVO bvo = new BoardVO();
		bvo.setBOARD_TITLE(BOARD_TITLE);
		bvo.setWRITER(WRITER);
		bvo.setMEMBER_ID(MEMBER_ID);;
		bvo.setBOARD_CONTENT(BOARD_CONTENT);
		bvo.setFILE_NAME(FILE_NAME);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.write(bvo);

		if(cnt>0) {
			System.out.println("�Խñ� �ۼ� ����");
			response.sendRedirect("ListService");
		}else {
			System.out.println("�Խñ� �ۼ� ����");
			response.sendRedirect("comuWrite.jsp");
		}
		
	}

}
