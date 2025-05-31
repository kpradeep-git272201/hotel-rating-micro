package com.hotel.HotelService.repositories;

import com.hotel.HotelService.entities.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Long> {
}
