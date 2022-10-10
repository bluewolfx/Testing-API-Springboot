package com.demo.demo;

/*
 * Truphone coding challenge
 * @author: Ricardo Banon de Jesus a.k.a on Github @bluewolfx
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DeviceNotFoundAdvice {
    
    @ResponseBody // rendered straight to the response body
    @ExceptionHandler(DeviceNotFoundException.class) //only responds if an notFoundException is thrown
    @ResponseStatus(HttpStatus.NOT_FOUND) //respondes to HTTP 404 with message.
    String deviceNotFoundHandler(DeviceNotFoundException exception){
        return exception.getMessage();
    }
}
