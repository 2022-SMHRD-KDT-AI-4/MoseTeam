package MT.model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ReviewDAO {
	
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
	// 결정 선택시 히스토리 정보 생성(Review 내용 평가는 null로 삽입)
	public int insertReview(HashMap<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int res = 0;
		try {
			res = session.insert("insertReview", map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return res;
	}
	// 새 리뷰 작성
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
	
	// 리뷰 삭제
	public void delete(int num) {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.delete("rDelete",num);
		session.close();
	}
	
	
	// 가게 리뷰 불러오기
	public List<ReviewVO> search(String REST_ID) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<ReviewVO> list = session.selectList("rSearch",REST_ID);
		session.close();
		return list;
	}
	
	
	// 내리뷰 불러오기
	public List<ReviewVO> myList(String MEMBER_ID) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<ReviewVO> list = session.selectList("myRList",MEMBER_ID);
		session.close();
		return list;
	}
	
	
	
	
	

}
