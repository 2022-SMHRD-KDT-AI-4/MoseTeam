package MT.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantVO {
	private int rest_id;
	private String rest_nm;
	private String main_cate;
	private String sub_cate;
	private String rest_addr;
	private ArrayList<RestmenuVO> restMenu;  
}
