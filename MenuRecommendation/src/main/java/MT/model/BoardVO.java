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
	int BOARD_NO;
	@NonNull
	String BOARE_TITLE;
	@NonNull
	String BOARD_CONTENT;
	String MEMBER_ID;
	String WRITE_DATE = null;
}
