package MT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data // 기본 메서드 생성
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자
@NoArgsConstructor // 아무것도 들어있지 않은 생성자
@RequiredArgsConstructor
public class MemberVO {

	@NonNull
	private String id;
	@NonNull
	private String pw;
	private String nickname;

}
