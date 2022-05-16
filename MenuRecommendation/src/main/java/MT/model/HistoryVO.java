package MT.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryVO {
	private int review_no;
	private String rest_id;
	private String rest_nm;
	private String sub_cate;
	private Date enter_date;
	private String review_level;
	private String review_content;
	private String member_id;
	private Date review_date;
}
