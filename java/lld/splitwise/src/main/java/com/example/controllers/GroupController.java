package com.example.controllers;

import com.example.dto.GroupDTO;
import com.example.models.Group;
import com.example.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {

    private GroupService groupService;

    @PostMapping(value = {"", "/"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createGroup(@RequestBody GroupDTO requestBody) {

        try {
            Group group = groupService.createGroup(requestBody);
            return ResponseEntity.ok("Group Created Successfully with group id " + group.getId());
        } catch (Exception e) {
            System.out.println("Error occurred while creating group");
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @GetMapping(value = "/{groupId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGroup(@PathVariable long groupId) {
        System.out.println("getGroup : " + groupId);

        try {
            return ResponseEntity.ok(groupService.getGroup(groupId));
        } catch (Exception e) {
            System.out.println("Error while fetching group with id " + groupId);
            return ResponseEntity.internalServerError().body("Error while fetching group with id " + groupId);
        }
    }

    @PostMapping(value = "/{groupId}/add-member/{userId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addMemberToGroup(@PathVariable long userId, @PathVariable long groupId) {
        try {
            groupService.addMemberToGroup(groupId, userId);
            return ResponseEntity.ok("Member added successfully.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

}
