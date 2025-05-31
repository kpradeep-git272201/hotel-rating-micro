package com.user.userservice.external.service;

import com.user.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url="http://localhost:8083/webapi/api/v1", value="RATING-SERVICE")
@FeignClient(name="http://RATING-SERVICE/webapi/api/v1")
public interface RatingService {

    @GetMapping("/rating/users/{userId}")
    List<Rating> getRatingByUserId(@PathVariable Long userId);
}
