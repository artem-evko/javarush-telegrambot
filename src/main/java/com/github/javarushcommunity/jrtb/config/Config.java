package com.github.javarushcommunity.jrtb.config;

import com.github.javarushcommunity.jrtb.command.*;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import com.google.common.collect.ImmutableMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.BeanParam;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;

@Configuration
public class Config {

    @Bean
    public ImmutableMap<String, Command> commandMap( TelegramUserService telegramUserService){
        return ImmutableMap.<String,Command>builder()
                .put(START.getCommandName(),new StartCommand(telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand())
                .put(NO.getCommandName(), new NoCommand())
                .put(STAT.getCommandName(), new StatCommand(telegramUserService))
                .build();
    }
}
