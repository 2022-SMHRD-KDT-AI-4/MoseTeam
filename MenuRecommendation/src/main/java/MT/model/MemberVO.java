package MT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data // �⺻ �޼��� ����
@AllArgsConstructor // ��� �ʵ带 �Ű������� �޴� ������
@NoArgsConstructor // �ƹ��͵� ������� ���� ������
@RequiredArgsConstructor
public class MemberVO {

	@NonNull
	private String MEMBER_ID;
	@NonNull
	private String MEMBER_PW;
	private String NICK_NM;

}
