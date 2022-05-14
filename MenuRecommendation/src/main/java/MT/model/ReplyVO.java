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
	private int REPLY_NO;
	@NonNull
	private int BOARD_NO;
	@NonNull
	private String REPLY_CONTENT;
	@NonNull
	private String MEMBER_ID;
	private String WRITE_DATE = null;
	@NonNull
	private String NICK;
}
