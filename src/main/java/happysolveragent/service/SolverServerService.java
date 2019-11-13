package happysolveragent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import happysolveragent.config.AgentConfiguration;
import happysolveragent.rest.SolverServerClient;
import happysolveragent.rest.resources.AgentRegister;
import happysolveragent.rest.resources.BinPackingSolution;

@Service
public class SolverServerService {

	@Autowired
	private SolverServerClient solverServerClient;

	@Autowired
	private AgentConfiguration configuration;

	public void sendSolution(BinPackingSolution solution) {
		solverServerClient.sendSolution(solution);
	}

	public void registerAgent() {
		AgentRegister agentRegister = new AgentRegister(configuration.getAgentName(),
				configuration.getAgentStartInstant());
		solverServerClient.register(agentRegister);
	}
}
