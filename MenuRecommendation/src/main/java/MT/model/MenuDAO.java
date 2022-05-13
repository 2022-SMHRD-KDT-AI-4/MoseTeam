package MT.model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MenuDAO {

	// Connection pool
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

	// 메뉴목록 조회
	public MenuVO getMenu() {
		SqlSession session = sqlSessionFactory.openSession(true);
		MenuVO vo = session.selectOne("selectMenu");
		session.close();
		return vo;
	}
	
	// Main에서 아이콘으로 선택한 메뉴 조회
	public MenuVO getIconMenu(String menu_id) {
		SqlSession session = sqlSessionFactory.openSession(true);
		MenuVO vo = session.selectOne("selectIconMenu", menu_id);
		session.close();
		return vo;
	}

}
