package com.github.javarushcommunity.jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class AbstractCommand implements Command {
    protected String commandIdentifier;

    public abstract String getCommandIdentifier();

}
