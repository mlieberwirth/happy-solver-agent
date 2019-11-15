package happysolveragent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import happysolveragent.config.AgentConfiguration;
import happysolveragent.rest.SolverServerClient;
import happysolveragent.rest.resources.AgentRegister;
import happysolveragent.rest.resources.BinPackingSolution;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SolverServerService {

	@Autowired
	private SolverServerClient solverServerClient;

	@Autowired
	private AgentConfiguration configuration;

	public void sendSolution(BinPackingSolution solution) {
		solverServerClient.sendSolution(solution);
	}

	public boolean registerAgent() {
		AgentRegister agentRegister = new AgentRegister(configuration.getAgentName(),
				configuration.getAgentStartInstant());
		try {
			solverServerClient.register(agentRegister);
			return true;
		} catch (Exception e) {
			log.debug("Error to register agent.", e);
			return false;
		}
	}
}
