package com.demo.demo;
/*
 * Truphone coding challenge
 * @author: Ricardo Banon de Jesus a.k.a on Github @bluewolfx
 */

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Creation of the datastore to access device data
 */
public class DataStore {

    private static Map<String, List<Device>> deviceMap =  new HashMap<>();
    private static DataStore instance = new DataStore();

    public static DataStore getInstance(){
        return instance;
    }

    private DataStore(){
        // insert data for testing
    }
    
    public void addDevice(Device device){
        List<Device> newDeviceList = getListDeviceByBrand(device.getBrand());
        newDeviceList.add(device);
        deviceMap.put(device.getBrand(), newDeviceList);
    }

    public Device getDevice(Device device){
        return new Device ();
    }

    public List<Map<String, List<Device>>> geListAllDevices(){
        return Arrays.asList(deviceMap);
    }

    public List<Device> getListDeviceByBrand(String Brand){
        return deviceMap.get(Brand);
    }

    public void updateDevice(Device device){
        List<Device> newDeviceList  = deviceMap.get(device.getBrand());
        if(!newDeviceList.contains(device)){
            System.out.println("Device doesn't exists!");
        }else{
            int index = newDeviceList.indexOf(device);
            newDeviceList.set(index, device);
        }
        deviceMap.replace(device.getBrand(), newDeviceList);
    }

    public void deleteDevice(Device device){
        List<Device> newDeviceList  = deviceMap.get(device.getBrand());
        if(!newDeviceList.contains(device)){
            System.out.println("Device doesn't exists!");
        }else{
            int index = newDeviceList.indexOf(device);
            newDeviceList.remove(index);
        }
        deviceMap.replace(device.getBrand(), newDeviceList);
    }

    public Device searchDeviceByBrand(Device device){
        int index = deviceMap.get(device.getBrand()).indexOf(device);

        return deviceMap.get(device.getBrand()).get(index);
    }


}