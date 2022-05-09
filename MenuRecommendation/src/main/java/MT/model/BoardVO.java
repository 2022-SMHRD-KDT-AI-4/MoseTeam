package MT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data 
@AllArgsConstructor 
public class BoardVO {
	int board_no;
	String board_title;
	String board_content;
	String member_id;
	String write_date = null;
}
