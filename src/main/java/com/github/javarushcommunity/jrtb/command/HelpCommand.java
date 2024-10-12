package com.github.javarushcommunity.jrtb.command;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import static com.github.javarushcommunity.jrtb.command.CommandName.*;

@Component
@RequiredArgsConstructor
public class HelpCommand extends AbstractCommand{
    private final static String commandIdentifier = "/help";


    public static final String HELP_MESSAGE = String.format("✨Дотупные команды✨\n\n"

                    + "Начать\\закончить работу с ботом:\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"

                    + "Работа с подписками на группы:\n"
                    + "%s - подписаться на группу статей\n"
                    + "%s - отписаться от группы статей\n"
                    + "%s - получить список групп, на которые подписан\n\n"

                    + "%s - получить помощь в работе со мной\n"
                    + "%s - получить мою статистику использования\n",
            START.getCommandName(), STOP.getCommandName(), ADD_GROUP_SUB.getCommandName(),
            DELETE_GROUP_SUB.getCommandName(), LIST_GROUP_SUB.getCommandName(), HELP.getCommandName(),
            STAT.getCommandName());

    @Override
    public SendMessage buildResponse(Update update) {
        return new SendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);

    }

    @Override
    public String getCommandIdentifier() {
        return commandIdentifier;
    }
}
