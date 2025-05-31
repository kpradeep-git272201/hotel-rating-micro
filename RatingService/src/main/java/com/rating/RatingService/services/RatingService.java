package com.rating.RatingService.services;

import com.rating.RatingService.dtos.RatingDTOs;
import com.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    RatingDTOs addRating(RatingDTOs ratingDTOs);
    List<RatingDTOs> addRatings(List<RatingDTOs> ratingDTOs);
    RatingDTOs getRating(Long ratingId);
    List<RatingDTOs> getRatings();
    boolean deleteRating(Long Id);
    RatingDTOs updateRating(RatingDTOs ratingDTOs, Long ratingId);
    List<Rating> deleteMulRating(List<Long> ratingIds);
    List<Rating> updateMulRating(List<Rating> ratings);

    List<RatingDTOs> getRatingByUserId(Long userId);

    List<RatingDTOs> getRatingByHotelId(Long hotelId);
}
