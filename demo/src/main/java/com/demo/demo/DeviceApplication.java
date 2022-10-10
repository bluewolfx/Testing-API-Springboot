package com.demo.demo;

/*
 * Truphone coding challenge
 * @author: Ricardo Banon de Jesus a.k.a on Github @bluewolfx
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // with this meta-annotation we can component scanning, autoconfiguration and property support.
public class DeviceApplication{

    public static void main(String...args){
        SpringApplication.run(DeviceApplication.class, args);
    }
}