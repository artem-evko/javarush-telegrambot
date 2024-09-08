package com.github.javarushcommunity.jrtb.command;

import static com.github.javarushcommunity.jrtb.command.UnknownCommand.UNKNOWN_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class UnknownCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return "/sdhfuhasdhfj";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}