package MT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuVO {
	private int menu_id;
	private String menu_nm;
	private int parent_id;
	private String discript;
	private String code_list;
	private String image_path;
}
