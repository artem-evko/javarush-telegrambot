package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.repository.entity.TelegramUser;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import javax.ws.rs.NotFoundException;

import java.util.stream.Collectors;

import static com.github.javarushcommunity.jrtb.command.CommandUtils.getChatId;

@Component
@RequiredArgsConstructor
public class ListGroupSubCommand extends AbstractCommand{

    private final TelegramUserService telegramUserService;
    @Override
    public SendMessage buildResponse(Update update) {
        TelegramUser telegramUser = telegramUserService.findByChatId(getChatId(update))
                .orElseThrow(NotFoundException::new);

        String message = "Я нашел все подписки на группы: \n\n";
        String collectedGroups = telegramUser.getGroupSubs().stream()
                .map(it -> "Группа: " + it.getTitle() + " , ID = " + it.getId() + " \n")
                .collect(Collectors.joining());

        return new SendMessage(telegramUser.getChatId(), message + collectedGroups);
    }

    @Override
    public String getCommandIdentifier() {
        return "/listGroupSub";
    }
}
