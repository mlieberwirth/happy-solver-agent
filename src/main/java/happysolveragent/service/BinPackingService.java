package happysolveragent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import happysolveragent.rest.SolverServerClient;
import happysolveragent.rest.resources.BinPackingModel;
import happysolveragent.rest.resources.BinPackingSolution;

@Service
public class BinPackingService {

	@Autowired
	private BinPackingSolverService solverService;

	@Autowired
	private SolverServerClient serverClient;

	public void runSolver(BinPackingModel model) {
		BinPackingSolution solution = solverService.runSolver(model);
		serverClient.sendSolution(solution);
	}
}