package com.hotel.HotelService.controller;

import com.hotel.HotelService.dtos.HotelDTOs;
import com.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    // add user

    @PostMapping("/addHotel")
    public ResponseEntity<Object> addHotel(@RequestBody HotelDTOs hotelDTOs){
        HotelDTOs hotelDTOs1 = hotelService.addHotel(hotelDTOs);
        return new ResponseEntity<>(hotelDTOs1, HttpStatus.CREATED);
    }
    // add all user

    @PostMapping("/addHotels")
    public ResponseEntity<Object> addHotels(@RequestBody List<HotelDTOs> hotelDTOs1){
        List<HotelDTOs> hotelDTOs = this.hotelService.addHotels(hotelDTOs1);
        return new ResponseEntity<>(hotelDTOs, HttpStatus.CREATED);
    }
    //get user
    @GetMapping("/{hotelId}")
    public ResponseEntity<Object> getHotelById( @PathVariable String hotelId){
        HotelDTOs hotelDTOs = hotelService.getHotel(Long.parseLong(hotelId));
        return new ResponseEntity<>(hotelDTOs, HttpStatus.OK);
    }

    //get all user
    @GetMapping("/allHotels")
    public ResponseEntity<Object> getAllHotelss(){
        List<HotelDTOs> hotels = hotelService.getHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }


    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Object> deleteUserById(@PathVariable String hotelId){
        boolean isHotelDeleted = this.hotelService.deleteHotel(Long.parseLong(hotelId));
        if(isHotelDeleted){
            return new ResponseEntity<>("Hotel deleted successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Hotel deletion failed!", HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{hotelId}")
    public ResponseEntity<Object> updatedUserById(@PathVariable String hotelId, @RequestBody HotelDTOs hotelDTOs){
        HotelDTOs updatedHotel = this.hotelService.updateHotel(hotelDTOs, Long.parseLong(hotelId));
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }
    @GetMapping("/test")
    public String getTest(){
        return "I am running";
    }
}
