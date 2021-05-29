package com.pzone.kiran.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.pzone.kiran.client.service.ETSWsClientService;

/**
 * @author Ashva Probs Team
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class kiranClientApp {

  public static void main(String[] args) {
    final ConfigurableApplicationContext context = SpringApplication.run(kiranClientApp.class, args);
    final ETSWsClientService apWsClientService = context.getBean(ETSWsClientService.class);
    apWsClientService.connectToServer();
  }
}
