package com.demo.demo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class DeviceModelAssembler implements RepresentationModelAssembler<Device, EntityModel<Device>> {

    @Override
    public EntityModel<Device> toModel(Device device){
        return EntityModel.of(device, linkTo(methodOn(DeviceController.class).singleDevice(device.getId())).withSelfRel(),linkTo(methodOn(DeviceController.class).allDevices()).withRel("devices"));
    }


    
}
