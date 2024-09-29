package com.github.javarushcommunity.jrtb.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    SendMessage buildResponse(Update update);
    String getCommandIdentifier();
}
