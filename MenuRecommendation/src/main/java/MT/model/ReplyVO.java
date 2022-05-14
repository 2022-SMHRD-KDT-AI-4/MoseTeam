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
public class ReplyVO {
	@NonNull
	private int REPLY_NO;
	@NonNull
	private int BOARD_NO;
	private String CONTENT;
	@NonNull
	private String MEMBER_ID;
	private String DATE = null;
}
