package com.pzone.kiran.client.service;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pzone.kiran.client.model.Trigger;
import com.pzone.kiran.client.ws.config.ETSWsClient;
import com.pzone.kiran.client.ws.config.ETSWsClient.MessageHandler;

/**
 * @author Kiran Team
 *
 */
@Service
public class ETSWsClientService {

  private static final Logger LOG  = LogManager.getLogger(ETSWsClientService.class);

  @Value("${server.ws.url}")
  private String              serverUrl;

  @Value("${server.ws.token}")
  private String              accessToken;

  private ETSWsClient          socketClient;

  private Gson                gson = new GsonBuilder().setPrettyPrinting().setLenient().create();

  /**
   * Connects to kiran websocket server to listen for messages.
   * 
   */
  public void connectToServer() {
    try {

      final String wsUrl = serverUrl + accessToken;
      socketClient = new ETSWsClient(new URI(wsUrl));
      socketClient.connectToServer();

      socketClient.addMessageHandler(new MessageHandler() {

        @Override
        public void handleMessage(String message) {
          final Trigger clientProbs= gson.fromJson(message, Trigger.class);
          LOG.info("Trigger  {}", gson.toJson(clientProbs));
        }
      });

    } catch (Exception e) {
      LOG.error("Error connection server.", e);
      throw new RuntimeException(e.getLocalizedMessage());
    }
  }
}
