package MT.model;

import java.io.InputStream;

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
}
