package com.hotel.HotelService.dtos;

public class HotelDTOs {
    private Long hotelId;
    private String name;
    private String location;
    private String about;

    public HotelDTOs(Long hotelId, String name, String location, String about) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.about = about;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAbout() {
        return about;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
