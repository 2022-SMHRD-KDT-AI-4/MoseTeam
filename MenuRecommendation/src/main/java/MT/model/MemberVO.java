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
	private String id;
	@NonNull
	private String pw;
	private String nickname;

}
