package com.rating.RatingService.services;

import com.rating.RatingService.dtos.RatingDTOs;
import com.rating.RatingService.entities.Hotels;
import com.rating.RatingService.entities.Rating;
import com.rating.RatingService.exceptions.ResouceNotFoundException;
import com.rating.RatingService.external.service.HotelService;
import com.rating.RatingService.repositories.RatingRepository;
import com.rating.RatingService.utils.CustomObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private CustomObjectMapper objectMapper;
    @Autowired
    private HotelService hotelService;
    @Override
    public RatingDTOs addRating(RatingDTOs ratingDTOs) {
        Rating rating = objectMapper.convert(ratingDTOs, Rating.class);
        Rating saveRating = this.ratingRepository.save(rating);
        return objectMapper.convert(saveRating, RatingDTOs.class);
    }

    @Override
    public List<RatingDTOs> addRatings(List<RatingDTOs> ratingDTOs) {
        List<Rating> convert = Arrays.asList(objectMapper.convert(ratingDTOs, Rating[].class));
        List<Rating> ratings = this.ratingRepository.saveAll(convert);
        return Arrays.asList(objectMapper.convert(ratings, RatingDTOs[].class));
    }

    @Override
    public RatingDTOs getRating(Long ratingId) {
        Rating rating = this.ratingRepository.findById(ratingId).orElseThrow(() -> new ResouceNotFoundException("User not found for given Id: " + ratingId));
        return objectMapper.convert(rating, RatingDTOs.class);
    }

    @Override
    public List<RatingDTOs> getRatings() {
        List<Rating> allRatings = this.ratingRepository.findAll();
        List<Rating> ratings = allRatings.stream().peek(rating -> {
            Hotels hotelById = hotelService.getHotelById(rating.getHotelId());
            rating.setHotels(hotelById);
        }).toList();
        return Arrays.asList(objectMapper.convert(ratings, RatingDTOs[].class));
    }

    @Override
    public boolean deleteRating(Long Id) {
        boolean isRatingDeleted =false;
        try{
            this.ratingRepository.deleteById(Id);
            isRatingDeleted=true;
        }catch (Exception ignored){
        }
        return isRatingDeleted;
    }

    @Override
    public RatingDTOs updateRating(RatingDTOs ratingDTOs, Long ratingId) {
        Optional<Rating> byId = this.ratingRepository.findById(ratingId);
        Rating rating = byId.get();
        if(ratingDTOs.getFeedback()!=null){
            rating.setFeedback(ratingDTOs.getFeedback());
        }

        Rating rating1 = this.ratingRepository.save(rating);
        return objectMapper.convert(rating1, RatingDTOs.class);
    }

    @Override
    public List<Rating> deleteMulRating(List<Long> ratingIds) {
        return null;
    }

    @Override
    public List<Rating> updateMulRating(List<Rating> ratings) {
        return null;
    }

    @Override
    public List<RatingDTOs> getRatingByUserId(Long userId) {
        List<Rating> ratingByUserId = this.ratingRepository.getRatingByUserId(userId);
        return Arrays.asList(objectMapper.convert(ratingByUserId, RatingDTOs[].class));
    }

    @Override
    public List<RatingDTOs> getRatingByHotelId(Long hotelId) {
        List<Rating> ratingByHotelId = this.ratingRepository.getRatingByHotelId(hotelId);
        return Arrays.asList(objectMapper.convert(ratingByHotelId, RatingDTOs[].class));
    }
}
