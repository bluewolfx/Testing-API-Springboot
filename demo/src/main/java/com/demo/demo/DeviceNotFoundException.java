package com.demo.demo;

/*
 * Truphone coding challenge
 * @author: Ricardo Banon de Jesus a.k.a on Github @bluewolfx
 */

public class DeviceNotFoundException extends RuntimeException{
    
    DeviceNotFoundException(Long id){
        super("Could not find device " + id);
    }
}
