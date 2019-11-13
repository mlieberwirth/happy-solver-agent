package happysolveragent.rest.resources;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BinPackingSolution {

	private Long modelId;

	private String modelName;

	private List<BinPackingBin> bins = new ArrayList<>();

}
