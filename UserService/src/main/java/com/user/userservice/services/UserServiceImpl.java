package com.user.userservice.services;

import com.user.userservice.dtos.RatingDTOs;
import com.user.userservice.dtos.UserDto;
import com.user.userservice.entities.Hotels;
import com.user.userservice.entities.Rating;
import com.user.userservice.entities.User;
import com.user.userservice.exceptions.ResouceNotFoundException;
import com.user.userservice.external.service.HotelService;
import com.user.userservice.external.service.RatingService;
import com.user.userservice.repositories.UserRepository;
import com.user.userservice.utils.CustomObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private CustomObjectMapper objectMapper;
    @Autowired
    private UserRepository repository;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private HotelService hotelService;
    @Override
    public UserDto addUser(UserDto userDto) {
        User user = objectMapper.convert(userDto, User.class);
        User saveUser = this.repository.save(user);
        return objectMapper.convert(saveUser, UserDto.class);
    }

    @Override
    public List<UserDto> addUsers(List<UserDto> userDtos) {
        List<User> convert = Arrays.asList(objectMapper.convert(userDtos, User[].class));
        List<User> users = this.repository.saveAll(convert);
        return Arrays.asList(objectMapper.convert(users, UserDto[].class));
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = this.repository.findById(userId).orElseThrow(() -> new ResouceNotFoundException("User not found for given Id: " + userId));
        List<Rating> ratingByUserId = ratingService.getRatingByUserId(user.getId());
        user.setRating(ratingByUserId);
        return objectMapper.convert(user, UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> allUsers = this.repository.findAll();
        List<User> collect = allUsers.stream().peek(user -> {
            List<Rating> ratingByUserId = ratingService.getRatingByUserId(user.getId());
            ratingByUserId.stream().peek(rating->{
                Hotels hotelById = hotelService.getHotelById(rating.getHotelId());
                rating.setHotels(hotelById);
            }).collect(Collectors.toList());
            user.setRating(ratingByUserId);
        }).collect(Collectors.toList());
        return Arrays.asList(objectMapper.convert(collect, UserDto[].class));
    }

    @Override
    public boolean deleteUser(Long Id) {
        boolean isUserDeleted =false;
        try{
            this.repository.deleteById(Id);
            isUserDeleted=true;
        }catch (Exception e){
            isUserDeleted=false;
        }
        return isUserDeleted;
    }

    @Override
    public UserDto updateUser(UserDto user, Long userId) {
        Optional<User> byId = this.repository.findById(userId);
        User user1 = byId.get();
        if(user.getAbout()!=null){
            user1.setAbout(user.getAbout());
        }
        if(user.getEmail()!=null){
            user1.setEmail(user.getEmail());
        }
        if(user.getName()!=null){
            user1.setName(user.getName());
        }
        User save = this.repository.save(user1);
        return objectMapper.convert(save, UserDto.class);
    }

    @Override
    public List<User> deleteMulUser(List<Long> userIds) {
        return null;
    }

    @Override
    public List<User> updateMulUser(List<User> users) {
        return null;
    }
}
