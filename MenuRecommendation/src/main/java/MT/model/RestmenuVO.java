package MT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestmenuVO {
	private int rmenu_id;
	private String rmenu_nm;
	private int rest_id;
	private int menu_id;
	private int price;
}
