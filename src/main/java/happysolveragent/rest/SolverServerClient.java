package happysolveragent.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import happysolveragent.rest.resources.AgentRegister;
import happysolveragent.rest.resources.BinPackingSolution;

@FeignClient("solver-server")
public interface SolverServerClient {

	@PostMapping("/solution")
	void sendSolution(BinPackingSolution solution);

	@PostMapping("/register")
	void register(@RequestBody AgentRegister register);
}
