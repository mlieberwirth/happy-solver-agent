package happysolveragent.rest.resources;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BinPackingModel {

	private Long id;

	private String name;

	private Integer capacity;

	private List<BinPackingItem> items = new ArrayList<>();
}
