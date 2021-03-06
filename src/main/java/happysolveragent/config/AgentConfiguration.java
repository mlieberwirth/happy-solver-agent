package happysolveragent.config;

import java.time.Instant;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Configuration("agent")
public class AgentConfiguration {

	private final Instant agentStartInstant = Instant.now();

	@Value("${agent.name}")
	private String agentName;

	@Value("${agent.number-of-threads}")
	private Integer numberOfThreads;

	@Bean(name = "rest-thread-pool")
	public ThreadPoolTaskScheduler createRESTThreadPool() {
		return createThreadPool("REST-Pool");
	}

	private ThreadPoolTaskScheduler createThreadPool(String name) {
		ThreadPoolTaskScheduler threadPool = new ThreadPoolTaskScheduler();
		threadPool.setThreadNamePrefix(name);
		threadPool.setErrorHandler(exception -> log.error("Exception in thread.", exception));
		threadPool.setPoolSize(numberOfThreads);
		threadPool.setWaitForTasksToCompleteOnShutdown(true);
		threadPool.setAwaitTerminationSeconds(30);
		return threadPool;
	}

	@Bean
	public LocaleResolver localeResolver() {
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		TimeZone.setDefault(timeZone);

		Locale locale = Locale.US;
		Locale.setDefault(locale);

		FixedLocaleResolver localeResolver = new FixedLocaleResolver();
		localeResolver.setDefaultLocale(locale);
		localeResolver.setDefaultTimeZone(timeZone);
		return localeResolver;
	}
}
