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
public class BoardVO {
	@NonNull
	private int BOARD_NO;
	@NonNull
	private String BOARD_TITLE;
	@NonNull
	private String BOARD_CONTENT;
	private String FILE_NAME;
	private String MEMBER_ID;
	private String WRITE_DATE = null;
	private String WRITER;
	private int GOOD;
	
}
