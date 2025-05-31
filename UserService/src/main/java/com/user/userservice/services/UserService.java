package com.user.userservice.services;

import com.user.userservice.dtos.UserDto;
import com.user.userservice.entities.User;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);
    List<UserDto> addUsers(List<UserDto> userDtos);
    UserDto getUser(Long userId);
    List<UserDto> getUsers();
    boolean deleteUser(Long Id);
    UserDto updateUser(UserDto user, Long userId);
    List<User> deleteMulUser(List<Long> userIds);
    List<User> updateMulUser(List<User> users);
}
