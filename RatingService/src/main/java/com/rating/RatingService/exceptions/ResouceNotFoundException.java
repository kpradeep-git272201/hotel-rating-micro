package com.rating.RatingService.exceptions;

public class ResouceNotFoundException extends RuntimeException {

    public ResouceNotFoundException(){
        super("Resource not found on server!");
    }
    public ResouceNotFoundException(String message){
        super(message);
    }
}
