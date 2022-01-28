package com.example.bookinfoservice.controller;

import com.example.bookinfoservice.model.*;
import com.example.bookinfoservice.repository.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;



@CrossOrigin
@RestController
public class AdminController {
    // This controller contains the CUD functions of:
    // Domain , Location

    // Domain CUD
    @Autowired
    DomainRepository domainRepository;
    @PostMapping("/domains")
    public Domain addDomains(@RequestBody Domain domain){
        return domainRepository.save(new Domain(domain.getName(),domain.getDescription()));
    }
    @PutMapping("/domains")
    public Domain updateDomains(@RequestBody Domain domain){
        return domainRepository.save(domain);
    }
    @DeleteMapping("/domains/{domain_id}")
    public void deleteDomain(@PathVariable int domain_id){
        domainRepository.deleteById(domain_id);
    }

    // Location CUD
    @Autowired
    LocationRepository locationRepository;
    @PostMapping("/locations")
    public Location addLocation(@RequestBody Location location){
        return locationRepository.save(new Location(location.getName(),location.getPostalCode()));
    }
    @PutMapping("/locations")
    public Location updateLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }
    @DeleteMapping("/locations/{location_id}")
    public void deleteLocation(@PathVariable int location_id){
        domainRepository.deleteById(location_id);
    }




}
