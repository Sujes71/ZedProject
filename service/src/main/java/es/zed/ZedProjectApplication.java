package es.zed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration.class,
    org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
})

@EnableAsync
public class ZedProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZedProjectApplication.class, args);
  }
}