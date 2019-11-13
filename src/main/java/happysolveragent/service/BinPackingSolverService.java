package happysolveragent.service;

import org.springframework.stereotype.Service;

import happysolveragent.rest.resources.BinPackingModel;
import happysolveragent.rest.resources.BinPackingSolution;

@Service
public class BinPackingSolverService {

	public BinPackingSolution runSolver(BinPackingModel model) {
		// TODO call happy-solver-solver.jar
		return new BinPackingSolution();
	}
}
