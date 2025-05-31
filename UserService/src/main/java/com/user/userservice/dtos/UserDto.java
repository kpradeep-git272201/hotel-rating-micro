package com.user.userservice.dtos;

import com.user.userservice.entities.Rating;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String about;
    private List<Rating> rating = new ArrayList<>();


    public UserDto(Long id, String name, String email, String about, List<Rating> rating) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.about = about;
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAbout(String about) {
        this.about = about;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAbout() {
        return about;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }
}
