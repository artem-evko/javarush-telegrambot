package com.github.javarushcommunity.jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public class CommandUtils {
    public static String getChatId(Update update) {
        return update.getMessage().getChatId().toString();
    }
    /**
     * Retrieve text of the message from {@link Update} object.
     *
     * @param update provided {@link Update}
     * @return the text of the message from the provided {@link Update} object.
     */
    public static String getMessage(Update update) {
        return update.getMessage().getText();
    }
}
