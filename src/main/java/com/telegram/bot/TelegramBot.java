package com.telegram.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.telegram.bot.buttons.ButtonBot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TelegramBot extends TelegramLongPollingBot{
	  private static final Logger logger = LoggerFactory.getLogger(TelegramBot.class);
	  
	  
	  
	@Override
	public void onUpdateReceived(Update update) {
		logger.debug("####+- Start Logging onUpdateReceived(Update u) -+####");
		 if (update.hasMessage() && update.getMessage().hasText()) {
		        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
		        message.setChatId(update.getMessage().getChatId().toString());
		        message.setText(update.getMessage().getText());
		        
		        
		        
		       
//		        logger.debug("####+- Username : {}", update.getChatMember().getFrom().getUserName()+" -+####");
//		        logger.debug("####+- Date : {}", update.getChatMember().getDate()+" -+####");
//		        logger.debug("####+- Message : {}", update.getMessage().getText()+" -+####");
		        logger.debug("####+- Close Logging onUpdateReceived(Update u) -+####");
		        onClosing();
		        try {
		            execute(message); // Call method to send the message
		        } catch (TelegramApiException e) {
		            e.printStackTrace();
		        }
		    }
	}

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "youUserName";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "yourApi";
	}

	
	@Override
	public void onClosing() {
		
	}
	
	
	
	
}
