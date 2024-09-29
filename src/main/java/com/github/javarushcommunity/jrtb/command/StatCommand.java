package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class StatCommand extends AbstractCommand{

    private final TelegramUserService telegramUserService;

    public final static String STAT_MESSAGE = "Javarush Telegram Bot использует %s человек.";

    @Override
    public SendMessage buildResponse(Update update) {
        int activeUserCount =telegramUserService.retrieveAllActiveUsers().size();
        return new SendMessage(update.getMessage().getChatId().toString(),String.format(STAT_MESSAGE, activeUserCount));
    }

    @Override
    public String getCommandIdentifier() {
        return "/stat";
    }
}
