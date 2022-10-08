package com.demo.demo;

/*
 * Truphone coding challenge
 * @author: Ricardo Banon de Jesus a.k.a on Github @bluewolfx
 */

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

/**
 * Device creation
 */
@Entity
public class Device {
    
    private @Id @GeneratedValue Long id;
    private String name;
    private String brand;
    private Date creationTime;

    public Device(){
    }

    /**
     * Initialization of the Device object
     * 
     * @param name         - name of the device
     * @param brand        - the brand which the device belongs
     * @param creationTime - date the device was created
     */
    public Device(String name, String brand, Date creationTime){
        this.name = name;
        this.brand = brand;
        this.creationTime = creationTime;
    }

    /**
     * Get id from current device
     * 
     * @return a long with the id of the device
     */
    public Long getId(){
        return id;
    }

    /**
     * Get name from current device
     * 
     * @return a string with the name of the device
     */
    public String getName(){
        return name;
    }

    /**
     * Get brand from current device
     * 
     * @return string with the brande of the device
     */
    public String getBrand(){
        return brand;
    }

    /**
     * Get creation time from current device
     * 
     * @return Date object with the creation time in it.
     */
    public Date getCreationTime(){
        return creationTime;
    }
    /**
     * Set the device name with @param name
     * 
     * @param name new name for the device
     */
    public void setDeviceName(String name){
        this.name = name;
    }

    /**
     * Set the brand with @param brand
     * 
     * @param brand new brand for the device
     */
    public void setDeviceBrand(String brand){
        this.brand = brand;
    }

    /**
     * Set the creation time with @param creationTime
     * 
     * @param creationTime new creation time for the device
     */
    public void setCreationTime(Date creationTime){
        this.creationTime = creationTime;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.brand, this.creationTime);
    }

    @Override
    public boolean equals(Object deviceToComp){
        if (this == deviceToComp)
            return true;
        if (!(deviceToComp instanceof Device))
            return false;
        Device device = (Device) deviceToComp;
        return Objects.equals(this.id, device.id)
                && Objects.equals(this.name, device.name)
                && Objects.equals(this.brand, device.brand);
    }

    @Override
    public String toString(){
        return "Device{id= " + id + " , name=" + name + " ,brand " 
        + " ,Creation Time= " + creationTime.toString() + "}";
    }
}