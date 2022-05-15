package MT.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ReviewDAO {
	
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
	
	// �� ���� �ۼ�
	public int insert(ReviewVO vo) {

		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			cnt = session.insert("insert",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();
		return cnt;
	}
	
	// ���� ����
	public void delete(int num) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.delete("delete",num);
		session.close();
	}
	
	
	// ���� ���� �ҷ�����
	public List<ReviewVO> search(String REST_ID) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<ReviewVO> list = session.selectList("search",REST_ID);
		session.close();
		return list;
	}
	
	
	// ���� ���� �ҷ�����
	public List<ReviewVO> myList(String MEMBER_ID) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<ReviewVO> list = session.selectList("myList",MEMBER_ID);
		session.close();
		return list;
	}
	
	
	
	
	

}
