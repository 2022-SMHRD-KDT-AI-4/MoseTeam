package MT.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ReplyDAO {
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
		
		// 댓글작성
		public int addComment(ReplyVO rvo) {
			
			SqlSession session = sqlSessionFactory.openSession(true);
			
			int cnt = 0;
			
			try {
				cnt = session.insert("addComment", rvo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			session.close();
			return cnt;
		}
		
		
		// 댓글 리스트 출력
		public List<ReplyVO> selectList(int num) {
			
			SqlSession session = sqlSessionFactory.openSession(true);
			
			List<ReplyVO> list = session.selectList("selectList",num);
			
			session.close();
			return list;
		}
		
		

		// myList 메서드
		public List<ReplyVO> myList(String MEMBER_ID) {
			SqlSession session = sqlSessionFactory.openSession(true);
			List<ReplyVO> list = session.selectList("myCList",MEMBER_ID);
			session.close();
			return list;
		}

		
		
}
