package happysolveragent.rest.resources;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BinPackingBin {

	private List<BinPackingItem> items = new ArrayList<>();
}
