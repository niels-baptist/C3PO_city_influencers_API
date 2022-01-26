package com.example.bookinfoservice.controller;
import com.example.bookinfoservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.bookinfoservice.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class SharedController  {
    @Autowired
    DomainRepository domainRepository;

    @GetMapping("/domains")
    public List<Domain> getDomains(){
        return domainRepository.findAll();
    }
}
