//package com.github.javarushcommunity.jrtb.service;
//
//import com.github.javarushcommunity.jrtb.bot.JavaRushTelegramBot;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DisplayName("Unit-lvl testing for SendBotMessageService")
//class SendBotMessageServiceTest {
//    private SendBotMessageService sendBotMessageService;
//    private JavaRushTelegramBot javarushBot;
//
//    @BeforeEach
//    public void init() {
//        javarushBot = Mockito.mock(JavaRushTelegramBot.class);
//        sendBotMessageService = new SendBotMessageServiceImpl(javarushBot);
//    }
//
//    @Test
//    public void shouldProperlySendMessage() throws TelegramApiException {
//        String chatId="test_chat_id";
//        String message="test_message";
//
//        SendMessage sendMessage=new SendMessage();
//        sendMessage.setText(message);
//        sendMessage.setChatId(chatId);
//        sendMessage.enableHtml(true);
//
//        sendBotMessageService.sendMessage(chatId,message);
//
//        Mockito.verify(javarushBot).execute(sendMessage);
//    }
//
//}