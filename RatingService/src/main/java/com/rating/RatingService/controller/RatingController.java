package com.rating.RatingService.controller;

import com.rating.RatingService.dtos.RatingDTOs;
import com.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rating")
public class RatingController {
    @Autowired
    private RatingService  ratingService;


    @PostMapping("/addRating")
    public ResponseEntity<Object> addRating(@RequestBody RatingDTOs ratingDTOs){
        RatingDTOs ratingDTOs1 = ratingService.addRating(ratingDTOs);
        return new ResponseEntity<>(ratingDTOs1, HttpStatus.CREATED);
    }


    @PostMapping("/addRatings")
    public ResponseEntity<Object> addRatings(@RequestBody List<RatingDTOs> ratingDTOs){
        List<RatingDTOs> ratingDTOs1 = ratingService.addRatings(ratingDTOs);
        return new ResponseEntity<>(ratingDTOs1, HttpStatus.CREATED);
    }
    //get user
    @GetMapping("/{ratingId}")
    public ResponseEntity<Object> getRatingById( @PathVariable String ratingId){
        RatingDTOs ratingDTOs = ratingService.getRating(Long.parseLong(ratingId));
        return new ResponseEntity<>(ratingDTOs, HttpStatus.OK);
    }

    //get all user
    @GetMapping("/allRatings")
    public ResponseEntity<Object> getAllRatings(){
        List<RatingDTOs> ratingDTOs = ratingService.getRatings();
        return new ResponseEntity<>(ratingDTOs, HttpStatus.OK);
    }


    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Object> deleteRatingById(@PathVariable String ratingId){
        boolean isRatingDeleted = this.ratingService.deleteRating(Long.parseLong(ratingId));
        if(isRatingDeleted){
            return new ResponseEntity<>("Rating deleted successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Rating deletion failed!", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{ratingId}")
    public ResponseEntity<Object> updatedRatingById(@PathVariable String ratingId, @RequestBody RatingDTOs ratingDTOs){
        RatingDTOs updatedRating = this.ratingService.updateRating(ratingDTOs, Long.parseLong(ratingId));
        return new ResponseEntity<>(updatedRating, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Object> getRatingByUserId( @PathVariable String userId){
        List<RatingDTOs> ratingByUserId = ratingService.getRatingByUserId(Long.parseLong(userId));
        return new ResponseEntity<>(ratingByUserId, HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<Object> getRatingByHotelId( @PathVariable String hotelId){
        List<RatingDTOs> ratingByHotelId = ratingService.getRatingByHotelId(Long.parseLong(hotelId));
        return new ResponseEntity<>(ratingByHotelId, HttpStatus.OK);
    }
    @GetMapping("/test")
    public String getTest(){
        return "I am running";
    }

}
