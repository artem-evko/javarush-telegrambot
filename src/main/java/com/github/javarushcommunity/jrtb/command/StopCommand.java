package com.github.javarushcommunity.jrtb.command;


import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class StopCommand extends AbstractCommand{

    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE="Деактивировал все ваши подписки \uD83D\uDE1F.";

    @Override
    public SendMessage buildResponse(Update update) {

        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
        return new SendMessage(update.getMessage().getChatId().toString(),STOP_MESSAGE);
    }

    @Override
    public String getCommandIdentifier() {
        return "/stop";
    }
}
