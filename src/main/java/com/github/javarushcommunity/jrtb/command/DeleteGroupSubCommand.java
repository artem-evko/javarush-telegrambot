package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.repository.entity.GroupSub;
import com.github.javarushcommunity.jrtb.repository.entity.TelegramUser;
import com.github.javarushcommunity.jrtb.service.GroupSubService;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.github.javarushcommunity.jrtb.command.CommandName.DELETE_GROUP_SUB;
import static com.github.javarushcommunity.jrtb.command.CommandUtils.getChatId;
import static com.github.javarushcommunity.jrtb.command.CommandUtils.getMessage;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.isNumeric;

@Component
@RequiredArgsConstructor
public class DeleteGroupSubCommand extends AbstractCommand{
    private final TelegramUserService telegramUserService;
    private final GroupSubService groupSubService;
    @Override
    public SendMessage buildResponse(Update update) {
        if(getMessage(update).equalsIgnoreCase(DELETE_GROUP_SUB.getCommandName()))
        return sendGroupIdList(getChatId(update));
        String groupId = getMessage(update).split(SPACE)[1];
        String chatId = getChatId(update);
        if(isNumeric((groupId))){
            Optional<GroupSub>optionalGroupSub=groupSubService.findById(Integer.valueOf(groupId));
            if(optionalGroupSub.isPresent()){
                GroupSub groupSub =optionalGroupSub.get();
                TelegramUser telegramUser=telegramUserService.findByChatId(chatId).orElseThrow(NotFoundException::new);
                groupSub.getUsers().remove(telegramUser);
                groupSubService.save(groupSub);
                return new SendMessage(chatId, format("Удалил подписку на группу: %s", groupSub.getTitle()));
            } else {
                return new SendMessage(chatId,"Не нашел такой группы =/");
            }
        }else{
            return new SendMessage(chatId,"неправильный формат ID группы.\n " +
                    "ID должно быть целым положительным числом");
        }
    }

    @Override
    public String getCommandIdentifier() {
        return "/deleteGroupSub";
    }

    private SendMessage sendGroupIdList(String chatId){
        String message;
        List<GroupSub> groupSubs = telegramUserService.findByChatId(chatId)
                .orElseThrow(NotFoundException::new)
                .getGroupSubs();
        if(CollectionUtils.isEmpty(groupSubs)) {
            message = "Пока нет подписок на группы. Чтобы добавить подписку напиши /addGroupSub";
        }else{
            message = "Чтобы удалить подписку на группу - передай комадну вместе с ID группы. \n" +
                    "Например: /deleteGroupSub 16 \n\n" +
                    "я подготовил список всех групп, на которые ты подписан) \n\n" +
                    "имя группы - ID группы \n\n" +
                    "%s";
        }
        String userGroupSubData = groupSubs.stream()
                .map(group -> format("%s - %s \n", group.getTitle(), group.getId()))
                .collect(Collectors.joining());
        return new SendMessage(chatId,format(message, userGroupSubData));
    }
}
