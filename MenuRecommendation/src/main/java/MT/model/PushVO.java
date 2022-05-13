package MT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushVO {
	
	private int BOARD_NO;
	private String MEMBER_ID;
	private int GOOD;

}
