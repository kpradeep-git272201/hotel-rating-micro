package com.user.userservice.controller;

import com.user.userservice.dtos.UserDto;
import com.user.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService  userService;
    // add user

    @PostMapping("/addUser")
    public ResponseEntity<Object> addUser(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.addUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }
    // add all user

    @PostMapping("/addUsers")
    public ResponseEntity<Object> addUsers(@RequestBody List<UserDto> userDtos){
        List<UserDto> userDto1 = userService.addUsers(userDtos);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }
    //get user
   @GetMapping("/{userId}")
    public ResponseEntity<Object> getUseryById( @PathVariable String userId){
       UserDto userDto = userService.getUser(Long.parseLong(userId));
       return new ResponseEntity<>(userDto, HttpStatus.OK);
   }

    //get all user
    @GetMapping("/allUsers")
    public ResponseEntity<Object> getAllUsers(){
        List<UserDto> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUserById(@PathVariable String userId){
        boolean isUserDeleted = this.userService.deleteUser(Long.parseLong(userId));
        if(isUserDeleted){
           return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User deletion failed!", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<Object> updatedUserById(@PathVariable String userId, @RequestBody UserDto userDto){
        UserDto updatedUser = this.userService.updateUser(userDto, Long.parseLong(userId));
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @GetMapping("/test")
    public String getTest(){
        return "I am running";
    }

}
