package MT.model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {


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

	// join �޼���
	public int join(MemberVO vo) {

		// 1. SQL Session ��������
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// 2. Mapper.xml�� ����� SQL���� ����
		int cnt = 0; // ����ũ(pk) �ߺ� ����(?)
		try {
			cnt = session.insert("join", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3. ���� ��ȯ
		session.close();
		
		// 4. ��� ����
		return cnt;
	}
	

	// login �޼���
	public MemberVO login(MemberVO vo) {
		
		SqlSession session = sqlSessionFactory.openSession(true);
		
		MemberVO mvo = session.selectOne("login", vo);
		
		session.close();
		return mvo;
		
	}
	
	
	
}
