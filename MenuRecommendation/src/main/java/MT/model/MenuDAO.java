package MT.model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MenuDAO {
	
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

}
