package MT.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class RestaurantDAO {
	
	// Connection pool
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			// Connection pool¼³Á¤
			String resource = "MT/mapper/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<RestaurantVO> getMenuRestaurant(String menu_id) {
		SqlSession session = sqlSessionFactory.openSession(true);
		List<RestaurantVO> restList = session.selectList("selectMenuRest", menu_id);
		session.close();
		return restList;
	}
	
	public RestaurantVO getRestaurant(String rest_id) {
		SqlSession session = sqlSessionFactory.openSession(true);
		RestaurantVO vo = session.selectOne("selectRestaurant", rest_id);
		session.close();
		return vo;
	}
	
	public void getAddCount(int rest_id) {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.update("addCount",rest_id);
		session.close();
	}
	
	public void getMinusCount(int rest_id) {
		SqlSession session = sqlSessionFactory.openSession(true);
		session.update("minusCount",rest_id);
		session.close();
	}
}
