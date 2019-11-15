package happysolveragent;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class AgentLauncher {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AgentLauncher.class).run(args);
	}
}
