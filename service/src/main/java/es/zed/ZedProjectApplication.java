package es.zed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ZedProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZedProjectApplication.class, args);
  }
}