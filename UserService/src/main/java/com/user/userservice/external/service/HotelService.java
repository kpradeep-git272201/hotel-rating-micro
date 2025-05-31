package com.user.userservice.external.service;

import com.user.userservice.entities.Hotels;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url="http://localhost:8082/webapi/api/v1", value="HOTEL-SERVICE")
@FeignClient(name="http://HOTEL-SERVICE/api/v1")
public interface HotelService {
    @GetMapping("/hotel/{hotelId}")
    Hotels getHotelById(@PathVariable Long hotelId);
}
