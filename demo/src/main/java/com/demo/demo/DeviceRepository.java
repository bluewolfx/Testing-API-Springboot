package com.demo.demo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

interface DeviceRepository extends JpaRepository<Device, Long>{
    Collection<Device> findByBrand(String brand);
}
