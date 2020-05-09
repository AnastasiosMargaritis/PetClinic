package com.example.PetClinic.controllers;


import com.example.PetClinic.model.Index;
import com.example.PetClinic.services.map.IndexServiceMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IndexController {

    private IndexServiceMap indexService;

    public IndexController(IndexServiceMap indexService) {
        this.indexService = indexService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    public Index index(){
       return this.indexService.findById(1L);
    }
}
