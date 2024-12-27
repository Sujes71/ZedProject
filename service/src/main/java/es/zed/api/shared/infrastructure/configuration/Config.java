package es.zed.api.shared.infrastructure.configuration;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

  @Bean
  public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }

  @Bean(name = "taskExecutor")
  public Executor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(5); // Número mínimo de hilos.
    executor.setMaxPoolSize(10); // Número máximo de hilos.
    executor.setQueueCapacity(25); // Capacidad de la cola.
    executor.setThreadNamePrefix("AsyncThread-");
    executor.initialize();
    return executor;
  }
}

