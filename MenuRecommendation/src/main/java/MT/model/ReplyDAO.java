package MT.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ReplyDAO {
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
		
		// ����ۼ�
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
		
		
		// ��� ����Ʈ ���
		public List<ReplyVO> selectList(int num) {
			
			SqlSession session = sqlSessionFactory.openSession(true);
			
			List<ReplyVO> list = session.selectList("selectList",num);
			
			session.close();
			return list;
		}
		
		

		// myList �޼���
		public List<ReplyVO> myList(String MEMBER_ID) {
			SqlSession session = sqlSessionFactory.openSession(true);
			List<ReplyVO> list = session.selectList("myCList",MEMBER_ID);
			session.close();
			return list;
		}

		
		
}
