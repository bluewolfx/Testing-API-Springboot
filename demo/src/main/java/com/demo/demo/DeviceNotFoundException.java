package com.demo.demo;

public class DeviceNotFoundException extends RuntimeException{
    
    DeviceNotFoundException(Long id){
        super("Could not find device " + id);
    }
}
