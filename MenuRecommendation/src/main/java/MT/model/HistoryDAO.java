package MT.model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HistoryDAO{
	
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
	
	public List<HistoryVO> getHistory(HashMap<String, String> map) {
		SqlSession session = sqlSessionFactory.openSession(true);
		
		List<HistoryVO> hisList = session.selectList("selectHistory", map);
		session.close();
		return hisList;
	}
}
