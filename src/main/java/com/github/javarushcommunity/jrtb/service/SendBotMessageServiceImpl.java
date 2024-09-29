package com.github.javarushcommunity.jrtb.service;

import com.github.javarushcommunity.jrtb.bot.JavaRushTelegramBot;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@RequiredArgsConstructor
public class SendBotMessageServiceImpl implements SendBotMessageService{

    private final JavaRushTelegramBot javarushBot;

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
//        try {
//            javarushBot.execute(sendMessage);
//        } catch (TelegramApiException e){
//            e.printStackTrace();
//        }
    }
}
