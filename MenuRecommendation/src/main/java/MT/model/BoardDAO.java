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
	
	// ���� ���
	public int upload(BoardVO bvo) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int cnt = 0; 
		try {
			cnt = session.insert("upload", bvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	// ���� ��� ���� �������� select Board method
	public List<ComuVO> selectBoard() {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<ComuVO> list = session.selectList("selectBoard");
		session.close();
		return list;
		
	}
	
	// �Խñ� ����
	public void delete(BoardVO vo) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.delete("delete",vo);
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
	
	public List<ComuVO> search(String search) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<ComuVO> list = session.selectList("search",search);
		session.close();
		return list;
	}
	
	
	
	
}
