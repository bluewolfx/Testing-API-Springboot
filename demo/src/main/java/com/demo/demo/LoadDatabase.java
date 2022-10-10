package com.demo.demo;

/*
 * Truphone coding challenge
 * @author: Ricardo Banon de Jesus a.k.a on Github @bluewolfx
 */

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDataBase(DeviceRepository repository){
        Date date = new Date();

        // Spring boot will run commandlineruner and will copy this device repository, while creating the next 2 entitys and store them
        return args -> {
            log.info("Preloading " + repository.save(new Device("Pixel5", "Google",date)));
            log.info("Preloading " + repository.save(new Device("Galaxy S20", "Samsung", date)));
          };
    }
}
