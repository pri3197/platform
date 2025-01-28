package com.gala.standardization.platform.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gala.standardization.platform.entities.Domain;
import com.gala.standardization.platform.repository.DomainDTO;
import com.gala.standardization.platform.service.DomainService;
import com.gala.standardization.platform.service.DomainServiceImpl;

@RestController
public class DomainController {
    @Autowired
    private DomainServiceImpl domainService;

    @GetMapping("/api/home")
    public String home(){
        return "this is home page";
    }

    //get all domains
    // @GetMapping("/domains/{cityId}")
    // public List<Domain>getDomainsByCity(@PathVariable String cityId){
    //     return domainService.getDomainsByCity(cityId);
    // }

    //  //add a domain
    // @PostMapping(path="/domains", consumes="application/json")
    // public Domain setDomain(@RequestBody Domain domain){
    //     return this.domainService.addDomain(domain);
    // }


    // // Get specific domain for a city
    // @GetMapping("/cities/{cityId}/domains/{domainId}")
    // public Domain getDomain(@PathVariable String cityId, @PathVariable String domainId) {
    //     return domainService.getDomain(cityId, Long.parseLong(domainId));
    // }


     // Get a domain by ID
    @GetMapping("/{id}")
    public ResponseEntity<DomainDTO> getDomainById(@PathVariable String id) {
        return ResponseEntity.ok(domainService.getDomainById(id));
    }

    // Get all domains for a specific city
    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<DomainDTO>> getDomainsByCity(@PathVariable String cityId) {
        return ResponseEntity.ok(domainService.getDomainsByCity(cityId));
    }
  
}

   
