package com.telegram.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.telegram.bot.TelegramBot;

@EnableAutoConfiguration
@SpringBootApplication
public class MainApplication {
	  private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);
	  

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		
		 try {
			 logger.debug("-+-+-+- Application Started -+-+-+-");
			
	            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
	           
				botsApi.registerBot(new TelegramBot());
	        } catch (TelegramApiException e) {
	            e.printStackTrace();
	        }
	}

}
