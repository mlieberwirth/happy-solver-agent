package happysolveragent.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AgentRegisterService {

	private Instant successfulRegisterInstant;

	private boolean isRegistered;

	@Autowired
	private SolverServerService serverService;

	public boolean isAgentRegistered() {
		return isRegistered;
	}

	public Instant getLastRegistation() {
		return successfulRegisterInstant;
	}

	public void registerAgent() {

		boolean isAgentRegistered = serverService.registerAgent();

		if (isAgentRegistered) {
			log.debug("Successful registration of agent.");
			successfulRegisterInstant = Instant.now();
			isRegistered = true;
		} else {
			log.debug("No server for registration of agent.");
			isRegistered = false;
		}
	}
}
