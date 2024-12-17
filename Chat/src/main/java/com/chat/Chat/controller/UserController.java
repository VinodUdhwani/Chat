package com.chat.Chat.controller;

import com.chat.Chat.payloads.UserDto;
import com.chat.Chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createResource(@RequestBody UserDto userDto){
        return this.userService.createUser(userDto);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateResource(@RequestBody UserDto userDto,@PathVariable Integer userId){
        return this.userService.updateUser(userDto,userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteResource(@PathVariable Integer userId){
        return this.userService.deleteUser(userId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getResource(@PathVariable Integer userId){
        return this.userService.getUser(userId);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getResource(){
        return this.userService.getALlUser();
    }
}
