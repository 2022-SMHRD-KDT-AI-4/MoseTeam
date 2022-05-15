package MT.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	// Connection pool�����
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			// Connection pool����
			String resource = "MT/mapper/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ==============================================================
	
	// �Խñ� �ۼ�(�̹��� ����)
	public int imgWrite(BoardVO bvo) {
		
		SqlSession session = sqlSessionFactory.openSession(true);
		
		int cnt = 0; 
		
		try {
			cnt = session.insert("imgWrite", bvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return cnt;
	}
	
	
	// �Խñ� �ۼ�(�̹��� ����)
	public int write(BoardVO bvo) {
		
		SqlSession session = sqlSessionFactory.openSession(true);
		
		int cnt = 0; 
		
		try {
			cnt = session.insert("write", bvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return cnt;
	}
		
	
	// ���� ��� ���� �������� select Board method
	public List<BoardVO> selectBoard() {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("selectBoard");
		session.close();
		return list;
	}
	// �������� ��������
	public List<BoardVO> notice() {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("notice");
		session.close();
		return list;
	}
	
	// �Խñ� ����
	public void delete(int num) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.delete("delete",num);
		session.close();
	}
	
	// �Խñ� ����
	public int update(BoardVO vo) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			cnt= session.update("update", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return cnt;
	}
	
	// ���� �˻� search �޼���
	public List<BoardVO> search(String search) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("search",search);
		session.close();
		return list;
	}
	
	
	// �Ѱ��� �������� �޼���(selectOne)
	public BoardVO selectOne(int num) {
		SqlSession session = sqlSessionFactory.openSession(true);
		BoardVO bvo = session.selectOne("selectOne",num);
		session.close();
		return bvo;
	}
	
	// ��õȮ��
	public int goodCheck(PushVO dao) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt=0;
		if(session.selectOne("goodCheck",dao)==null) {
			cnt=1;
		}
		session.close();
		return cnt;
	}
	
	// ��õ �ø���
	public void goodAdd(PushVO dao) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.update("goodAdd",dao);
		int cnt2 = session.insert("push", dao);
		session.close();
	}
	
	// �Ű�� ��� ���� �������� select Board method
	public List<BoardVO> badList() {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("badList");
		session.close();
		return list;
	}
	
	// �Ű��ϱ�
	public void badAdd(int num) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.update("badAdd",num);
		session.close();
	}
	
	// �α�� ���� ��� ����
	public List<BoardVO> popList() {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("popList");
		session.close();
		return list;
	}
	

	// myList �޼���
	public List<BoardVO> myList(String MEMBER_ID) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("myBList",MEMBER_ID);
		session.close();
		return list;
	}
	
	
	
	
}
