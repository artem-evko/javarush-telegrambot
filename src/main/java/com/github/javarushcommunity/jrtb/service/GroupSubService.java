package com.github.javarushcommunity.jrtb.service;

import com.github.javarushcommunity.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.javarushcommunity.jrtb.repository.entity.GroupSub;

import java.util.Optional;

public interface GroupSubService {
    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
    GroupSub save(GroupSub groupSub);
    Optional<GroupSub> findById(Integer id);
}
