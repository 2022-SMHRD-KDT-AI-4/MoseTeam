package MT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ComuVO {

	@NonNull
	private String BOARD_NO;
	@NonNull
	private String BOARD_TITLE;
	private String BOARD_CONTENT;
	private String NICK_NM;
	private String MEMBER_ID;
	private String WRITE_DATE;
	private String FILE_NAME;

}
