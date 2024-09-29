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


    public static final String HELP_MESSAGE=String.format("✨<b>Доcтупные команды</b>✨\n\n"

            + "<b>Начать\\закончить работу с ботом</b>\n"
            + "%s - начать работу со мной\n"
            + "%s - приостановить работу со мной\n\n"
            + "%s - получить помощь в работе со мной\n\n"
            + "%s - узнать статистику\n",
            START.getCommandName(),STOP.getCommandName(),HELP.getCommandName(),STAT.getCommandName());

    @Override
    public SendMessage buildResponse(Update update) {
        return new SendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);

    }

    @Override
    public String getCommandIdentifier() {
        return commandIdentifier;
    }
}
