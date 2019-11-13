package happysolveragent.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import happysolveragent.rest.resources.BinPackingModel;
import happysolveragent.service.BinPackingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/binpacking")
public class BinPackingController {

	@Autowired
	@Qualifier("rest-thread-pool") // own pool for graceful shutdown
	private ThreadPoolTaskScheduler threadPool;

	@Autowired
	private BinPackingService binPackingService;

	@PostMapping("/runSolver")
	public ResponseEntity<String> runSolver(@RequestBody BinPackingModel model) {

		String msg = "Run solver on model: " + model.getName();
		log.info(msg);
		CompletableFuture.runAsync(() -> binPackingService.runSolver(model), threadPool);
		return ResponseEntity.ok(msg);
	}
}
