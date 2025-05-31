package com.rating.RatingService.external.service;

import com.rating.RatingService.entities.Hotels;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="http://HOTEL-SERVICE/webapi/api/v1")
public interface HotelService {
    @GetMapping("/hotel/{hotelId}")
    Hotels getHotelById(@PathVariable Long hotelId);
}
