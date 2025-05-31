package com.hotel.HotelService.services;

import com.hotel.HotelService.dtos.HotelDTOs;
import com.hotel.HotelService.entities.Hotels;

import java.util.List;

public interface HotelService {

    HotelDTOs addHotel(HotelDTOs hotelDTOs);
    List<HotelDTOs> addHotels(List<HotelDTOs> hotelDTOs);
    HotelDTOs getHotel(Long userId);
    List<HotelDTOs> getHotels();
    boolean deleteHotel(Long Id);
    HotelDTOs updateHotel(HotelDTOs hotelDTOs, Long hotelId);
    List<HotelDTOs> deleteMulHotel(List<Long> hotelIds);
    List<Hotels> updateMulHotel(List<Hotels> hotels);
}
