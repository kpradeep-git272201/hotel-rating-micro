package com.rating.RatingService.repositories;

import com.rating.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    public List<Rating> getRatingByUserId(Long userId);
    public List<Rating> getRatingByHotelId(Long hotelId);
}
