package MT.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
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
	
	// 게시글 작성(이미지 있음)
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
	
	
	// 게시글 작성(이미지 없음)
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
		
	
	// 보드 모든 정보 가져오는 select Board method
	public List<BoardVO> selectBoard() {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("selectBoard");
		session.close();
		return list;
	}
	// 공지사항 가져오기
	public List<BoardVO> notice() {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("notice");
		session.close();
		return list;
	}
	
	// 게시글 삭제
	public void delete(int num) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.delete("delete",num);
		session.close();
	}
	
	// 게시글 수정
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
	
	// 보드 검색 search 메서드
	public List<BoardVO> search(String search) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("search",search);
		session.close();
		return list;
	}
	
	
	// 한개만 가져오는 메서드(selectOne)
	public BoardVO selectOne(int num) {
		SqlSession session = sqlSessionFactory.openSession(true);
		BoardVO bvo = session.selectOne("selectOne",num);
		session.close();
		return bvo;
	}
	
	// 추천확인
	public int goodCheck(PushVO dao) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt=0;
		if(session.selectOne("goodCheck",dao)==null) {
			cnt=1;
		}
		session.close();
		return cnt;
	}
	
	// 추천 올리기
	public void goodAdd(PushVO dao) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.update("goodAdd",dao);
		int cnt2 = session.insert("push", dao);
		session.close();
	}
	
	// 신고글 모든 정보 가져오는 select Board method
	public List<BoardVO> badList() {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("badList");
		session.close();
		return list;
	}
	
	// 신고하기
	public void badAdd(int num) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.update("badAdd",num);
		session.close();
	}
	
	// 인기글 순서 모든 정보
	public List<BoardVO> popList() {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("popList");
		session.close();
		return list;
	}
	

	// myList 메서드
	public List<BoardVO> myList(String MEMBER_ID) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<BoardVO> list = session.selectList("myBList",MEMBER_ID);
		session.close();
		return list;
	}
	
	
	
	
}
