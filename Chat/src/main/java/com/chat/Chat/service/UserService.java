package com.chat.Chat.service;

import com.chat.Chat.entities.User;
import com.chat.Chat.exceptions.ResourceNotFoundException;
import com.chat.Chat.payloads.UserDto;
import com.chat.Chat.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public ResponseEntity<UserDto> createUser(UserDto userDto){
        User user=this.modelMapper.map(userDto,User.class);
        User savedUser = this.userRepository.save(user);
        return new ResponseEntity<>(this.modelMapper.map(savedUser, UserDto.class), HttpStatus.CREATED);
    }

    public ResponseEntity<UserDto> updateUser(UserDto userDto,Integer userId){
        User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setBio(userDto.getBio());

        User updatedUser = this.userRepository.save(user);
        UserDto updatedUserDto=this.modelMapper.map(updatedUser, UserDto.class);
        return new ResponseEntity<>(updatedUserDto,HttpStatus.OK);
    }


    public ResponseEntity<?> deleteUser(Integer userId){
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        this.userRepository.delete(user);
        return ResponseEntity.accepted().body("delete request accepted successfully");
    }

    public ResponseEntity<UserDto> getUser(Integer userId){
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        UserDto userDto=this.modelMapper.map(user,UserDto.class);
        return new ResponseEntity<>(userDto,HttpStatus.FOUND);
    }

    public ResponseEntity<List<UserDto>> getALlUser(){
        List<User> userList = this.userRepository.findAll();
        List<UserDto> userDtoList = userList.stream().map(user -> this.modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(userDtoList,HttpStatus.OK);
    }
}
