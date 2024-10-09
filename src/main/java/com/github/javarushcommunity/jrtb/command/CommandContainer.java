package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;

@RequiredArgsConstructor
@Component
public class CommandContainer {
    private final List<Command> commands;
    private final UnknownCommand unknownCommand;


    public Command retrieveCommand(String commandIdentifier){
        return commands.stream()
                .filter(command -> commandIdentifier.equalsIgnoreCase(command.getCommandIdentifier()))
                .findFirst()
                .orElse(unknownCommand);
    }
}
