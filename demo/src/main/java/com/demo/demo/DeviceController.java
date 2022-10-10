package com.demo.demo;

/*
 * Truphone coding challenge
 * @author: Ricardo Banon de Jesus a.k.a on Github @bluewolfx
 * In this class we used spring HATEOAS, where is a project to define a RESTFUL service and render it for client consumption
 * we also use the static helper methods from WebMvcLinkBuilder to build the links shown below
 */

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //data returned by each method will go straight to the body and won't render a template.
public class DeviceController {
    
    private final DeviceRepository repository;
    private final DeviceModelAssembler assembler;

    DeviceController(DeviceRepository repository, DeviceModelAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }
    //Routes for each operation corresponding to GET, POST, PUT and DELETE from HTTP

    @GetMapping("/devices")
    CollectionModel<EntityModel<Device>> allDevices(){
        List<EntityModel<Device>> devices = repository.findAll().stream() // message driven microservice/event driven
      .map(assembler::toModel) //
      .collect(Collectors.toList());

    return CollectionModel.of(devices, linkTo(methodOn(DeviceController.class).allDevices()).withSelfRel());
    }

    @GetMapping("/devices")
    Collection<Device> devicesByBrand(@PathVariable String brand){
        
        return repository.findByBrand(brand);
    }

    @PostMapping("/devices")
    ResponseEntity<?> newDevice(@RequestBody Device newDevice) {

        EntityModel<Device> entityModel = assembler.toModel(repository.save(newDevice));
      
        return ResponseEntity //
            .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
            .body(entityModel);
    }

    @GetMapping("/devices/{id}")
    EntityModel<Device> singleDevice(@PathVariable Long id){
        Device device = repository.findById(id) //
        .orElseThrow(() -> new DeviceNotFoundException(id));
  
    return assembler.toModel(device);
    }

    @PutMapping("/devices/{id}")
    Device replaceDevice(@RequestBody Device newDevice, @PathVariable Long id){
        return repository.findById(id)
        .map(device -> {
            device.setDeviceName(newDevice.getName()); 
            device.setDeviceBrand(newDevice.getBrand()); 
            device.setCreationTime(newDevice.getCreationTime()); 
            return repository.save(newDevice);
        })
        .orElseGet(()-> {
            newDevice.setDeviceId(id); 
            return repository.save(newDevice);
        });
    }

    @DeleteMapping("/devices/{id}")
    void deleteDevice(@PathVariable Long id){
        repository.deleteById(id);
    }

}



