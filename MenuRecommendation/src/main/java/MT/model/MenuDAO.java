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
			// Connection pool����
			String resource = "MT/mapper/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �޴���� ��ȸ
	public MenuVO getMenu() {
		SqlSession session = sqlSessionFactory.openSession(true);
		
		MenuVO vo = session.selectOne("selectMenu");
		
		session.close();
		return vo;
	}
	

}
