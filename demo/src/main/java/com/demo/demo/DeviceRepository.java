package com.demo.demo;

/*
 * Truphone coding challenge
 * @author: Ricardo Banon de Jesus a.k.a on Github @bluewolfx
 * 
 * Whis this repository we will be able to automatically be able to create new employees, update existing ones, delete and find by extending JPS repository.
 * 
 */

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

interface DeviceRepository extends JpaRepository<Device, Long>{
    Collection<Device> findByBrand(String brand);
}
