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
public class ReviewVO {

	private int REVIEW_NO;
	@NonNull
	private int REST_ID;
	@NonNull
	private int REVIEW_LEVEL;
	@NonNull
	private String REVIEW_CONTENT;
	@NonNull
	private String MEMBER_ID;
	private String REVIEW_DATE = null;
	
}
