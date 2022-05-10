package MT.model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {


	// Connection pool만들기
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			// Connection pool설정
			String resource = "MT/mapper/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ==============================================================

	// join 메서드
	public int join(MemberVO vo) {

		// 1. SQL Session 빌려오기
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// 2. Mapper.xml에 적어둔 SQL문장 실행
		int cnt = 0; // 유니크(pk) 중복 방지(?)
		try {
			cnt = session.insert("join", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3. 세션 반환
		session.close();
		
		// 4. 결과 리턴
		return cnt;
	}
	

	// login 메서드
	public MemberVO login(MemberVO vo) {
		
		SqlSession session = sqlSessionFactory.openSession(true);
		
		MemberVO mvo = session.selectOne("login", vo);
		
		session.close();
		return mvo;
		
	}
	
	
	
}
