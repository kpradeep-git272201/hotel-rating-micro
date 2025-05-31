package com.hotel.HotelService.services;

import com.hotel.HotelService.dtos.HotelDTOs;
import com.hotel.HotelService.entities.Hotels;
import com.hotel.HotelService.exceptions.ResouceNotFoundException;
import com.hotel.HotelService.repositories.HotelRepository;
import com.hotel.HotelService.utils.CustomObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements  HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private CustomObjectMapper objectMapper;
    @Override
    public HotelDTOs addHotel(HotelDTOs hotelDTOs) {
        Hotels convertHotel = objectMapper.convert(hotelDTOs, Hotels.class);
        Hotels save = this.hotelRepository.save(convertHotel);
        return objectMapper.convert(save, HotelDTOs.class);
    }

    @Override
    public List<HotelDTOs> addHotels(List<HotelDTOs> hotelDTOs) {
        List<Hotels> listHotel = Arrays.asList(objectMapper.convert(hotelDTOs, Hotels[].class));
        List<Hotels> hotels = this.hotelRepository.saveAll(listHotel);
        return Arrays.asList(objectMapper.convert(hotels, HotelDTOs[].class));
    }

    @Override
    public HotelDTOs getHotel(Long hotelId) {
        Hotels hotels = this.hotelRepository.findById(hotelId).orElseThrow(() -> new ResouceNotFoundException("User not found for given Id: " + hotelId));
        return objectMapper.convert(hotels, HotelDTOs.class);
    }

    @Override
    public List<HotelDTOs> getHotels() {
        List<Hotels> allHotels = this.hotelRepository.findAll();
        return Arrays.asList(objectMapper.convert(allHotels, HotelDTOs[].class));
    }

    @Override
    public boolean deleteHotel(Long Id) {
        boolean isHotelDeleted =false;
        try{
            this.hotelRepository.deleteById(Id);
            isHotelDeleted=true;
        }catch (Exception ignored){
        }
        return isHotelDeleted;
    }

    @Override
    public HotelDTOs updateHotel(HotelDTOs hotelDTOs, Long hotelId) {
        Optional<Hotels> byId = this.hotelRepository.findById(hotelId);
        Hotels hotels = byId.get();
        if(hotelDTOs.getAbout()!=null){
            hotels.setAbout(hotelDTOs.getAbout());
        }
        if(hotelDTOs.getName()!=null){
            hotels.setName(hotelDTOs.getName());
        }
        if(hotelDTOs.getLocation()!=null){
            hotels.setLocation(hotelDTOs.getLocation());
        }
        Hotels save = this.hotelRepository.save(hotels);
        return objectMapper.convert(save, HotelDTOs.class);
    }

    @Override
    public List<HotelDTOs> deleteMulHotel(List<Long> hotelIds) {
        return null;
    }

    @Override
    public List<Hotels> updateMulHotel(List<Hotels> hotels) {
        return null;
    }
}
