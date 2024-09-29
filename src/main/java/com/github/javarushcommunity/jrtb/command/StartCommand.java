package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.repository.entity.TelegramUser;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class StartCommand extends AbstractCommand{
    private final TelegramUserService telegramUserService;


    public final static String START_MESSAGE="Привет. Я Javarush Telegram Bot. Я помогу тебе быть в курсе последних " +
            "статей тех авторов, котрые тебе интересны. Я еще маленький и только учусь.";

    @Override
    public SendMessage buildResponse(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user ->{
                    user.setActive(true);
                    telegramUserService.save(user);
                }, () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                }
        );
        return new SendMessage(chatId,START_MESSAGE);
    }

    @Override
    public String getCommandIdentifier() {
        return "/start";
    }
}
