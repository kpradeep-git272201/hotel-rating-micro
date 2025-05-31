package com.rating.RatingService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
public class RatingDTOs {
    private Long ratingId;
    private Long userId;
    private Long hotelId;
    private int rating;
    private String feedback;
    private HotelDTOs hotels;
    public RatingDTOs(){}

    public RatingDTOs(Long ratingId, Long userId, Long hotelId, int rating, String feedback, HotelDTOs hotels) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedback = feedback;
        this.hotels = hotels;
    }

    public void setHotels(HotelDTOs hotels) {
        this.hotels = hotels;
    }
    public HotelDTOs getHotels() {
        return hotels;
    }
    public Long getRatingId() {
        return ratingId;
    }
    public Long getUserId() {
        return userId;
    }
    public Long getHotelId() {
        return hotelId;
    }
    public int getRating() {
        return rating;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
