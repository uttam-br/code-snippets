package com.example.services;

import com.example.dto.GroupDTO;
import com.example.models.Group;
import com.example.models.User;
import com.example.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupService {

    private GroupRepository groupRepository;

    private UserService userService;

    public Group createGroup(GroupDTO groupRequestDTO) throws Exception {
        try {
            User user;
            try {
                user = userService.getUser(groupRequestDTO.getCreatedBy());
            } catch (Exception e) {
                System.out.println("Error occurred while fetching group created by user. " + e.getMessage());
                throw e;
            }

            Group group = new Group();
            group.setCreatedBy(user);
            group.setDescription(groupRequestDTO.getDescription());
            group.setMembers(List.of(user));

            return groupRepository.save(group);
        } catch(Exception e) {
            System.out.println("Error occurred while creating group. " + e.getMessage());
            throw e;
        }
    }

    public Group getGroup(long groupId) throws Exception {
        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (groupOptional.isEmpty()) {
            System.out.println("Cannot find group with id " + groupId);
            throw new Exception("Cannot find group with id " + groupId);
        }

        return groupOptional.get();
    }

    public void addMemberToGroup(long groupId, long userId) throws Exception {
        User user;
        try {
            user = userService.getUser(userId);
        } catch (Exception e) {
            System.out.println("Error occurred while fetching group created by user. " + e.getMessage());
            throw e;
        }

        Group group = getGroup(groupId);
        group.getMembers().add(user);
        groupRepository.save(group);
    }


}
