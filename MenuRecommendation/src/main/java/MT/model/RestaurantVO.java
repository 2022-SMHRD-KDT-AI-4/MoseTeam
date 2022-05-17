package MT.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class RestaurantVO {
	@NonNull
	private int rest_id;
	@NonNull
	private String rest_nm;
	@NonNull
	private String main_cate;
	@NonNull
	private String sub_cate;
	@NonNull
	private String rest_addr;
	@NonNull
	private String menu_id;
	@NonNull
	private List<RestmenuVO> restMenu;  
	private int restcount;
}
