package com.github.javarushcommunity.jrtb.command;

public enum CommandName {
    START("/start"),
    HELP("/help"),
    NO("nocommand"),
    STOP("/stop"),
    STAT("/stat"),
    ADD_GROUP_SUB("/addgroupsub"),
    LIST_GROUP_SUB("/listgroupsub");
    private final String commandName;
    CommandName(String commandName){
        this.commandName=commandName;
    }
    public String getCommandName(){
        return commandName;
    }
}
