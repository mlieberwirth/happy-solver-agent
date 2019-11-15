package happysolveragent.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import happysolveragent.service.AgentRegisterService;

@Component
public class AgentRegisterScheduler {

	@Autowired
	private AgentRegisterService registerService;

	@Scheduled(fixedDelayString = "${scheduler.register-agent-interval-millis}")
	public void run() {
		registerService.registerAgent();
	}
}
